/**
   Implements a set, which is a data container that contains no duplicate elements.
      
   Type Parameters:
      @param <E> the parametric type of data items in this set.
      
   @see Set
      
   @author A. Luchetta
   @version 11 Jan. 2025
*/
// implementation using a partially filled array kept sorted.
// method add checks if the item to insert is of the Comparable data type
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
      // check on comparable type - if not comparable throw exception
      if (!(item instanceof Comparable)) throw new ClassCastException();
      
      // check preconditions
      if (item == null || contains(item)) return false;
      
      
      // dynamically resize if needed
      if (vSize >= v.length)
      {
         Object[] newV = new Object[2 * v.length];
         System.arraycopy(v, 0, newV, 0, v.length);
         v = newV;
      }
      
      // insert data item keeping the array sorted
      int j = vSize - 1;
      while (j >= 0 && ((Comparable)item).compareTo(v[j]) < 0)
      {
         v[j + 1] = v[j];
         j--;
      }     
      v[j + 1] = item;
      
      // increment item counter
      vSize++;
      
      return true;
   }
   
   /**
      Checks if this set contains the specified item.
      @param o the data item to be checked.
      @return true if this set contains the specified data item.      
   */
   // O(logn) in average and worst cases
   @Override
   public boolean contains(Object o)
   {
      // check for null
      if (o == null) return false;
      
      // binary search
      int n = search(o);
      
      return n >= 0;
   }
   
   // binary search
   private int search(Object key)
   {
      return search(0, vSize - 1, key);
   }
   
   private int search(int from, int to, Object key)
   {
      // base case
      if (from > to) return -1;
      
      // in the middle
      int mid = (from + to) / 2;
      E midItem = (E) v[mid];
      
      // base case
      if (((Comparable)midItem).compareTo(key) == 0) return mid;
      
      // recursive steps
      else if (((Comparable)midItem).compareTo(key) < 0)
         return search(mid + 1, to, key);
      else
         return search(from, mid - 1, key);   
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
      // move all elements following the item to be canceled - sequence matters!
      for (int i = index; i < vSize - 1; i++)
      {
         v[i] = v[i + 1];
      }
      
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
