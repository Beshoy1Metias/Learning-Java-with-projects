/*
The division by zero in double-precision IEEE 754 floating-point numbers

Write the DoubleDivider class code that reads two floating point numbers x and y from standard input and prints the result of the x / y division on standard output.

Compile and run.

Try the pairs of numbers below:

x = 7.0 y = 0.0,
x = -7.0 y = 0.0,
x = 0.0 y = 0.0.
Explain the results obtained.	
*/
import java.util.Scanner;
public class DoubleDivider
{
	
	public static void main(String[] args)
	{
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter your double X: ");
		double X = scanner.nextDouble();
		System.out.print("Enter your double Y: ");
		double Y = scanner.nextDouble();
		/*
		if(Y==0){
			System.out.println("You can't divide by zero so Y can't be zero!!");
			System.exit(0);
		}*/
		double divisionResult = X/Y;
		double modulusResult = X%Y;
		System.out.println("X / Y ="+ divisionResult);
		System.out.println("X % Y ="+ modulusResult);
		
		
	}
	
	
	
}