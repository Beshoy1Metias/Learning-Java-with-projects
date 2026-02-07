public class LE<E extends Comparable> extends L<E>
{
	 public int rankOfSortedList(E element)
	 {
		 Object[] arr = toArray();
		 mergeSort(arr);
		 return recBinSearch(arr, 0, arr.length-1, element);
	 }
	 private int recBinSearch(Object[] a, int from, int to, E target)
	 {
		 if(from>to){return -1;}
		 int mid = (to+from)/2;
		 if(((Comparable)a[mid]).compareTo(target)==0){return mid;}
		 else if(((Comparable)a[mid]).compareTo(target)<0){return recBinSearch(a, mid+1, to, target);}
		 else{return recBinSearch(a, from, mid-1, target);}
	 }
	 public List<E> toSortedList()
	 {
		 List<E> n = new LE<E>();
		 Object[] arr = toArray();
		 mergeSort(arr);
		 for(int i=0;i<arr.length;i++)
		 {
			 n.add((E)arr[i]);
		 }
		 return n;
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