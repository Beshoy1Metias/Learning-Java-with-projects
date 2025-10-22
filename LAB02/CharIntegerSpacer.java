/*Spacing an integer	
Repeat the exercise of spacing a number by obtaining the single digits using the charAt (int) method of the java.lang.String class to extract the single characters from the input string.	
*/
import java.util.Scanner;

public class CharIntegerSpacer{
	
	public static void main(String[] args)
	{
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your integer: ");
		int number = scanner.nextInt();
		String digits = Integer.toString(number);
		char first = digits.charAt(0);
		char second = digits.charAt(1);
		char third = digits.charAt(2);
		System.out.println(first + " "+ second + " "+third+" ");
	}
	
}