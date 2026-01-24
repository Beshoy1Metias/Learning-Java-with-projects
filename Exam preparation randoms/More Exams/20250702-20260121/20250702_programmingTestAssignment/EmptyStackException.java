// FOUNDATIONS OF COMPUTER SCIENCE
// Exam dated 2 July 2025

/**
   Thrown by methods in the Stack class to indicate that the stack is empty.
   
   @author A.Luchetta
   @version 26 June 2025
*/

public class EmptyStackException extends RuntimeException
{
   /**
      Constructs a new EmptyStackException without error message string.   
   */
   public EmptyStackException() { super(); }
   
   /**
      Constructs a new EmptyStackException with error message string.
      @param message the error message string 
   */   
   public EmptyStackException(String message) { super(message); }
}
