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
      this();
	  for(int i=0; i<a.length; i++)
	  {
		  super.add(a[i]);
	  }
   }
   
    /**
      initializes this set with the elements of the specified set
	   @param s the specified set
   */
   public SE(Set s)
   {
	 this();
	 Iterator<E> iter = s.iterator();
	 while(iter.hasNext())
	 {
		 super.add(iter.next());
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
     Iterator<E> iter = iterator();
	 Iterator<E> iters = s.iterator();
      while(iter.hasNext() && iters.hasNext())
	  {
		  E tmp1 = iters.next();
		  E tmp2 = iter.next();
		  if(tmp1.compareTo(tmp2)<0){return -1;}
		  else if(tmp1.compareTo(tmp2)>0){return 1;}
	  }
	  if(iters.hasNext()){return -1;}
	  if(iter.hasNext()){return 1;}
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
      Iterator<E> iter = iterator();
	  return iter.next();
              
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
      SE<E> extendedSet = new SE<E>();
	  while(iter.hasNext()){extendedSet.add(iter.next());}
         
      return extendedSet;      
   } 
}
