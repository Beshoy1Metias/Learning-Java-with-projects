/**
Write an executable class that reads a line containing three words (strings separated by the characters SP or '\ t') from standard input and prints them on standard output one per line in the order they are in the string.

Example: if the string "one two three" is entered, the execution of the class produces the following printouts

$ java Echo3

enter three words in the same line: one two three

one

two

three*/

import java.util.Scanner;

public class Echo3{
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("enter three words in the same line: ");
		String output="";
		int counter = 0;
		while(counter <=2 && in.hasNext()){
			
			output += "\n"+ in.next();
			counter++;
			
		}
		System.out.print(output);
		
	}
	
	
	
}