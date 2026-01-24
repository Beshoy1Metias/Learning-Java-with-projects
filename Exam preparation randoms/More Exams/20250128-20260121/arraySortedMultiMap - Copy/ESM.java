public class ESM<K extends Comparable<K>,V extends Comparable<V>> extends SM<K,V>
{
	public ESM(){super();}
	public Object[] findAll(K key) // returns an array containing all values associated with the specified key
	{
		int len = size();
		Object[] values = new Object[len];
		int count=0;
		while(find(key)!=null)
		{
			values[count++]=remove(key);
		}
		if(count<len)
		{
			Object[] tmp = new Object[count];
			System.arraycopy(values, 0, tmp, 0, count);
			values=tmp;
		}
		return values;
	}
	public int size() //overrides the superclass method with a recursive implementation
	{
		if(isEmpty()){return 0;}
		Object[] keys = sortedKeys();
		V val = remove((K) keys[0]);
		int n = size();
		insert((K)keys[0], val);
		return n+1;
	}
	public Object[] sortedKeySet() //returns an array with the keys of this extended sorted multimap sorted in ascending order according to their natural order and without duplicates.
	{
		Object[] keys = sortedKeys();
		Object[] keyssss = new Object[keys.length];
		int count =0;
		keyssss[count++]=keys[0];
		for(int i=1; i<keys.length; i++)
		{
			if(keys[i-1].equals(keys[i])){continue;}
			keyssss[count++]=keys[i];
		}
		if(count<keys.length)
		{
			Object[] tmp = new Object[count];
			System.arraycopy(keyssss, 0, tmp, 0, count);
			keyssss=tmp;
		}
		return keyssss;
	}
}