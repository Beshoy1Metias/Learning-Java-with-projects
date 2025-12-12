/*
   Foundations of Computer Science
   Programming Test - 1 February 2023
*/
/**  
   Defines a container of items. 
   
*/
public interface Container
{
   /**
      Checks if this container is empty
      @return true if this container is empty
   */
   boolean isEmpty();

   /**
     Makes this container empty
   */
   void makeEmpty();
   
   /**
      Returns the size of this container
      @return  the number of items in this container
   */
   int size();
}
