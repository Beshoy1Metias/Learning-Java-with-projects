public class S<E extends Comparable> implements Set<E> {
private Comparable[] v;
int vSize;
private Iterator<E> iter;
 public S()
 {
	 v = new Comparable[1];
	 vSize=0;
	 iter = iterator();
 } // constructs an empty sorted set
 private void mergeSort(Comparable[] a)
 {
	 if(a.length<2){return;}
	 int mid = a.length/2;
	 Comparable[] left = new Comparable[mid];
	 Comparable[] right = new Comparable[a.length - mid];
	 System.arraycopy(a, 0, left, 0, left.length);
	 System.arraycopy(a, mid, right, 0, right.length);
	 mergeSort(left);
	 mergeSort(right);
	 merge(a, left, right);
 }
 private void merge(Comparable[] a, Comparable[] b, Comparable[] c)
 {
	 int ia=0, ib=0, ic=0;
	 while(ib<b.length && ic<c.length)
	 {
		 if(b[ib].compareTo(c[ic])<0)
		 {
			 a[ia++]=b[ib++];
		 }
		 else{a[ia++]=c[ic++];}
	 }
	 while(ib<b.length){a[ia++]=b[ib++];}
	 while(ic<c.length){a[ia++]=c[ic++];}
 }
 public S(E[] a)
 {
	 mergeSort(a);
	 v= new Comparable[a.length];
	 vSize=0;
	 for(int i=0; i<a.length;i++)
	 {
		 add(a[i]);
	 }
	 
 } // constructs a sorted set containing the elements of
 // the specified array
 public S(Set s){
	 S sett = new S();
	 /*Comparable[] arr = s.toSortedArrayy();
	 for(int i=0; i<arr.length; i++)
	 {
		 sett.add(arr[i]);
	 }*/
 } // constructs a sorted set containing the elements of
 // of the specified set
 public Iterator<E> iterator()
 {
	 return new arrayIterator(); 
 }
 private class arrayIterator implements Iterator<E>
 {
	 int iter;
	 public arrayIterator(){iter=0;}
	 public boolean hasNext(){return iter<vSize;}
	 public E next() throws java.util.NoSuchElementException
	 {
		 if(!hasNext()){throw new java.util.NoSuchElementException();}
		 return (E)v[iter++];
	}
	   /**
      Remove the last element inspected by this iterator
      @throws java.lang.IllegalStateException if the next method has not been
              called before or the remove method has been called after the last
              call to the next method
   */
	 public void remove() throws java.lang.IllegalStateException 					//TODOOOOOOOOOO
	 {
		if (iter==0){throw new java.lang.IllegalStateException();}
		
	 }
 }
 
 private void resize()
 {
	 Comparable[] tmp = new Comparable[v.length*2];
	 System.arraycopy(v, 0, tmp, 0, vSize);
	 v = tmp;
 }
 public boolean add(E e){ 
	 if(contains(e)){return true;}
	 
	 if(vSize>= v.length)
	 {
		 resize();
	 }
	 int j=vSize-1;
	 while(j>=0 && e.compareTo(v[j])<0)
	 {
		 v[j+1]= v[j];
		 j--;
	 }
	 v[j+1]=e;
	 vSize++;
	 return false;
	 }
 
 public boolean contains(E element)
 {
	 if(isEmpty()){return false;}
	 return binSearch(element, v, 0, vSize-1)!=-1;}
 private int binSearch(E element, Comparable[] a, int start, int end)
 {
	 if(end<start){return -1;}
	 int mid = (end+start)/2;
	 if(a[mid].compareTo(element)==0){return mid;}
	 else if(a[mid].compareTo(element)<0){return binSearch(element, a, mid+1, end);}
	 else{return binSearch(element, a, start, mid-1);}
 }
 public boolean isEmpty(){return vSize<=0;}
 public int size(){return vSize;}
 public int toSortedArray(E[] a) throws ArrayIndexOutOfBoundsException
 {
	 return 0;
 }

 
 
 
 
 
 // search for the minimum element
 public E min() throws java.util.NoSuchElementException 
 {
	 if (isEmpty()) // precondition – the set is empty
	 throw new java.util.NoSuchElementException();
	 // generate an iterator to inspect the set elements
	 Iterator<E> iter = iterator();
	 // first guess for the minimum
	 E min = iter.next();
	 // Inspect the elements and selecting the minimum element
	 while (iter.hasNext()) {
	 E tmp = iter.next();
	 if (tmp.compareTo(min) < 0) min = tmp;
	 }
	 return min;
 }
}