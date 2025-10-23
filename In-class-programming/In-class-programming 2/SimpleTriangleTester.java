/**
  * Test class of SingleTriangle class
  *
  * @author A. Luchetta
  * @version 17-10-2015
  *
  */
public class SimpleTriangleTester
{
   public static void main(String[] args)
   {
      // triangle instantiation
      SimpleTriangle t1 = new SimpleTriangle(3, 4, 5);
      SimpleTriangle t2 = new SimpleTriangle(5, 12, 13);      
      SimpleTriangle t3 = new SimpleTriangle(7, 24, 25);
      
      //computation of strings containing perimeter and area 
      String s1 = t1 + " perimeter " + t1.perimeter() + " area " + t1.area();       
      String s2 = t2 + " perimeter " + t2.perimeter() + " area " + t2.area();       
      String s3 = t3 + " perimeter " + t3.perimeter() + " area " + t3.area(); 
      
      // printing of results on standard output
      System.out.println(s1);      
      System.out.println(s2);          
      System.out.println(s3);          
   }  
}
