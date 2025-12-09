/**
  * Fondamenti di Informatica - Gruppo 2
  * Prova di programmazione del 16-07-2018
  *
  * EmptyLinkedListException
  * @author A. Luchetta
  */
public class EmptyLinkedListException extends RuntimeException
{
   public EmptyLinkedListException()
   {
   }

   public EmptyLinkedListException(String err)
   {
      super(err);
   }
}
