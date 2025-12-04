public class TextBox implements Container
{
	int capacity =0;
	String[] a = new String[capacity];
	public TextBox()
	{
		
	}
	
	public void append(String s)
	{
		capacity++;
		String[] w = new String[capacity];
		System.arraycopy(a, 0, w, 0, a.length);
		a=w;
		a[a.length-1]=s;
	}
	
	
	@Override
	public boolean isEmpty()
	{
		return a==null || a.length==0;
	}
	
	@Override
	public void makeEmpty()
	{
		for(int i=0; i<a.length; i++)
		{
			a[i]=null;
		}
	}
	
	public String removeLast()
	{
		String tmp = a[a.length-1];
		capacity--;
		String[] w = new String[capacity];
		System.arraycopy(a, 0, w, 0, a.length-1);
		a=w;
		return tmp;
	}
	
	@Override
	public int size()
	{
		return a.length;
	}
	
	public void sort(){
		mergeSort(a);
	}
	
	private void mergeSort(String[] f)
	{
		if(f.length<2){
			return;
		}
		int mid = f.length/2;
		String[] left = new String[mid];
		String[] right = new String[f.length-mid];
		System.arraycopy(f, 0, left, 0, left.length);
		System.arraycopy(f, mid, right, 0, right.length);
		mergeSort(left);
		mergeSort(right);
		merge(f, left, right);
	}
	private void merge(String[] a, String[] b, String[] c)
	{
		int ia=0;
		int ib=0;
		int ic=0;
		while(ib < b.length && ic < c.length)
		{
			if(b[ib].compareTo(c[ic]) < 0){
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
}