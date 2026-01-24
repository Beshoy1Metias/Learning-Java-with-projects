public class M <K extends Comparable, V> implements Map <K, V>
{
	private Object[] v;
	private int vSize;
	public M()
	{
		v = new Object[1];
		vSize=0;
		
	}
	
	private class Entry <K extends Comparable, V>
	{
		private K key;
		private V value;
		public Entry(K k, V v)
		{
			key = k;
			value = v;
		}
		public Entry()
		{
			this(null, null);
		}
		private void setValue(V v){value = v;}
		private void setKey(K k){key = k;}
		private K getKey(){return key;}
		private V getValue(){return value;}
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
	   return (V)((Entry)v[pos]).getValue();
   } 
   
   private int recBinSearch(Object[] a, int from, int to, K key)
   {
	   if(from>to){return -1;}
	   int mid = (from +to)/2;
	   if(((Entry)a[mid]).getKey().compareTo(key)==0){return mid;}
	   else if(key.compareTo(((Entry)a[mid]).getKey())<0){return recBinSearch(a, from, mid-1, key);}
	   else{return recBinSearch(a, mid+1, to, key);}
   
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
	   Comparable[] keys = new Comparable[size()];
	   for(int i=0; i<vSize;i++)
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
	   if(vSize>=v.length)
	   {
		   Object[] tmp = new Object[v.length*2];
		   System.arraycopy(v, 0, tmp, 0, vSize);
		   v = tmp;
	   }
	   if(get(key)!=null)
	   {
		   V val = get(key);
		   int pos = recBinSearch(v, 0, vSize, key);
		   ((Entry)v[pos]).setValue(value);
		   return val;
	   }
	   int j = vSize-1;
	   while(j>=0 && ((Entry)v[j]).getKey().compareTo(key)>0)
	   {
		   v[j+1] = v[j];
		   j--;
	   }
	   v[j+1] = new Entry(key, value);
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
	   V val = get(key);
	   if(val==null){return null;}
	   
	   int pos = recBinSearch(v, 0, vSize-1, key);
	   for(int i=pos; i<vSize-1; i++)
	   {
		   v[i]=v[i+1];
	   }
	   vSize--;
	   return val;
	   
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
	   Object[] values = new Comparable[size()];
	   for(int i=0; i<vSize;i++)
	   {
		   values[i]=((Entry)v[i]).getValue();
	   }
	   return values;
   }        
}