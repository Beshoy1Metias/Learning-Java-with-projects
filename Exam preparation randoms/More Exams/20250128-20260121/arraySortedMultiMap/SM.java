/**
   Implements a sorted multimap, which is a container of key-value mappings where
   duplicate keys are allowed and keys are bounded to classes that implement the
   java.lang.Comparable interface.
      
   Parameteric types:
      @param <K> the parametric type of the keys in this sorted multimap
      @param <V> the parametric type of mapped values in this sorted multimap
      
   @see SortedMultimap    
      
   @author A. Luchetta
   @version 26 Dec. 2024
*/
// Implementation using a partially filled array. Asymptotic time complexity of the find method is O(n).
public class SM<K extends Comparable<K>,V> implements SortedMultimap<K,V>
{
   // constants
   private static final int INITIAL_CAPACITY = 1;  // note: any positve integer works
   
   // instance variables
   private Entry[] v;     // array of mappings - Entry is not parametric
   private int vSize;     // mapping counter
   
   /**
      Constructs an empty sorted multimap
   */
   public SM()
   {
      // initialize the inner array
      v = new Entry[INITIAL_CAPACITY];
      
      // initialize mapping counter
      vSize = 0;
   }

  /**
      Returns a value to which the specified key is mapped, or null if this sorted
      multimap contains no mapping for the key.
      @param key the key whose associated value is to be returned.
      @return a value to which the specified key is mapped, or null if this sorted
              multimap contains no mapping for the key.
   */
   @Override
   public V find(K key)  // O(n) in average and worst cases
   {
      // check preconditions - a null key can't be in the sorted multimap - see insert
      // method
      if (key == null) return null;
      
      // search for key
      int n = search(key); // O(n) in average and worst cases
      
      // case where the key is not present
      if (n < 0)   return null;
      
      // case where the key is present
      return (V)v[n].getValue();        // type cast is needed
   }
   
   // search for a mapping with specified key in this sorted multimap. As the key can be
   // mapped to multiple values, it returns the index of the first occurence of the key
   // in the sorted multimap.
   // k is the specified key
   // returns the index in the array where a mapping with specified key is or -1 if the a
   // mapping with the specified key is not present in this sorted multimap
   private int search(K k) // O(n) in average and worst cases
   {
      // linear search
      for (int i = 0; i < vSize; i++)  // note: upper limit is vSize. Don't use v.length!
      {
         // Get current key
         K curKey = (K)v[i].getKey();  // type cast is needed
         
         // check keys
         if (curKey.compareTo(k) == 0) return i;  // key is found      
      }
      return -1;                                  // key is not found
   }
   
   /**
      Returns true if this sorted multimap contains no key-value mappings.
      @return Returns true if this sorted multimap contains no key-value mappings.
   */
   @Override
   public boolean isEmpty()
   {
       return vSize <= 0;
   }
   
   /**
      Returns an array view of the keys contained in this sorted multimap. Keys in the
      array must be sorted in ascending order according to their natural order.
      @return an array view of the sorted keys contained in this sorted multimap.
   */
   @Override
   public Object[] sortedKeys() // O(n) in all cases
   {
      // define return array
      Object[] keys = new Object[vSize];  // note: array length equals mapping counter
      
      // copy keys
      for (int i = 0; i < keys.length; i++)     
      {
         keys[i] = v[i].getKey();
      }
      
      // sort keys
      sort(keys);

      // return array with sorted keys
      return keys;
   }
   
   // sorts array of objects 
   private static void sort(Object[] a)
   {
      // base case
      if (a.length < 2) return;
      
      // about in the middle
      int mid = a.length / 2;
      
      // define subarrays
      Object[] left = new Object[mid];
      Object[] right = new Object[a.length - mid];
      
      // copy elements
      System.arraycopy(a, 0, left, 0, left.length);
      System.arraycopy(a, mid, right, 0, right.length);
      
      // recursive steps
      sort(left);
      sort(right);
      
      // merge
      merge(a, left, right);
   }
   
   // merge
   private static void merge(Object[] a, Object[] b, Object[] c)
   {
      int ia = 0, ib = 0, ic = 0;
      
      while (ib < b.length && ic < c.length)
         if (((Comparable)b[ib]).compareTo(c[ic]) < 0) // note: type cas is needed
            a[ia++] = b[ib++];
         else
            a[ia++] = c[ic++];   
            
      while (ib < b.length)
         a[ia++] = b[ib++];
         
      while (ic < c.length) 
         a[ia++] = c[ic++];                
   }      
   
   /**
      Associates the specified value with the specified key in this sorted multimap.
      @param value the value to be associated with the specified key.     
      @throw java.lang.IllegalArgumentException if the specified key or value is null.
   */
   @Override
   public void insert(K key, V value) // O(n) in average and worst cases
   {
      // check preconditions
      if (key == null || value == null) throw new IllegalArgumentException();
           
      // dynamically resize if needed
      if (vSize >= v.length) // O(1) in average case, O(n) in worst cases
      {
         // define new mapping array with double the size of current  mapping array
         Entry[] newV = new Entry[2 * v.length];
         
         // copy mappings from current mapping array to new one
         System.arraycopy(v, 0, newV, 0, v.length);
         
         // abandon current array
         v = newV;
      }
 
      // add new mapping
      v[vSize] = new Entry(key, value);
      
      // increment mapping counter
      vSize++;
   }  
   
   /**
      Removes a mapping for a key from this sorted multimap if it is present.
      @param key the key whose mapping is to be removed from this sorted multimap.
      @return the previous value associated with key, or null if there was no mapping
              for the specified key. 
   */
   @Override
   public V remove(K key) // O(n) in average and worst cases
   {
      // check preconditions - a null key can't be in the sorted multimap - see insert
      // method
      if (key == null) return null;
      
      // search for key
      int n = search(key); // O(n) in average and worst cases
      
      // case where the key is not present      
      if (n < 0) return null;
      
      // case where the key is present   
      // save mapping value
      V curValue = (V)v[n].getValue();    // type cast is needed
      
      // remove mapping
      v[n] = v[vSize - 1];                // note: sequence does not matter
      
      // remove duplicate mapping
      v[vSize - 1] = null;
         
      // decrement mapping counter
      vSize--; 
         
      // return old value
      return curValue;       
   }
   
   /**
      Returns the number of key-value mappings in this sorted multimap.
      @return the number of key-value mappings in this sorted multimap.
   */
   @Override
   public int size()
   {
      return vSize;
   } 
}
