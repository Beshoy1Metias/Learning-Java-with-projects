public class SortedContainer implements Container
{
	Comparable[] objects;
	int len = 0;
	public SortedContainer()
	{
		objects = new Comparable[10];
	}
	
	public void add(Comparable obj){}
	
	@Override
	public boolean isEmpty(){}
	
	@Override
	public void makeEmpty(){}
	
	public Object removeMax(){}
	
	@Override
	public int size(){}
}