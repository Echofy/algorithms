package datastru.cla;

// Link List

// 节点
class Link {
	public int key;
	public Link prev;
	public Link next;

	public Link(int value) {
		key = value;
		prev = null;
		next = null;
	}
}

// 链表
class LinkList {
	private Link head;

	public LinkList() {
		head = null;
	}

	// 判断链表是否为空
	public boolean isEmpty() {
		return (head == null);
	}

	// 插入第一个元素
	public void insertFirst(int value) {
		Link link = new Link(value);
		link.next = head;
		head = link;
	}

	// 插入
	public void insert(int value) {
		if(head == null)
			head.next = null;
		Link link = new Link(value);

		if(head.next != null)
			head.next.prev = link;
		link.next = head.next;
		head.next = link;
	}

	// 查找
	public Link search(int value) {
		Link first = head.next;

		while(first != null && first.key != value)
			first = first.next;

		return first;
	}

	// 删除
	public boolean delete(int value) {
		Link link = search(value);

		if(link == null)
			return false;

		if(link.prev == null)
			link.prev = head;
		link.prev.next = link.next;
		if(link.next != null)
			link.next.prev = link.prev;

		return true;
	}

	// 显示
	public void display() {
		for(Link start = head.next; start != null; start = start.next)
			System.out.print(start.key + " ");
	 	System.out.println();
	}
} // end class linkList


// 测试类
class linklistApp {
	public static void main(String [] args) {
		LinkList linklist = new LinkList();

		linklist.insertFirst(32);

		linklist.insert(20);
		linklist.insert(40);
		linklist.insert(60);
		linklist.insert(30);
		linklist.insert(10);
		linklist.insert(70);
		linklist.insert(50);

		linklist.display();

		linklist.delete(40);

		linklist.display();
	} // end main
} // end class linklistApp