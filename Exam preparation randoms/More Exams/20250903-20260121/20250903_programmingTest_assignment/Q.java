public class Q implements Queue
{
	public Q()
	{
		makeEmpty();	
	}
	private ListNode head, tail;
	private int length;
	private void addLast(Comparable x)
	{
		ListNode n = new ListNode(x, null);
		tail.setNext(n);
		tail = tail.getNext();
		length++;
	}
	private Comparable removeFirst()
	{
		Comparable ele = head.getNext().getElement();
		head = head.getNext();
		head.setElement(null);
		length--;
		return ele;
	}
	private class ListNode
	{
		private ListNode next;
		private Comparable element;
		public ListNode(Comparable e, ListNode n)
		{
			setElement(e);
			setNext(n);
		}
		public ListNode()
		{
			this(null, null);
		}
		private void setElement(Comparable e){element=e;}
		private void setNext(ListNode n){next = n;}
		private ListNode getNext(){return next;}
		private Comparable getElement(){return element;}
	}
	/**
      Returns true if this queue contains the specified comparable item
      @param item the item to be checked
      @return true if this queue contains the specified item 
   */
   public boolean contains(Comparable item)
   {
	   ListNode n = head.getNext();
	   while(n.getNext()!=null)
	   {
		   if(item.equals(n.getElement())){return true;}
	   }
	   return false;
   }
   
   /**
      Removes the front item from this queue and returns it.
      @return the removed front item of this queue or null if the this queue is empty.
   */
   public Comparable dequeue()
   {
	   if(isEmpty()){return null;}
	   return removeFirst();
   }
   
   /**
      Inserts the specified comparable item into this queue.
      @param item the specified item to be inserted.
      @throws java.lang.IllegalArgumentException if the specified item is null.
   */
   public void enqueue(Comparable item) throws IllegalArgumentException
   {
	   if(item == null){throw new IllegalArgumentException();}
	   addLast(item);
   } 
   
   /**
      Returns the front item of this queue.
      @return the front item of this queue or null if this queue is empty.
   */
   public Comparable front()
   {
	   if(isEmpty()){return null;}
	   return head.getNext().getElement();
   }
   
  /**
      Checks if this queue is empty.
      @return true if this queue is empty.
   */
   public boolean isEmpty()
   {
	   return length<=0;
   }
   
   /**
      Makes this queue empty.
   */
   public void makeEmpty()
   {
	   head = tail = new ListNode();
	   head.setNext(tail);
	   length=0;
   }
   
   /**
      Returns the maximum item in this queue according to the natural ordering
      of the comparable elements of this queue.
      @return the maximum data item in this queue or null if it is empty.
   */
   public Comparable maxItem()
   {
	   if(isEmpty()){return null;}
	   Comparable max = front();
	   ListNode n = head.getNext();
	   while(n.getNext()!= null)
	   {
		   if(max.compareTo(n.getElement())<0){max =n.getElement();}
		   n = n.getNext();
	   }
	   return max;
   }
   
   /**
      Returns the number of items in this queue.
      @return number of items in this queue.
   */
   public int size()
   {
	   return length;
   } 
}