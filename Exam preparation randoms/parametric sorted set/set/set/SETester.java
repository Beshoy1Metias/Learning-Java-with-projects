/**
  * FOUNDATIONS OF COMPUTER SCIENCE
  * Programming test dated 29-01-2020
  *
  * Test Class of th SE class
  *
  * @see SE
  * @see S
  */
public class SETester
{
   public static void main(String[] args)
   {
      final String[] STR1 = {"Charlie", "Bravo", "Alpha", "Charlie"};
      final String[] STR2 = {"Delta", "Charlie", "Bravo", "Alpha"};
      
      // test of the constructors and of the add method
      SE<String> s1 = new SE<String>(STR1);
      SE<String> s2 = new SE<String>(STR2);
      SE<String> s3 = new SE<String>(s1);
      
      // test of the size method            
      System.out.println("SIZE S1/S2 = " +s1.size() + "/" +s2.size());
      
      // test of iterator, hasNext and next methods            
      System.out.print("ELEMENTS S1 = ");
      Iterator<String> iter = s1.iterator();
      while (iter.hasNext())
         System.out.print(iter.next() + " ");
      System.out.println(); 
      
      System.out.print("ELEMENTS S2 = ");
      iter = s2.iterator();
      while (iter.hasNext())
         System.out.print(iter.next() + " ");
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
    
      // test of compareTo method      
      if (s1.compareTo(s2) < 0)
         System.out.println("S1 PRECEDES S2");
      else if (s1.compareTo(s2) > 0)
         System.out.println("S1 FOLLOWS S2"); 
      else
         System.out.println("S1 EQUALS S2"); 
                          
      if (s1.compareTo(s3) < 0)
         System.out.println("S1 PRECEDES S3");
      else if (s3.compareTo(s2) > 0)
         System.out.println("S1 FOLLOWS S3"); 
      else
         System.out.println("S1 EQUALS S3");  
           
      // test of subset method                 
      System.out.print("SUBSET S4 ");
      iter = s2.iterator();
      System.out.print("MISSING " + iter.next() + ": ");
      SE<String> s4 = s2.subset(iter);
      iter = s4.iterator();         
      while (iter.hasNext())
         System.out.print(iter.next() + " ");
      System.out.println();
      
      // test of remove method      
      System.out.print("REMOVED = ");
      iter = s2.iterator();
      while (iter.hasNext()) {
         System.out.print(iter.next() + " ");         
         iter.remove();
      }                 
      System.out.println("\nSIZE: " + s2.size()); 
       
      // test of min method      
      System.out.println("MIN S1: " + s1.min());
   }
}
