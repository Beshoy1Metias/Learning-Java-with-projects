/**
  * FOUNDATIONS OF COMPUTER SCIENCE
  * Programming test dated 29-01-2020
  *
  * Test class of the S class
  *
  * @See S
  */
public class STester
{
   public static void main(String[] args)
   {
      final String[] STR1 = {"Charlie", "Bravo", "Alpha", "Charlie"};
      final String[] STR2 = {"Delta", "Charlie", "Bravo", "Alpha"};
      
      // test the constructors and add method
      S<String> s1 = new S<String>(STR1);
      S<String> s2 = new S<String>(STR2);
      S<String> s3 = new S<String>(s1);
      
      // test of size method            
      System.out.println("SIZE S1/S2 = " +s1.size() + "/" +s2.size());
      
      // test of iterator, hasNext and next methods            
      System.out.print("ELEMENTS S1 = ");
      Iterator<String> iter = s1.iterator();
      while (iter.hasNext()) System.out.print(iter.next() + " ");
         System.out.println(); 
         
      System.out.print("ELEMENTS S2 = ");
      iter = s2.iterator();
      while (iter.hasNext()) System.out.print(iter.next() + " ");
         System.out.println(); 
         
      // test of toSortedArray method
      System.out.print("SORTED ELEMENTS S1 = ");
      String[] st = new String[s1.size()]; 
      s1.toSortedArray(st);   
      for (String p : st)
         System.out.print(p + " ");
      System.out.println();     
      
      System.out.print("SORTED ELEMENTS S2 = ");
      st = new String[s2.size()]; 
      s2.toSortedArray(st); 
      for (String p : st)
         System.out.print(p + " ");
      System.out.println();   
      
      // test of remove method      
      System.out.print("REMOVED = ");
      iter = s2.iterator();
      while (iter.hasNext()) {
         System.out.print(iter.next() + " ");         
         iter.remove();
      }        
      System.out.println();          
      System.out.println("SIZE: " + s2.size());
      
      // test of min method      
      System.out.println("MIN S1: " + s1.min());      
   }
}
