package datastru.cla;

// create class priority queue

class PriorityQ {
	private int [] prioArr;
	private int maxSize;
	private int nItem;

	public PriorityQ(int mS) {
		maxSize = mS;
		prioArr = new int[maxSize];
		nItem = 0;
	}

	// 插入
	public void insert(int value) {
		int i;

		if(nItem == 0)
			prioArr[nItem++] = value;

		else {
			for(i = nItem-1; i >=0; i--)
				if(prioArr[i] > value)
					prioArr[i+1] = prioArr[i];
				else
					break;
			prioArr[i+1] = value;
			nItem++;
		}
	}

	// 删除
	public int remove() {
		return (prioArr[--nItem]);
	}

	// 返回最小值
	public int peekMin() {
		return (prioArr[nItem-1]);
	}

	// 返回最大值
	public int peekMax() {
		return (prioArr[0]);
	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return (nItem == 0);
	}

	public boolean isFull() {
		return (nItem == maxSize);
	}

} // end class PriorityQ

// 测试类
class PriorityQApp {
	public static void main(String [] args) {
		PriorityQ prioQ = new PriorityQ(10);

		prioQ.insert(12);
		prioQ.insert(45);
		prioQ.insert(38);
		prioQ.insert(20);
		prioQ.insert(91);
		prioQ.insert(4);

		prioQ.remove();

		while(!prioQ.isEmpty()) {
			System.out.print(prioQ.remove() + " ");
		}
	} // end main
} // end class PriorityQApp