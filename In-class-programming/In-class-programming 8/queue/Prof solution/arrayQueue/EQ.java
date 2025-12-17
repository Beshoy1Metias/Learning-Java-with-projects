/**
  *         FOUNDATIONS OF COMPUTER SCIENCE - A.A. 2014-15
  *                Programming Test - 17-02-2015
  *
  * Implements an extended queue
  * T is the parametric data type of the item of the queue
  *
  * @see Q
  *
  * @author A. Luchetta
  * @version 9-Feb-2015
  *
  */
public class EQ<T extends Comparable> extends Q<T>//implements an extended queue
{
   public void enqueue(T x) { super.enqueue(x); } // code provided by teacher
   

   /**
      returns an array containing the extended queue items sorted in ascending 
      order according to the queue element natural order
      @return returns an array containing the extended queue items sorted in
              ascending order according to the queue element natural order
   */
   public Object[] toSortedArray() // O(nlogn) due to mergesort
   {
      // get array with queue items in FIFO sequence
      Object[] v = toArray();
      
      // sort array
      sort(v);
           
      return v;
   }
   
   //sort - implements mergesort - O(nlogn)
   private static void sort(Object[] a) // note: argument is an array of objects
   {
      // base case
      if (a.length < 2) return;
      
      // create new arrays
      int mid = a.length / 2;
      Object[] left = new Object[mid];              // array of Objects
      Object[] right = new Object[a.length - mid];  // array of Objects
      
      // copy elements
      System.arraycopy(a, 0, left, 0, left.length);
      System.arraycopy(a, mid, right, 0, right.length);
      
      // recursive steps
      sort(left);
      sort(right);
      
      // merge
      merge(a, left, right);     
   }
   
   private static void merge(Object[] a, Object[] b, Object[] c)
   {
      int ia = 0, ib = 0, ic = 0;
      
      while (ib < b.length && ic < c.length)
      {
         if (((Comparable)b[ib]).compareTo(c[ic]) < 0) // type cast is needed!
         {
            a[ia++] = b[ib++];
         }
         else
         {
            a[ia++] = c[ic++];
         }
      }
      while (ib < b.length)
      {
         a[ia++] = b[ib++];
         
      }
      
      while (ic < c.length)
      {
         a[ia++] = c[ic++];
         
      }      
   }
   
   /**
      returns an array containing the items of this extended stack without
      duplicates
      @reurn returns an array containing the items of this extended stack 
             without duplicates 
   */
   public Object[] getOnlyUniqueItems() // O(nlogn) due to mergesort
   {
      // return array
      Object[] r = new Object[size()];  // max length can be size, i.e. the
                                        // number of items in this queue

      // sorted array with the queue elements
      Object[] v = toSortedArray(); 
      
      // removing duplicates in an array
      // There are two algorithms to remove duplicates in an array: one requires
      // sorting the array first (time complexity O(nlogn), the other works on
      // an unsorted array (time complexity O(n^2)).
      // Note: if we use the algorithm that sort the array first, the
      // unique items in the return array will be in ascending order.
      // if we use the algorithm to remove duplicates without sorting the array
      // first, the items in the array will be in the FIFO sequence
      // In the method specification, there is no specific requirement on the
      // sequence of items, so we can choose which algorithm we prefer
            
      // Below the solution using the algorithm which works on a sorted array
      r[0] = v[0];      // handles first element in the array
      int j = 1;        // index to scan the return array
      for (int i = 1; i < v.length; i++) // note: the loop starts with index 1
      {
         if (!(v[i].equals(r[j - 1]))) // if element at index i is not the same 
         {                             // as the last inserted into return array
            r[j++] = v[i];             // insert it into the return array
         }
      }
      
      // resize to return a full array
      Object[] ret = new Object[j];  // Note: j is the number of elements 
                                     // inserted into the return array
      System.arraycopy(r, 0, ret, 0, ret.length);

      return ret;
   }
   
   /**
      splits this extended queue (source queue) into multiple extended queues
      (destination queues). The following conditions must hold in the
      destination queues:
      - each item of the source queue is assigned to one and only one
        destination queue
      - all destination queues have the same number of items, except for one unit
      - if item A precedes item B in the source queue and A and B are assigned
        to the same destination queue, then A precedes B in the destination queue
      - running the method does not change the source queue
      @param n the specified number of destination extended queues
      @return an array of queues containing the destination extended queues
      @throw java.lang.IllegalArgumentException if the specified number of
             extended queues is non-positive
   */
   public EQ[] split(int n)
   {
     // check preconditions
     if (n <= 0)
     {
        throw new IllegalArgumentException();
     }
     
     // create and initialize the array of queues
     EQ[] q = new EQ[n];
     for (int i = 0; i < q.length; i++)
     {
        q[i] = new EQ(); //Note: creation of queues is important! Do not forget!
     }
     
     // remove elements from source queue and insert into destionation queues
     int i = 0;
     EQ<T> aq = new EQ();        // auxiliary queue
     while (!isEmpty())          // executes loop to spli source queue
     {
        T item = dequeue();      // dequeues item from source queue
        q[i].enqueue(item);      // insert extracted item into destination queue
                                 // with index i
                                 
        aq.enqueue(item);        // stores extracted item into auxiliary queue
                                 
        i = (i + 1) % q.length;  // increment i using a circular increment
     }
     
     // loop to restore the source queue
     while (!aq.isEmpty())
     {
        enqueue(aq.dequeue()); // moves front item from auxiliary queue to this
                               // queue
     }
         
     return q;
   }
}
