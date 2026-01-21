import java.util.Scanner;
/**
  * Test class of D class
  *
  * @see D
  * @author A. Luchetta
  * @version 24-12-2018
  *
  */
public class TestD
{
   public static void main(String[] args) throws java.io.IOException
   {
      // checkhe command line
      if (args.length < 1)
      {
         System.out.println("usage: java TestD filename");
         return;
      }

      // create a multimap
      D<String, String> m = new D();
      
      // read data from file
      Scanner in = new Scanner(new java.io.FileReader(args[0]));     
      while (in.hasNextLine())
      {
         Scanner tk = new Scanner(in.nextLine()).useDelimiter("[#]+");
         m.insert(tk.next(), tk.next()); 
         tk.close();       
      }      
      in.close();
         
      // print the mapping counter on standard output
      System.out.println("SIZE: " + m.size());
      
      // retrieve keys
      Comparable[] k = m.keys();         
      
      // print mappings on standard output
      System.out.println("FINDALL: ");
      for (int i = 0; i < k.length; i++)
      {
         Object[] v = m.findAll((String)(k[i]));
         if (v.length > 0)
         {
            System.out.print(k[i] + " "); 
            for (int j = 0; j < v.length; j++)
               System.out.print(" + " + v[j]);  
            System.out.println();
         }             
      }
      
      // remove mappings by keys and print on standard output 
      System.out.println("\nREMOVEALL: ");
      for (int i = 0; i < k.length; i++)
      {
         Object[] v = m.removeAll((String)(k[i]));
         if (v.length > 0)
         {
            System.out.print(k[i]+ " "); 
            for (int j = 0; j < v.length; j++)
               System.out.print(" + " + v[j]);  
            System.out.println();
         }     
      }      
         
      // print the mapping counter on standard output
      System.out.println("\nSIZE: " + m.size());                 
   }
}
