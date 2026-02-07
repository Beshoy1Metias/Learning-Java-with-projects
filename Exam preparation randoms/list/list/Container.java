/** FOUNDATIONS OF COMPUTER SCIENCE
  * PROGRAMMING TEST DATED 3-July-2019
  *
  * Defines a data container
  *
  * @author A. Luchetta
  * @version 18-06-2019
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
