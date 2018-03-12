// merge sort

// create an array class
class ArrayMer
{
	// attribute
	private double [] arr;
	private int nElems;

	// constructor 
	public ArrayMer(int maxSize)
	{
		arr = new double [maxSize];
		nElems = 0;
	}

	// insert value 
	public void insert(double value)
	{
		arr[nElems] = value;
		nElems++;
	}

	// display
	public void display()
	{
		for(int j = 0; j < nElems; j++)
			System.out.print(arr[j] + " ");
		System.out.println("");
	}

	// merge sort called by main, create a workspace 
	public void mergeSort()
	{
		double [] workspace = new double [nElems];
		recMergeSort(workspace, 0, nElems-1);
	}

	// recurrative merge 
	public void recMergeSort(double [] workspace, int lowerbound, int upperbound)
	{
		if(lowerbound == upperbound)
			return;
		else
		{
			int mid = (lowerbound + upperbound) / 2;	
			recMergeSort(workspace, lowerbound, mid);
			recMergeSort(workspace, mid+1, upperbound);
			merge(workspace, lowerbound, mid, upperbound);
		}
	} // end recMergeSort 

	// merge two array
	public void merge(double [] workspace, int lowerbound, int mid, int upperbound)
	{
		int j = 0; 
		int lowerPtr = lowerbound;
		int n = upperbound - lowerbound + 1;
		//int highPtr = mid+1;

		while(lowerbound <= mid && mid+1 <= upperbound)
		{
			if(arr[lowerbound] < arr[mid+1])
				workspace[j++] = arr[lowerbound++];
			else
				workspace[j++] = arr[++mid];
		}
		while(lowerbound <= mid)
			workspace[j++] = arr[lowerbound++];
		while(mid+1 <= upperbound)
			workspace[j++] = arr[++mid];

		for(j = 0; j <= n; j++)
			arr[lowerPtr++] = workspace[j];
	}

	// merge call
	public void mergeSort2()
	{
		recMergeSort2(0, nElems-1);
	} // end mergeSort2

	// introduction of algorithms 
	public void recMergeSort2(int p, int r)
	{
		if(p < r)
		{
			int q = (p + r) / 2;
			recMergeSort2(p, q);
			recMergeSort2(q+1, r);
			merge2(p, q, r);
		}
	} // end recMergeSort2

	//
	public void merge2(int p, int q, int r)
	{
		int lsize = q-p+1;
		int rsize = r-q;
		double [] larr = new double [lsize+1];
		double [] rarr = new double [rsize+1];

		// distribute arr to 2 arrays 
		for(int i = 0; i < lsize; i++)
			larr[i] = arr[i+p];
		for(int j = 0; j < rsize; j++)
			rarr[j] = arr[j+q+1];

		// set dectect 
		larr[lsize] = Double.POSITIVE_INFINITY;
		rarr[rsize] = Double.POSITIVE_INFINITY;

		// sort
		int i = 0, j = 0, k = p;
		while(k < r+1)
		{
			if(larr[i] < rarr[j])
				arr[k++] = larr[i++];
			else
				arr[k++] = rarr[j++];
		} // end while 
			
	} // end merge2

} // end class ArrayMer


// create class to test 
class MergeSortTest
{
	public static void main(String [] args)
	{
		ArrayMer arr = new ArrayMer(30);

		arr.insert(12);
		arr.insert(32);
		arr.insert(62);
		arr.insert(142);
		arr.insert(82);
		arr.insert(92);
		arr.insert(2);
		arr.insert(22);
		arr.insert(72);
		arr.insert(7);
		arr.insert(46);
		arr.insert(3);
		arr.insert(201);
		arr.insert(77);

		arr.display();

		arr.mergeSort2();

		arr.display();
	} // end main
} // end class test