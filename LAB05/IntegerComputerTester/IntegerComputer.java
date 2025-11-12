/**
 * Provides static methods to elaborate on integers.
 *
 * @author Adriano Luchetta
 * @version 22 Nov-2018
 *
 */
public class IntegerComputer
{
   /** 
      Checks if the specified postive integer is a prime
      @param n the specified integer
      @return true if the specified integer is a prime, false otherwise
      @throws IllegaArgumentException if the specified integer is zero or
              negative
   */
   public static boolean isPrime(int n)
   {
      // preconditions
      if (n < 1)
      {
         throw new IllegalArgumentException();
      }

      int j = 2;
      while (j * j  <= n)
      {
         if (n % j == 0)
         {
            return false;
         }
         j++;
      }

      return true;
   }
   
   /**
      Computed the Greatest Common Divider (GCD) of the specified integers
      @param p the first specified integer
      @param q the second specified integer
      @return the greatest common divider of the specified integers
      @throws IllegaArgumentException if at least one of the specified integers
              is zero or negative
   */
   public static int gcd(int p, int q)
   {
      // preconditions
      if (p < 1 || q < 1)
      {
         throw new IllegalArgumentException();
      }

      int m = p;
      int n = q;

      int k;
      while ((k = m % n) > 0)
      {
         m = n;
         n = k;
      }

      return n;
   }
   
   /**
      Decomposes in prime factors the specified integer<br>
      Example: n = 42 = 1 * 2 * 3 * 7.
      @param n the specified integer
      @return string containing the decomposition in prime factors of the
              specified integer
      @throws IllegaArgumentException if the specified integer is zero or
              negative              
   */
   public static String factors(int n)
   {
      // preconditions
      if (n < 1)
      {
         throw new IllegalArgumentException();
      }

      String factorString = "1";
      int k = n;
      int j = 2;
      while (j * j <= k)
      {
         while (k % j == 0)
         {
            factorString = factorString + " * " + j; // a divider found
            k = k / j;              // new number to factorize is k / j
         }
         j++;
      }

      if (k > 1)                 // if k is greater than 1, then it is a divider
      {
         factorString += " * " + String.valueOf(k);
      }

      return factorString;
   }
   
   /**
      Computes the Fibonacci number with index equal to the specified integer: <br>
      f(0) = 1, f(1) = 1, f(n) = f(n-2) + f(n-1) for n greater than 1.
      @param n the specified index
      @return the Fibonacci number associated with the specified index
      @throws IllegaArgumentException if the specified integer is negative         
   */
   public static int fibonacci(int n)
   {
      // preconditions
      if (n < 0)
      {
         throw new IllegalArgumentException();
      }

      if (n == 0 || n == 1)
      {
         return 1;
      }

      int f_old = 1;
      int f = 1;

      int j = 2;
      while (j <= n)
      {
         int tmp = f_old;
         f_old = f;
         f += tmp;;
         j++;
      }

      return f;
   }
   
   /**
      Computes the triangular number with the specified index:<br>
      t(n) = n * (n + 1) / 2 = n + (n - 1) +...+ 2 + 1, for n equal or greater
      than 1
      @param n the specified index
      @return the triangular number associated with the specified integer
      @throws IllegaArgumentException if the specified integer is zero or
              negative 
   */
   public static int triangular(int n)
   {
      // preconditions
      if (n < 1)
      {
         throw new IllegalArgumentException();
      }

      return n * (n + 1) / 2;
   }
}
