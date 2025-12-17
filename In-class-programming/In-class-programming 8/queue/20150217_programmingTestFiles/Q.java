public class Q<T> implements Queue<T>
{
	private static final int INITIAL_CAPACITY=1;
	private Object[] v;
	private int vSize;
	public Q()
	{
		makeEmpty();
	}
	private void makeEmpty()
	{
		v = new Object[INITIAL_CAPACITY];
		vSize=0;
	}
	public T dequeue() throws EmptyQueueException
	{
		if(isEmpty()){throw new EmptyQueueException();}
		T temp = front();
		for(int i=1; i<vSize;i++)
		{
			v[i-1]=v[i];
		}
		vSize--;
		return temp;
	}
	public void enqueue(T x) throws IllegalArgumentException
	{
		if(x==null){throw new IllegalArgumentException();}
		if(vSize>=v.length)
		{
			Object[] temp = new Object[v.length*2];
			System.arraycopy(v, 0, temp, 0, vSize);
			v=temp;
		}
		v[vSize]=x;
		vSize++;
	}

	public T front() throws EmptyQueueException
	{
		if(isEmpty()){throw new EmptyQueueException();}
		return (T)v[0];
	}
	public boolean isEmpty()
	{
		return vSize<=0;
	}
	public int size()
	{
		return vSize;
	}
	public Object[] toArray()
	{
		Object[] output = new Object[vSize];
		for(int i=0; i<vSize; i++)
		{
			output[i]=v[i];
		}
		return output;
	}
}