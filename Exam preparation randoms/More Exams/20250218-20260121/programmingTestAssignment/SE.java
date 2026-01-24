/**
   Implements an extended set.
      
   Type Parameters:
      @param <E> the parametric type of data items in this extended set.
      
   @see S
      
   @author A. Luchetta
   @version 11 Jan. 2025
*/
public class SE<E extends Comparable<E>> extends S<E>
{
   /**
      Constructs an empty extended set.
   */
   public SE()
   {
      super();
   }
   
   /**
      Overrides the superclass method of the same name using a recursive algorithm.
      @param item the item to check.
      @return true if this extended set contains the specified item.
   */
   @Override
   public boolean contains(Object o)
   {
      Object[] arr = toSortedArray();
	  return ! (recBinSearch(arr, 0, size()-1, o)<0);
      //return super.contains(o);

   }
   private int recBinSearch(Object[] a, int from, int to, Object o)
   {
	   if(from>to){return -1;}
	   int mid = (from+to)/2;
	   if(a[mid].equals(o)){return mid;}
	   else if(((Comparable)a[mid]).compareTo(o)<0){return recBinSearch(a, mid+1, to, o);}
		else{return recBinSearch(a, from, mid-1, o);}
	   
   }
   
   /**
      Compares the specified object with this extended set for equality.
      @param o the specified object.
      @return true if the specified object equals this extended set.
   */
   @Override
   public boolean equals(Object o)
   {
	   SE<E> s1 = (SE) o;
	   if(size()!=s1.size()){return false;}
        Object[] arr = toSortedArray();
		Object[] arr2 =s1.toSortedArray();
		for(int i=0; i<arr.length; i++)
		{
			if(!arr[i].equals(arr2[i])){return false;}
		}
        
        return true;                              // sets are equal
   }     
   
   /**
      Returns an array containing the data item of this extended set sorted in ascending
      order according to their natural order.
      @return an array containing the data item of this set sorted according to their
              natural order or an empty array if this extended set is empty
   */
   public Object[] toSortedArray()
   {
      Object[] arr = toArray();
	  mergeSort(arr);
	  return arr;
   }
   private void mergeSort(Object[] a)
   {
	   if(a.length<2){return;}
	   int mid = a.length/2;
	   Object[] left = new Object[mid];
	   Object[] right = new Object[a.length -mid];
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
		   if(((Comparable)b[ib]).compareTo(c[ic])<0){a[ia++]=b[ib++];}
		   else{a[ia++]=c[ic++];}
	   }
	   while(ib<b.length){a[ia++]=b[ib++];}
	   while(ic<c.length){a[ia++]=c[ic++];}
   }
}
