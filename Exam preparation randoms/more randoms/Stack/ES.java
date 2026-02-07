// Mock Exam dated January 14, 2026

/**
  * Implements an Extended Stack.
  *
  * @param <E> the parametric type of the elements of the extended stack.
  * @see S
  *
  * @author A. Luchetta
  * @version 07-Jan-2026
  */
public class ES<E extends Comparable> extends S<E>
{   
   /**
      Constructs an empty extended stack.
   */
   public ES()
   {
      super();
   }
   
   @Override
   /**
      Overrides the superclass method with the same name by using a recursive
      implementation.
      @return the minimum element in this stack.
      @throw emptyStackException if this stack is empty.
   */
   public E getMin()
   {
      if(isEmpty()){throw new EmptyStackException();}
      return getMin(size());
      
   }
   private E getMin(int depth)
   {
	   if(depth<2){return top();}
	   E item = pop();
	   E min = getMin();
	   push(item);
	   if(item.compareTo(min)<0){min = item;}
	   return min;
   }
   
   @Override
   /**
      Compares the specified object with this extended stack for equality.
      @param o the specified object to be compared with this extended stack.
   */
   public boolean equals(Object o)
   {
      //TODO
      
      return false;
   }
      
   /**
      Returns an extended stack containing the elements of both this stack and
      the specified one. In the returned stack, elements are sorted in ascending
      order with the maximum element at the top of the extended stack.
      @param s the specified extended stack.
      @return a sorted extended stack containing elements from both this
              extended stack and the specified one, if the specified stack is
              not null, otherwise a sorted stack containing only the elements of
              this stack sorted in ascending order.
   */
   public ES<E> mergeSorted(ES<E> s)
   {
      //TODO
      
      return null;
   }

}
