import java.io.*;
import java.lang.Integer;

// heap sort

// create a node class
class Node 
{
	public int iData;

	public Node(int key)
	{
		iData = key;
	}
} // end class Node

// create class heap
class Heap
{
	// attribute
	private Node [] theHeap;
	private int maxSize;
	private int curSize;

	// constructor
	public Heap(int mS)
	{
		maxSize = mS;
		curSize = 0;
		theHeap = new Node[maxSize];
	}

	// isEmpty
	public boolean isEmpty()
	{
		return(curSize == 0);
	}

	// insert
	public boolean insert(int value)
	{
		if(maxSize == curSize)
		{
			System.out.println("insert faild!");
			return false;
		}

		Node newNode = new Node(value);
		theHeap[curSize++] = newNode;
		trickleUp(curSize);
		return true;
	}

	// trickleUp
	public void trickleUp(int index)
	{
		int parent = index / 2;
		Node bottom = theHeap[index-1];

		while(index > 1 && bottom.iData > theHeap[parent-1].iData)
		{
			theHeap[index-1] = theHeap[parent-1];
			index = parent;
			parent = parent / 2;
		}
		theHeap[index-1] = bottom;
	}

	// remove
	public Node remove()
	{
		Node root = theHeap[--curSize];
		theHeap[0] = root;

		trickleDown(1);

		return root;
	}

	// trickle down
	public void trickleDown(int root)
	{
		int largerChild;	
		Node top = theHeap[root-1];	

		while(root < curSize/2+1)
		{
			int leftChild = 2 * root;
			int rightChild = leftChild + 1;
			
			if(rightChild < curSize+1 && theHeap[rightChild-1].iData>theHeap[leftChild-1].iData)
				largerChild = rightChild;
			else
				largerChild = leftChild;

			if(top.iData >= theHeap[largerChild-1].iData)
				break;

			theHeap[root-1] = theHeap[largerChild-1];
			root = largerChild;
		}
		theHeap[root-1] = top;
	} // end trickleDown 

	// change
	public boolean change(int index, int value)
	{
		if(index > curSize)
		{
			return false;
		}

		int oldValue = theHeap[index].iData;
		theHeap[index].iData = value;

		if(oldValue > value)
			trickleUp(index);
		if(oldValue < value)
			trickleDown(index);

		return true;
	} // end change

	// display
	public void display()
	{
		// array format display
		System.out.print("heapArray: ");
		for(int i = 0; i < curSize; i++)
			if(theHeap[i] != null)
				System.out.print(theHeap[i].iData + " ");
			else
				System.out.print("-- ");
		System.out.println();

		// heap format display
		int nBlanks = 32;
		int itemsPerRow = 1;
		int column = 0;
		int j = 0;
		String dots = ".................................";
		System.out.println(dots+dots);

		while(curSize > 0)
		{
			if(column == 0)
				for(int k = 0; k < nBlanks; k++)
					System.out.print(" ");

			System.out.print(theHeap[j].iData);

			if(++j == curSize)
				break;

			if(++column == itemsPerRow)
			{
				nBlanks /= 2;
				itemsPerRow *= 2;
				column = 0;
				System.out.println();
			}
			else
				for(int k = 0; k<nBlanks*2-2; k++)
					System.out.print(" ");
		} // end while
		System.out.println("\n" + dots + dots);

	} // end display
} // end class Heap

// create test class
class HeapApp
{
	public static void main(String [] args) throws IOException
	{
		Heap theHeap = new Heap(30);
		boolean success;
		int value, index;

		theHeap.insert(19);
		theHeap.insert(65);
		theHeap.insert(7);
		theHeap.insert(34);
		theHeap.insert(72);
		theHeap.insert(41);
		theHeap.insert(38);
		theHeap.insert(4);
		theHeap.insert(128);
		theHeap.insert(32);
		theHeap.insert(99);
		theHeap.insert(57);
		theHeap.insert(23);

		while(true)
		{
			putText("Enter first letter of ");
			putText(" show, insert, remove, change: ");
			int choice = getChar();

			switch(choice)
			{
				case 's':
				theHeap.display();
				break;

				case 'i':
				putText("Enter value to insert: ");
				value = getInt();
				success = theHeap.insert(value);
				if(!success)
					putText("Can't insert; heap is full" + '\n');
				break;

				case 'r':
				if(!theHeap.isEmpty())
					theHeap.remove();
				else
					putText("Can't remove; heap is empty" + '\n');
				break;

				case 'c':
				putText("Enter the index of item: ");
				index = getInt();
				putText("Enter new priority: ");
				value = getInt();
				success = theHeap.change(index, value);
				if(!success)
					putText("Invalid entry\n");
				break;

				default:
				putText("Invalid entry!");
			} // end switch
		} // end while 
	} // end main

	public static void putText(String s)
	{
		System.out.print(s);
		System.out.flush();
	}

	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	public static char getChar() throws IOException
	{
		String s = getString();
		return s.charAt(0);
	}

	public static int getInt() throws IOException
	{
		String s = getString();
		return Integer.parseInt(s);
	}
} // end class HeapSort