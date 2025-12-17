public class EQ<T extends Comparable> extends Q<T>
{
	public EQ[] split(int n) throws IllegalArgumentException
	{
		if(n<1){throw new IllegalArgumentException();}
		
		int len = super.size();
		int numberOfQueues=0;
		numberOfQueues = len/n;
		EQ[] arr = new EQ[numberOfQueues];
		Object[] array = super.toArray();
		if(len%n>0)
		{
			numberOfQueues++;
			arr = new EQ[numberOfQueues];
			int count=0;
		for(int i=0; i<numberOfQueues-1; i++)
		{
			EQ temp = new EQ();
			for(int j=0; j< numberOfQueues-1; j++)
			{
				temp.enqueue(array[i+count]);
				count++;
			}
			
			arr[i]=temp;
		}
		EQ temp = new EQ();
		for(int i=count; i< len; i++)
		{
			temp.enqueue(array[i]);
		}
		arr[numberOfQueues-1]=temp;
		
		return arr;
		}
		int count=0;
		for(int i=0; i<numberOfQueues; i++)
		{
			EQ temp = new EQ();
			for(int j=0; j< numberOfQueues; j++)
			{
				temp.enqueue(array[i+count]);
				count++;
			}
			arr[i]=temp;
		}
		
		return arr;
	}
	
	public void enqueue(T x) {super.enqueue(x);}
	public Object[] toSortedArray()
	{
		Object[] arr = super.toArray();
		mergeSort(arr);
		return arr;
	}
	private void mergeSort(Object[] a)
	{
		if(a.length<2){return;}
		int mid = a.length/2;
		Comparable[] left = new Comparable[mid];
		Comparable[] right = new Comparable[a.length-mid];
		System.arraycopy(a, 0, left, 0, left.length);
		System.arraycopy(a, mid, right, 0, right.length);
		mergeSort(left);
		mergeSort(right);
		merge(a, left, right);
	}
	private void merge(Object[] a, Comparable[] b, Comparable[] c)
	{
		int ia=0, ib=0, ic=0;
		while(ib<b.length && ic<c.length)
		{
			if(b[ib].compareTo(c[ic])<0){a[ia++]=b[ib++];}
			else{a[ia++]=c[ic++];}
		}
		while(ib<b.length){a[ia++]=b[ib++];}
		while(ic<c.length){a[ia++]=c[ic++];}
	}
	public Object[] getOnlyUniqueItems() // apple apple blackberry blackberry fig grape pear
	{
		Object[] arr = toSortedArray();
		int arrSize=0;
		int count =0;
		Object[] temp= new Object[arr.length];
		for(int i=0; i<arr.length-1; i++)
		{
			if(arr[i].equals(arr[i+1])){
				count=1;
				continue;
			}
			if(count==1){count =0; 
			continue;}
			temp[arrSize++]=arr[i];
		}
		
		if(arrSize<arr.length)
		{
			Object[] temporary = new Object[arrSize];
			System.arraycopy(temp, 0, temporary, 0, arrSize);
			temp = temporary;
		}
		return temp;
	}
	

}