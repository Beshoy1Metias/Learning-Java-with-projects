// Mock Exam dated January 14, 2026

/**
  * Test class of the S class.
  *   
  * @see S
  * @author A.Luchetta
  * @version 07-Jan-2026
  */
public class STester
{
   public static void main(String[] args)
   {
      // define stack item array
      final String[] TOWNS = {"Freetown","Dhaka","Cairo","Bishkek","Astana"};
      
      // define new stack
      Stack<String> s = new S();        // tests the constructor
      
      // insert items
      System.out.print("PUSH: ");
      for (String o : TOWNS)
      {
         s.push(o);                     // tests push method
         System.out.print(o + " ");
      }
      System.out.println();
      
      // get min
      System.out.print("MIN: ");
      String min = s.getMin();          // tests getMin method
      System.out.println(min);
      
      // top and pop items
      System.out.print("TOP&POP: ");
      while (!s.isEmpty())
      {
         String top = s.top();          // tests top method
         String pop = s.pop();          // tests pop methods
         System.out.print(top + "/" + pop + " ");
      }
      System.out.println();         
   }
}  