public class SortedContainer implements Container
{
	final static int INITIAL_CAPACITY=1;
	private Object[] v;
	private int vSize;
	public SortedContainer()
	{
		makeEmpty();
	}
	
	public void add(Comparable obj)
	{
		if(v.length<=vSize)
		{
			resize(v);
		}
		v[vSize++]=obj;
		sort(v);
	}
	private void resize(Object[] a)
	{
		Object[] k = new Object[v.length*2];
		System.arraycopy(a, 0, k, 0, a.length);
	}
	private void sort(Object[] a)
	{
		if (a.length<2)
		{
			return;
		}
		int mid = a.length/2;
		Object[] left = new Object[mid];
		Object[] right = new Object[a.length-mid];
		System.arraycopy(a, 0, left, 0, left.length);
		System.arraycopy(a, mid, right, 0, right.length);
		sort(left);
		sort(right);
		merge(a, left, right);
	}
	private void merge(Object[] a, Object[] b, Object[] c)
	{
		int ia, ib, ic=0;
		while(ib<b.length && ic<c.length)
		{
			if(b[ib].compareTo(c[ic]))
			{
				a[ia++]=b[ib++];
			}
			else{a[ia++]=c[ic++]}
		}
		while(b.length>ib){
			a[ia++]=b[ib++];
		}
		while(c.length>ic){
			a[ia++]=c[ic++];
		}
	}
	
	public boolean isEmpty()
	{return vSize<=0;}
	
	public void makeEmpty()
	{
		v = new Object[INITIAL_CAPACITY];
		vSize=0;
	}
	public Object removeMax()
	{
		Object tmp = v[vSize];
		v[vSize]=null;
		vSize--;
		return tmp;
	}
	
	public int size()
	{
		return vSize;
	}
}