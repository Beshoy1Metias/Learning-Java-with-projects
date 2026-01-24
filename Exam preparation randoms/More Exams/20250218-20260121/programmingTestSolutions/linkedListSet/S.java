/**
   Implements a set, which is a container of data items withour duplicates.
      
   Type Parameters:
      @param <E> the parametric type of data items in this set.
      
   @see Set
      
   @author A. Luchetta
   @version 11 Jan. 2025
*/
// implementation using a linked list
public class S<E> implements Set<E>
{   
   // instance variables
   private ListNode head;
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
      // initialize linked list array
      head = new ListNode();
      
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
      
      // insert data item
      head.setElement(item);
      head = new ListNode(null, head);
      
      // increment item counter
      size++;
      
      return true;
   }
   
   /**
      Checks if the specified item is contained in this set.
      @param o the data item to be checked.
      @return true if the data item is contained in this set.      
   */
   // O(n) in average and worst cases
   @Override
   public boolean contains(Object o)
   {
      // linear search
      ListNode n = search(o);
      
      return n.getNext() != null;
   }
   
   // linear search
   private ListNode search(Object key)
   {
      // define support list node reference
      ListNode n = head;

      // scroll linked list
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
   @Override
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
   @Override
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
      ListNode n = head.getNext();
      while (n != null)
      {
         items[index++] = n.getElement();
         n = n.getNext();
      }
      
      return items;
   }   
}
