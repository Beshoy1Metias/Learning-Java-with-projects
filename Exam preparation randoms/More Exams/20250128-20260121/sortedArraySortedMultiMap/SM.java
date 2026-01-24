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
// Implementation using a partially filled array kept sorted by mapping key.
// Asymptotic time complexity of the find method is O(logn)
// (receives two points for time complexity).
public class SM<K extends Comparable<K>,V> implements SortedMultimap<K, V>
{
   // constants
   private static final int INITIAL_CAPACITY = 1;  // note: any positive integer works
   
   // instance variables
   private Entry[] v;     // array of mappings - see limits of parametric programming
   private int vSize;     // mapping counter
   
   /**
      Constructs an empty sorted multimap.
   */
   public SM()
   {
      // initialize inner array
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
   public V find(K key)  // O(logn) in average and worst cases
   {
      // check preconditions - a null key can't be in the sorted multimap - see insert
      // method
      if (key == null) return null;
      
      // search for key
      int n = search(key); // O(logn) in average and worst cases
      
      // case where the key is not present
      if (n < 0)   return null;
      
      // case where the key is present
      return (V)v[n].getValue();
   }
   
   // search for a mapping with specified key in this map.
   // k is the specified key
   // returns the index in the array where the mapping with the specified key is or -1
   // if a mapping with the specified key is not present in this map
   private int search(K k) // O(logn) in average and worst cases
   {
      // binary search
      return search(0, vSize - 1, k);
   }
   
   // binary search
   private int search(int from, int to, K key)
   {
      // base case - key is not present
      if (from > to)  return -1;
      
      // approx in the middle
      int mid = (from + to) / 2;
      
      // select mid key
      K curKey = (K)v[mid].getKey();                // type cast is needed
      
      // base case
      if (curKey.compareTo(key) == 0)  return mid;  // key is present
      
      else if (curKey.compareTo(key) < 0) return search(mid + 1, to, key); // search right
      
      else return search(from, mid - 1, key);                              // search left
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
      array must be sorted according to theit natural order.
      @return an array view of the sorted keys contained in this sorted multimap.
   */
   @Override
   public Object[] sortedKeys() // O(n) in all cases
   {
      // define return array
      Object[] keys = new Object[vSize];
      
      // copy keys
      for (int i = 0; i < keys.length; i++)
      {
         keys[i] = v[i].getKey();
      }

      // return array with keys - keys are already sorted
      return keys;
   }
   
   /**
      Associates the specified value with the specified key in this sorted multimap.
      @param key the key to be associated with the specified value.
      @param value the value to be associated with the specified key.    
      @throw java.lang.IllegalArgumentException if the specified key or value is null
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
 
      // add new mapping keeping the array sorted by key
      int j = vSize - 1;
      while (j >= 0 && (key).compareTo((K)v[j].getKey()) < 0) // O(n) in average and worst cases
      {
         v[j + 1] = v[j];
         j--;
      }
      v[j + 1] = new Entry(key, value);
      
      // increment mapping counter
      vSize++;
   }  
   
   /**
      Removes a mapping for a key from this sorted multimap if it is present.
      @param key the key whose mapping is to be removed from this sorted multimap.
      @return the previous value associated with key, or null if there was no mapping for key. 
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
      
      // save mapping value
      V curValue = (V)v[n].getValue();   // type cast is necessary
       
      // remove mapping - // O(n) in average and worst cases
      for (int i = n; i < vSize - 1; i++) // note: sequence matters
      {
         v[i] = v[i + 1];
      }
      
      // remove duplicate mapping
      v[vSize - 1] = null;
         
      // decrement mapping counter
      vSize--; 
         
      // return mapping value
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
