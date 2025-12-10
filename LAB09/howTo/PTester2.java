/**
  * Teaching executable class which sorts arrays of objects from the P class
  * which implements the java.lang.Comparable interface
  *
  * @see P
  *
  * @author A. Luchetta
  * @version 8-Dic.2016
  *
  */

public class PTester2
{
   public static void main(String[] args)
   {
      // define array length
      final int CAPACITY = 10;
      
      // create an array of P instances
      P[] v = new P[CAPACITY];
      
      // initiale the array with P instances
      for(int i = 0; i < v.length; i++)
      {
         v[i] = new P();
      }
         
      // print the array elements on standard output
      System.out.println("***PRINTING THE ORIGINAL ARRAY***");
      for (P e: v)
      {
         System.out.print(e + " ");
      }
      System.out.println();      
        
      // sort of v array        
      ArrayAlgorithms3.mergeSort(v);
      
      System.out.println("***PRINTING THE SORTED ARRAY***");
      for (P e: v)
      {
         System.out.print(e + " ");
      }
      System.out.println();      
   }
}
