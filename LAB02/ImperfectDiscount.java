 import java.util.Locale;
 /**
  * ImperfectDiscount
  * Executable class that applies a discount of 50 units on an amount
  * of 100 milion of bilions of units
  *
  * @version 10-Ott-2005
  * @author Adriano Luchetta
  */
public class ImperfectDiscount
{
   public static void main(String[] args)
   {
      final double AMOUNT = 1.0e+18;
      final int DISCOUNT = 50;

      double doubleResult = AMOUNT - DISCOUNT;        // calculation with doubles
      long longResult = ((long) AMOUNT) - DISCOUNT;   // calculation with long
      
      // Arithmetic of the IEEE754 double precision doubleing point numbers 
      System.out.println("if the discount is computed by using double floating point arithmetc, we get ");
      System.out.printf(Locale.US, "%20.1f -", AMOUNT);
      System.out.println();
      System.out.printf(Locale.US, "%21.1f", (double) DISCOUNT);
      System.out.println();
      System.out.println("____________________ =");
      System.out.printf(Locale.US, "%20.1f  !",  doubleResult);
      System.out.println("\nand the fifty units? Where have they gone?");
      System.out.println();

      // Arithmetic of long numbers (64 bits)
      System.out.println();
      System.out.println("if the discount is done by using long integer arithmetic, we get ");
      System.out.println((long) AMOUNT + " -");
      System.out.printf(Locale.US, "%19d", DISCOUNT);
      System.out.println();
      System.out.println("__________________ =");
      System.out.printf(Locale.US, "%18d   !", longResult);
      System.out.println("\nthe fyfty units are there!");
   }
}
