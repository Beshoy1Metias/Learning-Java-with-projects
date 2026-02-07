import java.util.Scanner;
/**
  * Test class of ESD class
  *
  * @see ESD
  * @author A. Luchetta
  * @version 27-12-2020
  *
  */
public class ESDTester
{
   public static void main(String[] args) throws java.io.IOException
   {                                      // note the clause trows      
      // check the command line
      if (args.length < 1)
      {
         System.out.println("usage: java ESDTester filename");
         return;
      }
      
      // create an extended multimap
      ESD<String, String> m = new ESD();
      
      // read data from file
      Scanner in = new Scanner(new java.io.FileReader(args[0]));     
      while (in.hasNextLine())
      {
         Scanner tk = new Scanner(in.nextLine()).useDelimiter("[#]+");
         m.insert(tk.next(), tk.next()); 
         tk.close();       
      }
      in.close();
         
      // retrieve unique keys
      Comparable[] k = m.keySet();   

      // print mapping counter on standard output
      System.out.println("SIZE: " + m.size());
      
      // print mappings on standard output
      System.out.println("\nFINDALL: ");
      for (int i = 0; i < k.length; i++)
      {
         if (m.contains((String)k[i]))
         {
            System.out.print(k[i]); 
            Object[] v = m.findAll((String)(k[i]));
            for (int j = 0; j < v.length; j++)
               System.out.print(" + " + v[j]);  
            System.out.println();              
         }
      }
      
      // print unique values on standard output
      Comparable[] a = m.valueSet();
      System.out.println("\nVALUESET: "); 
      for (int i = 0; i < a.length; i++)
         System.out.print(a[i] + " ");  
      System.out.println();      
      
      // remove and print the mappings
      System.out.println("\nREMOVEALL: ");
      for (int i = 0; i < k.length; i++)
      {
         System.out.print(k[i]); 
         Object[] v = m.removeAll((String)(k[i]));
         for (int j = 0; j < v.length; j++)
            System.out.print(" + " + v[j]); 
         System.out.println();    
      }      

      // print mapping counter on standard output   
      System.out.println("\nSIZE: " + m.size());                 
   }
}
