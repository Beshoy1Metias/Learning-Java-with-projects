/*
   Foundations of Computer Science
   Programming Test - 1 February 2023
*/
/** 
   Defines the Exception for an Empty stack
   Thrown by methods in the Stack class to indicate that the stack is empty
*/
public class EmptyStackException extends RuntimeException
{
   public EmptyStackException()
   {
   }

   public EmptyStackException(String err)
   {
      super(err);
   }
}
