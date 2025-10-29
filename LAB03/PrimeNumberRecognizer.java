
import java.util.Scanner;

public class PrimeNumberRecognizer
{
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your int: ");
		int n = in.nextInt();
		int j = 2;
		if (n<1){
			System.out.println("Number not allowed");
			System.exit(0);
		}
		while(j*j <=n){
			if (n%j==0){
				System.out.println("The number " + n + " can be divided by " + j); 36 6
				System.exit(0);
			}			
			j++;
		}
		System.out.println("the number " + n + " is prime");
		in.close();
		

		
		
	}
	
	
}