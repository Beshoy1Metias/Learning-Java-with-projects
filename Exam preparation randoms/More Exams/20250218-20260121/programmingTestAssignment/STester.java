/**
   Test class of the S class.
      
   @see S
      
   @author A. Luchetta
   @version 11 Jan. 2025
*/

public class STester {
   public static void main(String[] args) {
      // define constant String array
      final String[] COUNTRIES = {"Russia","China","Vietnam","China","Japan"};
      final String[] OTHER_COUNTRIES = {"Korea","Russia","Japan"};      
      // define test set
      Set<String> s1 = new S();
      
      // insert data items into test set
      for (String p : COUNTRIES) s1.add(p);               // test of add method
      
      // print set size
      System.out.println("SIZE: " + s1.size());          // test of size method
      
      // print set elements
      Object[] items = s1.toArray();                  // test of toArray method
      System.out.print("ITEMS: ");
      for (Object o : items) System.out.print(o + " ");
      System.out.println(); 
      
      // check contains
      System.out.print("CONTAINS: ");
      for (String s : OTHER_COUNTRIES) {
         if (s1.contains(s)) System.out.print(s + " OK - ");// test of contains
         else System.out.print(s + " KO - "); 
      }
      System.out.println(); 
      
      // remove items 
      System.out.print("REMOVE: ");                    // test of remove method
      int index = 0;
      while (!s1.isEmpty()) {
         System.out.print(items[index] +" ");
         s1.remove(items[index++]); 
      }
      System.out.println();
      
      System.out.println("SIZE: " + s1.size());          // test of size method
   }
}
