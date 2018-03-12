// link list

// create class Node
class Link
{
	public int key;
	public Link prev;
	public Link next;

	public Link(int value)
	{
		key = value;
		prev = null;
		next = null;
	}
}

// create class link table
class LinkList
{
	private Link head;

	public LinkList()
	{
		//head = new Link(0);
		head = null;
	}

	public void insert(int value)
	{
		if(head == null)
			head.next = null;
		Link link = new Link(value);

		if(head.next != null)
			head.next.prev = link;
		link.next = head.next;
		head.next = link;
	}

	public Link search(int value)
	{
		Link first = head.next;

		while(first != null && first.key != value)
			first = first.next;

		return first;
	}

	public boolean delete(int value)
	{
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

	public void display()
	{
		for(Link start = head.next; start != null; start = start.next)
			System.out.print(start.key + " ");
	 	System.out.println();
	}

}// end class linkList

// create class to test 
class linklistApp
{
	public static void main(String [] args)
	{
		LinkList linklist = new LinkList();

		linklist.insert(20);
		linklist.insert(40);
		linklist.insert(60);
		linklist.insert(30);
		linklist.insert(10);
		linklist.insert(70);
		linklist.insert(50);
		linklist.insert(90);
		linklist.insert(80);
		linklist.insert(100);

		linklist.display();

	}
}// end class linklistApp