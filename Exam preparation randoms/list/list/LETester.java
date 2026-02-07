import java.util.Scanner;
/** FOUNDATIONS OF COMPUTER SCIENCE
  * PROGRAMMING TEST DATED 3-July-2019
  *
  * Test class of the LE class
  *
  * @see LE
  *
  * @author A. Luchetta
  * @version 18-06-2019
  */
public class LETester
{
   public static void main(String[] args) throws java.io.IOException
   {
      // create an extended list of strings
      LE<String> l = new LE<String>();

      // read data from file and insert them into the list
      Scanner in = new Scanner(new java.io.FileReader(args[0]));
      int r = 0;
      while (in.hasNext())
      {
         l.add(r++, in.next());                         //test of the ass method
      }
      in.close();
      
      // print on standard output the number of elements in the list
      System.out.println("SIZE " + l.size());          //test of the size method
      
      // inspect the elements through an iterator and print them on
      // standard output
      System.out.print("ELEMENTS: ");
      Iterator iter = l.iterator();
      while (iter.hasNext())                        //test of the hasNext method
      {                        
         System.out.print(iter.next() + " ");          //test of the next method
      }
         
      // inspect the elements through their position and print them on
      // standard output
      System.out.print("\nELEMENT POSITION: ");      
      Object[] v = l.toArray();                     //test of the toArray method
      for (int i = 0; i < v.length; i++)
      {
         System.out.print(v[i] + ":" +
                         l.rankOf((String)v[i]) + " ");  //test of rankOf method
      }
                     
      // print on standard output the sorted elements
      System.out.print("\nSORTED ELEMENTS: "); //test of the toSortedList method
      v = l.toSortedList().toArray();
      for (int i = 0; i < v.length; i++)
      {
         System.out.print(v[i] + " "); 
      }
                  
      // print on standard output the sorted elements and their positions
      System.out.print("\nSORTED ELEMENT POSITION: ");      
      for (int i = 0; i < v.length; i++)
      {
         System.out.print(v[i] + ":" +                // test of the 
              l.rankOfSortedList((String)v[i]) + " ");// rankOfSortedList method
      }
      
      // remove the elements through an iterator and print them on standard
      // output
      System.out.print("\nREMOVE: ");
      iter = l.iterator();
      while (iter.hasNext())                        //test of the hasNext method
      {
         System.out.print(iter.next() + " ");         // test of the next method
         iter.remove();                              //test of the remove method
      }                               
         
      // print of the number of elements after removing
      System.out.println("\nSIZE " + l.size());        //test of the size method
      
      // test of the isEmpty method 
      if (l.isEmpty())
      {
         System.out.println("ISEMPTY: OK");
      }
   }  
}
