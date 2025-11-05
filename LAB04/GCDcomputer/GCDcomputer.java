import java.util.Scanner;

public class GCDcomputer
{
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("*****************************************************");
		System.out.println("*** Computes the GDC of numbers m and n           ***");
		System.out.println("*** where m and n are read from standard input    ***");
		System.out.println("*** Prints the result on standard output          ***");
		System.out.println("*****************************************************");
		System.out.print("Enter m and n: ");

		int numerator = in.nextInt();
		int denominator = in.nextInt();
		int numeratorr = numerator;
		int denominatorr = denominator;
		
		while(numerator%denominator>0)
		{
			int tmp=numerator;
			
			numerator = denominator;
			
			denominator = tmp%denominator;
			
			
		}
		int GCD = denominator;
		System.out.printf("GCD(%d, %d)= %d",numeratorr, denominatorr, GCD );
	
	
}
}