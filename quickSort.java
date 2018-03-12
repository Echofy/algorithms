// quick sort

// create class ArrayQuc
class ArrayQuc
{
	private int [] arrQ;
	private int curSize;
	private int maxSize;

	public ArrayQuc(int mxS)
	{
		maxSize = mxS;
		curSize = 0;
		arrQ = new int[maxSize];
	}

	public void cpArray(int [] arr)
	{
		int arrLen = arr.length;

		if(arrLen >= maxSize)
			arrLen = maxSize;

		for(int i = 0; i < arrLen; i++)
			arrQ[i] = arr[i];

		curSize = arrLen;
	}

	public int getCurSize()
	{
		return curSize;
	}

	public void quickSort(int start, int end)
	{
		if(start < end)
		{
			int pio = partition(start, end);
			quickSort(start, pio-1);
			quickSort(pio+1, end);
		}
	} // end quick sort

	public int partition(int start, int end)
	{
		int pioVal = arrQ[end-1];
		int i = start - 1;
		for(int j = start; j < end; j++)
		{
			if(arrQ[j-1] <= pioVal)
			{
				i += 1;
				int temp = arrQ[i-1];
				arrQ[i-1] = arrQ[j-1];
				arrQ[j-1] = temp;
			}

		} // end for

		if(i == start -1 && arrQ[start-1] <= arrQ[end-1])
			i = end - 1;
		else
		{
			arrQ[end-1] = arrQ[i];
			arrQ[i] = pioVal;
		}
		return i+1;

	} // end partition

	public void display()
	{
		for(int i = 0; i < curSize; i++)
			System.out.print(arrQ[i] + " ");
		System.out.println();
	}

} // end class ArrayQuc


// create class to test
class quickApp
{
	public static void main(String [] args)
	{
		int [] arr =  {2, 5, 4, 43, 21, 65, 102, 99, 7, 18, 30, 48, 66};
		ArrayQuc arrQ = new ArrayQuc(30);

		arrQ.cpArray(arr);

		arrQ.display();

		int end = arrQ.getCurSize();
		//System.out.println(end);
		arrQ.quickSort(1, end);

		arrQ.display();
	}
} // end class quickApp