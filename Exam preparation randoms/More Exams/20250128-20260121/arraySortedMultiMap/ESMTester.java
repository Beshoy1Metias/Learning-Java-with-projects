/**
   Test class for class ME
      
   @see ME
      
   @author A. Luchetta
   @version 26 Dec. 2024
*/
public class ESMTester {
   public static void main(String[] args) throws java.io.IOException {
      // check command line
      if (args.length < 1) {
         System.out.println("Use: java MainME filename");
         return;
      }

      // define new extended multimap
      ESM<String,String> m = new ESM();                       // test of constructor
      
      // read mappings from input file and add them to multimap
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
         
         // add new mapping to multimap
         m.insert(key, value);                              // test of insert method      
      }
      in.close();                                         
      
      // print size
      System.out.println("SIZE " + m.size());              // test of size method 
      
      // print duplicated key
      Object[] keys =  m.sortedKeys();                 // test of sortedKeySet method
      System.out.print("KEYS: ");
      for (Object o : keys) System.out.print(o + " ");
      System.out.println();
      
      // print non duplicated key
      Object[] keySet =  m.sortedKeySet();                 // test of sortedKeySet method
      System.out.print("KEYSET: ");
      for (Object o : keySet) System.out.print(o + " ");
      System.out.println();
                
      // test of method findAll       
      System.out.println("FINDALL: ");
      for (int i = 0; i < keySet.length; i++) {
         Object[] values = m.findAll((String)keySet[i]);   // test of findAll method
         
         System.out.print("KEY " + keySet[i] + ": ");
         for (int j = 0; j < values.length; j++) System.out.print(values[j] + " ");
         System.out.println(); 
      }
   
      System.out.println("SIZE BEFORE REMOVING: " + m.size());    
    
      // remove all mappings
      int i = 0;
      while (!m.isEmpty()) {
         String curKey = (String)keySet[i++];
         while (m.find(curKey) != null) m.remove(curKey);
      }
    
      // print size
      System.out.println("SIZE AFTER REMOVING: " + m.size());            // test of size method  
   }    
 }   
