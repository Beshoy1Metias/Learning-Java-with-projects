

import java.util.Scanner;

public class Echo5{
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("enter three double numbers in the same line: ");
		int sum=0;
		double[] array = new double[3];
		String output = "";
		int counter = 0;
		while(counter <=2 && in.hasNextDouble()){
			
			array[counter]= in.nextDouble();
			counter++;
			
		}
		
		for(int i=0; i<=(array.length-1); i++){
			sum += array[i];
			if (i==array.length-1){
				output += array[i];
				
				break;
			}
			output += array[i] +" + ";
			
			
		}
		
		System.out.print(output+ "= " + sum);
		
		
	}
	
	
	
}