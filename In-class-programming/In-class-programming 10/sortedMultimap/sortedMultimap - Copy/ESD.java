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

	public ESD()
	{
		super.makeEmpty();
	}
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
	   int length = super.size();
	   Comparable[] allKeys = super.keys();
	   Comparable[] output = new Comparable[length];
	   int count=1;
	   output[0]=allKeys[0];
	   for(int i=1; i<length; i++)
	   {
		   if(allKeys[i].equals(allKeys[i-1])){continue;}
		   output[count++]=allKeys[i];
	   }
	   if(count<length)
	   {
		   Comparable[] temp = new Comparable[count];
		   System.arraycopy(output, 0, temp, 0, count);
		   output=temp;
	   }
	   return output;
   } 
   
   /**
     * Retrieves the sorted non-duplicated value in this multimap
     * @return a sorted array containing the values of this multimap without duplicates
     * multimappa
     */
   public Comparable[] valueSet()
   {
	   int length = super.size();
	   Object[] output= new Object[length];
	   int count=0;
	   Comparable[] keys = keySet();
	   for(int i=0; i<keys.length; i++)
	   {
		   Object[] tmp = findAll((K)keys[i]);
		   for(int j=0; j<tmp.length;j++)
		   {
			   output[count++]=tmp[j];
		   }
	   }
	   mergeSort(output);
	   Object[] finalOutput= new Object[count];
	   int count2=1;
	   finalOutput[0]=output[0];
	   for(int i=1;i<count;i++)
	   {
		   if(output[i].equals(output[i-1])){continue;}
		   finalOutput[count2++]=output[i];
	   }
	   if(count2<count)
	   {
		   Comparable[] tmp=new Comparable[count2];
		   System.arraycopy(finalOutput, 0, tmp, 0, count2);
		   finalOutput=tmp;
	   }
	   Comparable[] finalfinaloutput = new Comparable[count2];
	   for(int i=0; i<count2;i++)
	   {
		   finalfinaloutput[i] = (Comparable)finalOutput[i];
	   }
      
      return finalfinaloutput;
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
	   int ia=0, ib=0, ic=0;
	   while(ib<b.length && ic<c.length)
	   {
		   if(((Comparable)b[ib]).compareTo((Comparable)c[ic])<0){a[ia++]=b[ib++];}
		   else{a[ia++]=c[ic++];}
	   }
	   while(ic<c.length){a[ia++]=c[ic++];}
	   while(ib<b.length){a[ia++]=b[ib++];}
   }
}
