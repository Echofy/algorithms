// split an array to four equal sum part

class QuaArray
{
	private int [] arr;
	private int maxSize;
	private int curSize;

	public QuaArray(int mxS)
	{
		maxSize = mxS;
		curSize = 0;
		arr = new int[maxSize];
	}

	public void cpArray(int [] arrCp)
	{
		int arrLen = arrCp.length;

		if(arrLen > maxSize)
			arrLen = maxSize;

		for(int i = 0; i < arrLen; i++)
			arr[i] = arrCp[i];

		curSize = arrLen;
	}

	public void quaSplit()
	{
		int sum = 0;
		int maxPer = curSize -3;

		for(int i = 0; i < curSize; i++)
			sum += arr[i];

		int perArray = sum / 4;

		for()

	}

}// end class QuaArray