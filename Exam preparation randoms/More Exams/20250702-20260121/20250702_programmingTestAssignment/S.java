public class S implements Stack
{
	public S()
	{
		makeEmpty();
	}
	private ListNode head;
	private ListNode tail;
	private int length;
	private void addFirst(Object e)
	{
		head.setElement(e);
		ListNode n = new ListNode(null, head);
		head = n;
		length++;
	}
	private Object removeFirst()
	{
		Object e = head.getNext().getElement();
		head = head.getNext();
		head.setElement(null);
		length--;
		return e;
	}
	private class ListNode
	{
		ListNode next;
		Object element;
		public ListNode(Object e, ListNode n)
		{
			setElement(e);
			setNext(n);
		}
		public ListNode()
		{
			this(null, null);
		}
		private void setElement(Object e){element = e;} 
		private void setNext(ListNode n){next = n;}
		private Object getElement(){return element;}
		private ListNode getNext(){return next;}
	}
   /**
      Checks if this stack contains the specified item.
      @param item the specified item to be checked
      @return true if this stack contains the specified item      
   */
   public boolean contains(Object item)
   {
	   ListNode n = head.getNext();
	   while(n != null)
	   {
		   if ((n.getElement()).equals(item)){return true;}
		   n = n.getNext();
	   }
	   return false;
   }
   
   /**
      Returns true if this stack is empty
      @return true if this stack is empty.
   */
   public boolean isEmpty()
   {
	   return length<=0;
   }
   
   /**
      Makes this set empty.
   */
   public void makeEmpty()
   {
		head = new ListNode();
		length=0;	   
   }

   /**
      Removes the object at the top of this stack and returns that object as
      the value of this function.
      @return The object at the top of this stack.
      @throws EmptyStackException if this stack is empty
   */
   public Object pop() throws EmptyStackException
   {
	   if(isEmpty()){throw new EmptyStackException();}
	   return removeFirst();
   }
   
   /**
      Pushes an item onto the top of this stack, if not null.
      @param item the item to be pushed onto this stack.
   */
   public void push(Object item)
   {
	   if(item == null){return;}
	   addFirst(item);
   }
   
   /**
      Returns the number of item in this stack.
      @return the number of item in this stack
   */
   public int size()
   {
	   return length;
   }
   
   /**
      Looks at the object at the top of this stack without removing it from the
      stack.
      @return the object at the top of this stack.
      @throws EmptyStackException if this stack is empty. 
   */
   public Object top() throws EmptyStackException
   {
	   if(isEmpty()){throw new EmptyStackException();}
	   return head.getNext().getElement();
   }
}