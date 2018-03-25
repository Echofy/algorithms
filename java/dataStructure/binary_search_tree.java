package datastru.cla;

import java.lang.Integer;
import java.io.*;

// 二叉查找数

class Node {
	public int data;
	public Node left;
	public Node right;

	public Node(int _data) {
		data = _data;
		left = null;
		right = null;
	}
} // end class Node 

// 数据是节点的队列，为了层次遍历
class QueueNode {
	private Node [] qArr;
	private int maxSize;
	private int front;
	private int rear;
	private int nItems;

	public QueueNode(int mx) {
		maxSize = mx;
		qArr = new Node[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	public void enqueue(Node value) {
		if(rear == maxSize-1)
			rear = -1;

		qArr[++rear] = value;
		nItems ++;
	}

	public Node dequeue() {
		Node temp = qArr[front];

		if(++front == maxSize)
			front = 0;

		nItems --;

		return temp;
	}

	public Node peekFront() {
		return qArr[front];
	}

	public boolean isEmpty()
	{
		return (nItems == 0);
	}

	public boolean isFull()
	{
		return (nItems == maxSize);
	}

} // end class Queue

class BinaryTree {
	private Node root;

	public BinaryTree(int key) {
		root = new Node(key);
	}

	// 复制树
	public void cpTree(Node _root) {
		root = _root;
	}

	// 查找
	public boolean find(int key) {
		Node current = root;

		// 沿着根依据key的大小往下搜索
		while(current != null) {
			if(current.data == key) {
				System.out.println("find success!");
				return true;
			}
			else if(key > current.data)
				current = current.right;
			else
				current = current.left;
		} // end while
		System.out.println("find failed!");
		return false;
	}// end find

	// 插入
	public boolean insert(int key) {
		Node keyNode = new Node(key);
		Node current = root;
		Node parent = current;
		// 记录是根的左子树还是右子树
		boolean isLeft = true;

		// 沿着根，依据key的大小，往下搜索key的正确位置
		while(current != null) {
			if(key > current.data) {
				parent = current;
				isLeft = false;
				current = current.right;
			}
			
			// 禁止插入重复key	
			else if(key == current.data) {
				System.out.println("duplicate key!");
				return false;
			}

			else {
				parent = current;
				isLeft = true;
				current = current.left;
			}
		} // end while

		if(isLeft)
			parent.left = keyNode;
		else
			parent.right = keyNode;

		return true;
	} // end func insert

	// 层次遍历
	public void levelTravel() {
		QueueNode theQueue = new QueueNode(20);
		Node re;

		theQueue.enqueue(root);

		System.out.print("level travel: ");

		// 利用队列先进先出的特性进行层次遍历
		while(!theQueue.isEmpty()) {
			re = theQueue.dequeue();
			System.out.print(re.data + " ");

			if(re.left != null)
				theQueue.enqueue(re.left);

			if(re.right != null)
				theQueue.enqueue(re.right);
		}
		System.out.println();
	} // end levelTravel

	// 中序遍历，递归
	public void intravel(Node x) {
		if(x != null) {
			intravel(x.left);
			System.out.print(x.data + " ");
			intravel(x.right);
		}
	}

	// 中序遍历
	public void intravelCall() {
		System.out.print("Inorder travel: ");
		intravel(root);
		System.out.println();
	}

	// 前序遍历，递归
	public void pretravel(Node x) {
		if(x != null) {
			System.out.print(x.data + " ");
			pretravel(x.left);
			pretravel(x.right);
		}
	}

	// 前序遍历
	public void pretravelCall() {
		System.out.print("Preorder travel: ");
		pretravel(root);
		System.out.println();
	}

	// 删除
	public int delete(int key) {
		Node current = root;
		Node parent = null;
		boolean isLeft = false;

		// 找到要删除的key的位置current和它的parent
		while(current != null) {
			if(key == current.data)
				break;

			else if(key > current.data) {
				parent = current;
				isLeft = false;
				current = current.right;
			}

			else {
				parent = current;
				isLeft = true;
				current = current.left;
			}
		} // end while

		if(current == null) {
			System.out.println("the key you specified is not exist!");
			return -999;
		}

		Node deleN, succDele;

		// 1.若要删除的节点既没有左子树也没有右子树，直接删除此节点即可
		// 2.若要删除的节点有一个子树，则让被删节点的parent连上这个子树即可
		// 3.若要删除的节点有两颗子树，则用将删节点的后继替代将删节点，并且将此的后继的子树给此后继的parent
		if(current.left == null || current.right == null)
			deleN = current;
		else {
			// 若要删除的节点有两颗子树，则被删节点变为本来要删的节点的后继，parent,isleft相应改变
			// 此时此后继是没有左子树的
			deleN = successor(current)[0];
			parent = successor(current)[1];
			if(deleN == parent.left)
				isLeft = true;
			else
				isLeft = false;
		}

		if(deleN.left != null)
			// 被删节点的左子树不为空，被删节点属于2中的一种情况
			succDele = deleN.left;
		else
			// 1（deleN.right=null）或者3的情况
			succDele = deleN.right;

		// 如果被删的节点是根、根的左子树、根的右子树
		if(deleN == root)
			root = succDele;
		else if(isLeft)
			parent.left = succDele;
		else if(!isLeft)
			parent.right = succDele;

		int deleData = current.data;

		// 第3种情况中，替换
		if(current.data != deleN.data)
			current.data = deleN.data;

		System.out.println(deleData + " delete sucessed!");
		return deleData;

	} // end delete

	// 只针对节点的右子树查找后继，（不是完全的后继）
	public Node [] successor(Node x) {
		Node [] result = new Node[3];
		Node current = x.right;
		Node parent = current;
		Node papa = current;

		while(current != null) {
			papa = parent;
			parent = current;
			current = current.left;
		}
			
		result[0] = parent;
		result[1] = papa;

		return result;
	}
} // end class BinaryTree


// 测试类
class binaryApp {
	public static void main(String [] args) throws IOException {
		int root, key;
		char ch;
		putText("Enter root key of binary tree: ");
		root = getInt();
		BinaryTree theBT = new BinaryTree(root);

		while(true) {
			putText("Enter operation levelTravel, mintravel, pretravel, insert, delete, find: ");
			ch = getChar();

			switch(ch) {
				case 'l':
				theBT.levelTravel();
				break;
				
				case 'm':
				theBT.intravelCall();
				break;

				case 'p':
				theBT.pretravelCall();
				break;

				case 'i':
				putText("Enter key you want to insert: ");
				key = getInt();
				theBT.insert(key);
				break;

				case 'd':
				putText("Enter key you want to delete: ");
				key = getInt();
				theBT.delete(key);
				break;

				case 'f':
				putText("Enter key you want to find: ");
				key = getInt();
				theBT.find(key);
				break;

				default:
				putText("invalid entry!" + '\n');
				break;
			} // end switch
		} // end while 
	} // end main

	public static void putText(String str) {
		System.out.print(str);
		System.out.flush();
	}

	public static String getString() throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		return str;
	}

	public static char getChar() throws IOException {
		String str = getString();
		return str.charAt(0);
	}

	public static int getInt() throws IOException {
		String str = getString();
		return Integer.parseInt(str);
	}
} // end class binaryApp
