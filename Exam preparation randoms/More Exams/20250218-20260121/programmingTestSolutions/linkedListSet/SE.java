/**
   Implements an extended set.
      
   Type Parameters:
      @param <E> the parametric type of data items in this extended set.
      
   @see S
      
   @author A. Luchetta
   @version 11 Jan. 2025
*/
public class SE<E extends Comparable<E>> extends S<E>
{
   /**
      Constructs an empty extended set.
   */
   public SE()
   {
      super();
   }
   
   /**
      Overrides the superclass method of the same name using a recursive algorithm.
      @param item the item to check.
      @return true if this extended set contains the specified item.
   */
   @Override
   public boolean contains(Object o)
   {
      // check preconditions
      if (o == null) return false;
      
      // check if item to be checked is of the E data type
      // note statement instance of E is not supported
      // workaround is to catch ClassCastException when the item to check is
      // not of the E data type
      E item;
      try {           
         item = (E) o;
      }
      catch (ClassCastException e)
      {
         return false;  // item cannot be contained if not of the E data type
      }
      
      // base case
      if (isEmpty()) return false;
      
      // base case
      Object[] v = toArray();
      E curItem = (E)v[0];
      if (item.compareTo(curItem) == 0) return true;
      
      //Symplification and recursive step
      remove(curItem);
      boolean contains = contains(item);
      
      // re-insert extracted item
      add(curItem);
      
      return contains;     
   }
   
   /**
      Compares the specified object with this extended set for equality.
      @param o the specified object.
      @return true if the specified object equals this extended set.
   */
   @Override
   public boolean equals(Object o)
   {
        // check preconditions
        // if the specified object is not a set, it is not equal to this
        // extended set
        if (!(o instanceof SE)) return false;
        
        // type cast the specified object
        SE s = (SE) o;
        
        // compare length of this set to length of specified set
        if (size() != s.size()) return false;
        
        // get data item from specified set
        Object[] items = s.toArray();
        
        // check if this extended set contains data items of the specified set
        // note: the two sets have the same number of elements
        for (int i = 0; i < items.length; i++)
        {
           // current item
           E curItem = (E)items[i];               // type cast is needed
           
           // if this set does not contain the current item from the specified
           // array then the sets are not equal
           if (!contains(curItem)) return false;  // sets are different
        }
        
        return true;                              // sets are equal
   }     
   
   /**
      Returns an array containing the data item of this extended set sorted in ascending
      order according to their natural order.
      @return an array containing the data item of this set sorted according to their
              natural order or an empty array if this extended set is empty
   */
   public Object[] toSortedArray()
   {
      // get data items in this array
      Object[] items = toArray();
      
      // dort data items
      sort(items);
      
      // return array
      return items;
   }
   
   // mergesort
   private static void sort(Object[] v)
   {
      if (v.length < 2)
         return;
         
      int mid = v.length / 2;
      
      Object[] left = new Object[mid];
      Object[] right = new Object[v.length - mid];
      System.arraycopy(v, 0, left, 0, left.length);
      System.arraycopy(v, mid, right, 0, right.length);
      
      sort(left); 
      sort(right);
      
      merge(v, left, right);
   }
   
   private static void merge(Object[] a, Object[] b, Object[] c)
   {
      int ia = 0, ib = 0, ic = 0;
      
      while (ib < b.length && ic < c.length)
         if (((Comparable)b[ib]).compareTo(c[ic]) < 0)
            a[ia++] = b[ib++];
         else
            a[ia++] = c[ic++]; 
            
      while (ib < b.length)
         a[ia++] = b[ib++];                 
      while (ic < c.length)
         a[ia++] = c[ic++]; 
   }             
}
