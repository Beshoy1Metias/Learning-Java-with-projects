import java.util.NoSuchElementException;
public class S<E extends Comparable> implements Set<E> {
 private Comparable[] v;
 private int vSize;
 private static final int INITIAL_CAPACITY=1;
 public S() 
 {
	 v= new Comparable[INITIAL_CAPACITY];
	 vSize=0;
 } // constructs an empty sorted set
 public S(E[] a)
 {
	 this();
	 
	 for(E e : a)
	 {
		 add(e);
	 }
 } // constructs a sorted set containing the elements of
 // the specified array
 public S(Set s)
 {
	 this();
	 Iterator<E> iter = s.iterator();
	 while(iter.hasNext())
	 {
		 add(iter.next());
	 }
 } // constructs a sorted set containing the elements of
 // of the specified set
 
 
 
    /**
      Inserts the specified element into this set if it is not null and not
      already in the set
      @param e the specified element to insert
      @return true if this set did not already contain the specified element
   */
   public boolean add(E e)
   {
	   if(contains(e)){return false;}
	   if(vSize>=v.length){resize();}
	   int j=vSize-1;
	   while(j>=0 && e.compareTo(v[j])<0)
	   {
		   v[j+1]= v[j];
		   j--;
	   }
	   v[j+1]=e;
	   vSize++;
	   return true;
   }
   private void resize()
   {
	   Comparable[] tmp = new Comparable[v.length *2];
	   System.arraycopy(v, 0, tmp, 0, vSize);
	   v = tmp;
   }
      /**
      Checks if this set is empty
      @return true if this set is empty
   */
   public boolean isEmpty(){return vSize<=0;}
   public int size(){return vSize;}
    /**
      Checks if the specified element is present in this set
      @param element the specified element
      @return true if this set contains the specified element
   */
   public boolean contains(E element)
   {
	   return binSearch(element, v, 0, vSize-1)>=0;
   }
   private int binSearch(E e, Comparable[] a, int left, int right)
   {
	   if(left>right){return -1;}
	   int mid = (left+right)/2;
	   if(a[mid].equals(e)){return mid;}
	   else if(a[mid].compareTo(e)<0){return binSearch(e, a, mid+1, right);}
	   else{return binSearch(e, a, left, mid-1);}
   }
 
    /**
      Copies the elements of this set to the specified array. The elements in 
      the specified array must be arranged in ascending order according to their
      natural order.
      @return number of elements of this set copied to the specified array
      @throws java.lang.ArrayIndexOutOfBoundsException if the specified array
              length is less than the set size       
   */
   public int toSortedArray(E[] a) throws ArrayIndexOutOfBoundsException
   {
	   if(a.length<size()){throw new ArrayIndexOutOfBoundsException();}
	   int count=0;
	   Iterator<E> iter = iterator();
	   while(iter.hasNext())
	   {
		   a[count++]=iter.next();
	   }
	   return count;
   }
   
      /**
      Returns an iterator over the sequence
      @return an iterator over the sequence
   */
   public Iterator<E> iterator()
   {
	   return new arrayIterator();
   }
   
   public class arrayIterator implements Iterator<E>
   {
	   int current;
	   int lastRead;
	   public arrayIterator()
	   {
		   current =0;
		   lastRead = -1;
	   }
	   /**
      Checks if there are more elements
      @return true if the iteration has subsequent elements
   */
   public boolean hasNext()
   {
	   return current<vSize;
   }
      /**
      Inspects the element following the position of this iterator
      @return the next element in the iteration
      @throws java.util.NoSuchElementException if the iteration has no
              subsequent elements
   */   
   public E next() throws java.util.NoSuchElementException
   {
	   if(!hasNext()){throw new NoSuchElementException();}
	   lastRead=current;
	   return (E)v[current++];
   }
      /**
      Remove the last element inspected by this iterator
      @throws java.lang.IllegalStateException if the next method has not been
              called before or the remove method has been called after the last
              call to the next method
   */
   public void remove() throws java.lang.IllegalStateException //1234 
   {
	   if(lastRead<0){throw new IllegalStateException();}
	   
	   for(int i = lastRead; i<vSize-1;i++)
	   {
		   v[i]=v[i+1];
	   }
	   if (lastRead < current) current--;
	   vSize--;
   }
   
   }
   
   
 // search for the minimum element
 public E min() throws java.util.NoSuchElementException {
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