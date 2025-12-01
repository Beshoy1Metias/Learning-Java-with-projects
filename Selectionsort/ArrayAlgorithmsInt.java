public class ArrayAlgorithmsInt
{
	public static void main(String[] args){
		int[] v = {5, 3, 2, 6, 9, 8};
		selectionSort(v);
		
		for(int i = 0; i<v.length; i++){
			System.out.print(v[i]+ " ");
		}
		System.out.printf("%n"+ binarySearch(v, 5));
		//System.out.printf("%nlinearSearch for your number is "+linearSearch(v, 5));
	}
	
	public static int binarySearch(int[] a, int target)
	{
		return binSearch(a, 0, a.length-1, target);
		
	}
	private static int binSearch(int[] a, int from, int to, int target){
		if(from>to){
			return -1;
		}
		int mid = (from+to)/2;
		if(a[mid]==target){
			return mid;
		}
		else if(a[mid] <target)
		{
			return binSearch(a, mid+1, to, target);
		}
		else
		{
			return binSearch(a, from, mid-1, target);
		}
	}
	
	public static int linearSearch(int[] a, int s)
	{
		for(int i=0; i<a.length; i++)
		{
			if(a[i]== s){
				return i;
			}
		}
		return -1;
	}
	
	public static void selectionSort(int[] a)
	{
		for(int i=0; i<a.length-1; i++)
		{
			int min = findMinPos(a, i);
			if(a[i]==min)
			{
				continue;
			}
			else{
				swap(a, min, i);
			}
		}
		
	}
	
	private static void swap(int[] a, int to, int from)
	{
		int temp = a[to];
		a[to]=a[from];
		a[from]=temp;
	}
	private static int findMinPos(int[] a, int from)
	{
		int minIndex=from;
		for(int i=from+1; i<a.length; i++)
		{
			if(a[minIndex]>a[i]){
				minIndex=i;
			}
		}
		return minIndex;
	}
	
}