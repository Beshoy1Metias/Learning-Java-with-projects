/**
  * Implements an extended SortedMultimap
  *
  * param K parametric type limited to Comparable for the key 
  * param V parametric type limited to Comparable for the value
  *
  * @author A. Luchetta
  * @version 12-02-2019
  *
  */
public class ESD<K extends Comparable,V extends Comparable> extends D<K,V>
{      
   /**
     * checks if there is at least a mapping for the key in this multimap
     * @param key the key specified
     * @return true if this multimap contains a mapping with the specified key,
     *         otherwise false
     */
   public boolean contains(K key)
   {
      // TODO
      
      return findAll(key).length>0;
   }
 
   /**
     * retrieves the unique keys in this map
     * @return  a sorted array containing the keys in this multimap
     */
   public Comparable[] keySet()
   {
      Comparable[] keys = keys();
	  Comparable[] keySet = new Comparable[size()];
	  int count=0;
	  keySet[count++]=keys[0];
	  for(int i=1; i<keys.length;i++)
	  {
		  if(keys[i-1].equals(keys[i])){continue;}
		  keySet[count++]=keys[i];
	  }
	  Comparable[] out = new Comparable[count];
	  System.arraycopy(keySet, 0, out, 0, count);
      return out;
   } 
   
   /**
     * Retrieves the sorted non-duplicated value in this multimap
     * @return a sorted array containing the values of this multimap without duplicates
     * multimappa
     */
   public Comparable[] valueSet()
   {
      Comparable[] keys = keySet();
	  Comparable[] values = new Comparable[size()];
	  int count = 0;
	  for(int i=0; i<keys.length;i++)
	  {
		  Object[] val = findAll((K)keys[i]);
		  for(int j=0; j<val.length;j++)
		  {
			  values[count++]=(Comparable)val[j];
		  }
	  }
	  Comparable[] tmp = new Comparable[count];
	  System.arraycopy(values, 0, tmp, 0, count);
	  values=tmp;
	  mergeSort(values);
	  
	  tmp = new Comparable[count];
	  count=0;
	  tmp[count++]=values[0];
	  for(int i = 1; i<values.length; i++)
	  {
		  if(values[i-1].equals(values[i])){continue;}
		  tmp[count++]=values[i];
	  }
	  Comparable[] out = new Comparable[count];
	  System.arraycopy(tmp, 0, out, 0, count);
	  return out;
   }
	private void mergeSort(Object[] a)
	{
		if(a.length<2){return;}
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
		int ia=0,ib=0,ic=0;
		while(ib<b.length && ic<c.length)
		{
			if(((Comparable)b[ib]).compareTo(c[ic])<0){a[ia++]=b[ib++];}
			else{a[ia++]=c[ic++];}
		}
		while(ib<b.length){a[ia++]=b[ib++];}
		while(ic<c.length){a[ia++]=c[ic++];}
	}
   
}
