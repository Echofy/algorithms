package datastru.cla;

class Queue
{
	private int [] qArr;
	private int maxSize;
	private int front;
	private int rear;
	private int nItems;

	public Queue(int mx)
	{
		maxSize = mx;
		qArr = new int[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	public void insert(int value)
	{
		if(rear == maxSize-1)
			rear = -1;

		qArr[++rear] = value;
		nItems ++;
	}

	public int remove()
	{
		int temp = qArr[front];

		if(++front == maxSize)
			front = 0;

		nItems --;

		return temp;
	}

	public int peekFront()
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

class QueueApp
{
	public static void main(String [] args)
	{
		Queue theQueue = new Queue(10);

		theQueue.insert(19);
		theQueue.insert(64);
		theQueue.insert(36);
		theQueue.insert(95);
		theQueue.insert(33);
		theQueue.insert(53);
		theQueue.insert(27);

		theQueue.remove();

		while(!theQueue.isEmpty())
		{
			System.out.print(theQueue.remove() + " ");
		}

	} // end main
} // end class QueueApp

