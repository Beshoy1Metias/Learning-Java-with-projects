/**
  *         FOUNDATIONS OF COMPUTER SCIENCE - A.A. 2014-15
  *               Programming Test - 17-02-2015
  *
  * Test class the EQ class
  *
  * @see EQ
  *
  * @author A. Luchetta
  * @version 15-Feb-2015
  *
  */
public class MainEQ
{
   public static void main(String[] args)
   {
      // constants
      final int DEST_QUEUES_NO = 3;

      // generate a queue to contain strings
      EQ<String> q = new EQ(); 
 
      // read data from standard input and insert into the queue
      java.util.Scanner in = new java.util.Scanner(System.in); 
      while (in.hasNext())                  
      {  
         q.enqueue(in.next());             // test of the enqueue method  
      }                                             
      in.close();
         
      // test the toSortedArray method
      System.out.print("***toSortedArray = ");        
      Object[] v = q.toSortedArray();                         
      for (int i = 0; i < v.length;i++) 
      {
         System.out.print(v[i] + " "); 
      }
         
      // test the getOnlyUniqueTtems method  
      System.out.print("\n***getOnlyUniqueItems = ");   
      v = q.getOnlyUniqueItems();                        
      for (int i = 0; i < v.length; i++) 
      {
         System.out.print(v[i] + " ");
      }
      System.out.println();
      
      // print source queue items before splitting 
      System.out.print("SOURCE QUEUE ITEMS BEFORE SPLITTING: ");
      v = q.toArray();
      for(Object e : v) 
      {
         System.out.print(e + " ");
      }
      System.out.println();       
      
      // test the split method
      System.out.print("***split =");                                     
      EQ[] qs = q.split(DEST_QUEUES_NO);             
      for (int i = 0; i < qs.length; i++)
      {
         v = qs[i].toArray();
         for (int j = 0; j < v.length; j++)
         {
            System.out.print(" " + v[j]);
         }
         System.out.print(" |");
      } 
      System.out.println();
     
      // check source queue
      //System.out.println("SOURCE QUEUE SIZE AFTER SPLITTING " + q.size());
      System.out.print("SOURCE QUEUE ITEMS AFTER SPLITTING: ");
      v = q.toArray();
      for(Object e : v) 
      {
         System.out.print(e + " ");
      }
      System.out.println();                    
   }   
}  
