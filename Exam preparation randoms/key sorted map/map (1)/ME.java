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
	public ME()
	{
		super();
	}
   /**
      checks if there is a mapping with the specified key in this extended map
      @param key the specified key
      @return true if there is a mapping with the specified key in this map,
   */
   public boolean containsKey(K key)
    {
       if(get(key)==null){return false;}
       return true;
    }
    
   /**
      checks if there is a mapping with the specified value in this extended map
      @param value the specified value
      @return true if there is a mapping with the specified value in this map
   */
   public boolean containsValue(V value)
   {
      Comparable[] values = valueSet();
      
      return linearSearch(values, value)>=0;
   }
   private int linearSearch(Comparable[] a, V value)
   {
	   for(int i=0; i<a.length; i++)
	   {
		   if (a[i].equals(value)){return i;}
	   }
	   return -1;
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
      Object[] values = values();
	  Comparable[] tmp = new Comparable[size()];
	  int count =0;
	  tmp[count++]=(Comparable)values[0];
	  for(int i=1; i<size(); i++)
	  {
		  if(values[i].equals(values[i-1])){continue;}
		  tmp[count++]=(Comparable)values[i];
	  }
	  Comparable[] output = new Comparable[count];
	  System.arraycopy(tmp, 0, output, 0, count);
	  return output;
   }
   //write mergesort to sort values and you're done but not now
}
