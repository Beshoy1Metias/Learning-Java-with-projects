import java.util.Random;
public class ArrayAlgorithms1
{
	public static void main(String[] args)
	{
		Random rand = new Random();
		int[] v = new int[10];
		System.out.print("Unsorted: ");
		for(int i=0; i<v.length; i++)
		{
			v[i]= rand.nextInt(11);
		}
		printArray(v);
		int[] s = new int[10];
		System.arraycopy(v, 0, s, 0, s.length);
		selectionSort(s);
		System.out.printf("%nselectionSorted: ");
		printArray(s);
		int[] d = new int[10];
		System.arraycopy(v, 0, d, 0, d.length);
		insertionSort(d);
		System.out.printf("%nInsertionSorted: ");
		printArray(d);
		int[] f = new int[10];
		System.arraycopy(v, 0, f, 0, f.length);
		mergeSort(f);
		System.out.printf("%nmergeSorted: ");
		printArray(f);
	}

	private static void mergeSort(int[] a) // 6 5 8 3 7
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
	
	
	private static void insertionSort(int[] a) // 6 5 8 3 5
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
	
	
	private static void selectionSort(int[] a)
	{
		for(int i =0; i<a.length; i++)
		{
			int minimumIndex = findMinPos(a, i);
			swap(a, i, minimumIndex);
		}
	}
	private static int findMinPos(int[] a, int from)
	{
		int min =a.length-1;
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
}