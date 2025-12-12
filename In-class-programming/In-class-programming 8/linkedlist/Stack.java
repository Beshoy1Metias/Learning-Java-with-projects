/*
   Foundations of Computer Science
   Programming Test - 1 February 2023
*/
/**  
   Defines the Stack abstract data type with Last In First Out (LIFO) data
   access mode. 
   
   @param T the parametric type of the stack items
   @see EmptyStackException
*/
public interface Stack<T> extends Container // Generic stack ADT
{ 
   /**
      Removes the object at the top of this stack and returns it
      @return the object at the top of this stack
      @throws EmptyStackException if this stack is empty
   */
   T pop()throws EmptyStackException;
   
   /**
      Pushes an item onto the top of this stack, if not null
      @param item the item to be pushed onto this stack
      @throws IllegalArgumentException if the item to be pushed is null
   */
   void push(T item);
   
   /**
      Returns the position of an object in the stack. If the object x is present
      in the stack, the method returns the distance from the top of the stack to
      the nearest occurrence of x. The topmost item on the stack is considered
      to be at distance 0.
      @param x the desired object
      @return the position from the top of the stack where the object is
              located; -1 indicates that the object is not in this stack.    
   */
   int search(T x);
     
   /**
      Looks at the object at the top of this stack without removing it
      @return the object at the top of this stack
      @throws EmptyStackException if this stack is empty
   */
   T top() throws EmptyStackException;
}
