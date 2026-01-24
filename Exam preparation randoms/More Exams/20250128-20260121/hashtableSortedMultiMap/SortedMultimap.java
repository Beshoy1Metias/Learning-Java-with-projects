/**
   Defines a sorted multimap, i.e. a container of key-value mappings in which duplicate
   keys are allowed.
      
   Type Parameters:
      @param <K> the parametric type of keys in this sorted multimap
      @param <V> the parametric type of mapped values in this sorted multimap
      
   @author A. Luchetta
   @version 26 Dec. 2024
*/
public interface SortedMultimap<K extends Comparable<K>, V>
{
   /**
      Returns a value to which the specified key is mapped, or null if this sorted multimap
      contains no mappings for the key.
      @param key the key whose associated value is to be returned.
      @return a value to which the specified key is mapped, or null if this sorted multimap
              contains no mapping for the key.
   */
   V find(K key);
   
   /**
      Returns true if this sorted multimap contains no key-value mappings.
      @return true if this sorted multimap contains no key-value mappings.
   */
   boolean isEmpty();
     
   /**
      Associates the specified value with the specified key in this sorted multimap.
      @param key the key with which the specified value is to be associated.
      @param value the value to be associated with the specified key.    
      @throw java.lang.IllegalArgumentException if the specified key or value is null.
   */
   void insert(K key, V value);   
   
   /**
      Removes a mapping for a key from this sorted multimap if it is present.
      @param key the key whose mapping is to be removed from this sorted multimap.
      @return the previous value associated with key, or null if there was no mapping for
              key. 
   */
   V remove(K key);
   
   /**
      Returns the number of key-value mappings in this sorted multimap.
      @return the number of key-value mappings in this sorted multimap.
   */
   int size(); 
   
   /**
      Returns an array view of the keys contained in this sorted multimap. Keys in the
      array are sorted in ascending order according to their natural order.
      @return an array view of the sorted keys contained in this sorted multimap where
              keys are sorted in ascending order according to their natural order.
   */
   Object[] sortedKeys();   
}
