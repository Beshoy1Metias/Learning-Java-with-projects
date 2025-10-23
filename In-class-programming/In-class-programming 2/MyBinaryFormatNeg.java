/**
 * Class used in in-class programming 1
 * Converts a decimal negative integer in the range [-128, -1] to binary 8-bit
 * two's complement format
 *
 * @author A. Luchetta
 * @version 20251017
 */
public class MyBinaryFormatNeg
{
   public static void main(String[] args)
   {
      // define constants
      final int BASE = 2;
      final int SIGN = 1;
      final String BINARY_PREFIX = "0b";
      final String NIBBLE_DIVIDER = "_";
      final int BYTE_SHIFT = Byte.MAX_VALUE + 1;  // this int is 127 + 1 = 128

      // define integer in range [-128, -1]
      int n = -1;  // integer to convert

      // convert decimal integer to 8-bit two's complement

      // compute least significant digit
      int q0 = n + BYTE_SHIFT;
      int d0 = q0 % BASE;
      
       // compute 2nd digit
      int q1 = q0 / BASE;
      int d1 = q1 % BASE; 

       // compute 3rd digit
      int q2 = q1 / BASE;
      int d2 = q2 % BASE;

       // compute 4th digit
      int q3 = q2 / BASE;
      int d3 = q3 % BASE; 

       // compute 5th digit
      int q4 = q3 / BASE;
      int d4 = q4 % BASE;

       // compute 6th digit
      int q5 = q4 / BASE;
      int d5 = q5 % BASE; 

       // compute 7th digit
      int q6 = q5 / BASE;
      int d6 = q6 % BASE; 

       // compute 8th digit 
       int d7 = SIGN; // we know that most significant bit is the sign

       // create string in binary prefix (0b) and nibble diveder (_)  
       String s = BINARY_PREFIX + d7 + d6 + d5 + d4
          + NIBBLE_DIVIDER + d3 + d2 + d1 + d0;       

      // print result to standard out
      System.out.println(n + " decimal is " + s + " in base " + BASE);      
   }
}