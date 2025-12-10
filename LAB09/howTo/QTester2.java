  /**
  * test class of the Q class
  *
  * @see Q
  *
  * @author A. Luchetta
  * @version 8-Dic.2016
  *
  */

public class QTester2
{
   public static void main(String[] args)
   {
      final int CAPACITY = 10;
      
      // create an array of Q instances
      Q[] v = new Q[CAPACITY];
      
      // initialize the array with Q instances
      for(int i = 0; i < v.length; i++)
         v[i] = new Q();
         
      // print on standard output the array elements
      System.out.println("***PRINTING THE ORIGINAL ARRAY***");
      for (Q e: v)
      {
         System.out.print(e + " ");
      }
      System.out.println();      
        
      // sorting of the v array        
      ArrayAlgorithms3.mergeSort(v);
      
      System.out.println("***PRINTING THE SORTED ARRAY***");
      for (Q e: v)
      {
         System.out.print(e + " ");
      }
      System.out.println();      
   }
}
