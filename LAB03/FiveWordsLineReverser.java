/**

Write an executable class that reads a line of five words from standard input and prints a line in which the words are arranged in reverse order on standard output.

Example:

input: one two three four five

output: five four three two one

*/


import java.util.Scanner;

public class FiveWordsLineReverser{
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("enter three words in the same line: ");
		String output="";
		int counter = 0;
		while(counter <=4 && in.hasNext()){
			
			output = in.next() + " " + output;
			counter++;
			
		}
		System.out.print(output);
		
	}
	
	
	
}