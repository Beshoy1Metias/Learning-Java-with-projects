/**
  * FOUNDATIONS OF COMPUTER SCIENCE
  * PROGRAMMING TEST DATED 22.2.2017
  *
  * Defines the Map abstract data type, that is a container of key/value
  * mappings (entries) in which the key is unique.
  * The entry key and value are of parametric types
  *
  * param K the key parametric type
  * param V the value parametric type
  *
  * @author A. Luchetta
  * @version 16-Dic-2020
  */
public interface Map<K extends Comparable, V>
{
   /**
      Returns the value to which the specified key is mapped 
      @param key the specified key
      @return the value to which the specified key is mapped, or null if this
              map contains no mapping for the key
   */ 
   V get(K key); 
   
   /**
      Returns true if this map contains no key-value mappings
      @return true if this map is empty
   */
   boolean isEmpty();
   
   /**
      Returns an array containing the keys of the key/value mappings of this map
      The array is sorted in ascending order according to the natural order of
      the keys
      @return a sorted array containing the keys of the key/value mappings of
              this map, otherwise an empty array if this map is empty
   */
   Comparable[] keySet();     

   /**
      Maps the specified value to the specified key in this map. If this
      map previously contained a mapping for the key, the old value is replaced
      by the specified value
      @param key with which the specified value is to be associated
      @param value value to be associated with the specified key
      @return the previous value associated with key, or null if there was no
              mapping for key.
      @throws IllegalArgumentException if the specified key or value is null
   */
   V put(K key, V value);
   
   /**
      Removes the mapping for the specified key from this map
      @param key the specified key of the mapping to be removed
      @return the previous value associated with key, or null if there was no
              mapping for key.
   */
   V remove(K key);
   
   /**
      Returns the number of key-value mappings in this map
      @return the number of key-value mappings in this map
   */
   int size();
   
   /**
      Returns an array view of the values contained in this map
      @return an array containing the values of this map or an empty array if
              this map is empty
   */ 
   Object[] values();         
}
