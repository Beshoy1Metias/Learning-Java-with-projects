/*
 * MyPoint2DTester
 * test class of class MyPoint2D
 * @author A. Luchetta
 * @version 14-09-221
 */
import java.util.Scanner;
import java.util.Locale;
public class MyPoint2DTester
{ public static void main(String[] args)
 { Scanner in = new Scanner(System.in); // opens the input data stream
 in.useLocale(Locale.US);

 System.out.print("Enter x1 e y1 ");
 double x1 = in.nextDouble();
 double y1 = in.nextDouble();
 System.out.print("Enter x2 e y2 ");
 double x2 = in.nextDouble();
 double y2 = in.nextDouble();
 in.close(); // closes the input data stream

 MyPoint2D p = new MyPoint2D(x1, y1); // creates new point p
 MyPoint2D r = new MyPoint2D(x2, y2); // creates new point r

 System.out.println("Distance of point " + p + " from point + " + r
 + " is " + p.getDistanceFrom(r));
 System.out.println("Midpoint of point " + p + " and point " + r
 + " is " + p.getMidpoint(r));
 }
}