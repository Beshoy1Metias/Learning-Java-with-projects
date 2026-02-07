/**
  * Defines a container
  *
  * @author A. Luchetta
  * @version 18-Nov-2016
  */
public interface Container
{
   /**
      checks if this container is empty
      @return true if this container is empty
  */
   boolean isEmpty();

   /**
      makes this container empty
   */
   void makeEmpty();

   /**
      returns the number of data items in this container
      @return the number of data items in this container
   */
   int size();
}  
