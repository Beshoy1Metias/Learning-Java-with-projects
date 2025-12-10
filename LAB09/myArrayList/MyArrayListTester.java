 import java.util.Scanner;
 /**
  * Test class of the MyArrayList class
  * @see MyArrayList
  *
  * @version 9-Dec-2013
  * @author Adriano Luchetta
  */
public class MyArrayListTester
{
   public static void main(String[] args)
   {
      // reate array lists
      MyArrayList v1 = new MyArrayList();
      MyArrayList v2 = new MyArrayList();

      // test of methods add(Object) and add(int, Object)
	   System.out.println(">>> TEST OF ADD METHODS <<<");
      Scanner in = new Scanner(System.in); // opens input data stream
	   int k = 1;
      while (in.hasNext())
      {
         String s = in.next();
		   Integer ik = Integer.valueOf(k++);
		   System.out.println("v1.add(): we add at the end " + s);
		   System.out.println("v2.add(0,e): we add at the beginning " + ik);		 
	      v1.add(s);
		   v2.add(0, ik);
      }
      in.close();                        // closes input data stream

      // test of methods capacity and size
	   System.out.println(">>> TEST OF CAPACITY AND SIZE METHODS <<<");
      System.out.println("CAPACITY = " + v1.capacity());
      System.out.println("SIZE = " + v1.size());

      // test of method elementAt
	   System.out.println(">>> TEST OF ELEMENTAT METHOD <<<");
      System.out.println("*** ELEMENTAT: DIRECT SEQUENCE ***"); 
      int size = v1.size();
      for (int i = 0; i < size; i++)
      {
         System.out.println(v1.elementAt(i));
      }

	   System.out.println("*** *** ELEMENTAT: INVERSE SEQUENCE ******"); 
      for (int i = 0; i < size; i++)
      {
         System.out.println(v2.elementAt(i));
      }
		 
      // test of toArray method
	   System.out.println(">>> TEST OF METHOD TO ARRAY <<<");
	   System.out.println("*** TOARRAY: DIRECT SEQUENCE ***"); 
      Object[] t = v1.toArray();
      for (int i = 0; i < t.length; i++)
      {
         System.out.println(t[i]);
      }

	   System.out.println("*** TOARRAY: INVERSE SEQUENCE ***"); 
      t = v2.toArray();
      for (int i = 0; i < t.length; i++)
      {
         System.out.println(t[i]);
      }
		 
      // test of metodo toString
	   System.out.println(">>> TEST OF TOSTRING METHOD <<<");
	   System.out.println("*** TOSTING: DIRECT SEQUENCE ***");
      System.out.println(v1);

	   System.out.println("*** TOSTRING: DIRECT SEQUENCE ***");
      System.out.println(v2);	  

      // test of method remove
	   System.out.println(">>> TEST OF REMOVE METHOD <<<");
      System.out.println("*** REMOVE: DIRECT SEQUENCE  ***"); 
      while (!v1.isEmpty())
      {
         System.out.println(v1.remove(0));
      }

	   System.out.println("*** REMOVE: DIRECT SEQUENCE ***"); 
      while (!v2.isEmpty())
      {
         System.out.println(v2.remove(0));
      }
 
      // test of methods capacity e size
      System.out.println(">>> TEST OF METHODS CAPACITY AND SIZE <<<");	  	  
      System.out.println("CAPACITY = " + v1.capacity());
      System.out.println("SIZE = " + v1.size());		 
   }
}
