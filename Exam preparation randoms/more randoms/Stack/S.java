public class S<E> implements Stack<E>
{
	private ListNode head;
	private int length;
	private class ListNode
	{
		E element;
		ListNode next;
		public ListNode(E e, ListNode n)
		{
			setElement(e);
			setNext(n);
		}
		public ListNode(){this(null,null);}
		private void setElement(E e){element = e;}
		private void setNext(ListNode n){next = n;}
		private E getElement(){return element;}
		private ListNode getNext(){return next;}
	}
	private void addFirst(E e)
	{
		head.setElement(e);
		ListNode n = new ListNode(null, head);
		head = n;
		length++;
	}
	private E removeFirst()
	{
		E removed = head.getNext().getElement();
		head = head.getNext();
		head.setElement(null);
		length--;
		return removed;
	}
	public S()
	{
		length=0;
		head = new ListNode();
	}
	
   /**
      Returns the minimum element in this stack based on the natural order
      of the elements of this stack.
      @return the minimum element in this stack.
      @throws EmptyStackException if this stack is empty.
   */
   public E getMin()
   {
	   if(isEmpty()){throw new EmptyStackException();}
	   E min = top();
	   ListNode n = head.getNext();
	   while(n!=null)
	   {
		   if(((Comparable)n.getElement()).compareTo(min)<0){min = n.getElement();}
		   n = n.getNext();
	   }
	   return min;
	   
   }

   /**
      Returns true if this stack contains no elements.
      @return true if this stack contains no elements.
   */
   public boolean isEmpty()
   {
	   return length<=0;
   }
   
   /**
      Returns the number of elements in this stack.
      @return the number of elements in this stack.
   */
   public int size()
   {
	   return length;
   }
   
   /**
     Removes the element at the top of this stack and returns it.
     @return the element at the top of this stack.
     @throws EmptyStackException if this stack is empty.
   */  
   public E pop() throws EmptyStackException
   {
	   if(isEmpty()){throw new EmptyStackException();}
	   return removeFirst();
   }
   
   /**
     Pushes an element onto the top of this stack.
     @param element the element to be pushed onto this stack.
     @throws java.lang.IllegalArgumentException if the specified element is
            null.
     @throws java.lang.ClassCastException if the data type of the specified
            element is not a class that implements the Comparable interface.
   */
   public void push(E element)
   {
	   if(element==null){throw new IllegalArgumentException();}
	   addFirst(element);
   }

   /**
     Looks at the element at the top of this stack without removing it from the
     stack.
     @return the element at the top of this stack.
     @throws EmptyStackException if this stack is empty.
   */ 
   public E top() throws EmptyStackException
   {
	   if(isEmpty()){throw new EmptyStackException();}
	   return head.getNext().getElement();
   }
}