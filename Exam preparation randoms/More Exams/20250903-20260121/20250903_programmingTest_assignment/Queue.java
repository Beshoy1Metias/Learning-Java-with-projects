/**
  *        FOUNDATIONS OF COMPUTER SCIENCE - A.A. 2024-25
  *                Programming Test - 03-09-2025
  *
  * Defines a queue, that is collection of items with First In First Out (FIFO) access
  * policy, where the first item inserted (front item) is the first extracted.
  *
  * @author A. Luchetta
  * @version 2-Aug-2025
  *
  */
public interface Queue // ADT Queue 
{  
   /**
      Returns true if this queue contains the specified comparable item
      @param item the item to be checked
      @return true if this queue contains the specified item 
   */
   boolean contains(Comparable item);
   
   /**
      Removes the front item from this queue and returns it.
      @return the removed front item of this queue or null if the this queue is empty.
   */
   Comparable dequeue();
   
   /**
      Inserts the specified comparable item into this queue.
      @param item the specified item to be inserted.
      @throws java.lang.IllegalArgumentException if the specified item is null.
   */
   void enqueue(Comparable item) throws IllegalArgumentException; 
   
   /**
      Returns the front item of this queue.
      @return the front item of this queue or null if this queue is empty.
   */
   Comparable front();
   
  /**
      Checks if this queue is empty.
      @return true if this queue is empty.
   */
   boolean isEmpty();
   
   /**
      Makes this queue empty.
   */
   void makeEmpty();
   
   /**
      Returns the maximum item in this queue according to the natural ordering
      of the comparable elements of this queue.
      @return the maximum data item in this queue or null if it is empty.
   */
   Comparable maxItem();
   
   /**
      Returns the number of items in this queue.
      @return number of items in this queue.
   */
   int size();   
}  
