/**
Write an executable class to read from standard input a set of lines made up of any number of words (the words are tokens separated by whitespace characters).

For each line, print on standard output a corresponding line in which the words are arranged in reverse order.

End the program using the command cntr + D.

Example:

$ java LineWordReverser

insert line: one two three four five

input: one two three four five

output: five four three two one

input: ctrl-D

*** END ***

It is similar to a lab2 exercise, but this time the number of words in the string is not known.
*/

import java.util.Scanner;

public class LineWordReverser
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		final String END_OF_DATA = "D";
		
		
		while(in.hasNextLine()){
			
			String line = in.nextLine();
			String[] tokens = line.split(" ");
			int counter = 0;
			String inverse = "";
			while(counter < tokens.length){
				if(tokens[counter].equals(END_OF_DATA)){
					System.exit(0);
				}
				inverse = tokens[counter]+ " " + inverse;
				counter++;
			}
			System.out.println(inverse);
		}
		
		
		
	}
}