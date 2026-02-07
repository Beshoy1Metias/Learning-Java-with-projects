public class D<K extends Comparable,V> implements SortedMultimap<K,V>
{
	private Object[] v;
	private int vSize;
	private class Entry
	{
		K key;
		V value;
		public Entry(K k, V v)
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
		private V getValue(){return value;}
		private K getKey(){return key;}
	}
	public D()
	{
		makeEmpty();
	}
     /**
     * Returns an array containing all the values mapped to the specified key in
     * this multimap
     * @param key the specified key whose mapped values to return
     * @return an array containing all the values mapped to the specified key in
     *         this multimap if this multimap contains mappings for the key,
     *         otherwise an empty array
     */      
   public Object[] findAll(K key)
   {
	   Object[] values = new Object[vSize];
	   int count=0;
	   for(int i=0; i<vSize; i++)
	   {
		   if(((Entry)v[i]).getKey().equals(key)){values[count++]=((Entry)v[i]).getValue();}
	   }
	   Object[] output = new Object[count];
	   System.arraycopy(values, 0, output, 0, count);
	   return output;
   }
   
   /** 
     * Maps the specified value to the specified key in this multimap
     * @param key the specified key
     * @param value the specified value
     * @throws java.lang.IllegalArgumentException if the specified key or value
     *         is null
     */
   public void insert(K key, V value)
   {
	   if(key==null || value == null){throw new IllegalArgumentException();}
	   if(vSize>=v.length)
	   {
		   Object[] tmp = new Object[v.length*2];
		   System.arraycopy(v, 0, tmp, 0, vSize);
		   v = tmp;
	   }
	   int j=vSize-1;
	   while(j>=0 && ((Entry)v[j]).getKey().compareTo(key)>0)
	   {
		   v[j+1]=v[j];
		   j--;
	   }
	   v[j+1]= new Entry(key, value);
	   vSize++;
   }    
  
   /**
     * Returns the keys in this multimap
     * @return a sorted array containing the keys of this map if this multimap
     *         is not empty, otherwise an empty array
     */
   public Comparable[] keys()
   {
	   Comparable[] keys = new Comparable[size()];
	   for(int i=0;i<vSize;i++)
	   {
		   keys[i]= ((Entry)v[i]).getKey();
	   }
	   return keys;
   }   
        
   /**
     * Removes from this multimap all the mappings of the specified key and 
     * return the mapped values in an array
     * @param key the specified key
     * @return an array containing the values mapped to the specified key,
     *         if any, otherwise an empty array
     */   
   public Object[] removeAll(K key)
   {
	   Object[] values = findAll(key);
	   int pos = recBinSearch(v, 0, vSize-1, key);
	   while(pos>=0)
	   {
		   for(int i =pos; i<vSize-1; i++)
		   {
			   v[i]= v[i+1];
		   }
		   v[vSize-1]=null;
		   vSize--;
		   pos = recBinSearch(v, 0, vSize-1, key);
	   }
	   return values;
   }      
   private int recBinSearch(Object[] a, int from, int to, K target)
   {
	   if(from>to){return -1;}
	   int mid = (from + to) /2;
	   if(((Entry)a[mid]).getKey().compareTo(target)==0){return mid;}
	   else if(((Entry)a[mid]).getKey().compareTo(target)<0){return recBinSearch(a, mid+1, to, target);}
	   else{return recBinSearch(a, from, mid-1, target);}
   }
   
   /**
      checks if this container is empty
      @return true if this container is empty
  */
   public boolean isEmpty()
   {
	   return vSize<=0;
   }

   /**
      makes this container empty
   */
   public void makeEmpty()
   {
	   v = new Object[1];
	   vSize=0;
   }

   /**
      returns the number of data items in this container
      @return the number of data items in this container
   */
   public int size()
   {
	   return vSize;
   }
}