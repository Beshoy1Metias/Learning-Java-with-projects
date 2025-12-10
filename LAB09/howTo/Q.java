/**
  * Teaching class not implementing the java.lang.Comparable<T> interface
  *
  * @author A. Luchetta
  * @version 8-Dic.2016
  *
  */
public class Q   // note: class does not implement the Comparable interface
{
   // instance variable
   private final int q;
   
   /**
      Initializes the instance variable by using a random integer in the range
      [1, 100]
   */
   public Q()
   {
      q = (int)(1 +  99 * Math.random()); // generates a random integer in the 
                                          // range [1, 100]
   }
   
   /*
      Compares this instance with the specified instance     
      @param other the specified instance
      @return a negative integer, zero, or a positive integer when this instance
              is less than, equal to, or greater than the specified instance
   */
   public int compareTo(Q other)
   {
      return q - other.q;
   }
   
   /**
      Returns the textual description
      @returns the textual description
   */
   public String toString()
   {
      return "Q" + q;
   }
}
