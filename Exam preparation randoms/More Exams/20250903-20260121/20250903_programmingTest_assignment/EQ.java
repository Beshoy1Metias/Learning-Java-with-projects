/**
  *        FOUNDATIONS OF COMPUTER SCIENCE - A.A. 2024-25
  *                Programming Test - 03-09-2025
  *
  * Implements an extended queue.
  *
  * @author A. Luchetta
  * @version 18-Jan-2025
  *
  */
public class EQ extends Q
{
   /**
      Constructs an empty extended queue
   */
   public EQ()
   {
      super();
   }
   
   /**
      Constructs an extended queue with the same elements as the specified
      queue in the same FIFO sequence. If the specified queue is null,
      constructs an empty extended queue
      @param q the specified extended queue
      @throws NullPointerException if the specified queue is null
   */
   public EQ(EQ q)
   {
      if(q==null){throw new NullPointerException();}
	  int len = q.size();
	  for(int i=0;i<len;i++)
	  {
		  enqueue(q.dequeue());
	  }
	  
   }
   
   /**
      Returns the maximum item in this extended queue - recursive implementation
      @return the maximum item in this extended queue if this extended queue in not
              empty or otherwise null
   */
   @Override
   public Comparable maxItem()
   {
      if(isEmpty()){return null;}
	  recursivehelper();
	  return recursivehelper();
   }
   private Comparable recursivehelper()
   {
	   if(size()<=1){return front();}
	   Comparable curFront = dequeue();
	   Comparable max = recursivehelper();
	   enqueue(curFront);
	   if(curFront.compareTo(max)>0){max = curFront;}
	   return max;
   }
   
             
   /**
      Returns an array that contains the elements of this extended queue in the same FIFO
      sequence as in this extended queue with the front item at index 0.
      @return an array that contains the element of this extended queue in the same FIFO
      sequence as in this extended queue if it is not empty or otherwise an empty array.
   */
   public Comparable[] toArray()
   {
      if(isEmpty()){return null;}
	  EQ q1 = new EQ();
	  int len = size();
	  Comparable[] arr = new Comparable[len];
	  for(int i=0; i<len;i++)
	  {
		  arr[i]=front();
		  q1.enqueue(dequeue());
	  }
	  for(int i=0; i<len; i++)
	  {
		  enqueue(q1.dequeue());
	  }
	  return arr;
	  
   }
}  
