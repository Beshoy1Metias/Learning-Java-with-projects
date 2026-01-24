public class Q<T> implements Queue<T>
{
	private ListNode head;
	private ListNode tail;
	private int length;
	private T removeFirst()
	{
		T ele = head.getNext().getElement();
		head.getNext().setElement(null);
		head= head.getNext();
		length--;
		return ele;
	}
	private void addLast(T x)
	{
		ListNode n = new ListNode(x, null);
		tail.setNext(n);
		tail = n;
		length++;
	}
	private class ListNode
	{
		private T element;
		private ListNode next;
		public ListNode(T e, ListNode n)
		{
			setElement(e);
			setNext(n);
		}
		public ListNode()
		{
			this(null, null);
		}
		private void setElement(T e){element = e;}
		private void setNext(ListNode n){next =n;}
		private ListNode getNext(){return next;}
		private T getElement(){return element;}
	}
	public Q()
	{
		head = tail = new ListNode();
		head.setNext(tail);
		length = 0;
	}
   /*
      removes the front item from this queue and returns it 
      @return the front item removed from this queue
      @throws EmptyQueueException if this queue is empty
   */
   public T dequeue() throws EmptyQueueException
   {
	   if(isEmpty()){throw new EmptyQueueException();}
	   return removeFirst();
   }   
   
   /**
      inserts the specified item into this queue
      @param x the specified item to be inserted
      @throws java.lang.IllegalArgumentException if the specified item is null
   */
   public void enqueue(T x) throws IllegalArgumentException
   {
	   if(x==null){throw new IllegalArgumentException();}
	   addLast(x);
   } 
   
   /**
      returns the front item of this queue
      @return the front item of this queue
      @throws EmptyQueueException if this queue is empty
   */
   public T front() throws EmptyQueueException
   {
	   if(isEmpty()){throw new EmptyQueueException();}
	   return head.getNext().getElement();
   }
   
  /**
      checks if this queue is empty
      @return true if this queue is empty
   */
   public boolean isEmpty()
   {
	   return length<=0;
   }
   
   /**
      returns the number of items in this queue
      @return number of items in this queue
   */
   public int size()
   {
	   return length;
   }   
   
   /**
      returns an array containing the items of this queue in the FIFO
      sequence with the front of this queue at index zero. The size of the array
      is equal to the number of items in this queue 
      @return an array containing the items of this queue, if the queue is
              not empty, otherwise an empty array
   */
   public Object[] toArray()
   {
	   Object[] arr = new Object[length];
	   ListNode n = head.getNext();
	   for(int i=0; i<length; i++)
	   {
		   arr[i]=n.getElement();
		   n=n.getNext();
	   }
	   return arr;
   }
}