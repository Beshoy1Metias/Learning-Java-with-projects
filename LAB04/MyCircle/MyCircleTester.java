import java.util.Scanner;
import java.util.Locale;
public class MyCircleTester
{
   public static void main(String[] args)
   {
      final String END_OF_PROGRAM = "Q";
      
      System.out.println( "\n************************************\n"   
                          + "*** Q TO TERMINATE THE PROGRAMMA ***\n"
                          + "************************************\n"  );

      System.out.println(   "****************************************************\n"
                          + "*** Use '.' as separator character between whole ***\n"
                          + "*** and fractional part of floating point numbers***\n"
                          + "****************************************************");

      // opens input data flow
      Scanner in = new Scanner(System.in);
      String s = "";
            
      double x;
      double y;         
      double r;
      
      // loop to read data
      while (true)
      {
         do
         {
            System.out.print("enter O(x1,y1) e r1: ");
            s = in.nextLine();
            if (s.equalsIgnoreCase(END_OF_PROGRAM))
            {
               in.close();
               return;
            }
               
            Scanner p = new Scanner(s);
            p.useLocale(Locale.US);   
            x = p.nextDouble();
            y = p.nextDouble();         
            r = p.nextDouble();
            p.close();
         } while (r < 0);
         
         MyCircle c1 = new MyCircle(x, y, r); 
         
        do
         {
            System.out.print("enter O(x2,y2) e r2: ");
            s = in.nextLine();
            if (s.equalsIgnoreCase(END_OF_PROGRAM))
            {
               in.close();
               return;
            }
               
            Scanner p = new Scanner(s);
            p.useLocale(Locale.US);    
            x = p.nextDouble();
            y = p.nextDouble();         
            r = p.nextDouble();
            p.close();
         } while (r < 0);
         
         MyCircle c2 = new MyCircle(x, y, r);
      
         if (c1.isCoincident(c2))
            System.out.println(c1 + " " + c2 + " coincident");
         if (c1.isEncircled(c2))
            System.out.println(c1 + " " + c2 + " are one inside the other");
         if (c1.isTangential(c2))
            System.out.println(c1 + " " + c2 + " are tangent");
         if (c1.isSecant(c2))          
            System.out.println(c1 + " " + c2 + " are secant");
         if (c1.isExternal(c2))                            
            System.out.println(c1 + " " + c2 + " are external to each other");
      }  
   }
}
