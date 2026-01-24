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
// Implementation using a hash table. Asymptotic time complexity of the find method is O(n/CAPACITY)
// when the hash code is uniformly distrubuted (receives two points for time complexity).
public class SM<K extends Comparable<K>,V> implements SortedMultimap<K, V>
{
   // constants
   private static final int CAPACITY = 29;   // prime integer to improve uniformity of  
                                             // hash code distribution
   
   // instance variables
   private Object[] v;       // array of Objects - see limits of parametric programming
   private int size;         // mapping counter
   
   // inner class list node
   private class ListNode
   {
      // instance variables
      private Entry element;
      private ListNode next;
      
      // constructs a new listnode with the specified key, value and next list node
      public ListNode(K k, V v, ListNode n)
      {
         element = new Entry(k, v);
         setNext(n);
      }
      
      // constructs an empty list node
      public ListNode()
      {
         element = new Entry(null, null);
         next = null;
      }
      
      // accessor methods
      public K getKey()         { return (K)element.getKey();   }
      public V getValue()       { return (V)element.getValue(); }
      public ListNode getNext() { return next;                  }
      
      // mutator methods
      public void setKey(K k)         { element.setKey(k);   }
      public void setValue(V v)       { element.setValue(v); }
      public void setNext(ListNode n) { next = n;            }
   }
   
   /**
      Constructs an empty sorted multimap.
   */
   public SM()
   {
      // initialize inner array
      v = new Object[CAPACITY];
      
      // initialize buckets
      for (int i = 0; i < v.length; i++)
      {
         v[i] = new ListNode();
      }
      
      // initialize mapping counter
      size = 0;
   }

  /**
      Returns a value to which the specified key is mapped, or null if this sorted multimap contains
      no mapping for the key.
      @param key the key whose associated value is to be returned
      @return a value to which the specified key is mapped, or null if this sorted multimap contains
              no mapping for the key
   */
   @Override
   public V find(K key) // O(n/M) in average and worst cases where M is the size of the table
   {
      // check preconditions
      // a null key can't be in the sorted multimap - see insert method
      if (key == null) return null;
      
      // search for key
      ListNode n = search(key); // O(n/M) in average and worst cases where M is the size of the table
      
      // case where the key is not present
      if (n.getNext() == null)   return null;
      
      // case where the key is present
      return n.getNext().getValue();
   }
   
   // search for mapping with specified key in this sorted multimap
   // k is the specified key
   // returns the reference to the list node before the list node where a mapping with
   // the specified key is or the tail node of the bucket if a mapping with the specified
   // key in not in this map
   private ListNode search(K k) // O(n/M) in average and worst cases where M is the size
                                // of the table
   {
      // select bucket
      int h = hash(k);

      // linear search in the bucket
      ListNode head = (ListNode)v[h];
      ListNode n = head;
      while (n.getNext() != null)
      {
         if (n.getNext().getKey().compareTo(k) == 0) break;  // key is found
         
         n = n.getNext();
      }
      
      return n;                                      // key is not found
   }
   
   // returns the hash code for the specified key
   private int hash(K key)
   {
      // compute signed hash code - may be positive or negative or zero
      int h = key.hashCode() % v.length;
      
      // compute absolute value
      if (h < 0) h = -h;
      
      // return hash code
      return h;   
   }
   
   /**
      Returns true if this sorted multimap contains no key-value mappings.
      @return Returns true if this sorted multimap contains no key-value mappings.
   */
   @Override
   public boolean isEmpty()
   {
       return size <= 0;
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
      Object[] keys = new Object[size];
      
      // copy keys
      int j = 0;
      for (int i = 0; i < v.length; i++)  // scrolls all buckets in inner array
      {
         // current bucket
         ListNode curHead = (ListNode)v[i];   // type cast is needed
         
         // scroll bucket
         ListNode n = curHead.getNext();
         while (n != null)
         {
            keys[j++] = n.getKey();
            n = n.getNext();
         }
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
      @param key the key with which the specified value is to be associated.
      @param value the value to be associated with the specified key.     
      @return the previous value associated with key, or null if there was no mapping for key.
      @throw java.lang.IllegalArgumentException if the specified key or value is null.
   */
   @Override
   public void insert(K key, V value) // O(1) in all cases
   {     
      // check preconditions
      if (key == null || value == null) throw new IllegalArgumentException();
      
      // select bucket
      int h = hash(key);
 
      // add new mapping
      ListNode head = (ListNode)v[h];     // gets head of selected bucket
      head.setKey(key);                   // inserts key into head             
      head.setValue(value);               // inserts value into head
      ListNode newHead = new ListNode();  // creates a new head for the bucket
      newHead.setNext(head);              // links new head to current head
      v[h] = newHead;                     // inserts bucket with new head into hash table
      
      // increment mapping counter
      size++;
   }  
   
   /**
      Removes the mapping for a key from this sorted multimap if it is present.
      @param key the key whose mapping is to be removed from this sorted multimap.
      @return the previous value associated with key, or null if there was no mapping for key. 
   */
   @Override
   public V remove(K key) // O(n/M) in average and worst cases where M is the size of the table
   {                      // assuming that the hashcode is uniformly distributed     
      // check preconditions
      // a null key can't be in the sorted multimap - see insert method
      if (key == null) return null;
      
      // search for key
      ListNode n = search(key); // O(n/M) in average and worst cases where M is the size of the table
      
      // case where the key is not present      
      if (n.getNext() == null) return null;

      // case where the key is present    
      // save mapping value
      V curValue = n.getNext().getValue();
      
      // remove mapping
      n.setNext(n.getNext().getNext());
                  
      // decrement mapping counter
      size--;      
         
      // return cur value
      return curValue;       
   }
   
   /**
      Returns the number of key-value mappings in this sorted multimap.
      @return the number of key-value mappings in this sorted multimap.
   */
   @Override
   public int size()
   {
      return size;
   }   
}
