/**

Write an executable class that reads three different types of data in the same row from standard input: an integer, a word, and a floating point number and prints them on standard output in reverse order, as in the following example:

$ java Echo7

enter an integer, a string and a floating point number: 7 hello 5,1

5.1 hello 7

Note: insert the floating point numbers using the point or the comma as a separator character between the whole part and the fractional part, according to what is required by your operating system.

*/


import java.util.Scanner;

public class Echo7{
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("enter an integer, a string and a floating point number: ");
		int integer = in.nextInt();
		String string = in.next();
		double doub = in.nextDouble();
		
		System.out.print(doub + " " + string + " " + integer);
		
	}
	
	
	
}