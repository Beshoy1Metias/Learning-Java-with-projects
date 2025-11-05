/*


import java.util.Scanner;
public class FibonacciSequenceGenerator
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter k: ");
		int k = in.nextInt();
		if(k==0){
			System.out.print("0");
			System.exit(0);
		}
		if(k==1){
			System.out.print("0, 1");
			System.exit(0);
		}
		if(k==2){
			System.out.print("0, 1, 1");
			System.exit(0);
		}
		k = k-4;
		int count =0;
		
		int first=1;
		int second =1;
		int res=0;
		String output="";
		while(count<=k){
			if(k==0){}
			res = first+second;
			output = output+ ", " +res;
			first = second;
			second = res;
			
			count++;
		}
		System.out.print("0, 1, 1"+output);
	}
}
**/
import java.util.Scanner;
public class FibonacciSequenceGenerator
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter k: ");
		int k = in.nextInt();
		int count =0;
		
		int first=1;
		int second =1;
		int res=0;
		String output="";
		while(count<=k){
			if(k==0){
				System.out.print("0 ")
				}
			res = first+second;
			output = output+ ", " +res;
			first = second;
			second = res;
			
			count++;
		}
		System.out.print("0, 1, 1"+output);
	}
}