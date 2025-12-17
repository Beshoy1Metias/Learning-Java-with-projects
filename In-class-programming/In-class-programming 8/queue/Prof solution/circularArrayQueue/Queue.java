/**
  *        FOUNDATIONS OF COMPUTER SCIENCE - A.A. 2014-15
  *                Programming Test - 17-02-2015
  *
  * Defines a queue, that is collection of items with FIFO (First In First
  * Out) access policy, where the first item inserted (front) is the first
  * extracted.
  * T is the parametric data type of the items of the queue
  
  * @author A. Luchetta
  * @version 9-Feb-2015
  *
  */
public interface Queue <T> // ADT Queue 
{  
   /*
      removes the front item from this queue and returns it 
      @return the front item removed from this queue
      @throws EmptyQueueException if this queue is empty
   */
   T dequeue() throws EmptyQueueException;   
   
   /**
      inserts the specified item into this queue
      @param x the specified item to be inserted
      @throws java.lang.IllegalArgumentException if the specified item is null
   */
   void enqueue(T x) throws IllegalArgumentException; 
   
   /**
      returns the front item of this queue
      @return the front item of this queue
      @throws EmptyQueueException if this queue is empty
   */
   T front() throws EmptyQueueException;
   
  /**
      checks if this queue is empty
      @return true if this queue is empty
   */
   boolean isEmpty();   
   
   /**
      returns the number of items in this queue
      @return number of items in this queue
   */
   int size();   
   
   /**
      returns an array containing the items of this queue in the FIFO
      sequence with the front of this queue at index zero. The size of the array
      is equal to the number of items in this queue 
      @return an array containing the items of this queue, if the queue is
              not empty, otherwise an empty array
   */
   Object[] toArray();  
}  
