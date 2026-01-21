public class D<K extends Comparable,V> implements SortedMultimap<K,V>
{
	private final static int INITIAL_CAPACITY=1;
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
		private void setKey(K k){key=k;}
		private void setValue(V v){value=v;}
		private K getKey(){return key;}
		private V getValue(){return value;}
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
	   Object[] tmp = new Object[vSize];
	   int count=0;
	   for(int i=0; i<vSize; i++)
	   {
		   if(((Entry)v[i]).getKey().equals(key))
		   {
			   tmp[count++]=((Entry)v[i]).getValue();
			}
	   }
	   
	   if(count<vSize)
	   {
		   Object[] a = new Object[count];
		   System.arraycopy(tmp, 0, a, 0, a.length);
		   tmp=a;
	   }
	   return tmp;
	   
   }
   
   /** 
     * Maps the specified value to the specified key in this multimap
     * @param key the specified key
     * @param value the specified value
     * @throws java.lang.IllegalArgumentException if the specified key or value
     *         is null
     */
   public void insert(K key, V value) throws IllegalArgumentException // 2
   {
	   if(key==null || value==null){throw new IllegalArgumentException();}
	   Entry e = new Entry(key, value);
	   if(vSize>=v.length)
	   {
		   Object[] tmp = new Object[v.length*2];
		   System.arraycopy(v, 0, tmp, 0, vSize);
		   v = tmp;
	   }
	   v[vSize++]=e;
	   int j=vSize-1;
	   while(j>0 && key.compareTo(((Entry)v[j-1]).getKey())<0)
	   {
		   v[j]=v[j-1];
		   j--;
	   }
	   v[j] = e;
   }    
  
   /**
     * Returns the keys in this multimap
     * @return a sorted array containing the keys of this map if this multimap
     *         is not empty, otherwise an empty array
     */
   public Comparable[] keys()
   {
	   Comparable[] tmp = new Comparable[vSize];
	   
	   for(int i=0; i<vSize; i++)
	   {
		   tmp[i]= ((Entry)v[i]).getKey();
	   }
	   return tmp;
   }   
        
   /**
     * Removes from this multimap all the mappings of the specified key and 
     * return the mapped values in an array
     * @param key the specified key
     * @return an array containing the values mapped to the specified key,
     *         if any, otherwise an empty array
     */   
   public Object[] removeAll(K key)// 2334
   {
	   Object[] values = new Object[vSize];
	   Object[] newV = new Object[vSize];
	   int countNewv=0;
	   int count =0;
	   
	   for(int i=0; i<vSize;i++)
	   {
		   if(((Entry)v[i]).getKey().equals(key))
		   {
			   values[count++]=((Entry)v[i]).getValue();
			   
			   continue;
			   
			}
			newV[countNewv++]=v[i];
	   }
	   
	   if(countNewv<vSize)
	   {
		   Object[] tmp = new Object[countNewv];
		   System.arraycopy(newV, 0, tmp, 0, tmp.length);
		   newV = tmp;
	   }
	   v = newV;
	   vSize= v.length;
	   
	   Object[] tmpval = new Object[count];
	   System.arraycopy(values, 0, tmpval, 0, tmpval.length);
	   values=tmpval;
	   mergeSort(values);
	   return values;
   }
      private void mergeSort(Object[] a)
   {
	   if(a.length<2){return;}
	   int mid = a.length/2;
	   Object[] left = new Object[mid];
	   Object[] right = new Object[a.length-mid];
	   System.arraycopy(a, 0, left, 0, left.length);
	   System.arraycopy(a, mid, right, 0, right.length);
	   mergeSort(left);
	   mergeSort(right);
	   merge(a, left, right);
   }
   private void merge(Object[] a, Object[] b, Object[] c)
   {
	   int ia=0, ib=0, ic=0;
	   while(ib<b.length && ic<c.length)
	   {
		   if(((Comparable)b[ib]).compareTo((Comparable)c[ic])<0){a[ia++]=b[ib++];}
		   else{a[ia++]=c[ic++];}
	   }
	   while(ic<c.length){a[ia++]=c[ic++];}
	   while(ib<b.length){a[ia++]=b[ib++];}
   }
   public D(){makeEmpty();}
   
	   /**
      checks if this container is empty
      @return true if this container is empty
  */
   public boolean isEmpty(){return vSize<=0;}

   /**
      makes this container empty
   */
   public void makeEmpty()
   {
	   v = new Object[INITIAL_CAPACITY];
	   vSize=0;
   }

   /**
      returns the number of data items in this container
      @return the number of data items in this container
   */
   public int size(){return vSize;}
}