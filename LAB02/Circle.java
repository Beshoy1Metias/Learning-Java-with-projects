/*	
Write a program that:

reads the value of a circle radius from standard input;
defines a constant to store the value of constant π (pi) expressed with 15 decimal digits (3.14159265358979)
stores the value of the circumference in a specific variable (2 π radius)
prints the following message on standard output:
"*** The circumference of a circle of radius ..... is equal to ... ***" where instead of the characters ... there are respectively the values ​​of the radius and the circumference
stores the value of the area in another variable (π radius2)
prints the following message on standard output:
"*** The area of ​​a circle of radius ... is equal to ... ***" where the values ​​of the radius and circumference are printed instead of characters ...
Visit the documentation of the Math class in the standard library (Java Platform API) and tell what the constants below represent.

Math.PI
Math.E
-------------------------------------------

Use of constants of the java.lang.Math class

If we need to use the constant π or the constant e (basis of natural logarithms) in a Java program, we do not have to define a variable and initialize it with the relative value, as in the exercise above, but we will use the constants defined in the java class. lang.Math.

For example, to calculate the circumference and area of ​​a circle of radius r we will write

double r = 0.5; // radius of the circle

double c = 2 * Math.PI * r; // circumference of the circle

double a = Math.PI * r * r; // area of ​​the circle ...

-------------------------------------------

Concatenation of strings

The following code snippet

// print the circumference value

double r = 0.5;

final double PI = 3.1415926535897;

double c = 2 * PI * r;

System.out.print ("\ n *** The circumference of the circle with radius");

System.out.print (r);

System.out.print ("is equal to");

System.out.print (c);

System.out.println ("***");

prints the string below on standard output:

*** the circumference of the circle with radius 0.5 is equal to 3.14159265358979 ***

The same result can be obtained with the following code:

// print the circumference value

double r = 0.5;

final double PI = 3.1415926535897;

double c = 2 * PI * r;

System.out.println ("\ n *** The circumference of the circle with radius" + r + "is equal to" + c + "***");

The + operator, used as in the example above, is the concatenation operator and is used to produce a single string from several components.

The example forms a single string from strings and numeric variables. Strings are "\ n *** The circumference of the circle with radius"  and "is equal to" "***".

The numeric variables are r and c.
*/


import java.util.Scanner;

public class Circle{
	public static void main(String[] args){
			
			Scanner scanner = new Scanner(System.in);
			
			final double pi = Math.PI;
			
			System.out.print("Enter the circle's radius: ");
			double radius = scanner.nextDouble();
			double circumference = 2* pi* radius;
			double area = pi * Math.pow(radius, 2);
			System.out.println("The circumference of a circle of radius " + radius + " cm is equal to "+ circumference +" cm");
			System.out.println("The area of a circle of radius " + radius + " cm is equal to " + area + " cm^2");
		
	}
	
	
	
}