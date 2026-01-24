/**
   Implements an extended sorted multimap
      
   Parameteric types:
      @param <K> the parametric type of the keys in this sorted multimap.
      @param <V> the parametric type of mapped values in this sorted multimap.
      
   @see SM   
      
   @author A. Luchetta
   @version 26 Dec. 2024
*/
public class ESM<K extends Comparable<K>, V extends Comparable<V>> extends SM<K, V>
{
   /**
      Initializes an empty extended sorted multimap.
   */
   public ESM()
   {
      super();
   }

   
   /**
      Returns all values to which the specified key is mapped, or null if this sorted
      multimap contains no mapping for the key.
      @param key the key whose associated values is to be returned.
      @return arrray containing the values to which the specified key is mapped, or null
              if this sorted multimap contains no mapping for the key.
   */
   public Object[] findAll(K key)
   {
       // define support sorted multimap with V-K mappings
       SortedMultimap<V, K> m = new SM();
       
       // inspect all values associated with key and extract mappings
       while (find(key) != null)
       {
          m.insert(remove(key), key); 
       } 
       
       // get array with values
       Object[] values = m.sortedKeys();
       
       // re-insert extracted mappings
       for (int i = 0; i < values.length; i++)
       {
          insert(key, (V)values[i]);
       }
       
       return values; 
   }   

   /**
      Overrides the superclass method with a recursive implementation.
      @return the number of mappings in this extended sorted multimap.
   */ 
   @Override
   public int size()
   {
      // base case
      if (isEmpty()) return 0;
      
      // simplify problem - remove mapping with the keys[0] key
      Object[] keys = sortedKeys();
      V value = remove((K)keys[0]);
      
      // recursive step
      int n = size();
      
      // insert removed mapping
      insert((K)keys[0], value);
      
      // return number of mappings
      return 1 + n;
   }
   
   /**
      Returns an array with the keys of this extended multimap sorted according their
      natural order and without duplicates
      @return an array with the keys of this extended multimap sorted according their
              natural order and without duplicates or an empty array if this exetnded sorted
              multimap is empty
   */
   public Object[] sortedKeySet()
   {
      // check preconditions
      if (isEmpty()) return new Object[0];
     
      // remove duplicates
      Object[] keySet = purge();
      
      return keySet;
   }
   
   // purge
   private Object[] purge()
   {
      // support multimap
      ESM<K,K> m = new ESM();
      
      // get sorted keys with possible duplicates
      Object[] keys = sortedKeys();      
            
      // insert keys if not already in support map
      for (int i = 0; i < keys.length; i++)
      {
         // select current key
         K curKey = (K)keys[i];
                
         // insert into support multimap if not already contained
         if (m.find(curKey) == null) m.insert(curKey, curKey);
      }
      
      return m.sortedKeys();
   }
}
