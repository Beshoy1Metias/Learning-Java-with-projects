import java.util.Scanner;
/**
 * Contains a static method to check if an integer is a prime<br>
 * It uses the algorithm known as Eratosthenes Sieve
 *
 *   @author Adriano Luchetta
 *   @version 21-Ott-2021
 */
public class EratosthenesPrimeComputer
{
   /**
      Checks if the specifie integer is a prime by using the Eratosthenes sieve
      algorithm<br>
      @param the specified integer
      @return true if the specified integer is a prime, false otherwise
   */
   public static boolean isPrime(int n)
   {
     final boolean IS_MULTIPLE = true;
     
     // array - index k is associated to integer k
     // if isMultiple[k] is true, integer k is a multiple, therefore not a prime
     boolean[] isMultiple = new boolean[n + 1]; // all items initialized to false
                                                // i.e. initially all integer
                                                // are considered as primes     

     // loop to scan all integer of set J = {integers j > 1 | j * j <= n}
     int i = 2;   // loop control variable
     while (i * i <= n)
     {      
        if (!isMultiple[i])  // if i is a prime, its multiples are not primes
        {
           // cancellation of multiples
           for (int j = i + i; j <= n; j += i) // loop for cancellation of
           {                                   // multiples of integer i
              isMultiple[j] = IS_MULTIPLE;       
           }
        }

        // increment of the loop control index        
        i++;                       
     }

     return !isMultiple[n];
   }

   /**
      Makes the class executable. To test the class
   */
   public static void main(String[] args)
   {
      // data readout from standard input
      Scanner reader = new Scanner(System.in);
      System.out.print("Enter a positive integer: ");
      int n = Integer.parseInt(reader.nextLine());
      reader.close();
      
      // check
      if (isPrime(n))
      {
         System.out.println(n + " is a prime");
      }
      else
      {
         System.out.println(n + " is not a prime");
      }
   }
}
