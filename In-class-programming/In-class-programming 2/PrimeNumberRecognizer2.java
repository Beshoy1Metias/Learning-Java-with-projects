import java.util.Scanner;

public class PrimeNumberRecognizer2
{
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("*******************************************");
		System.out.println("*** Checks if the integer n is a prime  ***");
		System.out.println("*******************************************");
		System.out.print("n?: ");

		int n = scanner.nextInt();
		int divided= 0;
		for(int i = 2; i<n; i++)
		{
			if ((n%i) == 0){
				divided = i;
				break;
			}
			
		}
		if(divided ==0){
			System.out.printf("%d is a prime", n);
		}
		else
		{
			System.out.printf("%d divides %d", divided, n);
		}
		
		
	}
	
}