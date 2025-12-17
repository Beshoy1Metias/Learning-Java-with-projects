/**
  *         FOUNDATIONS OF COMPUTER SCIENCE - A.A. 2014-15
  *                 Programming Test - 17-02-2015
  *
  * Test class of the Q class
  *
  * @see Q
  *
  * @author A. Luchetta
  * @version 15-Feb-2015
  *
  */
public class TestQ
{
   public static void main(String[] args) throws java.io.IOException
   {
      // generate a queue to contain strings 
      Q<String> q = new Q(); 
 
      // read data from file and inserting data into the queue
      java.util.Scanner in = new java.util.Scanner(System.in);
      while (in.hasNext()) 
      {  
         q.enqueue(in.next());       // test of enqueue method 
      }                                            
      in.close();
      
      // test the size method
      System.out.println("***size = " + q.size());
                                
      // test the toArray method
      System.out.print("***toArray = ");
      Object[] v = q.toArray();                         
      for (int i = 0; i < v.length;i++) 
      {
         System.out.print(v[i] + " ");  
      }              
                           
      // test front and queue methods
      System.out.print("\n***front + dequeue = "); 
      while (!q.isEmpty())
      {
         System.out.print(q.front() + "/" + q.dequeue() + " ");
      }
      
      // test size method
      System.out.println("\n***size = " + q.size());
   }   
}  
