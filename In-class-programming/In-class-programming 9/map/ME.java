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
       // TODO
       
       return get(key)!=null;
    }
    
   /**
      checks if there is a mapping with the specified value in this extended map
      @param value the specified value
      @return true if there is a mapping with the specified value in this map
   */
   public boolean containsValue(V value)
   {
      
      
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
	   
      Object[] vals = super.values();
	  Comparable[] valscom = new Comparable[size()]; 
	  for(int i=0; i<size(); i++)
	  {
		  valscom[i]= (V) vals[i];
	  }
	  mergeSort(valscom);
	  Comparable[] unique = new Comparable[size()];
	  unique[0]=valscom[0];
	  int count=1;
	  for(int i=1; i<size(); i++)
	  {
		  if(valscom[i-1].equals(valscom[i])){continue;}
		  unique[count]=valscom[i];
		  count++;
	  }
	  if(count<size())
	  {
		  Comparable[] temp = new Comparable[count];
		  for(int i=0;i<count;i++){temp[i]=unique[i];}
		  unique=temp;
	  }
	  return unique;
   }
	private void mergeSort(Object[] a)
	{
		if(a.length<2)
		{
			return;
		}
		int mid = a.length/2;
		Object[] left = new Object[mid];
		Object[] right = new Object[a.length-mid];
		System.arraycopy(a, 0, left, 0, left.length);
		System.arraycopy(a, mid, right, 0, right.length);
		mergeSort(left);
		mergeSort(right);
		merge(a, left, right);
	}
	private void merge(Object[] a, Object[] b, Object[] c)
	{
		int ia=0, ib=0, ic=0;
		while(ib<b.length && ic<c.length)
		{
			if(((Comparable)b[ic]).compareTo(c[ic])<0)
			{
				a[ia++]=b[ib++];
			}
			else{a[ia++]=c[ic++];}
		}
		while(ib<b.length){a[ia++]=b[ib++];}
		while(ic<c.length){a[ia++]=c[ic++];}
	}
}
