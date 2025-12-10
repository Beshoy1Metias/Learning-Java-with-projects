public class LinkedListStack implements Stack
{
	public int size;
	public ListNode head, tail;
	private class ListNode
	{
		private Object element;
		private ListNode next;
		private ListNode(Object anElement, ListNode aNode)
		{
			setElement(anElement);
			setNext(aNode);
		}
		private ListNode()
		{
			this(null, null);
		}
		private Object getElement(){return element;}
		private ListNode getNext(){return next;}
		private void setElement(Object e){element = e;}
		private void setNext(ListNode e){next = e;}
		
	}
	public void addFirst(Object e)
	{
		head.setElement(e);
		head = new ListNode(null, head);
	}
	public Object getfirst()
	{
		return head.getNext().getElement();
	}
	public Object removeFirst()
	{
		Object tmp = getfirst();
		head = head.getNext();
		head.setElement(null);
		return tmp;
	}
	
	
	public LinkedListStack()
	{
		makeEmpty();
	}
	public void push(Object obj)
	{
		size++;
		addFirst(obj);
	}
	public Object pop() throws EmptyStackException
	{
		size--;
		Object tmp = getfirst();
		removeFirst();
		return tmp;
	}
	public Object top() throws EmptyStackException
	{
		return getfirst();
	} 
	public boolean isEmpty()
	{
		return head == tail;
	}
	public void makeEmpty()
	{
		head = tail = new ListNode();
		size=0;
	}	
	public int size()
	{
		return size;
	}
}