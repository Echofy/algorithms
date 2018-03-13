// heap sort from introduce of algorithm

// create class heap
class Heap
{
	private int [] theHeap;
	private int maxSize;
	private int curSize;

	public Heap(int mxS)
	{
		maxSize = mxS;
		curSize = 0;
		theHeap = new int[maxSize];
	}

	public void cpArray(int [] arr)
	{
		int arrLen = arr.length;

		if(arrLen >= maxSize)
			arrLen = maxSize;

		for(int i = 0; i < arrLen; i++)
			theHeap[i] = arr[i];
		curSize = arrLen;
	}

	public void insert(int value)
	{
		if(curSize < maxSize)
			theHeap[curSize++] = value;
	}

	public void keepMaxHeap(int parent)
	{		
		int left = parent * 2;
		int right = left + 1;
		int top = theHeap[parent-1];
		int largest = parent;

		if(left <= curSize && theHeap[parent-1] < theHeap[left-1])
			largest = left;
		else
			largest = parent;

		if(right <= curSize && theHeap[right-1] > theHeap[largest-1])
			largest = right;

		if(parent != largest)
		{
			theHeap[parent-1] = theHeap[largest-1];
			theHeap[largest-1] = top;
			keepMaxHeap(largest);
		}
		
	} // end keepMaxHeap

	// build heap
	public void buildHeap()
	{
		for(int i = curSize/2; i >= 1; i--)
			keepMaxHeap(i);
	}

	// heap sort 
	public void heapSort()
	{
		int curSizeBk = curSize;
		buildHeap();

		for(int i = curSize; i > 0; i--)
		{
			int top = theHeap[0]; 
			theHeap[0] = theHeap[--curSize];
			theHeap[curSize] = top;
			buildHeap();
		}
		curSize = curSizeBk;
	}

	// display
	public void display()
	{
		// array format display
		System.out.print("heapArray: ");
		for(int i = 0; i < curSize; i++)
			System.out.print(theHeap[i] + " ");
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

			System.out.print(theHeap[j]);

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


// class HeapApp
class HeapApp_alg
{
	public static void main(String [] args)
	{
		Heap heap = new Heap(40);
		int [] arr = {21,34,56,72,98,42,59,66,13,16,80,30,73};

		heap.cpArray(arr);

		heap.display();

		heap.buildHeap();

		heap.display();

		/*heap.insert(99);

		heap.display();*/

		heap.heapSort();

		heap.display();

	} // end main

} // end class HeapApp