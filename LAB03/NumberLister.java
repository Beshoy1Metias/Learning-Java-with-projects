/*
Write a program that prints the sequence of integers from 1 to n (including n) on standard output, where the number n is read from standard input.

Try printing the first 200 numbers.

Special cases: If n <= 0, print a message of the type: "Input not allowed" on standard output.

Running the class produces a result similar to the following on standard output:
**/

import java.util.Scanner;

public class NumberLister
{
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		System.out.print("N?: ");

		int n = in.nextInt();
		
		if(n <=0){
			System.out.println("Invalid input");
		}
		
		int columnCounter = 0;
		
		int i = 1;
		while (i<=n){
			
			if(columnCounter%10 ==0){
				System.out.println();
			}
			columnCounter++;
			System.out.printf("%5d", i);
			i++;
			
		}
		
		
		
		
	}
	
	
}