public class S<E extends Comparable> implements Set<E> 
{
	private Object[] v;
	private int vSize;
	public S() // constructs an empty sorted set
	{
		v = new Object[1];
		vSize=0;
	} 
	public S(E[] a)// constructs a sorted set containing the elements of the specified array
	{
		this();
		for(int i=0; i<a.length; i++)
		{
			add(a[i]);
		}
	} 
	// 
	public S(Set s)
	{
		this();
		Comparable[] a = new Comparable[s.size()];
		s.toSortedArray(a);
		for(int i=0; i<a.length; i++)
		{
			add((E)a[i]);
		}
		
	} // constructs a sorted set containing the elements of
	// of the specified set
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
	
	   /**
      Returns an iterator over the sequence
      @return an iterator over the sequence
   */
   public Iterator<E> iterator()
   {
	   return new ListIterator();
   }
   private class ListIterator<T> implements Iterator<T>
   {
	   private int current;
	   private int previous;
	   public ListIterator()
	   {
		   current=0;
		   previous=-1;
	   }
	   /**
      Checks if there are more elements
      @return true if the iteration has subsequent elements
   */
   public boolean hasNext()
   {
	   return current <vSize;
   }

   /**
      Inspects the element following the position of this iterator
      @return the next element in the iteration
      @throws java.util.NoSuchElementException if the iteration has no
              subsequent elements
   */   
   public T next() throws java.util.NoSuchElementException
   {
	   if(!hasNext()){throw new java.util.NoSuchElementException();}
	   previous=current;
	   return (T)v[current++];
   }
   
   /**
      Remove the last element inspected by this iterator
      @throws java.lang.IllegalStateException if the next method has not been
              called before or the remove method has been called after the last
              call to the next method
   */
   public void remove() throws java.lang.IllegalStateException
   {
	   if(previous<0){throw new IllegalStateException();}
	   for(int i=previous;i<vSize-1;i++)
	   {
		   v[i]=v[i+1];
	   }
	   v[vSize-1]=null;
	   vSize--;
	   current = previous;
	   previous =-1;
   } 
   }
	
	/**
      Inserts the specified element into this set if it is not null and not
      already in the set
      @param e the specified element to insert
      @return true if this set did not already contain the specified element
   */
   public boolean add(E e)
   {
	   if( e==null || contains(e) )
	   {
		   return false;
	   }
	   if(vSize>=v.length)
	   {
		   Object[] tmp = new Object[v.length*2];
		   System.arraycopy(v, 0, tmp, 0, vSize);
		   v=tmp;
	   }
	   int j=vSize-1;
	   while(j>=0 && ((Comparable)v[j]).compareTo(e)>0)//3459 6
	   {
		   v[j+1]=v[j];
		   j--;
	   }
	   vSize++;
	   v[j+1]=e;
	   return true;
   }
     
   /**
      Checks if the specified element is present in this set
      @param element the specified element
      @return true if this set contains the specified element
   */
   public boolean contains(E element)
   {
	   return !(recBinSearch(v, 0, vSize-1, element)<0);
   }
   
   private int recBinSearch(Object[] a, int from, int to, E e)
   {
	   if(from>to){return -1;}
	   int mid = (from +to)/2;
	   if(a[mid].equals(e)){return mid;}
	   else if(((Comparable)a[mid]).compareTo(e)<0){return recBinSearch(a, mid+1, to, e);}
	   else{return recBinSearch(a, from, mid-1, e);}
   }
     
   /**
      Checks if this set is empty
      @return true if this set is empty
   */
   public boolean isEmpty()
   {
	   return vSize<=0;
   }

   /**
      Returns the number of elements of this set
      @return the number of items in this set   
   */
   public int size()
   {
	   return vSize;
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
	   if(a.length<size()){throw new ArrayIndexOutOfBoundsException();	}
	   int count =0;
	   Iterator<E> iter = iterator();
	   while(iter.hasNext())
	   {
		   a[count++]=iter.next();
	   }
	   return count;
   }

}