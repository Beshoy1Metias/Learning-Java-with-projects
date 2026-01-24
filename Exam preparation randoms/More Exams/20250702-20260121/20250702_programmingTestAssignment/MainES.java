// FOUNDATIONS OF COMPUTER SCIENCE
// Exam dated 2 July 2025

/**
   Test class for class ES.
   
   @see ES
   
   @author A.Luchetta
   @version 26 June 2025
*/
public class MainES {
   public static void main(String[] args) {
      // define array
      final String[] PEOPLE = {"Eric", "Diana", "Claire", "Bart", "Alice"};
      
      // define test extended stack 1
      ES st1 = new ES();
      
      // push data into stack 1
      for (String s : PEOPLE) st1.push(s);
      
      // print to array
      System.out.print("TOARRAY1: ");
      Object[] items1 = st1.toArray();  // test of toArray method
      for (Object o : items1) System.out.print(o + " ");
      System.out.println();  
      
      // print stack size
      System.out.println("SIZE1 : " + st1.size());    
      
      // define test extended stack 2
      ES st2 = new ES(st1);  // test ES(ES s) constructor
      
      // print stack size
      System.out.println("SIZE2 : " + st2.size());
      
      // print to array
      System.out.print("TOARRAY2: ");
      Object[] items2 = st2.toArray();  // test of toArray method
      for (Object o : items2) System.out.print(o + " ");
      System.out.println();
      
      // print contains
      System.out.print("CONTAINS: ");
      if (st1.contains(PEOPLE[0]))             // test of contains method
         System.out.print("Stack contains " + PEOPLE[0]); 
      else System.out.print("Stack does not contain " + PEOPLE[0]);
      String notContained = PEOPLE[0] + PEOPLE[1];
      if (st1.contains(notContained)) // test of contains method
         System.out.print(" Stack contains " + notContained);
      else System.out.print(" Stack does not contain " + notContained);
      System.out.println();         
   }
}
