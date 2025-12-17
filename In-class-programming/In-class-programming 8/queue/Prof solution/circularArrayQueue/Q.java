/**
  *         FOUNDATIONS OF COMPUTER SCIENCE - A.A. 2014-15
  *                      Programming Test - 17-02-2015
  *
  * Implements a queue, that is a collection of items with FIFO (First In
  * First Out) access policy, where the first  item inserted (front)
  * is the first extracted.
  *
  * Implementation with a circular array
  *
  * @param T the parametric data type of the item of the queue
  *
  * @author A. Luchetta
  * @version 9-Feb-2015
  *
  */
public class Q<T> implements Queue<T> // implements a queue
{  
   // class constants  
   private static final int INITIAL_CAPACITY = 1;
   
   // instance variables   
   private int front, back;
   private Object[] v;                     // attention: array of Objects!
   
   
   /**
      constructs an empty queue
   */
   public Q()
   {
      front = back = 0;
      v = new Object[INITIAL_CAPACITY];    // attention: array of Objects!
   }

   /*
      removes the front item from this queue and returns it 
      @return the front item removed from this queue
      @throws EmptyQueueException if this queue is empty
   */
   public T dequeue() throws EmptyQueueException // O(1)
   {       
      // temporarily store the item to be removed 
      T ret = front();    // throws EmptyQueueException if the queue is empty

      // remove the item
      v[front] = null;         // garbage collector

      // advance the front index
      front = increment(front);
         
      return ret; 
   }  
   
   /**
      inserts the specified item into this queue
      @param x the specified item to be inserted
      @throws java.lang.IllegalArgumentException if the specified item is null
   */
   // O(n) in the worst case (resize)
   // O(1) in the other cases
   public void enqueue(T x) throws IllegalArgumentException 
   {                                                        
      // check preconditions
      if (x == null)
      {
         throw new IllegalArgumentException();
      }
         
      // dinamically resize if needed  - O(n)
      if (isFull())
      {
         Object[] newV = new Object[2 * v.length];
         int j = front;     // index in the old array (v)
         int size = size();
         for (int i = 0; i < size; i++) // i is the index in newV
         {
            newV[front + i] = v[j];     // copying from old to new array
            j = increment(j);           // circular increment of the v index
         }
         
         v = newV;

         // set the new back index as front + vSize
         back = front + size;    // front remains unchanged, only back changes   
      }  
         
      // insert the new item into the queue
      v[back] = x;
      
      // advance the back index
      back = increment(back);
   } 
   
   /**
      returns the front item of this queue
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
         
      // inspect front item
      return (T)v[front];             // notice: the type cast is needed
   }
   
  /**
      checks if this queue is empty
      @return true if this queue is empty, false otherwise
   */
   public boolean isEmpty()
   {
      return front == back;
   }   
   
   /**
      returns the number of items in this queue
      @return number of items in this queue
   */
   public int size()
   {
      if (front <= back)  // case in which items are placed in line
      {
         return back - front;
      }
      else                // case in which items are places in circular array
      {
         return v.length - front + back;
      }   
   }   
   
   /**
      returns an array containing the items of this queue in the FIFO
      sequence with the front of this queue at index zero. The size of the array
      is equal to the number of items in this queue
      @return an array containing the items of this queue, if the queue is
              not empty, otherwise an empty array
   */
   // O(n)
   public Object[] toArray()
   {
      // generate the return array
      Object[] r = new Object[size()];    // return array - length is size()
 
      // copy the items into the return array starting from the front item
      int j = front;                     // index in array v
      for (int i = 0; i < r.length; i++) // i index in the return array
      {
         r[i] = v[j];          // copying into the return array
         j = increment(j);     // circular increment
      }
      
      return r;
   }
   
   // increment
   private int increment(int n)
   {
      return (n + 1) % v.length;
   }
   
   // isFull
   private boolean isFull()
   {
      return increment(back) == front;
   }
}  
