public class M <K extends Comparable, V> implements Map <K, V>
{
	private Object[] v;
	private int vSize;
	private final int INITIAL_CAPACITY=100;
	private class Entry
	{
		K key;
		V value;
		Entry(K k, V v)
		{
			setKey(k);
			setValue(v);
		}
		private void setKey(K k){key=k;}
		private void setValue(V e){value=e;}
		private K getKey(){return key;}
		private V getValue(){return value;}
	}
	public M()
	{
		v = new Object[INITIAL_CAPACITY];
		vSize=0;
	}
	/**
      Returns the value to which the specified key is mapped 
      @param key the specified key
      @return the value to which the specified key is mapped, or null if this
              map contains no mapping for the key
   */ 
   public V get(K key)
   {
	   int n = linearsearch(key);
	   return ((Entry)v[n]).getValue();
	   
   }
   
   /**
      Returns true if this map contains no key-value mappings
      @return true if this map is empty
   */
   public boolean isEmpty()
   {
	   return vSize<=0;
   }
   
   /**
      Returns an array containing the keys of the key/value mappings of this map
      The array is sorted in ascending order according to the natural order of
      the keys
      @return a sorted array containing the keys of the key/value mappings of
              this map, otherwise an empty array if this map is empty
   */
   public Comparable[] keySet()
   {
	   Comparable[] tmp = new Comparable[vSize];
	   int count=0;
	   tmp[0]=((Entry)v[0]).getKey();
	   for(int i=1;i<vSize;i++)
	   {
		   if(((Entry)v[i]).getKey().equals(tmp[count])){continue;}
		   tmp[count]=((Entry)v[i]).getKey();
		   count++;
	   }
	   if(count<vSize)
	   {
		   Comparable[] temp = new Comparable[count];
		   System.arraycopy(tmp, 0, temp, 0, temp.length);
		   tmp=temp;
	   }
	   return tmp;
   }
   /**
      Maps the specified value to the specified key in this map. If this
      map previously contained a mapping for the key, the old value is replaced
      by the specified value
      @param key with which the specified value is to be associated
      @param value value to be associated with the specified key
      @return the previous value associated with key, or null if there was no
              mapping for key.
      @throws IllegalArgumentException if the specified key or value is null
   */
   public V put(K key, V value) throws IllegalArgumentException
   {
	   V val = null;
	   if(key==null || value==null){throw new IllegalArgumentException();}
	   int n = linearsearch(key);
	   if(n>0)
	   {
		   val = ((Entry)v[n]).getValue();
		   ((Entry) v[n]).setValue(value);
		}
	   else
	    {
			Entry e = new Entry(key, value);
			v[vSize++]=e;
		}
	   return val;
	   
   }
   private int search(K key, int from, int to)
   {
	   if(from>to){return -1;}
	   int mid = (from+to)/2;
	   if(((Entry)v[mid]).getKey().compareTo(key)==0){return mid;}
	   else if(((Entry)v[mid]).getKey().compareTo(key)<0){return search(key, mid, to);}
	   else{return search(key, from, mid);}
   }
   private int search(K key)
   {
	   return search(key, 0, vSize);
   }
   private int linearsearch(K key)
   {
	   for(int i=0;i<vSize;i++)
	   {
		   if(((Entry)v[i]).getKey().compareTo(key)==0){return i;}
	   }
	   return -1;
   }
   
   /**
      Removes the mapping for the specified key from this map
      @param key the specified key of the mapping to be removed
      @return the previous value associated with key, or null if there was no
              mapping for key.
   */
   public V remove(K key)
   {
	   int n = linearsearch(key);
	   if(n<0){return null;}
	   Entry e = (Entry) v[n];
	   V oldValue = e.getValue();
	   for(int i=n; i<vSize-1; i++)
	   {
		   v[i]=v[i+1];
	   }
	   vSize--;
	   return oldValue;
   }
   
   /**
      Returns the number of key-value mappings in this map
      @return the number of key-value mappings in this map
   */
   public int size(){return vSize;}
   
   /**
      Returns an array view of the values contained in this map
      @return an array containing the values of this map or an empty array if
              this map is empty
   */ 
   public Object[] values()
   {
	   Object[] tmp= new Object[vSize];
	   for(int i=0; i<vSize;i++)
	   {
		   tmp[i]=((Entry)v[i]).getValue();
	   }
	   return tmp;
   } 
}