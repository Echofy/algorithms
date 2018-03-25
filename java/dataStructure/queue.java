package datastru.cla;

// Queue

class Queue {
	private int [] qArr;
	private int maxSize;
	private int front;
	private int rear;
	private int nItems;

	public Queue(int mx) {
		maxSize = mx;
		qArr = new int[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	// 入队列
	public void enqueue(int value) {
		if(rear == maxSize-1)
			rear = -1;

		qArr[++rear] = value;
		nItems ++;
	}

	// 出队列
	public int dequeue() {
		int temp = qArr[front];

		if(++front == maxSize)
			front = 0;

		nItems --;

		return temp;
	}

	// 访问队列元素
	public int peekFront() {
		return qArr[front];
	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return (nItems == 0);
	}

	// 判断队列是否已满
	public boolean isFull() {
		return (nItems == maxSize);
	}
} // end class Queue

class QueueApp {
	public static void main(String [] args) {
		Queue theQueue = new Queue(10);

		theQueue.enqueue(19);
		theQueue.enqueue(64);
		theQueue.enqueue(36);
		theQueue.enqueue(95);
		theQueue.enqueue(33);
		theQueue.enqueue(53);
		theQueue.enqueue(27);

		theQueue.dequeue();

		while(!theQueue.isEmpty()) {
			System.out.print(theQueue.dequeue() + " ");
		}
	} // end main
} // end class QueueApp

