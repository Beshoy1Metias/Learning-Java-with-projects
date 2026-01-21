/**
  * FOUNDATIONS OF COMPUTER SCIENCE
  * Programming test dated 29-01-2020
  *
  * Defines the set abstract data type 
  *
  * param E the parametric type of the set data
  *
  * @see Iterable
  *
  * @author A. Luchetta
  * @version 20200115
  *
  */
public interface Set<E extends Comparable> extends Iterable<E>
{
   /**
      Inserts the specified element into this set if it is not null and not
      already in the set
      @param e the specified element to insert
      @return true if this set did not already contain the specified element
   */
   boolean add(E e);
     
   /**
      Checks if the specified element is present in this set
      @param element the specified element
      @return true if this set contains the specified element
   */
   boolean contains(E element);
     
   /**
      Checks if this set is empty
      @return true if this set is empty
   */
   boolean isEmpty();

   /**
      Returns the number of elements of this set
      @return the number of items in this set   
   */
   int size();
   
   /**
      Copies the elements of this set to the specified array. The elements in 
      the specified array must be arranged in ascending order according to their
      natural order.
      @return number of elements of this set copied to the specified array
      @throws java.lang.ArrayIndexOutOfBoundsException if the specified array
              length is less than the set size       
   */
   int toSortedArray(E[] a) throws ArrayIndexOutOfBoundsException;
}  
 
