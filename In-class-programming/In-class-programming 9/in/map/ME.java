/**
  * FOUNDATIONS OF COMPUTER SCIENCE
  * PROGRAMMING TEST DATED 22.2.2017
  *
  * Extended map
  *
  * @see M
  * @author A. Luchetta
  * @version 16-Dic-2020
  */
public class ME <K extends Comparable, V extends Comparable> extends M <K, V>
{
   /**
      checks if there is a mapping with the specified key in this extended map
      @param key the specified key
      @return true if there is a mapping with the specified key in this map,
   */
   public boolean containsKey(K key)
    {
       
       //TODO
       return false;
    }
    
   /**
      checks if there is a mapping with the specified value in this extended map
      @param value the specified value
      @return true if there is a mapping with the specified value in this map
   */
   public boolean containsValue(V value)
   {
      // TODO
      
      return false;
   }

   /**
      Maps the specified value to the specified key in this map. If this
      map previously contained a mapping for the key, the old value is replaced
      by the specified value
      @param key key to which the specified value is to be mapped
      @param value value to be mapped to the specified key
      @return the previous value mapped to the key, or null if there was no
              mapping for key.
      @throws IllegalArgumentException if the specified key or value is null
   */
   @Override
   public V put (K key, V value) { return super.put(key, value); }
   
   /**
      Returns a sorted array containing the values of this map without
      duplicated values
      @return sorted array containing the values of this map without
              duplicated values. The array is sorted in ascending order
              according to the natural order of the values.
   */
   public Comparable[] valueSet()
   {
	   Comparable[] tmp = new Comparable[size()];
	   Object[] vals= super.values();
	   for(int i=0; i<size();i++)
	   {
		   tmp[i]= (V) vals[i];
	   }
      return tmp;
   }
}
