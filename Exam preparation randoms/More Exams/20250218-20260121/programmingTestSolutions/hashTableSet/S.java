/**
   Implements a set, which is a container of data items withour duplicates.
      
   Type Parameters:
      @param <E> the parametric type of data items in this set.
      
   @see Set
      
   @author A. Luchetta
   @version 11 Jan. 2025
*/
// implementation using a hash table
public class S<E> implements Set<E>
{   
   // constants
   private static final int CAPACITY = 29;   // prime integer to improve uniformity of  
                                             // hash code distribution
                                             
   // instance variables
   private Object[] v;
   private int size;       // item counter
   
   // inner class list node
   private class ListNode
   {
      // instance variables
      private E element;
      private ListNode next;
      
      // constructs a new listnode with the specified element and next list node
      public ListNode(E e, ListNode n)
      {
         setElement(e);
         setNext(n);
      }
      
      // constructs an empty list node
      public ListNode()
      {
         this(null, null);
      }
      
      // accessor methods
      public E getElement()     { return element; }
      public ListNode getNext() { return next;    }
      
      // mutator methods
      public void setElement(E e)     { element = e; }
      public void setNext(ListNode n) { next = n;    }
   }
   
   
   /**
      Constructs an empty set
   */
   public S()
   {
      // initialize table
      v = new Object[CAPACITY];
      
      // initialize buckets
      for (int i = 0; i < v.length; i++)
      {
         v[i] = new ListNode();
      }
      
      // initialize item counter
      size = 0;
   }
   
   /**
      Inserts the specified data item into this set if it is not null and not already
      contained.
      @param item the data item to be inserted.
      @return true if the data item was not already contained.
   */
   @Override
   public boolean add(E item)
   {
      // check preconditions
      if (item == null || contains(item)) return false;
      
      // select bucket
      int h = hash(item);
      
      // insert data item
      ListNode head = (ListNode)v[h];
      head.setElement(item);
      head = new ListNode(null, head);
      v[h] = head;
      
      // increment item counter
      size++;
      
      return true;
   }
   
   // computes hash code
   private int hash(Object item) 
   {
      // compute signed hash code
      int h = item.hashCode() % v.length;
      
      // compute absolute value
      if (h < 0) h = -h;
     
      return h;
   }
   
   /**
      Checks if the specified item is contained in this set.
      @param o the data item to be checked.
      @return true if the data item is contained in this set.      
   */
   // O(n/CAPACITY)
   @Override
   public boolean contains(Object o)
   {
      // search
      ListNode n = search(o);
      
      return n.getNext() != null;
   }
   
   // linear search in selected bucket
   private ListNode search(Object key)
   {
      // select bucket
      int h = hash(key); 
 
      // define support list node
      ListNode head = (ListNode)v[h];
      ListNode n = head;

      // scroll bucket
      while (n.getNext() != null)
      {
         // check item
         if (n.getNext().getElement().equals(key)) break;  // found
         
         // move support node forward
         n = n.getNext();
      }
      
      return n;
   }
   
   /**
      Returns true if this set is empty.
      @return true if this set is empty.
   */
   public boolean isEmpty()
   {
      return size <= 0;
   }
      
   /**
      Removes the specified data item from this set if it is contained.
      @param item the specified item.
      @return true if this set contained the specified element.
   */
   @Override
   public boolean remove(Object o)
   {
      // linear search
      ListNode n = search(o);
      
      // case the specified object is not contained in this set
      if (n.getNext() == null) return false;
      
      // case the specified object is contained in this set
      // remove list node with specified item
      n.setNext(n.getNext().getNext());
      
      // decrement item counter
      size--;
      
      return true;
   }
   
   /**
      Returns the number of data item contained i this set.
      @return the number of data item contained i this set.
   */
   public int size()
   {
      return size;
   }   
   
   /**
      Returns an array view of this set.
      @return an array containing the data items of this set
   */
   @Override
   public Object[] toArray()
   {
      // define return array
      Object[] items = new Object[size];
      
      // copy elements to array
      int index = 0;
      for (int i = 0; i < v.length; i++)
      {
         ListNode head = (ListNode)v[i];
         ListNode n = head.getNext();
         while (n != null)
         {
            items[index++] = n.getElement();
            
            n = n.getNext();
         }
      }
      
      return items;
   }   
}
