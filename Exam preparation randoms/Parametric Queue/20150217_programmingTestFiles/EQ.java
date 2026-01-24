public class EQ<T extends Comparable> extends Q<T> // Extended queue
{
	public EQ(){super();}
	public void enqueue(T x) { super.enqueue(x); } // code provided by teacher
	
	public Object[] toSortedArray()
	{
		Object[] arr = toArray();
		mergeSort(arr);
		return arr;
	}
	private void mergeSort(Object[] a)
	{
		if(a.length<2){return;}
		int mid = a.length/2;
		Object[] left = new Object[mid];
		Object[] right = new Object[a.length-mid];
		System.arraycopy(a, 0, left, 0, left.length);
		System.arraycopy(a, mid, right, 0, right.length);
		mergeSort(left);
		mergeSort(right);
		merge(a, left, right);
	}
	private void merge(Object[] a, Object[] b, Object[] c)
	{
		int ia=0, ib=0, ic=0;
		while(ib< b.length && ic<c.length)
		{
			if(((Comparable)b[ib]).compareTo(c[ic])<0){a[ia++]=b[ib++];}
			else{a[ia++]=c[ic++];}
		}
		while(ib<b.length){a[ia++]=b[ib++];}
		while(ic<c.length){a[ia++]= c[ic++];}
	}
	public Object[] getOnlyUniqueItems()
	{
		Object[] arr = toArray();
		Object[] unique = new Object[arr.length];
		int count=0;
		mergeSort(arr);
		unique[count++]=arr[0];
		for(int i=1; i<arr.length; i++)
		{
			if(arr[i-1].equals(arr[i])){continue;}
			unique[count++]=arr[i];
		}
		if(count<arr.length)
		{
			Object[] tmp = new Object[count];
			System.arraycopy(unique, 0, tmp, 0, count);
			unique=tmp;
		}
		return unique;
	}
	public EQ[] split(int n)
	{
		if(n<1){throw new IllegalArgumentException();}
		EQ[] queues = new EQ[n];
		for(int i=0;i<n;i++)
		{
			queues[i] = new EQ();
		}
		Object[] arr = toArray();
		mergeSort(arr);
		for(int i=0; i<arr.length; i++)
		{
			queues[i%n].enqueue(arr[i]);
		}
		return queues;
	}
}
