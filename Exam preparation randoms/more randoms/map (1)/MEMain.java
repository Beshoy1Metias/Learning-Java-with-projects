/**
  * FOUNDATIONS OF COMPUTER SCIENCE
  * PROGRAMMING TEST DATED 22.2.2017
  *
  * Test class of the ME class
  *
  * @see ME
  * @author A. Luchetta
  * @version 16-Dic-2020
  */
public class MEMain // Test class of the extended map
{
   public static void main(String[] args) throws java.io.IOException
   {
      // generate an extended map
      ME<String,String> m = new ME();

      // read mappings from file 
      java.util.Scanner in = new java.util.Scanner(new java.io.FileReader(args[0]));
      while (in.hasNextLine())
      {
         java.util.Scanner tok = new java.util.Scanner(in.nextLine());
         m.put(tok.next(), tok.next());
      }
      in.close();
      
      // test the size method
      System.out.println("SIZE = " + m.size());
      
      // test the keySet and get methods
      System.out.print("ENTRIES: ");
      Object[] keys = m.keySet();
      for (Object e: keys)
         System.out.print(e + "/" + m.get((String)e) + " ");
      System.out.println();
      
      // test the values method
      System.out.print("VALUES: ");
      Object[] values = m.values(); 
      for (Object e: values)
         System.out.print(e + " ");
      System.out.println();
      
      // test the valueSet method
      System.out.print("VALUESET: ");
      values = m.valueSet(); 
      for (Object e: values)
         System.out.print(e + " ");
      System.out.println();    
      
      // test the remove method
      System.out.print("REMOVE: ");
      int i = 0;
      while (!m.isEmpty())
         System.out.print(keys[i] + "/" + m.remove((String)keys[i++]) + " ");
      System.out.println(); 
      
      // test the size method
      System.out.println("SIZE = " + m.size());    
   }  
}
