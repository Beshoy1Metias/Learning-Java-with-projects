/**
  * Foundation of Computer Science - Group 2
  * Programming test - 16-07-2018
  *
  * Implements a stack by using a linked list
  * 
  * @param T the parametric data type of the stack data items
  * @see Stack
  * @see EmptyStackException
*/
public class S<T> implements Stack<T>
{

   // instance variables
   private ListNode head;   // tail is useless!
   private int size;
   
   // inner class
   private class ListNode
   {
      // instance variables
      private T element;      // parametric data type
      private ListNode next;
      
      // constructs a list node with the specified data item and next list node
      public ListNode(T e, ListNode n)
      {
         setElement(e);
         setNext(n);
      }
      
      // constructs an empty list node (data item and next fields are null)
      public ListNode()
      {
         this(null, null);
      }
      
      // accessor methods
      public T getElement() { return element; }
      public ListNode getNext() { return next; }
      
      // mutator methods
      public void setElement(T e) { element = e; }
      public void setNext(ListNode n) { next = n; }
   }
   
   /**
      Constructs an empty stack
   */
   public S()
   {
      makeEmpty();
   }
   
   /**
      Checks if this container is empty
      @return true if this container is empty
   */
   public boolean isEmpty()
   {
      return size <= 0;
   }

   /**
      Makes this container empty
   */
   public void makeEmpty()
   {
       head = new ListNode();
       size = 0;     
   }
  
   /**
      Returns the number of data items in this container
      @return the number of data items in this container
   */
   public int size()
   {
      return size;
   }
  
   /**
      Inserts the specified item on top of this stack
      @param o the specified item
   */
    public void push(T o) //- corresponds to method addFirst
    {        
       // insert data item into linked list
       head.setElement(o);

       // update header
       head = new ListNode(null, head);
      
       // update the element counter 
       size++;     
    }
   
   /**
      Inspect the item at the top of this stack
      @return the item at the top of this stack
      @throws EmptyStackException if this stack is empty
   */
    public T top() throws EmptyStackException // corresponds to method getFirst
    {
       // preconditions
       if (isEmpty())
          throw new EmptyStackException();
         
       // returning the element inspected
       return head.getNext().getElement();
    }

   /**
      Removes the item from the top of this stack
      @return the item removed
      @throws EmptyStackException if the stack is empty
   */
    public T pop()throws EmptyStackException// corresponds to method removeFirst
    {
       // temporarily storing the element to remove
       T x = top();            // can throw EmptyStackException
       
       // updating the header
       head = head.getNext();

       // removing the data item
       head.setElement(null);     
      
       // updating the element counter
       size--;
      
       return x;
    }
    
    /**
       Provides the textual description of this stack consisting of a string
       in which the stack elements are in LIFO sequence separated by a space
       character
       @return tectual description
    */
    public String toString()
    {
       // return string
       String s = "";
       
       // traversing the stack in LIFO sequence
       ListNode n = head.getNext();  // starts from the next node of head
       while (n != null)             // checks if the end of the linked list 
       {                             // has been reached
          s = s + " " + n.getElement(); // concatenation of the data item in 
                                        // the current list node
          n = n.getNext();              // advance to the next list node
       }
          
       return s;   
    } 
}
