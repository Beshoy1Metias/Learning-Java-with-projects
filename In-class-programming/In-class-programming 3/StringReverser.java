/**Code the StringReverser.java class which reads a string of unknown length from standard input and then prints  a string with 
the same characters in reverse sequence on standard output.

Examples:

$java StringReverser

Please insert a string: ROMA

Reverse string:      AMOR

$java StringReverser

Please insert a string: NEVERODDOREVEN

Reverse string:      NEVERODDOREVEN
*/

import java.util.Scanner;
public class StringReverser{
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		
		String input = in.next();
		String output = "";
		for(int i = (input.length()-1); i>=0 ; i-- ){
			
			output += input.charAt(i);
			
		}
		
		
		System.out.print(output);
		
		
		
		
	}
	
	
}