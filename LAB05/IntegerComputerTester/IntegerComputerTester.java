import java.util.Scanner;
/**
* Test class of the IntegerComputer class
*
* @author Adriano Luchetta
* @version 22-Ott-2015
*
*/
public class IntegerComputerTester
{
   public static void main(String[] args)
   {
      final String PRIME           = "a";
      final String GCD             = "b";
      final String FACTORS         = "c";
      final String FIBONACCI       = "d";
      final String TRIANGULAR      = "e";
      final String QUIT            = "q";

      System.out.println("***NUMERICAL COMPUTER***");

      // Data readout from standard input
      Scanner in = new Scanner(System.in);

      // operation loop
      while (true)
      {
         System.out.println( "\nEnter:\n"
            + PRIME           + " to check if an integer is a prime\n"
            + GCD             + " to compute the GCD\n"
            + FACTORS         + " to compute the prime factors\n"
            + FIBONACCI       + " to compute the n-th Fibonacci number\n"
            + TRIANGULAR      + " to compute the n-th triangular number\n"
            + QUIT            + " to quit\n");

         // readout from standard input
         String line = "";
         if (in.hasNext())
         {
            line = in.next();
         }

         // exit check
         if (line.equalsIgnoreCase("Q"))
         {
            break;
         }

         if (line.equalsIgnoreCase(PRIME) || line.equalsIgnoreCase(FACTORS)
              || line.equalsIgnoreCase(FIBONACCI) || line.equalsIgnoreCase(TRIANGULAR))
         {
            System.out.print("n?: ");

            int n = -1;
            if (in.hasNextInt())
            {
               n = in.nextInt();
            }

            if (n < 0)
            {
            	System.out.println("n < 0, try again");
            }
            else
            {
               if (line.equals(PRIME))
               {
                  if (IntegerComputer.isPrime(n))
                  {
                     System.out.println(n + " is a prime");
                  }
                  else
                  {
                     System.out.println(n + " in not a prime (" + n + " = "
                                          + IntegerComputer.factors(n) + ")");
                  }
               }
               else if (line.equals(FACTORS))
               {
                  System.out.println(n + " = " + IntegerComputer.factors(n));
               }
               else if (line.equals(FIBONACCI))
               {
                  System.out.println("f(" + n + ") = " + IntegerComputer.fibonacci(n));
               }
               else
               {
                  System.out.println("t(" + n + ") = " + IntegerComputer.triangular(n));
               }
            }
         }
         else if (line.equals(GCD))
         {
            System.out.print("p e q?: ");
         	  
            int p = 0;
            if (in.hasNextInt())
            {
               p = in.nextInt();
            }

            int q = 0;
            if (in.hasNextInt())
            {
               q = in.nextInt();
            }
         	     
            if (p <= 0)
            {
               System.out.println("p <= 0, try again");
            }
            else if (q <= 0)
            {
               System.out.println("q <= 0, try again");
            }
            else
            {
               System.out.println("GCD(" + p + "," + q +") = "
                  + IntegerComputer.gcd(p,q));
            }
        }
        else
        {
           System.out.println("invalid choice");
        }
      }

      System.out.println("***END***");
   }
}

