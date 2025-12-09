/**
  * Foundation of Computer Scienec - Group 2
  * Programming test - 16-07-2018
  *  
  * Test class of the SE class
   
   @see SE
*/

public class SETester
{
   public static void main(String[] args)
   {
      // creating of a new extended stack
      SE<String> s = new SE();

      // reading data from standard input
      java.util.Scanner in = new java.util.Scanner(System.in);      
      while (in.hasNext())
      {
         s.push(in.next());                            //test of the push method    
      }                               
      in.close();
         
      // printing messages on standard output
      System.out.print("SIZE = " + s.size() + "\n");             // test of size
      System.out.print("TOSTRING = " + s.toString() + "\n");  //test of toString     
      
      System.out.print("CLONE = ");                                     
      Stack s1 = s.clone();                                     // test of clone
      System.out.println(s1.toString());                     //test of to string

      System.out.print("REVERSE = ");                                      
      s1 = s.reverse();                                       // test of reverse
      System.out.println(s1.toString());                     //test of to string
      
      System.out.print("CLONE TOP & POP = ");      
      s1 = s.clone();                                           // test of clone
      while (!s1.isEmpty())                                   // test of isEmpty
      {
         System.out.print(s1.top() + " ");                        // test of top
         s1.pop();                                                // test of pop
      }
      System.out.println();

      System.out.print("REVERSE TOP & POP= ");      
      s1 = s.reverse();                                       // test of reverse
      while (!s1.isEmpty())                                   // test of isEmpty
      {                                           
         System.out.print(s1.top() + " ");                        // test of top
         s1.pop();                                                // test of pop
      }                                 
      System.out.println();

      System.out.print("TOSORTEDARRAY = ");      
      Object[] a = s.toSortedArray();                   // test of toSortedArray
      for (Object o : a)                                                                             
         System.out.print(o + " ");                                                      
      System.out.println();  
                     
      System.out.print("SIZE = " + s1.size() + "\n");            // test of size    
   }  
}
