/**
  * Foundation of Computer Scienec - Group 2
  * Programming test - 16-07-2018
  *
  * EmptyStackException
  *
  * @see java.lang.RuntimeException
  *
  * @author A. Luchetta
  * @version 20-Nov-2018
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
