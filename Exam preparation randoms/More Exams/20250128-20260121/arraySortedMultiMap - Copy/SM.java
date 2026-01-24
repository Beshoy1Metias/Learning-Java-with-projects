public class SM<K extends Comparable<K>,V> implements SortedMultimap<K,V>
{
	private Entry[] v;
	private final static int INITIAL_CAPACITY=1;
	private int vSize;
	public SM()
	{
		v = new Entry[INITIAL_CAPACITY];
		vSize=0;
	}
   /**
      Returns a value to which the specified key is mapped, or null if this sorted multimap
      contains no mappings for the key.
      @param key the key whose associated value is to be returned.
      @return a value to which the specified key is mapped, or null if this sorted multimap
              contains no mapping for the key.
   */
   public V find(K key)
   {
	   /*
	   for(int i=0; i<vSize; i++)
	   {
		   if(v[i].getKey().equals(key)){return (V)v[i].getValue();}
	   }
	   return null;
	   */
	   
	   //int pos = recBinSearch(v, 0, vSize-1, key);
	   int pos = iterativeBinSearch(v, key);
	   if(pos<0 || (V)v[pos].getValue()==null){return null;}
	   return (V)v[pos].getValue();
	   
   }
   
   private int iterativeBinSearch(Entry[] a, K key)
   {
	   int from =0;
	   int to=vSize-1;
	   int mid = (from+to)/2;
	   while(from<=to)
	   {
		   if(a[mid].getKey().equals(key)){return mid;}
		   else if(((K)a[mid].getKey()).compareTo(key)<0){from = mid+1;}
		   else{to = mid-1;}
		   mid=(from+to)/2;
	   }
	   return -1;
	   
   }

   private int recBinSearch(Entry[] a, int from, int to, K key)
   {
	   if(from>to){return -1;}
	   int mid = (to+from)/2;
	   K middle = (K)a[mid].getKey();
	   if(middle.equals(key)){return mid;}
	   else if(middle.compareTo(key)<0){return recBinSearch(a, mid+1, to, key);}
	   else{return recBinSearch(a, from, mid-1, key);}
   }

	
	   
   /**
      Returns true if this sorted multimap contains no key-value mappings.
      @return true if this sorted multimap contains no key-value mappings.
   */
   public boolean isEmpty()
   {
	   return vSize<=0;
   }
     
   /**
      Associates the specified value with the specified key in this sorted multimap.
      @param key the key with which the specified value is to be associated.
      @param value the value to be associated with the specified key.    
      @throw java.lang.IllegalArgumentException if the specified key or value is null.
   */
   public void insert(K key, V value)
   {
	  if(key==null || value==null){throw new IllegalArgumentException();}
	  if(vSize>=v.length)
	  {
		  Entry[] tmp = new Entry[v.length*2];
		  System.arraycopy(v, 0, tmp, 0, vSize);
		  v = tmp;
	  }
	  int j=vSize-1;
	  while(j>=0 && ((Comparable)v[j].getKey()).compareTo(key)>0)
	  {
		  v[j+1]=v[j];
		  j--;
	  }
	  v[j+1]=new Entry(key, value);
	  
	  vSize++;
	  
   }  
   
   /**
      Removes a mapping for a key from this sorted multimap if it is present.
      @param key the key whose mapping is to be removed from this sorted multimap.
      @return the previous value associated with key, or null if there was no mapping for
              key. 
   */
   public V remove(K key)
   {
	   if(find(key)==null){return null;}
	   int pos=0;
	   V val = null;
	   for(int i=0;i<vSize;i++)
	   {
		   
		   if(v[i].getKey().equals(key))
		   {
			   val = (V)v[i].getValue();
			   break;
			   }
		   pos++;
	   }
	   for(int i=pos;i<vSize-1;i++)
	   {
		   v[i]=v[i+1];
	   }
	   
	   vSize--;
	   return val;
   }
   
   /**
      Returns the number of key-value mappings in this sorted multimap.
      @return the number of key-value mappings in this sorted multimap.
   */
   public int size()
   {
	   return vSize;
   }
   
   /**
      Returns an array view of the keys contained in this sorted multimap. Keys in the
      array are sorted in ascending order according to their natural order.
      @return an array view of the sorted keys contained in this sorted multimap where
              keys are sorted in ascending order according to their natural order.
   */
   public Object[] sortedKeys()
   {
	   Object[] keys = new Object[vSize];
	   for(int i=0; i<vSize;i++)
	   {
		   keys[i]=v[i].getKey();
	   }
	   return keys;
   }  
}