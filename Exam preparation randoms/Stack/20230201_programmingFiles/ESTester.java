/*
   Foundations of Computer Science
   Programming Test - 1 February 2023
*/
/**  
   Test class of the ES class. 
   
   @see ES
*/
public class ESTester {
   public static void main(String[] args) {
      // constant arrays
      String[] CITIES =  {"Teheran", "Doha", "Cairo", "Madrid", "Stockholm"};
      String[] TARGETS = {"Paris", "Stockholm", "Cairo", "Doha"};
   
      // test stack
      ES<String> s1 = new ES(CITIES);
                          
      System.out.print("TOARRAY: ");
      Object[] v = s1.toArray();                       // test of toArray method
      for (Object o : v) {
         System.out.print(o + " ");
      }
      System.out.println();
      
      System.out.print("TOSORTEDARRAY: ");
      v = s1.toSortedArray();                    // test of toSortedArray method  
      for (Object o : v) {
         System.out.print(o + " ");
      }
      System.out.println();      

      System.out.println("SEARCH = ");
      String top = s1.top();      
      for (String s : TARGETS) {
         int n = s1.search(s);                          // test of search method
         if (n < 0) {
            System.out.println("   " + s + " is not found");
         }
         else {
            System.out.println("   " + s + " is at distance " + n + " from " + top);         
         }           
      }                
      System.out.println("SIZE = " + s1.size()); // test of size method    
   }  
}
