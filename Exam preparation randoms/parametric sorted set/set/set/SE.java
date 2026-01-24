/**
  * FOUNDATIONS OF COMPUTER SCIENCE
  * Programming test dated 29-01-2020
  *
  * Implements an extended set
  *
  * @see S
  * @param E the type of elements contained in the set
  *
  * @author A. Luchetta
  * @version 20240112
  */
public class SE<E extends Comparable> extends S<E> implements Comparable<SE<E>>
{
   /**
      constructs an empty set
   */
   public SE()
   {
      super();
   }

   /**
      initializes this set together with the elements of the specified array
	   @param a the specified array
   */
   public SE(E[] a)
   {
      super();
	  for(int i=0; i<a.length;i++)
	  {
		  add((E)a[i]);
	  }
   }
   
    /**
      initializes this set with the elements of the specified set
	   @param s the specified set
   */
   public SE(Set s)
   {
		super();
		Comparable[] a = new Comparable[s.size()];
		s.toSortedArray(a);
		for(int i=0; i<a.length; i++)
		{
			add((E)a[i]);
		}
   }     

   /**
      defines the natural order of the class
      @param s the specified extended set
      @return zero if this set and the specified set are equal, a negative
	      number if this set precedes the specified set, otherwise a
	      positive number
      @throws NullPointerException if the specified set is null
   */           
   @Override // guarantees to override compareTo of the Comparable interface
   public int compareTo(SE<E> s) throws NullPointerException
   {
	   if(s == null){throw new NullPointerException();}
     Iterator<E> iter = iterator();
     Iterator<E> iter2 = s.iterator();
	 while(iter.hasNext() && iter2.hasNext())
	 {
		 E first = iter.next();
		 E second = iter2.next();
		 if(first.compareTo(second)<0){return -1;}
		 else if(first.compareTo(second)>0){return 1;}
	 }
	 if(iter.hasNext()){return 1;}
	 if(iter2.hasNext()){return -1;}
      return 0; // the sets are the same
   }

/**
      NOTE 1: recursive realization
	   The recursive implementation is less efficient than a corresponding
	   iterative implementation due to the sequence of method calls
	   generated at run time.
	   NOTE 2: The method must not modify this set
	   @return the minimum element of the collection
	   @throws java.util.NoSuchElementException if there is no minimum element
   */
   @Override  
   public E min() throws java.util.NoSuchElementException
   {
	   if(isEmpty()){throw new java.util.NoSuchElementException();}
	   Iterator<E> iter = iterator();
	   
	   E item = iter.next();
	   
	   if(size()==1){return item;}
	   iter.remove();
	   E minimum = min();
	   add(item);
	   if(minimum.compareTo(item)>0){minimum=item;}
	   return minimum;
   }

   /**
      returns an extended set that contains the elements that can be inspected
      with the specified iterator
      @param iterates the specified iterator
	   @return an extended set that contains the elements of this set accessible
	           through the specified iterator. Returns an empty set if the
	           specified iterator is null
   */
   public SE<E> subset(Iterator<E> iter)
   {
      SE<E> s1 = new SE<E>();
		while(iter.hasNext()){s1.add(iter.next());}
		return s1;
   } 
}
