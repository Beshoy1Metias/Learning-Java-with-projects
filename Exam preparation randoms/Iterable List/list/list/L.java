public class L<E> implements List<E>
{
	private Object[] v;
	private int vSize;
	private static final int INITIAL_CAPACITY=1;
	/**
      Returns an iterator over the elements of type T
      @return an iterator over the elements in a list in proper sequence
   */
   public Iterator<E> iterator()
   {
	   return new listIterator<E>();
   }
   private class listIterator<E> implements Iterator<E>
   {
	   
	   private int index;
	   private int previous;
	   private final static int ILLEGAL_STATE=-1;
	   public listIterator()
	   {
		   index=0;
		   previous=ILLEGAL_STATE;
	   }
	    
   /**	
      Returns true if the iteration has more elements.
      @return true if the  iterator has more elements.   
   */
   public boolean hasNext()
   {
	   return index<vSize;
   }
   
   /**
      Returns the next element in the list and moves forward the iterator
      position
      @return the next element in the list
      @throws java.util.NoSuchElementException if the iteration has no more
              elements
   */
   public E next()
   {
	   if(!hasNext()){throw new java.util.NoSuchElementException();}
	   previous=index;
	   return (E)v[index++];
   }
   
   /**
      Removes from the list the last element that was returned by this iterator.
      This call can only be made once per call to next
      @throws IllegalStateException if next has not been called, or remove or
              add have been called after the last call to next
   */
   public void remove()
   {
	   if(previous<0){throw new IllegalStateException();}
	   for(int j=previous; j<vSize-1; j++)
	   {
		   v[j]=v[j+1];
	   }
	   index=previous;
	   v[vSize-1]=null;
	   vSize--;
	   previous=ILLEGAL_STATE;
	   
   }
   }
 /**
     Inserts the specified element at the last position in this list
     @param element the specified element
     @throws IllegalArgumentException if the specified element is null                   
   */
   public void add(E element)
   {
	   if(element==null){throw new IllegalArgumentException();}
	   if(vSize>=v.length)
	   {
		   Object[] tmp = new Object[v.length*2];
		   System.arraycopy(v, 0, tmp, 0, vSize);
		   v = tmp;
	   }
	   v[vSize++]=element;
   }
   
 /**
     Inserts the specified element at the specified position i this list
     Shifts the element in that position and the following elements to the right
     (adds 1 to the indeces)
     @param index the specified position
     @param element the specified element
     @throws java.lang.IndexOutOfBoundsException if the the specified position
             is outside the valid range [0, number of elements in the list]
     @throws IllegalArgumentException if the specified element is null                   
   */
   public void add(int index, E element)
   {
	   if(element==null){throw new IllegalArgumentException();}
	   if(vSize>=v.length)
	   {
		   Object[] tmp = new Object[v.length*2];
		   System.arraycopy(v, 0, tmp, 0, vSize);
		   v = tmp;
	   }
	   if(index <0 || index>vSize){throw new IndexOutOfBoundsException();}
	   
	   
	   for(int i=index; i<vSize; i++)
	   {
		   v[i+1]=v[i];
	   }
	   v[index]=element;
	   vSize++;
   }
     
   /**
      Returns the element at the specified position in this list
      @param index the specified position
      @return the element at the specified position
      @throws java.lang.IndexOutOfBoundsException if the the specified position
              is outside the valid range [0, number of elements in the list - 1] 
   */
   public E get(int index)
   {
	   if(index <0 || index>vSize-1){throw new IndexOutOfBoundsException();}
	   return (E)v[index];
   }
      
   /**
      Returns the position of the specified element if it exists in this list
      @param element the specified element
      @return the position of the first occurrence of the specified element in
              this list or -1 if the element is not present in this list
   */
   public int rankOf(E element)
   {
	   return linearSearch(element);
   }    
   private int linearSearch(E element)
   {
	   for(int i=0; i<vSize; i++)
	   {
		   if(v[i].equals(element)){return i;}
	   }
	   return -1;
   }
   
   /**
      returns an array containing the elements of this list in the sequence in
      which they are in this list
      @return an array containing the elements of this list in the sequence in
              which they are in this list
   */
   public Object[] toArray()
   {
	   Object[] tmp = new Object[vSize];
	   System.arraycopy(v, 0, tmp, 0, vSize);
	   return tmp;
   }
   
   /**
      checks if this container is empty
      @return true if this container is empty
   */
   public boolean isEmpty()
   {
	   return vSize<=0;
   }

   /**
      makes this container empty
   */
   public void makeEmpty()
   {
	   vSize=0;
	   v = new Object[INITIAL_CAPACITY];
   }
   public L()
   {
	   makeEmpty();
   }
   /**
      returns the number of data items in this container
      @return the number of data items in this container
   */
   public int size()
   {
	   return vSize;
   }
	
}