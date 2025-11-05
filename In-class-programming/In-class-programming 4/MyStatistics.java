
/*
Code the MyStatistics.java class that computes the arithmetic mean and standard deviation of a set X of integer numbers.

Read the integers from the integers.dat file using standard input redirection

The class computes the mean and standard deviation of the X data set and prints them  on standard output.

The following expressions describe the mean μ (mu ) and the standard deviation σ (sigma) of a set X of data, where N is the number of elements of X.

**/

import java.util.Scanner;

public class MyStatistics
{
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int[] values = new int[200];
		
		int counter =0;
		double sum =0.0;
		
		while(in.hasNextInt()){
			String x = in.next();
			if(x.equals("")){
				break;
			}
			values[counter]=Integer.parseInt(x);
			
			sum += values[counter];		
			counter++;
		}
		double mean = sum/counter;

		double y=0;
		double root= 0;
		for(int j=0; j<counter; j++){
			
			double f=values[j]-mean;
			root += Math.pow(f, 2);
			
			
		}
		double result = Math.sqrt(root/counter);
		
		
		System.out.println("Standard deviation equals: "+result);
		System.out.println("Mean equals: "+mean);
		System.out.print("Number of values: "+counter);
		
		
	}
	
	
}