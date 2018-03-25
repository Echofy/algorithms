package ans.cla;

import java.lang.Integer;
import java.io.*;

class Node
{
	public int data;
	public Node left;
	public Node right;

	public Node(int _data)
	{
		data = _data;
		left = null;
		right = null;
	}
} // end class Node 

class QueueNode
{
	private Node [] qArr;
	private int maxSize;
	private int front;
	private int rear;
	private int nItems;

	public QueueNode(int mx)
	{
		maxSize = mx;
		qArr = new Node[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	public void insert(Node value)
	{
		if(rear == maxSize-1)
			rear = -1;

		qArr[++rear] = value;
		nItems ++;
	}

	public Node remove()
	{
		Node temp = qArr[front];

		if(++front == maxSize)
			front = 0;

		nItems --;

		return temp;
	}

	public Node peekFront()
	{
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

class BinaryTree
{
	private Node root;

	public BinaryTree(int key)
	{
		root = new Node(key);
	}

	public void cpTree(Node _root)
	{
		root = _root;
	}

	public boolean find(int key)
	{
		Node current = root;

		while(current != null)
		{
			if(current.data == key)
			{
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

	public boolean insert(int key)
	{
		Node keyNode = new Node(key);
		Node current = root;
		Node parent = current;
		boolean isLeft = true;

		while(current != null)
		{
			if(key > current.data)
			{
				parent = current;
				isLeft = false;
				current = current.right;
			}
				
			else if(key == current.data)
			{
				System.out.println("duplicate key!");
				return false;
			}

			else
			{
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



	public void levelTravel()
	{
		QueueNode theQueue = new QueueNode(20);
		Node re;

		theQueue.insert(root);

		System.out.print("level travel: ");

		while(!theQueue.isEmpty())
		{
			re = theQueue.remove();
			System.out.print(re.data + " ");

			if(re.left != null)
				theQueue.insert(re.left);

			if(re.right != null)
				theQueue.insert(re.right);
		}

		System.out.println();
	} // end levelTravel

	// recurtion way to inorder travel
	public void intravel(Node x)
	{
		if(x != null)
		{
			intravel(x.left);
			System.out.print(x.data + " ");
			intravel(x.right);
		}
	}

	public void intravelCall()
	{
		System.out.print("Inorder travel: ");
		intravel(root);
		System.out.println();
	}

	public void pretravel(Node x)
	{
		if(x != null)
		{
			System.out.print(x.data + " ");
			pretravel(x.left);
			pretravel(x.right);
		}
	}

	public void pretravelCall()
	{
		System.out.print("Preorder travel: ");
		pretravel(root);
		System.out.println();
	}

	public int delete(int key)
	{
		Node current = root;
		Node parent = current;
		boolean isLeft = false;

		while(current != null)
		{
			if(key == current.data)
				break;

			else if(key > current.data)
			{
				parent = current;
				isLeft = false;
				current = current.right;
			}

			else
			{
				parent = current;
				isLeft = true;
				current = current.left;
			}
			
		} // end while

		if(current == null)
		{
			System.out.println("the key you specified is not exist!");
			return -999;
		}

		Node deleN, succDele;

		if(current.left == null || current.right == null)
			deleN = current;
		else
		{
			deleN = successor(current)[0];
			parent = successor(current)[1];
		}

		if(deleN.left != null)
			succDele = deleN.left;
		else
			succDele = deleN.right;

		if(deleN == null)
			root = succDele;
		else if(isLeft)
			parent.left = succDele;
		else
			parent.right = succDele;

		if(current.data != deleN.data)
			current.data = deleN.data;

		System.out.println(current.data + " delete sucessed!");
		return current.data;

	} // end delete

	// successor just with right part
	public Node [] successor(Node x)
	{
		Node [] result = new Node[3];
		Node current = x.right;
		Node parent = current;
		Node papa = parent;

		while(current != null)
		{
			papa = parent;
			parent = current;
			current = current.left;
		}
			
		result[0] = parent;
		result[1] = papa;

		return result;
	}

} // end class BinaryTree

// binary tree test program
class binaryApp
{
	public static void main(String [] args) throws IOException
	{
		int root, key;
		char ch;
		putText("Enter root key of binary tree: ");
		root = getInt();
		BinaryTree theBT = new BinaryTree(root);

		while(true)
		{
			putText("Enter operation levelTravel, mintravel, pretravel, insert, delete, find: ");
			ch = getChar();

			switch(ch)
			{
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

	public static void putText(String str)
	{
		System.out.print(str);
		System.out.flush();
	}

	public static String getString() throws IOException
	{ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		return str;
	}

	public static char getChar() throws IOException
	{
		String str = getString();
		return str.charAt(0);
	}

	public static int getInt() throws IOException
	{
		String str = getString();
		return Integer.parseInt(str);
	}
	
} // end class binaryApp
