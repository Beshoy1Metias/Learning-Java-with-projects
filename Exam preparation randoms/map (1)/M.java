public class M <K extends Comparable, V> implements Map <K, V>
{
	private Object[] v;
	private int vSize;
	
	private class Entry
	{
		K key;
		V value;
		public Entry(K k , V v)
		{
			setKey(k);
			setValue(v);
		}
		public Entry()
		{
			this(null, null);
		}
		private void setKey(K k){key = k;}
		private void setValue(V v){value = v;}
		private K getKey(){return key;}
		private V getValue(){return value;}
	}
	
	public M()
	{
		v = new Object[1];
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
	   int pos = recBinSearch(v, 0, vSize-1, key);
	   if(pos<0){return null;}
	   return (V) ((Entry)v[pos]).getValue();
   }
   private int recBinSearch(Object[] a, int from, int to, K target)
   {
	   if(from>to){return -1;}
	   int mid = (from+to)/2;
	   if(((Entry)a[mid]).getKey().equals(target)){return mid;}
	   else if(((Entry)a[mid]).getKey().compareTo(target)<0){return recBinSearch(a, mid+1, to, target);}
	   else{return recBinSearch(a, from, mid-1, target);}
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
	   Comparable[] keys = new Comparable[vSize];
	   for(int i=0; i<vSize; i++)
	   {
		   keys[i]=((Entry)v[i]).getKey();
	   }
	   return keys;
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
   public V put(K key, V value)
   {
	   if(key == null || value == null){throw new IllegalArgumentException();}
	   int pos = recBinSearch(v, 0, vSize-1, key);
	   if(pos>=0)
	   {
		   V old = ((Entry)v[pos]).getValue();
		   ((Entry)v[pos]).setValue(value);
		   return old;
	   }
	   
	   if(vSize>=v.length)
	   {
		   Object[] tmp = new Object[v.length*2];
		   System.arraycopy(v, 0, tmp, 0, vSize);
		   v = tmp;
	   }
	   int j=vSize-1;
	   while(j>=0 && ((Entry)v[j]).getKey().compareTo(key)>0)
	   {
		   v[j+1] = v[j];
		   j--;
	   }
	   v[j+1]=new Entry(key, value);
	   vSize++;
	   return null;
   }
   
   /**
      Removes the mapping for the specified key from this map
      @param key the specified key of the mapping to be removed
      @return the previous value associated with key, or null if there was no
              mapping for key.
   */
   public V remove(K key)
   {
	   int pos = recBinSearch(v, 0, vSize-1, key);
	   if(pos<0){return null;}
	   V removed = ((Entry)v[pos]).getValue();
	   for(int i=pos; i<vSize; i++)
	   {
		   v[i]=v[i+1];
	   }
	   v[vSize-1]=null;
	   vSize--;
	   return removed;
   }
   
   /**
      Returns the number of key-value mappings in this map
      @return the number of key-value mappings in this map
   */
   public int size()
   {
	   return vSize;
   }
   
   /**
      Returns an array view of the values contained in this map
      @return an array containing the values of this map or an empty array if
              this map is empty
   */ 
   public Object[] values()
   {
	   Object[] values = new Object[vSize];
	   for(int i=0; i<vSize; i++)
	   {
		   values[i]=((Entry)v[i]).getValue();
	   }
	   return values;
   }    
}