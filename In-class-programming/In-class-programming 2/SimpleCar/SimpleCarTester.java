/**
   Test class of class SimpleCar
   
   @author A. Luchetta
   @version 20201021
*/
public class SimpleCarTester
{
   public static void main(String[] args)
   {
      // new instance of SimpleCar
      SimpleCar a = new SimpleCar();
      
      // prints data on standard output
      System.out.println(a);      
      
      // increases gear 0->1
      a.gearUp();
      
      // prints data on standard output
      System.out.println("gear increased: " + a);
      
      // increases speed
      a.speedUp();
      
      // prints data on standard output
      System.out.println("speed increased: " + a);
      
      // increases gear 1 -> 2
      a.gearUp();
      
      // increases speed
      a.speedUp();
      
      // increases speed
      a.speedUp();            
      
      // prints data on standard output
      System.out.println("gear and speed increased: " + a);
      
      // increases gear 2 -> 3
      a.gearUp();
      
      // prints data on standard output
      a.speedUp();
      
      // increases speed
      a.speedUp();            
      
      // prints data on standard output
      System.out.println("gear and speed increased: " + a);
      
      // increases gear 3 -> 4
      a.gearUp();
      
      // increases gear 4 -> 5
      a.gearUp();
      
      // increases speed
      a.speedUp();       
      
      // prints data on standard output
      System.out.println("gear and speed increased: " + a);
      
      // increases gear 5 -> 6
      a.gearUp();
      
      // increases speed
      a.speedUp();       
      
      // prints data on standard output
      System.out.println("gear and speed increased: " + a);
      
     // decreases gear
      a.gearDown(); // 6 -> 5
      a.gearDown(); // 5 -> 4
      a.gearDown(); // 4 -> 3
      a.gearDown(); // 3 -> 2

      // breake 
      a.brake();
      a.brake();
      a.brake();
      a.brake(); 
      
      // prints data on standard output      
      System.out.println("gear and speed decreased: " + a);
      
      // decreases gear
      a.gearDown(); // 2 -> 1                                                               

      // breake
      a.brake();
      a.brake(); 

      // prints data on standard output 
      System.out.println("gear and speed decreased: " + a);
      
      // break
      a.brake();
      a.brake();
      a.brake(); 

      // prints data on standard output 
      System.out.println("speed decreased: " + a);   
             
      // break
      a.brake(); 
      
      // prints data on standard output                 
      System.out.println("speed decreased: " + a);                       
   }
}

