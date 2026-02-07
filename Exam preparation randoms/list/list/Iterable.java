/** FOUNDATIONS OF COMPUTER SCIENCE
  * PROGRAMMING TEST DATED 3-July-2019
  *
  * Makes a list iterable
  *
  * @param <T> the type on which the iterator operates
  *
  * @author A. Luchetta
  * @version 18-06-2019
  */
public interface Iterable<T>
{
   /**
      Returns an iterator over the elements of type T
      @return an iterator over the elements in a list in proper sequence
   */
   Iterator<T> iterator();
}
