/**
  *         FOUNDATIONS OF COMPUTER SCIENCE - A.A. 2014-15
  *                   Programming Test - 17-02-2015
  *
  * Implements a queue, that is a collection of items with FIFO (First In
  * First Out) access policy, where the first  item inserted (front) is the
  * first extracted.
  *
  * Implementation with linked list
  *
  * @param T the parametric data type of the item of the queue
  *
  * @author A. Luchetta
  * @version 9-Feb-2015
  *
  */
public class Q<T> implements Queue<T> // Queue ADT
{  
   // instance variables
   private ListNode head, tail;
   private int size;             // counter of the queue items
   
   // inner class
   private class ListNode
   {
      // instance variables
      private T element;
      private ListNode next;
      
      // constructor . constructs a list node with the specified item and
      // next filed
      ListNode(T e, ListNode n)
      {
         element = e;
         next = n;
      }
      
      // constructor - constructs an empty list node
      ListNode()
      {
         this(null, null);
      }
      
      // accessing methods
      public T getElement()        { return element; }
      public ListNode getNext()    { return next; }

      // modifying methods
      public void setElement(T e)     { element = e; }
      public void setNext(ListNode n) { next = n; }
   }
   
   /**
      constructs an empty queue
   */
   public Q()
   {
      head = tail = new ListNode();
      size = 0;
   }

   /*
      removes the front item from this queue 
      @return the front item removed from this queue
      @throws EmptyQueueException if this queue is empty
   */
   public T dequeue() throws EmptyQueueException // O(1) - as RemoveFirst
   {       
      // temporarily store the item to be removed 
      T ret = front(); // throws EmptyQueueException if the queue is empty
      
      // remove the front item
      head = head.getNext();
      head.setElement(null);
      
      // update the item counter
      size--;
         
      return ret; 
   }  
   
   /**
      inserts the specified item into this queue
      @param x the specified item to be inserted
      @throws java.lang.IllegalArgumentException if the specified item is null
   */
   // O(1) in all cases
   public void enqueue(T x) throws IllegalArgumentException // as AddLast
   {
      // preconditions
      if (x == null)
      {
         throw new IllegalArgumentException();
      }
         
      // insert the new item as the tail item of the linked list
      tail.setNext(new ListNode(x, null)); 
      tail = tail.getNext();
      
      // update the item counter
      size++;  
   } 
   
   /**
      provides the front item of this queue
      @return the front item of this queue
      @throws EmptyQueueException if this queue is empty
   */
   // O(1)
   public T front() throws EmptyQueueException // as getFirst
   {
      // preconditions
      if (isEmpty())
      {
         throw new EmptyQueueException();
      }
         
      // inspect the front item
      return head.getNext().getElement();
   }
   
  /**
      checks if this queue is empty
      @return true if this queue is empty, false otherwise
   */
   public boolean isEmpty()
   {
      return head == tail;
   }   
   
   /**
      provides the number of items in this queue
      @return number of items in this queue
   */
   public int size()
   {
      return size;
   }   
   
   /**
      returns an array containing the items of this queue in the FIFO
      sequence with the front of this queue positioned at index zero. The size
      of the array is equal to the number of items in this queue
      @return an array containing the items of this queue, if the queue is
              not empty, otherwise an empty array
   */
   public Object[] toArray() // O(n)
   {
      // generate the return array
      Object[] v = new Object[size];
      
      // copy the queue items starting from the front item
      int i = 0;
      ListNode n = head.getNext();
      while (n != null)
      {
         v[i++] = n.getElement();
         n = n.getNext();
      }
      
      return v;
   }
}  
