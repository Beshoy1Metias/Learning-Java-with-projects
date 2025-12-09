/**
  * Foundations of Computer Science - Group 2
  * Programming test - 16-07-2018
  *
  * Defines the abstract data type stack, that is a data contaainer with Last
  * In First Out (LIFO) access policy
  *
  * @typeparam T the parametric type of the element of the stack
  *
  *  @see Container
  *  @see EmptyStackException
*/
public interface Stack<T> extends Container // Stack ADT
{
   /**
      inserts the specified iltem on top of this stack
      @param o the specified item
   */
   void push(T o);
   
   /**
      inspect the item at the top of this stack
      @return the item at the top of this stack
      @throws EmptyStackException if this stack is empty
   */
   T top() throws EmptyStackException;

   /**
      removes the item at the top of this stack
      @return the item removed
      @throws EmptyStackException if the stack is empty
   */
   T pop()throws EmptyStackException;
}
