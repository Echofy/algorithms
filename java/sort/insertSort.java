// insert sort 

// create an array class 
class ArrayIns
{
	// array attribute
	private double[] a;
    private int nElems;

    // constructor
    public ArrayIns(int max)
    {
    	a = new double [max];
    	nElems = 0;
    }

    // insert 
    public void insert(double value)
    {
    	a[nElems] = value;
    	nElems ++;
    }

    // display
    public void display()
    {
    	for(int j = 0; j < nElems; j++)
    		System.out.print(a[j] + " ");
    	System.out.println(""); 
    }

    // insertion sort 
    public void insertionSort()
    {
    	int out, in;
    	for(out = 1; out < nElems; out++)
    	{
    		double temp = a[out];
    		in = out;
    		while(in > 0 && a[in-1] >= temp)
    		{
    			a[in] = a[in-1];
    			in--;
    		} // end while 
    		a[in] = temp;
    	} // end for 
    } 
} // end class ArrayIns 

// class insertsort test
class InsertSortTest
{
	public static void main(String[] args)
	{
		int maxSize = 100;
		ArrayIns arr = new ArrayIns(maxSize);

		arr.insert(23);
		arr.insert(46);
		arr.insert(89);
		arr.insert(4);
		arr.insert(98);
		arr.insert(65);
		arr.insert(17);
		arr.insert(35);
		arr.insert(9);
		arr.insert(104);
		arr.insert(55);
        
        arr.display();

        arr.insertionSort();

        arr.display();
	} // end main
} // end class InsertSortTest
