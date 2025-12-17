/**
  *         FOUNDATIONS OF COMPUTER SCIENCE - A.A. 2014-15
  *                Programming Test - 17-02-2015
  *
  * Implements a queue, that is a collection of items with FIFO (First In
  * First Out) access policy, where the first item inserted (front)
  * is the first extracted.
  *
  * T is the parametric data type of the item of the queue
  *
  * @author A. Luchetta
  * @version 9-Feb-2015
  *
  */
  
// Implementation with a partially filled array  
public class Q<T> implements Queue<T> // implements the queue ADT
{  
   // class constants
   private static final int INITIAL_CAPACITY = 1;
   
   // instance variables
   private Object[] v;                   // Object[] data type!
   private int vSize;  
   
   /**
      constructs an empty queue
   */
   public Q()
   {
      v = new Object[INITIAL_CAPACITY];  // array of Objects!
      vSize = 0;
   }

   /*
      removes the front item from this queue and returns it
      @return the front item removed from this queue
      @throws EmptyQueueException if this queue is empty
   */
   public T dequeue() throws EmptyQueueException //O(n) in avrg. and worst cases
   {       
      // temporarily store the item to be removed 
      T ret = front();       // throws EmptyQueueException if the queue is empty

      // shift to the left to keep the array compact - O(n)
      for (int i = 0; i < vSize - 1; i++)  // note the upper limit!
      {
         v[i] = v[i + 1];
      }

      // remove front item
      v[vSize - 1] = null;                 // garbage collector

      // update item counter
      vSize--;
         
      return ret; 
   }  
   
   /**
      inserts the specified item into this queue
      @param x the specified item to be inserted
      @throws java.lang.IllegalArgumentException if the specified item is null
   */
   // O(n) in the worst case
   // O(1) in the average and best cases
   public void enqueue(T x) throws IllegalArgumentException
   {                                                        
      // check preconditions
      if (x == null)
      {
         throw new IllegalArgumentException();
      }
         
      // dinamically resize, if needed - O(n)
      if (vSize >= v.length)
      {
         Object[] newV = new Object[2 * v.length];
         System.arraycopy(v, 0, newV, 0, v.length);
         
         v = newV;  
      }  
         
      // insert the item into the queue
      v[vSize] = x;
      
      // update the number of items
      vSize++;
   } 
   
   /**
      provides the front item of this queue
      @return the front item of this queue
      @throws EmptyQueueException if this queue is empty
   */
   // O(1)
   public T front() throws EmptyQueueException
   {
      // check preconditions
      if (isEmpty())
      {
         throw new EmptyQueueException();
      }
         
      // inspect the front item
      return (T)v[0];  // attention: the type cast is needed
   }
   
  /**
      checks if this queue is empty
      @return true if this queue is empty, false otherwise
   */
   public boolean isEmpty()
   {
      return vSize <= 0;
   }   
   
   /**
      returns the number of items in this queue
      @return number of items in this queue
   */
   public int size()
   {
      return vSize;
   }   
   
   /**
      returns an array containing the items of this queue in the FIFO
      sequence with the front of this queue positioned at index zero. The size
      of the array is equal to the number of items in this queue
      @return an array containing the items of this queue, if the queue is not
              empty, otherwise an empty array
   */
   // O(n)
   public Object[] toArray() 
   {
    /* ATTENTION: returning the inner array is a violation of the encapsulation
       principle!
    */ 

      // generate the return array
      Object[] r = new Object[vSize];
      
      // copy the queue items into the return array
      System.arraycopy(v, 0, r, 0, r.length);
      
      return r;
   }
}  
