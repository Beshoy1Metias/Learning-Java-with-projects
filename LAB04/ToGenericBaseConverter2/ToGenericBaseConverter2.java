
/**
Write an executable class that converts decimal positive integers to a generic base b with

 2 ≤ b ≤ 10.

Read the integer to be converted and the base from standard input, one pair per line.

Terminate the program when the empty string is acquired.

*/

import java.util.Scanner;

public class ToGenericBaseConverter2
{
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int integer = in.nextInt();
		if(integer<0){
			throw new IllegalArgumentException("Integer value is invalide");
		}
		
		System.out.print("Enter a base: ");
		int base = in.nextInt();
		
		if(base<2 || base >9){
			throw new IllegalArgumentException("Base value is invalid");
		}
		
		int i = 0;
		String output="";
		while(integer>0)
		{
			i = integer%base;
			integer = integer/base;
			output = i + output;
			
			
		}
		System.out.print(output);
		
		
	}
	
	
}