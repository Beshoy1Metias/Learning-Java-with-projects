/**
   Test class of the SE class.
      
   @see SE
      
   @author A. Luchetta
   @version 11 Jan. 2025
*/

public class SETester {
   public static void main(String[] args) {
      // define constant String arrays
      final String[] COUNTRIES = {"Russia","China","Vietnam","China","Japan"};
      final String[] OTHER_COUNTRIES = {"Thailand","Laos","Vietnam","Cambodia"};
      
      // define test sets
      SE<String> s1 = new SE();
      SE<String> s2 = new SE();
            
      // insert data items into test sets
      for (String p : COUNTRIES) s1.add(p);
      for (String p : OTHER_COUNTRIES) s2.add(p);    
        
      // print set size
      System.out.println("SIZE S1/2: " + s1.size() +"/" + s2.size());
      
      // print unsorted data items
      Object[] items = s1.toArray();
      System.out.print("S1 UNSORTED ITEMS: ");
      for (Object o : items) System.out.print(o + " ");
      System.out.println(); 
        
      items = s2.toArray();
      System.out.print("S2 UNSORTED ITEMS: ");
      for (Object o : items) System.out.print(o + " ");
      System.out.println(); 
                  
      // print sorted data items
      Object[] sortedItems = s1.toSortedArray();// test of toSortedArray method
      System.out.print("S1 SORTED ITEMS: ");
      for (Object o : sortedItems) System.out.print(o + " ");
      System.out.println();
      
      sortedItems = s2.toSortedArray();
      System.out.print("S2 SORTED ITEMS: ");
      for (Object o : sortedItems) System.out.print(o + " ");
      System.out.println();
                    
      // compare sets
      System.out.print("EQUALS: ");
      if (s1.equals(s2)) System.out.println("S1 EQUALS S2");  // test of equals
      else System.out.println("S1 DOES NOT EQUAL S2");
      
      // compare sets
      s2 = s1;
      if (s1.equals(s2)) System.out.println("S1 EQUALS S2");  // test of equals
      else System.out.println("S1 DOES NOT EQUAL S2"); 
      
      // contains
      System.out.print("CONTAINS: ");
      for (String s : OTHER_COUNTRIES)
      {
         if (s1.contains(s)) System.out.print(s + " OK - "); // test of contains
         else System.out.print(s + " KO - ");
      }
      System.out.println();
      System.out.println("S1 SIZE " + s1.size());                       
   }
}
