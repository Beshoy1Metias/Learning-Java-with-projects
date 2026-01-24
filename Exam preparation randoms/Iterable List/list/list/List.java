/** FOUNDATIONS OF COMPUTER SCIENCE
  * PROGRAMMING TEST DATED 3-July-2019
  *
  * Defines a list of parametric data types
  *
  * @param <E> - the parametric type of the elements in the list
  *
  * @see Container
  * @see Iterable
  * @see Iterator
  *
  * @author A. Luchetta
  * @version 18-06-2019
  */
public interface List <E> extends Container, Iterable
{
 /**
     Inserts the specified element at the last position in this list
     @param element the specified element
     @throws IllegalArgumentException if the specified element is null                   
   */
   void add(E element);
   
 /**
     Inserts the specified element at the specified position i this list
     Shifts the element in that position and the following elements to the right
     (adds 1 to the indeces)
     @param index the specified position
     @param element the specified element
     @throws java.lang.IndexOutOfBoundsException if the the specified position
             is outside the valid range [0, number of elements in the list]
     @throws IllegalArgumentException if the specified element is null                   
   */
   void add(int index, E element);
     
   /**
      Returns the element at the specified position in this list
      @param index the specified position
      @return the element at the specified position
      @throws java.lang.IndexOutOfBoundsException if the the specified position
              is outside the valid range [0, number of elements in the list - 1] 
   */
   E get(int index);
      
   /**
      Returns the position of the specified element if it exists in this list
      @param element the specified element
      @return the position of the first occurrence of the specified element in
              this list or -1 if the element is not present in this list
   */
   int rankOf(E element);    
   
   /**
      returns an array containing the elements of this list in the sequence in
      which they are in this list
      @return an array containing the elements of this list in the sequence in
              which they are in this list
   */
   Object[] toArray();
}
