// FOUNDATIONS OF COMPUTER SCIENCE
// Exam dated 2 July 2025

/**
   Defines a stack that is a data container where data is inserted/extracted by
   using the Last-in-First-out data policy.
   
   @author A.Luchetta
   @version 26 June 2025
*/
public interface Stack
{
   /**
      Checks if this stack contains the specified item.
      @param item the specified item to be checked
      @return true if this stack contains the specified item      
   */
   boolean contains(Object item);
   
   /**
      Returns true if this stack is empty
      @return true if this stack is empty.
   */
   boolean isEmpty();
   
   /**
      Makes this set empty.
   */
   void makeEmpty();

   /**
      Removes the object at the top of this stack and returns that object as
      the value of this function.
      @return The object at the top of this stack.
      @throws EmptyStackException if this stack is empty
   */
   Object pop() throws EmptyStackException;
   
   /**
      Pushes an item onto the top of this stack, if not null.
      @param item the item to be pushed onto this stack.
   */
   void push(Object item);
   
   /**
      Returns the number of item in this stack.
      @return the number of item in this stack
   */
   int size();
   
   /**
      Looks at the object at the top of this stack without removing it from the
      stack.
      @return the object at the top of this stack.
      @throws EmptyStackException if this stack is empty. 
   */
   Object top() throws EmptyStackException;
}
