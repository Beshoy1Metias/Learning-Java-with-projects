/**
Write an executable class that reads a line containing three words (strings separated by the characters SP or '\ t') from standard input and prints them on standard output one per line in the inverse order they are in the string.

Example: if the string "one two three" is entered, the execution of the class produces the following printouts

$ java Echo4

enter three words in the same line: one two three

three

two

one*/

import java.util.Scanner;

public class Echo4{
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("enter three words in the same line: ");
		String output="";
		int counter = 0;
		while(counter <=2 && in.hasNext()){
			
			output = "\n"+ in.next() + output;
			counter++;
			
		}
		System.out.print(output);
		
	}
	
	
	
}