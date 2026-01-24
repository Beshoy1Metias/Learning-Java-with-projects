/**
   Implements a set, which is a data container that contains no duplicate elements.
      
   Type Parameters:
      @param <E> the parametric type of data items in this set.
      
   @see Set
      
   @author A. Luchetta
   @version 11 Jan. 2025
*/
// implementation using a partially filled array
public class S<E> implements Set<E>
{
   // constants
   private static final int INITIAL_CAPACITY = 1;
   
   // instance variables
   private Object[] v;      // inner array
   private int vSize;       // item counter
   
   /**
      Constructs an empty set
   */
   public S()
   {
      // initialize inner array
      v = new Object[INITIAL_CAPACITY];  // Note type cast!
      
      // initialize item counter
      vSize = 0;
   }
   
   /*
      Inserts the specified data item into this set if it is not null and not already
      present.
      @param item element to be added to this set.
      @return true if this set did not already contain the specified element.
   */
   @Override
   public boolean add(E item)
   {
      // check preconditions
      if (item == null || contains(item)) return false;
      
      // dynamically resize if needed
      if (vSize >= v.length)
      {
         Object[] newV = new Object[2 * v.length];
         System.arraycopy(v, 0, newV, 0, v.length);
         v = newV;
      }
      
      // insert data item
      v[vSize] = item;
      
      // increment item counter
      vSize++;
      
      return true;
   }
   
   /**
      Checks if this set contains the specified item.
      @param o the data item to be checked.
      @return true if this set contains the specified data item.      
   */
   // O(n) in the average and wprst cases
   @Override
   public boolean contains(Object o)
   {
      // linear search
      int n = search(o);
      
      return n >= 0;
   }
   
   // linear search
   private int search(Object key)
   {
      for (int i = 0; i < vSize; i++)
      {
         if (v[i].equals(key)) return i;
      }
      
      return -1;
   }
   
   /**
      Returns true if this set is empty.
      @return true if this set is empty.
   */
   @Override
   public boolean isEmpty()
   {
      return vSize <= 0;
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
      int index = search(o);
      
      // case the specified object is not contained in this set
      if (index < 0) return false;
      
      // case the specified object is contained in this set
      // copy last element to current index
      v[index] = v[vSize - 1];
      
      // remove duplicate
      v[vSize - 1] = null;
      
      // decrement item counter
      vSize--;
      
      return true;
   }
   
   /**
      Returns the number of data item contained i this set.
      @return the number of data item contained i this set.
   */
   @Override
   public int size()
   {
      return vSize;
   }   
   
   /**
      Returns an array view of this set.
      @return an array containing the data items of this set
   */
   @Override
   public Object[] toArray()
   {
      // define return array
      Object[] items = new Object[vSize];
      
      // copy elements
      System.arraycopy(v, 0, items, 0, items.length);
      
      return items;
   }   
}
