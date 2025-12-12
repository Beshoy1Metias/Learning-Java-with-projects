public class S<T> implements Stack<T>
{
	private ListNode head, tail;
	private int Size =0;
	private class ListNode
	{
		private ListNode next;
		private T element;
		private ListNode()
		{
			this.setElement(null);
			this.setNext(null);
		}
		private void setElement(T e)
		{
			element = e;
		}
		private void setNext(ListNode n)
		{
			next = n;
		}
		private ListNode getNext(){return next;}
		private T getElement(){return (T)element;}
			
	

	}

		private void addFirst(T e)
		{
			ListNode temp = new ListNode();
			temp.setElement(e);
			temp.setNext(head.getNext());
			head.setNext(temp);
			Size++;
		}
		private T getFirst() throws EmptyStackException
		{
			if(isEmpty()){throw new EmptyStackException();}
			return head.getNext().getElement();
		}
		private T removeFirst()
		{
			T tmp = getFirst();
			head.setNext(head.getNext().getNext());
			Size--;
			return tmp;
		}	
	public S()
	{
		makeEmpty();
	}
	@Override
	public int size(){return Size;}
	 
	@Override
	public T top() throws EmptyStackException
	{
		return getFirst();
	}
	
	@Override
	public void push(T item)
	{
		addFirst(item);
	}
	@Override
	public int search(T x){return 0;}
	@Override
	public T pop() throws EmptyStackException
	{
		return removeFirst();
	}
	@Override
	public boolean isEmpty()
	{
		return head==tail;
	}
	@Override
	public void makeEmpty()
	{
		head = new ListNode();
		tail = new ListNode();
		head.setNext(tail);
	}
	

	
}