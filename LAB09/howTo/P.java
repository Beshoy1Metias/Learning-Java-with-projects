/**
  * Teaching class implementing the java.lang.Comparable<T> interface to show 
  * how it works
  *
  * @see java.lang.Comparable<T>
  *
  * @author A. Luchetta
  * @version 8-Dic.2016
  *
  */
public class P implements Comparable<P>
{
   // instance variable
   private final int p;
   
   /**
      Initializes the instance variable by using a random integer in the range
      [1, 100]
   */
   public P()
   {
      p = (int)(1 +  99 * Math.random()); // generates a random integer in the 
                                          // range [1, 100]
   }
   
   /*
      Compares this instance with the specified instance     
      @param other the specified instance
      @return a negative integer, zero, or a positive integer when this instance
              is less than, equal to, or greater than the specified instance
   */
   public int compareTo(P other)
   {
      return p - other.p;
   }
   
   /**
      Returns the textual description
      @returns the textual description
   */
   public String toString()
   {
      return "P" + p;
   }
}
