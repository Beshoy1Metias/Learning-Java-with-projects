public class M <K extends Comparable, V> implements Map <K, V>
{
	private Comparable[][] arr;
	int arrSize;
	public M(){makeEmpty();}
	private void makeEmpty()
	{
		arr = new Comparable[10][10];
		arrSize=0;
	}
	public V get(K key)
	{
		for(int i=0; i<arrSize; i++)
		{
			if(arr[i][0].equals(key)){return (V)arr[i][1];}
		}
		return null;
	}
	public boolean isEmpty()
	{
		return arrSize<=0;
	}
	public Comparable[] keySet()
	{
		Comparable[] tmp = new Comparable[arrSize];
		for(int i=0; i<arrSize; i++)
		{
			tmp[i]= arr[i][0];
		}
		mergeSort(tmp);
		return tmp;
	}
	public V put(K key, V value)
	{
		Comparable[] tmp = new Comparable[2];
		tmp[0]=key;
		tmp[1]= (Comparable)value;
		V val = get(key);
		arr[arrSize]= tmp;
		arrSize++;
		return val;
		
	}
	public V remove(K key)
	{
		if(get(key)!=null)
		{
			V tmp = get(key);
		int i=0;
		while(i<arrSize)// 2 3 4 5
		{
			if(arr[i][0].equals(key))
			{
				break;
			}
			i++;
		}
		
		for(int j=i; j<arrSize-1;j++)
		{
			arr[j]=arr[j+1];
		}
		arrSize--;
		return tmp;
		}
		return null;
	}
	public int size(){return arrSize;}
	public Object[] values()
	{
		Object[] tmp = new Object[arrSize];
		for(int i=0; i<arrSize; i++)
		{
			tmp[i]= arr[i][1];
		}
		
		return tmp;
	}
	private void mergeSort(Object[] a)
	{
		if(a.length<2)
		{
			return;
		}
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
		while(ib<b.length && ic<c.length)
		{
			if(((Comparable)b[ic]).compareTo(c[ic])<0)
			{
				a[ia++]=b[ib++];
			}
			else{a[ia++]=c[ic++];}
		}
		while(ib<b.length){a[ia++]=b[ib++];}
		while(ic<c.length){a[ia++]=c[ic++];}
	}
}