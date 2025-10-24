/*
Write the MultipleLister2.java executable class that prints on standard output the multiples of the positive integer n included 
in the range [n, max], where max > n, in sequence from the largest to the smallest.

Read n and max from the standard input.

Example:

if n = 3 and max = 20, the program prints on standard output the string

"multiples of 3 between 3 and 20: 18 15 12 9 6 3"

Download and run the bytecode of MultipleLister2.class provided by the instructor (compiled with JDK 17).

Write a class with the same behavior.
*/
import java.util.Scanner;

public class MultipleLister2
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
		
		System.out.println("************************************************");
		System.out.println("* Prints the list of multiples of integer p in *");
		System.out.println("  the range [p, max]                           *");
		System.out.println("* Reads p and max from the standard input      *");
		System.out.println("************************************************");
		
		System.out.print("enter p and max: ");
		int p = scanner.nextInt();
		int max = scanner.nextInt();
		if(p<=0 || max<p){
			System.out.print("Values are incorrect");
			System.exit(0);
		}
		String output = "";
		int i = p+1;
		while(i<=max)
		{
			if((i%p)==0)
			{
				output = output+ " "+i;
			}
			i++;
		}
		System.out.printf("Multiples of %d in the range [%d, %d]:%s", p, p, max, output);
		
		scanner.close();
		/*
				for(int i=max; i>=p; i--){
			
			if((i%p)==0){
				
				output += " " + i;
				
			}
			
			
		}
		
		System.out.println("Write the MultipleLister2.java executable class that prints on standard output the multiples of the positive integer n included in the range [n, max], where max > n, in sequence from the largest to the smallest.");
		
		System.out.print("Enter n: ");
		int n = scanner.nextInt();
		System.out.print("Enter m: ");
		int max = scanner.nextInt();
		String output = "";
		for(int i=max; i>=n; i--){
			
			if((i%n)==0){
				
				output += " " + i;
				
			}
			
			
		}
		System.out.printf("multiples of %d between %d and %d:%s", n, n, max, output);
		*/
        
    }


}