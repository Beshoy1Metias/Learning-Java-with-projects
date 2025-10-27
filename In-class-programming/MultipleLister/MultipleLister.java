import java.util.Scanner;

public class MultipleLister{
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter your p, max, and min: ");
		int p = in.nextInt();
		int max = in.nextInt();
		int min = in.nextInt();
		int i = min;
		String output = "";
		
		
		while(i <= max ){
			
			if(i %p==0){
				output+= " "+ i;
			}
			i++;
		}
		

		System.out.println(output);
		
		in.close();
		
		
		
		
	}
	
	
	
}