/*
Write the code of the IntegerDivider class that reads two integers x and y from standard input and prints the result of the x / y division  and x % y module on standard output.

Compile and run.

What if the divisor is zero?
*/
import java.util.Scanner;

public class IntegerDivider{
	
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter your integer X: ");
		int X = scanner.nextInt();
		System.out.print("Enter your integer Y: ");
		int Y = scanner.nextInt();
		if(Y==0){
			System.out.println("You can't divide by zero so Y can't be zero!!");
			System.exit(0);
		}
		int divisionResult = X/Y;
		int modulusResult = X%Y;
		System.out.println("X / Y ="+ divisionResult);
		System.out.println("X % Y ="+ modulusResult);
		
		
		
	}
	
	
}