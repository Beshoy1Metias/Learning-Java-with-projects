/**
  * Defines a student<BR>
  * The class is immutable
  *
  * @see Comparable
  * @author Franco Bombi
  * @version 2012
  */
public class Student implements Comparable<Student>
{
   // instance variables
   private final String name;
   private final int rollno;

   public Student(String s, int n)
   {
      name = s;
      rollno = n;
   }

   /**
     provides the roll number of this student
     @return the roll number of this student
   */
   public int rollno() { return rollno; }

   /**
     provides the name of this student
     @return the name of this student
   */
   public String name() { return name; }

   /**
     privides the textual description in the format "rollno:name"
     @return textual description
   */
   public String toString() { return rollno + ":" + name; }

   /**
     compares on roll numbers this student with the specified student<br>
     defines the natural order of the class
     @param s the specified student
     @return 0 if this student and the specified one are equal in the order,
               a negative integer if this student precedes the specified student
               in the order, otherwise a positive number
   */
   public int compareTo(Student s)
   {
      return rollno - s.rollno;
   }
}
