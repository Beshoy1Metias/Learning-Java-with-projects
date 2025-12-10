/**
  * Abstract data type with LIFO access policy 
  * author Goodrich - Tamassia
  * @see Container
  * @see EmptyStackException
*/
public interface Stack extends Container
{  /**
      inserts the specified element on the top of this stack
      @param obj the specified element
   */
   void push(Object obj);

   /**
      removes the element from the top of this stack
      @return the element removed
      @throws EmptyStackException if the stack is empty
   */  
   Object pop() throws EmptyStackException;

   /**
      inspects the element on the top of this stack
      @return the element inspected
      @throws EmptyStackException if the stack is empty
   */ 
   Object top() throws EmptyStackException;
}
