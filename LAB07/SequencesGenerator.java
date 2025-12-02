import java.util.Random;
/**
   generates sequences of integers
   
   @author A. Luchetta
   @verson 11-Nov-2016
*/
public class SequencesGenerator
{   
   /** 
      returns an array of integers with size equal to the specified capacity and
      elements in the range [0, capacity - 1]. Each element is unique (only
      present once). The position of the integers in the array is random
      @param n specified capacity of the returned array
      @return array of integersa with the specified capacity containing unique
              integers in the range [0, n-1]
      @throws IllegalArgumentException if the specified capacity is negative
   */
   public static int[] uniqueRandomIntegerArray(int n)
   {
      // preconditions
      if (n < 0)
      {
         throw new IllegalArgumentException();
      }

      // generate a sorted array of integers
      int[] a = uniqueSortedIntegerArray(n);

      // shuffle the sorted array
      // i.e. obtaine a random array from the sorted array 
      for (int i = 0; i < a.length; i++)
      {
         // generating a random index in the range [0, length - 1]
         Random r = new Random();
         int j = r.nextInt(a.length);

         // swapping the element with index i with the element wit index j
         int tmp = a[j];
         a[j] = a[i];
         a[i] = tmp;
      }

      return a;
   } 
   

   /** 
      returns an array of integers with size equal to the specified capacity and
      elements in the range [0, capacity - 1]. Each element is unique (only
      present once). The position of the integers in the array is in ascending
      order.
      @param n specified capacity of the returned array
      @return array of integersa with the specified capacity containing unique
              integers in the range [0, n-1]
      @throws IllegalArgumentException if the specified capacity is negative
   */  
   public static int[] uniqueSortedIntegerArray(int n)
   {
      // preconditions
      if (n < 0)
      {
         throw new IllegalArgumentException();
      }
      
      // generating the array
      int[] a = new int[n];
      
      // initializing the sorted array {0 1 2 ... (n - 1)}
      for (int i = 0; i < a.length; i++)
      {
         a[i] = i;
      }
         
      return a;    
   }     
}
