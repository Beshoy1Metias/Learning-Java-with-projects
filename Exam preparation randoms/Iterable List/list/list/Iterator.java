/** FOUNDATIONS OF COMPUTER SCIENCE
  * PROGRAMMING TEST DATED 3-July-2019
  *
  * Defines an iterator over a list, i.e. a tool that allows the programmer
  * to step through the list and modify it while iterating
  *
  * @param <T>- the parametric type of the elements in the list
  *
  * @author A. Luchetta
  * @version 18-06-2019
  */
public interface Iterator<T>
{   
   /**	
      Returns true if the iteration has more elements.
      @return true if the  iterator has more elements.   
   */
   boolean hasNext();
   
   /**
      Returns the next element in the list and moves forward the iterator
      position
      @return the next element in the list
      @throws java.util.NoSuchElementException if the iteration has no more
              elements
   */
   T next();
   
   /**
      Removes from the list the last element that was returned by this iterator.
      This call can only be made once per call to next
      @throws IllegalStateException if next has not been called, or remove or
              add have been called after the last call to next
   */
   void remove();
}
