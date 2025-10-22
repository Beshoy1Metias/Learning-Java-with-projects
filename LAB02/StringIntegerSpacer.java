/* Spacing an integer	

Repeat the exercise of spacing an assigned integer done in lab01, obtaining the single digits using the substring (...) method of the String class.

Use a three digit integer read from standard input.

To convert an integer to a string use the following statements:

int n = ...;

String s = n + ""; // concatenation operation with the empty string

or

int n = ...;

String s = Integer.toString( n); // check the documentation of the static method toString() of the Integer class

Possible exception

When the integer to be spaced has less than 3 digits, the teacher-provided solution launches StringIndexOutOfBoundsException at run time.

How can we avoid it?
*/
import java.util.Scanner;

public class StringIntegerSpacer
{
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your integer: ");
		int number = scanner.nextInt();
		String digits = Integer.toString(number);
		String first = digits.substring(0, 1);
		String second = digits.substring(1, 2);
		String third = digits.substring(2);
		System.out.println(first + " "+ second + " "+third+" ");
	}
	
	
}