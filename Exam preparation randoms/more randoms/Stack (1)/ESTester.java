// Mock Exam dated January 14, 2026
/**
  * Test class of the ES class.
  *   
  * @see ES
  * @author A.Luchetta
  * @version 07-Jan-2026
  */
public class ESTester
{
   public static void main(String[] args)
   {
      // define stack item array
      final String[] TOWNS =  {"Bishkek", "Freetown","Astana", "Dhaka","Cairo"};
      final String[] TOWNS1 = {"Bishkek", "Freetown","Astana", "Dhaka","Cairo"};
      final String[] TOWNS2 = {"Bishkek", "Freetown", "Moscow", "Astana", "Dhaka"};
      final String[] TOWNS3 = {"Dublin", "Berlin", "NewDehli"};
      
      // define new stack
      ES<String> s = new ES();        // tests the constructor
      ES<String> s1 = new ES();       // tests the constructor
      ES<String> s2 = new ES();       // tests the constructor
      ES<String> s3 = new ES();       // tests the constructor  
      
      // insert items
      System.out.print("PUSHS0: ");
      for (String o : TOWNS)
      {
         s.push(o);                     // tests push method
         System.out.print(o + " ");
      }
      System.out.println();
      
      // insert items
      System.out.print("PUSHS1: ");
      for (String o : TOWNS1)
      {
         s1.push(o);                     // tests push method
         System.out.print(o + " ");
      }
      System.out.println();
      
      // insert items
      System.out.print("PUSHS2: ");
      for (String o : TOWNS2)
      {
         s2.push(o);                     // tests push method
         System.out.print(o + " ");
      }
      System.out.println();

      // insert items
      System.out.print("PUSHS3: ");
      for (String o : TOWNS3)
      {
         s3.push(o);                     // tests push method
         System.out.print(o + " ");
      }
      System.out.println();       
      
      // get min
      System.out.print("MINS0: ");
      String min = s.getMin();          // tests getMin method
      System.out.println(min);
      
      // check equals
      System.out.print("EQUALS: ");
      if (s.equals(s1))                 // tests equals method
      {
         System.out.print("S0 is equal to S1 / ");
      }
      else
      {
         System.out.print("S0 is not equal to S1 / ");         
      }
      
      if (s.equals(s2))                 // tests equals method
      {
         System.out.print("S0 is equal to S2 / ");
      }
      else
      {
         System.out.print("S0 is not equal to S2 / ");         
      }
      System.out.println();

      // get sorted extended stack
      ES<String> sortedStack = s1.mergeSorted(s3); // tests mergeSorted method

      // print sorted extended stack
      System.out.print("SORTEDSTACK:" + " ");
      while (!sortedStack.isEmpty())
      {
         System.out.print(sortedStack.pop() + " ");
      } 
      System.out.println();      
   }
}  