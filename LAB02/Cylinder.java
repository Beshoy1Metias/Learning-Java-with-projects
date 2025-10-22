/*
Write a program that:

reads  the values of a cylinder radius and height from standard input
calculates the value of the area of the base of the cylinder using the variable Math.PI and store it in a suitable variable
stores the cylinder volume value in a new variable
prints the following message on standard output:
"*** The volume of the cylinder of radius ... and height ... is equal to ... ***" where instead of the characters ... there are the values of the radius, height and volume of the cylinder.
NB: when you need the constant π, do not define it as in the previous exercise, but use the constant Math.PI defined in the java.lang.Math class.

See the documentation for the Math class in the Java ™ Platform API Specification.
*/

import java.util.Scanner;

public class Cylinder{
	
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the cylinder's radius: ");
		double radius = scanner.nextDouble();
		System.out.print("Enter the cylinder's height: ");
		double height = scanner.nextDouble();
		double volume = Math.PI * Math.pow(radius, 2) * height;
		
		
		System.out.println("The volume of the cylinder of radius "+radius+ " cm and height "+height+" cm is equal to "+volume+" cm^3");
		
		
	}
	
	
	
}