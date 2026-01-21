/**
  * FOUNDATIONS OF COMPUTER SCIENCE
  * Programming test dated 29-01-2020
  *
  * Defines an iterator
  *
  * param T the type of items returned by this iterator
  
  *
  * @author A. Luchetta
  * @version 20200115
  *
  */
public interface Iterator<T> // Iterator
{
   /**
      Checks if there are more elements
      @return true if the iteration has subsequent elements
   */
   boolean hasNext();

   /**
      Inspects the element following the position of this iterator
      @return the next element in the iteration
      @throws java.util.NoSuchElementException if the iteration has no
              subsequent elements
   */   
   T next() throws java.util.NoSuchElementException;
   
   /**
      Remove the last element inspected by this iterator
      @throws java.lang.IllegalStateException if the next method has not been
              called before or the remove method has been called after the last
              call to the next method
   */
   void remove() throws java.lang.IllegalStateException;  
}
