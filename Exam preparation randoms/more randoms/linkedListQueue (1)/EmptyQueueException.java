/**
  *         FOUNDATIONS OF COMPUTER SCIENCE - CHANNEL 4 - A.A. 2014-15
  *                      Programming Test - 17-02-2015
  *
  * EmptyQueueException
  *
  * @author A. Luchetta
  * @version 9-Feb-2015
  *
  */
public class EmptyQueueException extends RuntimeException
{  
   /*
      default constructor
   */
   public EmptyQueueException()
   {
      super();
   } 
   
   /*
      constructs the exception with the specified error message
      @param message the specified error message
   */
   public EmptyQueueException(String message)
   {
      super(message);
   }  
}  
