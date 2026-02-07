// Mock Exam dated January 14, 2026

/**
  * Defines the Stack Abstract Data Type, which is a data container that
  * enforces the Last In First Out (LIFO) data handling policy.
  *
  * @param <E> the parametric type of the stack elements
  * @see EmptyStackException
  *
  * @author A. Luchetta
  * @version 07-Jan-2026
  */
public interface Stack<E>
{
   /**
      Returns the minimum element in this stack based on the natural order
      of the elements of this stack.
      @return the minimum element in this stack.
      @throws EmptyStackException if this stack is empty.
   */
   E getMin();

   /**
      Returns true if this stack contains no elements.
      @return true if this stack contains no elements.
   */
   boolean isEmpty();
   
   /**
      Returns the number of elements in this stack.
      @return the number of elements in this stack.
   */
   int size();
   
   /**
     Removes the element at the top of this stack and returns it.
     @return the element at the top of this stack.
     @throws EmptyStackException if this stack is empty.
   */  
   E pop() throws EmptyStackException;
   
   /**
     Pushes an element onto the top of this stack.
     @param element the element to be pushed onto this stack.
     @throws java.lang.IllegalArgumentException if the specified element is
            null.
     @throws java.lang.ClassCastException if the data type of the specified
            element is not a class that implements the Comparable interface.
   */
   void push(E element);

   /**
     Looks at the element at the top of this stack without removing it from the
     stack.
     @return the element at the top of this stack.
     @throws EmptyStackException if this stack is empty.
   */ 
   E top() throws EmptyStackException;
}
