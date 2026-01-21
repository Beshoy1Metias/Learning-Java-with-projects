public class S<T> implements Stack<T>
{
	private ListNode head;
	private ListNode tail;
	private int length;
	private void addFirst(T e)
	{
		head.setElement(e);
		head = new ListNode(null, head);
		
	}
	private T removeFirst()
	{
		T ele = head.getNext().getElement();
		head.getNext().setElement(null);
		head = head.getNext();
		return ele;
	}
	
	private class ListNode
	{
		T element;
		ListNode next;
		public ListNode(T e, ListNode n)
		{
			setElement(e);
			setNext(n);
		}
		public void setNext(ListNode e){next = e;}
		public void setElement(T e){element=e;}
		public T getElement(){return element;}
		public ListNode getNext(){return next;}
	}
	public S()
	{
		makeEmpty();
	}
	   /**
      Removes the object at the top of this stack and returns it
      @return the object at the top of this stack
      @throws EmptyStackException if this stack is empty
   */
   public T pop()throws EmptyStackException
   {
	   if(isEmpty())
	   {
		   throw new EmptyStackException();
	   }
	   T removed =removeFirst();
	   length--;
	   return removed;
   }
   
   /**
      Pushes an item onto the top of this stack, if not null
      @param item the item to be pushed onto this stack
      @throws IllegalArgumentException if the item to be pushed is null
   */
   public void push(T item)
   {
	   if(item == null){throw new EmptyStackException();}
	   addFirst(item);
	   length++;
   }
   
   /**
      Returns the position of an object in the stack. If the object x is present
      in the stack, the method returns the distance from the top of the stack to
      the nearest occurrence of x. The topmost item on the stack is considered
      to be at distance 0.
      @param x the desired object
      @return the position from the top of the stack where the object is
              located; -1 indicates that the object is not in this stack.    
   */
   public int search(T x)
   {
	   ListNode n = head;
	   int i=0;
	   while(n.getNext()!=null)
	   {
		   if(n.getNext().getElement().equals(x))
		   {
			   return i;
		   }
		   i++;
		   n=n.getNext();
	   }
	   return -1;
   }
     
   /**
      Looks at the object at the top of this stack without removing it
      @return the object at the top of this stack
      @throws EmptyStackException if this stack is empty
   */
   public T top() throws EmptyStackException
   {
	   if(isEmpty())
	   {
		   throw new EmptyStackException();
	   }
	   
	   
	   return head.getNext().getElement();
   }
      /**
      Checks if this container is empty
      @return true if this container is empty
   */
   public boolean isEmpty()
   {
	   return length<=0;
   }

   /**
     Makes this container empty
   */
   public void makeEmpty()
   {
	   head = new ListNode(null, null);
	   tail = new ListNode(null, null);
		
   }
   
   /**
      Returns the size of this container
      @return  the number of items in this container
   */
   public int size()
   {
	   return length;
   }
}