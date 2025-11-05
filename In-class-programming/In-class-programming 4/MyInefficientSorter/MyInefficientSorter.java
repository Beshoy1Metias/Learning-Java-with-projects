/*Code the executable class MyInefficientSorter.java that reads a set of integers from the text file toSort.dat by redirection of the standard input and prints the sorted sequence on standard output.

Use the following algorithm:

1. store the read integers in a partially filled (unsorted) array

2. dynamically resize the array so that all its cells contain valid data (full array)

3. repeat steps 3.1 and 3.2 below until the array is empty, then go to step 4

3.1 find the index of the minimum element

3.2 store the minimum value in a backing array (sorted)

3.3 remove the minimum value from the unsorted  array and  dynamically resize it to obtain a full array

4. print the sorted sequence of integers to standard output.

To make the code clear, please define private static methods to perform the steps 3.1, 3.3 and 4.

The described algorithm is inefficient: We will soon study efficient algorithms to sort data.
**/

import java.util.Scanner;

public class MyInefficientSorter
{
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		
		int[] values = new int[200];
		int i =0;
		while(in.hasNext()){
			String x = in.next();
			if(x.equals("")){
				break;
			}
			values[i]= Integer.parseInt(x);
			i++;
		}
		int[] unsorted = new int[i];
		int[] sorted = new int[i];
		for(int j=0; j<i; j++){
			unsorted[j]= values[j];
		}
		int a =0;
		while(a<i){
			int indexx = minIndex(unsorted);
			sorted[a]= unsorted[indexx];
			unsorted = removeMin(unsorted, indexx);
			a++;
		}
		
		for(int j=0; j<i; j++){
			System.out.println(sorted[j]);
		}
		
		
	}
		
	private static int minIndex(int[] arr){
		int min = arr[0];
		int minIndex = 0;
		for(int l=0; l < arr.length; l++ )
		{
			if(arr[l]<=min){
				min = arr[l];
				minIndex = l;
			}
		}
		return minIndex;
		
		
	}

	private static int[] removeMin(int[] arr, int minimumIndex){
		int s =0;
		int[]deleted = new int[arr.length-1];
		for(int j=0; j<arr.length; j++){
			if(j == minimumIndex){
				continue;
			}
			deleted[s]= arr[j];
			s++;
		}
		return deleted;
		
	}
	
}