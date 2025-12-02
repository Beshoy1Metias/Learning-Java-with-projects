
// linear search, guarded linear search (linear search with a sentinel), recursive binary search, and loop-based binary search
public class ArrayAlgorithms1
{
	public static void main(String[] args)
	{
		
		SequencesGenerator gen = new SequencesGenerator();
		
		int[] v = gen.uniqueSortedIntegerArray(11);
		System.out.print("Unsorted: ");
		printArray(v);
		System.out.println();
		System.out.print(guardedLinearSearch(v, 5, 6));
	}
	public static int linearSearch(int[] a, int target)
	{
		for(int i =0; i<a.length; i++)
		{
			if(a[i]==target)
			{
				return i;
			}
		}
		return -1;
	}
	public static int guardedLinearSearch(int[] a, int sentinel, int target)
	{
		a[a.length-1]=sentinel;
		int i=0;
		while(a[i]!= target)
		{
			i++;
		}
		if(i==a.length){
			return -1;
		}
		else{return i;}
	}
	public static int recursiveBinarySearch(int[] a,int target)
	{
		return recursiveBinSearch(a, target, 0, a.length-1);
	}
	private static int recursiveBinSearch(int[] a,int target, int left, int right)
	{
		if(left>right)
		{
			return -1;
		}
		int mid = (left+right)/2;
		if(a[mid]==target){
			return mid;
		}
		else if(a[mid]<target){
			return recursiveBinSearch(a, target,mid+1 , right);
		}
		else{return recursiveBinSearch(a, target, left, mid-1);}
	}
	public static int iterativeBinarySearch(int[] a, int target)
	{
		int l =0;
		int r = a.length-1;
		
		while(l<=r)
		{
			int mid = (l+r)/2;
			if(a[mid]==target){
				return mid;
			}
			else if(a[mid]<target)
			{
				l=mid+1;
			}
			else
			{
				r=mid-1;
			}
			
		}
		return -1;
	}
	
	public static void mergeSort(int[] a)
	{
		if(a.length<2){
			return;
		}
		int mid = a.length/2;
		int[] left = new int[mid];
		int[] right = new int[a.length-mid];
		System.arraycopy(a, 0, left, 0, left.length);
		System.arraycopy(a, mid, right, 0, right.length);
		mergeSort(left);
		mergeSort(right);
		merge(a, left, right);
	}
	private static void merge(int[] a, int[] b, int[] c)
	{
		int ia=0;
		int ib=0;
		int ic=0;
		while(ib < b.length && ic < c.length)
		{
			if(b[ib]<c[ic]){
				a[ia++]=b[ib++];
			}
			else
			{
				a[ia++]=c[ic++];
			}
		}
		while(ib<b.length)
		{
			a[ia++]=b[ib++];
		}
		while(ic<c.length)
		{
			a[ia++]=c[ic++];
		}
	}
	
	
	public static void insertionSort(int[] a) // 6 5 8 3 5
	{
		for(int i=1; i<a.length; i++)
		{
			int j=i-1;
			int current = a[i];
			while(j>=0 && a[j]>current)
			{
				a[j+1]=a[j];
				j--;
			}
			a[j+1]= current;
		}
	}
	
	
	public static void selectionSort(int[] a)
	{
		for(int i =0; i<a.length; i++)
		{
			int minimumIndex = findMinPos(a, i);
			swap(a, i, minimumIndex);
		}
	}
	private static int findMinPos(int[] a, int from)
	{
		int min =from;
		for(int i=from; i<a.length;i++)
		{
			if(a[i]<a[min])
			{
				min=i;
			}
		}
		return min;
	}
	private static void swap(int[] a, int i, int j)
	{
		int tmp=a[i];
		a[i]=a[j];
		a[j]=tmp;
	}
	
	private static void printArray(int[] a)
	{
		for(int i=0; i<a.length; i++)
		{
			System.out.print(a[i]+" ");
		}
	}
	
		/*
	public static void main(String[] args)
	{
		
		SequencesGenerator gen = new SequencesGenerator();
		Chronometer timer = new Chronometer();
		
		int[] v = gen.uniqueRandomIntegerArray(1000001);
		System.out.print("Unsorted: ");
		//printArray(v);
		
		// Selection Sort
		int[] s = new int[v.length];
		System.arraycopy(v, 0, s, 0, s.length);
		timer.start();
		selectionSort(s);
		timer.stop();
		long timeSel = timer.getElapsedTime();  // Unique variable name
		timer.reset();
		System.out.printf("Selection Sort Time: %d ms%n", timeSel);

		// Insertion Sort  
		int[] d = new int[v.length];
		System.arraycopy(v, 0, d, 0, d.length);
		timer.start();
		insertionSort(d);
		timer.stop();
		long timeIns = timer.getElapsedTime();
		timer.reset();
		System.out.printf("Insertion Sort Time: %d ms%n", timeIns);

		// Merge Sort (add timing too)
		int[] f = new int[v.length];
		System.arraycopy(v, 0, f, 0, f.length);
		timer.start();
		mergeSort(f);
		timer.stop();
		long timeMerge = timer.getElapsedTime();
		timer.reset();
		System.out.printf("Merge Sort Time: %d ms%n", timeMerge);
		//printArray(f);

		
	}
*/
}