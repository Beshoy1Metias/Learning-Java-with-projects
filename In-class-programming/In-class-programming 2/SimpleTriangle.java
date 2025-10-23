/*
Code the SimpleTriangle.java class with the public interface SimpleTriangle.html.

Test it using the SimpleTriangleTester.java class provided by the instructor (download the test class in the same directory where you 
have your class SimpleTriangle.java and then compile it).

Successively, run the SimpleTriangleTester class.

You can find here an algorithm to compute the area of a triangle, given the sides.

Note: For now, do not check in the constructor if the triplet of the side values contains negative integers or if it does not represent a triangle.
*/
public class SimpleTriangle{
	public double sideA;
	public double sideB;
	public double sideC;
    public SimpleTriangle(double a, double b, double c){
		this.sideA = a;
		this.sideB = b;
		this.sideC = c;
		
	}
	public double perimeter(){
		return sideA + sideB + sideC;
	}
	 public double area() {
        double s = perimeter() / 2.0;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
	public String toString(){
		return "SimpleTriangle with sides " + sideA + ", "+ sideB + ", "+ sideC;
	}
}
