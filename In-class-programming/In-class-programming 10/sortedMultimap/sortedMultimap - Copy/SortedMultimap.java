/**
  * Defines the Sorted Multimap abstract data type, i.e. a data container of
  * key/value mappings in which the key may not be unique.
  * The key and value are of parametric types and the key is limited to
  * Comparable
  *
  *
  * param K parametric type limited to Comparable for the key 
  * param V parametric type for the value
  *
  * @author A. Luchetta
  * @version 27-12-2020
  *
  */
public interface SortedMultimap<K extends Comparable,V> extends Container
{   
     /**
     * Returns an array containing all the values mapped to the specified key in
     * this multimap
     * @param key the specified key whose mapped values to return
     * @return an array containing all the values mapped to the specified key in
     *         this multimap if this multimap contains mappings for the key,
     *         otherwise an empty array
     */      
   Object[] findAll(K key);
   
   /** 
     * Maps the specified value to the specified key in this multimap
     * @param key the specified key
     * @param value the specified value
     * @throws java.lang.IllegalArgumentException if the specified key or value
     *         is null
     */
   void insert(K key, V value);    
  
   /**
     * Returns the keys in this multimap
     * @return a sorted array containing the keys of this map if this multimap
     *         is not empty, otherwise an empty array
     */
   Comparable[] keys();   
        
   /**
     * Removes from this multimap all the mappings of the specified key and 
     * return the mapped values in an array
     * @param key the specified key
     * @return an array containing the values mapped to the specified key,
     *         if any, otherwise an empty array
     */   
   Object[] removeAll(K key);       
}
