// Mock Exam dated January 14, 2026

/**
  * Defines the exception of the empty stack
  *
  * @author A. Luchetta
  * @version 07-Jan-2026
  */
public class EmptyStackException extends RuntimeException
{
   /**
      Constructs a new EmptyStackException
   */
   public EmptyStackException()
   {
   }

   /**
      Constructs a new EmptyStackException with the specified error message
      @param message the specified error message
   */
   public EmptyStackException(String message)
   {
      super(message);
   }
}
