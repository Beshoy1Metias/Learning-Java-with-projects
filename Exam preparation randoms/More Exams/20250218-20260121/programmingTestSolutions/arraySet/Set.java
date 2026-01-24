/**
   Defines a set, which is a data container that contains no duplicate elements.
      
   Type Parameters:
      @param <E> the parametric type of data items in this set.
      
   @author A. Luchetta
   @version 11 Jan. 2025
*/
public interface Set<E>
{
   /**
      Inserts the specified data item into this set if it is not null and not
      already present.
      @param item element to be added to this set.
      @return true if this set did not already contain the specified element.
   */
   boolean add(E item);
   
   /**
      Checks if this set contains the specified item.
      @param o the data item to be checked.
      @return true if this set contains the specified data item.      
   */
   boolean contains(Object o);  
   
   /**
      Returns true if this set is empty.
      @return true if this set is empty.
   */
   boolean isEmpty();
      
   /**
      Removes the specified data item from this set if it is contained.
      @param item the specified item.
      @return true if this set contained the specified element.
   */
   boolean remove(Object o);
   
   /**
      Returns the number of data item in this set.
      @return the number of data item in this set.
   */
   int size();   
   
   /**
      Returns an array view of this set.
      @return an array containing the data items of this set.
   */
   Object[] toArray();   
}
