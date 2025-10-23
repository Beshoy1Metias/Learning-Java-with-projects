import java.util.Scanner;

public class FactorResolver
{
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("*******************************************");
		System.out.print("n?: ");
		final int number = scanner.nextInt();
		int n = number;
		String divided = "";
		for(int i = 2; i<=n; i++)
		{
			
			while(n%i==0){
				n = n/i;
				divided+= " * "+ i;
			}
			
		}
		System.out.println(number +" = 1"+ divided);
		
	}
	
}