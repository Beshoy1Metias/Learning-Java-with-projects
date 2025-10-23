 /**
  * Base converter
  *  
  * The class prints on standard output a positive integer expressed in a base
  * b, where 1 < b < 10.
  * The integer must be in the range [1, b^3 - 1] (^ means power of), so that
  * its base b representation uses three digits.
  * The integer to be converted and the base are defined in the code. 
  *
  * @version 10-Oct-2024
  * @author Adriano Luchetta
  */

public class BaseConverter
{
   public static void main(String[] args)
   {
      // constants
      final int BASE = 7;             // base to which the number is converted

      // number to be converted
      int n = 256;                    // integer to be converted

      //least significant digit r0
      int q0 = n;
      int d0 = q0 % BASE;             // least significant digit

      //middle digit r1
      int q1  = q0 / BASE;    
      int d1 = q1 % BASE;             // middle digit

      //most significant digit
      int q2 = q1 / BASE;             // most significant digit
      int d2 = q2 % BASE;

      //prints the integert to be converter on standard output 
      System.out.println("The decimal integer is " + n);      

      //prints the integer expressed in the new base on standard output
      System.out.print("Its representation in base " + BASE + " is ");
      System.out.print(d2); 
      System.out.print(d1);    
      System.out.println(d0);                     
   }
}
