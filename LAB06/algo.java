import java.util.Random;

public class algo
{
	public static void main(String[] args)
	{
		Random random = new Random();
		int[] v = new int[100000];
		System.out.print("Before: ");
		for(int i = 0; i<=v.length-1; i++)
		{
			v[i]= random.nextInt(101);
			
			System.out.print(v[i]+" ");
		}
		selectionSort(v);
		System.out.println();
		System.out.print("After: ");
		for(int i = 0; i<=v.length-1; i++)
		{
			
			System.out.print(v[i]+" ");
		}
	}
	

	
	
	
	private static void selectionSort(int[] a)
	{
		for(int i=0; i<a.length; i++)
		{
			int minimumIndex = findMinPos(a, i, a.length-1);
			swap(a, minimumIndex, i);
		}
	}
	private static void swap(int[] a, int fromIndex, int toIndex)
	{
		int tmp = a[toIndex];
		a[toIndex]= a[fromIndex];
		a[fromIndex] = tmp;
		
	}
	private static int findMinPos(int[] a, int from, int to)
	{
		
		int minimumIndex = to;
		for (int i = from; i<=to; i++)
		{
			if(a[i]<a[minimumIndex]) 
			{
				minimumIndex=i;
			}
		}
		return minimumIndex;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void InsertionSort(int[] a)
	{
		/*
		for(int i = 1; i<a.length; i++)
		{
			int tmp = a[i];
			int j=i;
			while(j>0 && a[j-1]>a[j]) // 32451 
			{
				a[j]= a[j-1];
				//a[j-1]=tmp;
				j--;
			}
			
			
		}
		*/
		for(int i = 1; i<a.length; i++)
		{
			int tmp = a[i];
			int j=i-1;
			while(j>=0 && a[j]>tmp)  
			{
				a[j+1]= a[j];
				//a[j-1]=tmp;
				j--;
			}
			a[j+1]=tmp;
			
		}
	}
}