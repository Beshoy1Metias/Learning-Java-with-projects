// FOUNDATIONS OF COMPUTER SCIENCE
// Exam dated 2 July 2025

/**
   Test class for class S.
   
   @see S
   
   @author A.Luchetta
   @version 26 June 2025
*/
public class TestS {
   public static void main(String[] args) {
      // define array
      final String[] PEOPLE = {"Eric", "Diana", "Claire", "Bart", "Alice"};
      
      // define test stack
      S st = new S();        // test of constructor
      
      // push data into stack
      for (String s : PEOPLE) st.push(s);  // test of push method
      
      // print stack size
      System.out.println("SIZE : " + st.size()); // test of size method
      
      // print contains
      System.out.print("CONTAINS: ");
      if (st.contains(PEOPLE[0]))             // test of contains method
         System.out.print("Stack contains " + PEOPLE[0]); 
      else System.out.print("Stack does not contain " + PEOPLE[0]);
      String notContained = PEOPLE[0] + PEOPLE[1];
      if (st.contains(notContained)) // test of contains method
         System.out.print(" Stack contains " + notContained);
      else System.out.print(" Stack does not contain " + notContained);
      System.out.println();      
      
      // print top and pop
      System.out.print("TOP&POP : ");
      while (!st.isEmpty()) {  // test of isEmpty method
         System.out.print(st.top() + "/" + st.pop() + " ");
      }
      System.out.println();
      
      // print stack size
      System.out.println("SIZE : " + st.size());    // test of size method  
   }
}
