public class LE<E extends Comparable> extends L<E>
{
	public LE()
	{
		super();
	}
	public int rankOfSortedList(E element)
	{
		List<E> l = toSortedList();
		Iterator iter = l.iterator();
		for(int i=0; i<l.size();i++)
		{
			if(iter.next().equals(element)){return i;}
		}
		return -1;
	}
	public List<E> toSortedList()
	{
		Object[] arr = toArray();
		LE<E> l = new LE<E>();
		mergeSort(arr);
		for(int i=0; i<arr.length;i++)
		{
			l.add(i, (E)arr[i]);
		}
		return l;
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
		int ia=0,ib=0,ic=0;
		while(ib<b.length && ic<c.length)
		{
			if(((Comparable)b[ib]).compareTo(c[ic])<0){a[ia++]=b[ib++];}
			else{a[ia++]=c[ic++];}
		}
		while(ib<b.length){a[ia++]=b[ib++];}
		while(ic<c.length){a[ia++]=c[ic++];}
	}
}
