public class MyArrayListGenerics<E> implements Container
{
	private final static int INITIAL_CAPACITY = 100;
	private Object[] v;
	private int vSize;
	
	
	public MyArrayListGenerics()
	{
		makeEmpty();
	}
	
	@Override
	public boolean isEmpty()
	{
		return vSize<=0;
	}
	@Override
	public void makeEmpty()
	{
		v = new Object[INITIAL_CAPACITY];
		vSize=0;
	}
	
	public void add(E e)
	{
		add(vSize, e);
	}
	
	public void add(int index, E e)
	{
		if(index>vSize){return;}
		if(index<vSize)
		{
			for(int i=vSize; i>index;i--)
			{
				v[i]=v[i-1];
			}
		}
		v[index]=e;
		vSize++;
	}
	public int capacity()
	{
		return v.length;
	}
	
	public boolean contains(E e)
	{
		for(int i=0; i<vSize; i++)
		{
			if(v[i].equals(e)){
				return true;
			}
		}
		return false;
	}
	public E elementAt(int index)
	{
		if(index>vSize || isEmpty()){
			return null;
		}
		return (E)v[index];
	}
	public int indexOf(E e)
	{
		for(int i=0; i<vSize; i++)
		{
			if(v[i].equals(e))
			{
				return i;
			}
		}
		return -1;
	}
	public E remove(int index)
	{
		if(index>vSize || isEmpty())
		{
			return null;
		}
		E tmp = (E)v[index];

		for(int i= index; i<vSize;i++)
		{
			v[i]=v[i+1];
		}
		vSize--;
		return tmp;
	} 
	public E set(int index, E e)
	{
		if(index>vSize || isEmpty())
		{
			return null;
		}
		E tmp = (E)v[index];
		v[index] = e;
		return tmp;
	}
	public Object[] toArray()
	{
		Object[] tmp = new Object[vSize];
		System.arraycopy(v, 0, tmp, 0, vSize);
		return tmp;
	}
	
	@Override
	public int size()
	{
		return vSize;
	}
	
	public String toString()
	{
		String output = "";
		for(int i=0; i<vSize; i++)
		{
			output = output + v[i] + "\n";
		}
		return output;
	}
}