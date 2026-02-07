/**
  * Implements the Stack Abstract Data Type, that is, a data container that
  * enforces the Last In First Out (LIFO) data handling policy.
  *
  * @param <E> the parametric type of the stack elements
  * @see Stack
  * @see EmptyStackException
  *
  * @author A. Luchetta
  * @version 07-Jan-2026
  */
// implementation by linked list
public class S<E> implements Stack<E>
{   
   // instance variables
   private ListNode head;     // tail node is not necessary
   private int size;          // stack element counter
   
   // inner class ListNode
   private class ListNode
   {
      // instance variable
      private E element;
      private ListNode next;
      
      // constructors
      public ListNode(E anElement, ListNode aNode)
      {
         setElement(anElement);
         setNext(aNode);
      }
      
      public ListNode()
      {
         this(null, null);
      }
      
      // accessor methods
      public E getElement() { return element; }
      public ListNode getNext() { return next; }
      
      // mutator methods
      public void setElement(E e) { element =  e; }      
      public void setNext(ListNode n) { next = n;}
   }
   
   /**
      Constructs an empty stack.
   */
   public S()
   {
      // initialize linked list
      head = new ListNode();
      
      // initialize element counter
      size = 0;
   }
   
   /**
      Returns the minimum element in this stack based on the natural order
      of stack elements.
      @return the minimum element in this stack.
      @throws EmptyStackException if this stack is empty.
   */
   public E getMin()
   {
      // check preconditions
      if (isEmpty())
      {
         throw new EmptyStackException("missing maximum element in empty stack");
      }
      
      // search for minimum
      ListNode tmp = head.getNext(); // auxiliary list node
      E curMin = tmp.getElement();  // assumes that min element is at index 0
      while (tmp.getNext() != null)
      {
         // select current element
         Comparable curItem = (Comparable)tmp.getNext().getElement();

         // check if current element is new minimum         
         if (curItem.compareTo(curMin) < 0)
         {
            curMin = (E)curItem; 
         }
         
         // move auxiliary list node forward
         tmp = tmp.getNext();
      }
      
      return curMin;
   }

   /**
      Returns true if this stack contains no elements.
      @return true if this stack contains no elements.
   */
   public boolean isEmpty()
   {
      return size <= 0;    
   }
   
   /**
      Returns the number of elements in this stack.
      @return the number of elements in this stack.
   */
   public int size()
   {
      return size;
   }
   
   /**
     Removes the object at the top of this stack and returns it.
     @return the object at the top of this stack.
     @throws EmptyStackException if this stack is empty.
   */  
   public E pop() throws EmptyStackException
   {
      // take advantage of top method
      E curTop = top();   // can throw EmptyStackException
      
      // remove top-most element - like removeFirst
      head = head.getNext();
      head.setElement(null);
      
      // update stack element counter
      size--;
           
      return curTop;
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
      // check preconditions - null element cannot be pushed into this stack
      if (element == null)  
      {
         throw new IllegalArgumentException("element is null");
      }
      
      if (!(element instanceof Comparable)) // non Comparable elements cannot 
      {                                     // be pushed into this stack
         throw new ClassCastException("element is not Comparable");
      }
      
      // push new element - like addFirst
      head.setElement(element);
      head = new ListNode(null, head);
     
      // update stack element counter
      size++;
   }

   /**
     Looks at the object at the top of this stack without removing it from the
     stack.
     @return the object at the top of this stack.
     @throws EmptyStackException if this stack is empty.
   */ 
   public E top() throws EmptyStackException
   {
      // check preconditions
      if (isEmpty())
      {
         throw new EmptyStackException();
      }
      
      // select stack top-most element
      E curTop = head.getNext().getElement();   // type cast is needed
      
      return curTop;
   }
}
