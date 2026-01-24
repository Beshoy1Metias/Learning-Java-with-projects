/**
  * Foundation of Computer Science - Group 2
  * Programming test - 16-07-2018
  *
  * Implements a stack by using a linked list
  * 
  * @typeparam T the parametric data type of the stack data items
  * @see Stack
  * @see EmptyStackException
*/
public class S<T> implements Stack<T>
{

   // instance variables
   private LinkedList l;
   
   // inner class
   private class ListNode
   {
      // instance variables
      private T element;     // parametric data type
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
      
      // modifier methods
      public void setElement(T e) { element = e; }
      public void setNext(ListNode n) { next = n; }
   }
   
   // inner class LinkedList
   // implements only the methods that act at the beginning of the linked list
   private class LinkedList
   {
      // instance variables
      private ListNode head;
      int size;
      
      // construct an empty linked list
      public LinkedList()
      {
         head = new ListNode();
      }
      
      // check if the list is empty
      public boolean isEmpty()
      {
         return head.getNext() == null;
      }
      
      // provided the number of elements in the list
      public int size()
      {
         return size;
      }

      // inserts the specified element in the list as the first element
      public void addFirst(T e)
      {
         if (e == null)
            throw new IllegalArgumentException();
            
         head.setElement(e);
         head = new ListNode(null, head); 
         size++;  
      }
      
      // inspects the first element in the list
      public T getFirst()
      {
         if (isEmpty())
            throw new EmptyStackException();
            
         return head.getNext().getElement();   
      } 
      
      // removes the first element from the list
      public T removeFirst()
      {
         T x = getFirst();
         
         head = head.getNext();
         head.setElement(null);
         size--;
         
         return x;
      } 
   }
   
   /**
      constructs an empty stack
   */
   public S()
   {
      makeEmpty();
   }
   
   /**
      checks if this container is empty
      @return true if this container is empty, otherwise false
   */
   public boolean isEmpty()
   {
      return l.isEmpty();
   }

   /**
     makes the container empty
   */
   public void makeEmpty()
   {
       l = new LinkedList();   
   }
  
   /**
      provides the number of data items in this container
      @return the number of data items in this container
   */
   public int size()
   {
      return l.size();
   }
  
   /**
      inserts the specified item at the top of this stack
      @param o the specified item
   */
    public void push(T o)
    {         
       l.addFirst(o);    
    }
   
   /**
      inspect the item at the top of this stack
      @return the item at the top of this stack
      @throws EmptyStackException if this stack is empty
   */
    public T top() throws EmptyStackException
    {
       if (isEmpty())
          throw new EmptyStackException();
         
       return l.getFirst();
    }

   /**
      removes the item at the top of this stack
      @return the item removed
      @throws EmptyStackException if the stack is empty
   */
    public T pop()throws EmptyStackException
    {
       T x = top();
       
       l.removeFirst();     
      
       return x;
    }
    
    /**
       provides the textual description of this stack consisting of a string
       in which the stack elements are in LIFO sequence separated by a space
       character
       @return textual description
    */
    public String toString()
    {
       // return string
       String r = "";
       
       // temporary stack
       Stack s = new S();
              
       // extracting the elements from the stack
       while (!isEmpty())
       {
          r = r + " " + top();    // concatenating with the return string
          s.push(pop());          // saving in temporary stack
       } // here the stack is empty
       
       // reinserting the elements in the stack in the LIFO sequence
       while (!s.isEmpty())
          push((T)s.pop());
          
       return r;   
    } 
}
