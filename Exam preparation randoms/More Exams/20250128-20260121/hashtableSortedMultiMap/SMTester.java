/**
   Test class for class SM
      
   @see SM
      
   @author A. Luchetta
   @version 26 Dec. 2024
*/
public class SMTester {
   public static void main(String[] args) throws java.io.IOException {
      // check command line
      if (args.length < 1) {
         System.out.println("Use: java TestM filename");
         return;
      }

      // define new test sorted multimap
      SortedMultimap<String,String> m = new SM();
      
      // read mappings from input file and add them to sorted multimap
      java.util.Scanner in = new java.util.Scanner(new java.io.FileReader(args[0]));
      // read mappings
      while (in.hasNextLine()) {
         // read new line
         String s = in.nextLine();
         
         // decompose new line
         java.util.Scanner tok = new java.util.Scanner(s).useDelimiter("[#]+");
         String key = tok.next();
         String value = tok.next();        
         tok.close();
         
         // add new mapping to test sorted multimap
         m.insert(key, value);                           // test of put method      
      }
      in.close();                                        
      
      // print size
      System.out.println("SIZE " + m.size());            // test of size method
      
      // print keys
      Object[] keys = m.sortedKeys();                    // test of sortedKeys method
      System.out.print("SORTED KEYS: ");
      for (Object k : keys) System.out. print(k + " ");
      System.out.println();
      
      // remove mappings
      System.out.print("MAPPINGS: ");
      int i = 0;                      // key array index
      while (!m.isEmpty()) {                            // test of isEmpty method
         // get key
         String key = (String)keys[i];
         
         // remove mapping
         while (m.find(key) != null) {                  // test of find method
            String value = m.remove(key);               // test of remove method        
            
            // print mapping
            System.out.print(key + "/" + value + " ");  
         }
         
         // increment key array index 
         i++;     
      }
      System.out.println(); 
      
      // print size
      System.out.println("SIZE " + m.size());            // test of size method                       
   }
}
