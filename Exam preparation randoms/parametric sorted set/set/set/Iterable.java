/**
  * FOUNDATIONS OF COMPUTER SCIENCE
  * Programming test dated 29-01-2020
  *
  * By implementing this interface it is possible to scan the elements of a
  * container in sequence
  *
  * param T the type of items returned by the iterator
  *
  * @see Iterator
  *
  * @author A. Luchetta
  * @version 20200115
  *
  */
public interface Iterable<T>
{
   /**
      Returns an iterator over the sequence
      @return an iterator over the sequence
   */
   Iterator<T> iterator();
}

