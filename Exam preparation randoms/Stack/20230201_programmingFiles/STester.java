/*
   Foundations of Computer Science
   Programming Test - 1 February 2023
*/
/**  
   Test class of the S class. 
   
   @see S
*/
public class STester {
   public static void main(String[] args) {
      // constant arrays
      String[] CITIES =  {"Teheran", "Doha", "Cairo", "Madrid", "Stockholm"};
      String[] TARGETS = {"Paris", "Stockholm", "Cairo", "Doha"};
   
      // test stacks
      S<String> s1 = new S();
      S<String> s2 = new S();
                  
      //push data into test stacks
      for (String s : CITIES) {
         s1.push(s);
         s2.push(s);
      }
         
      System.out.print("SIZE = " + s1.size() + "\n");     // test of size method 
                                                                               
      System.out.print("TOP & POP = ");   
      while (!s1.isEmpty()) {                           //test of isEmpty method
         System.out.print(s1.top() + " ");                  //test of top method
         s1.pop();                                          //test of pop method
      }
      System.out.println();

      System.out.println("SEARCH = ");
      String top = s2.top();      
      for (String s : TARGETS) {
         int n = s2.search(s);
         if (n < 0) {
            System.out.println("   " + s + " is not found");
         }
         else {
            System.out.println("   " +  s + " is at distance " + n + " from " + top);         
         }   
         
      }                
      System.out.println("SIZE 1/2 = " + s1.size() + "/" + s2.size()); // test of size method    
   }  
}
