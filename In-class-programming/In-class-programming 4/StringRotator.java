/**
Code the StringRotator.java class that rotates a string s by a number of characters equal to the integer n and then prints the rotated string on standard output.

Read string s and integer n from standard input.

If n > 0, rotate the string to the right and if n < 0, rotate it to the left. In the case of n = 0 the program returns the original string s.

The figure below explains the rotations of the string s by one step to the right and to the left.
	@author B. Metias
	@version 11/05/2025
*/
import java.util.Scanner;

public class StringRotator
{
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		System.out.print("enter string: ");
		String input = in.next();
		System.out.print("insert the number of rotations: ");
		int r = in.nextInt();
		char[] output = new char[input.length()];
		char[] backup = new char[input.length()];
		int length =input.length();
		for(int i =0; i<input.length(); i++){
			output[i]= input.charAt(i);
			backup[i]=input.charAt(i);
		}
		
		while(Math.abs(r)>length){
			r -= length;
		}
		while(r<0){
			r = r+(length);
		}
		for(int j =0; j <input.length(); j++){
			if(r==input.length()){
				r=0;
			}
			if(j+r ==length){
				
				for(int l=0; l<r; l++){
					output[l]=backup[j];
					j++;
				}
				break;
			}
			output[j+r]=backup[j];
		}
		
		System.out.print("rotated string: ");
		for(int i =0; i<input.length(); i++){
			System.out.print(output[i]);
		}
		
	}
	
}