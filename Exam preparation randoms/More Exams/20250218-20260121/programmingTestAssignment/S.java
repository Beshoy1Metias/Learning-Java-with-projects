 public class S<E> implements Set<E>
 {
	 private Object[] v;
	 private int vSize;
	 private final static int INITIAL_CAPACITY=1;
	 public S()
	 {
		 v = new Object[INITIAL_CAPACITY];
		 vSize=0;
	 }
   /**
      Inserts the specified data item into this set if it is not null and not
      already present.
      @param item element to be added to this set.
      @return true if this set did not already contain the specified element.
   */
   public boolean add(E item)
   {
	   if(item == null || contains(item)){return false;}
	   if(vSize>=v.length)
	   {
		   Object[] tmp = new Object[v.length*2];
		   System.arraycopy(v, 0, tmp, 0, vSize);
		   v=tmp;
	   }
	   v[vSize]=item;
	   vSize++;
	   return true;
   }
   
   /**
      Checks if this set contains the specified item.
      @param o the data item to be checked.
      @return true if this set contains the specified data item.      
   */
   public boolean contains(Object o)
   {
	   return linearSearch(o)>=0;
   }
   
   /**
      Returns true if this set is empty.
      @return true if this set is empty.
   */
   public boolean isEmpty()
   {
	   return vSize<=0;
   }
      
   /**
      Removes the specified data item from this set if it is contained.
      @param o the data item to be removed.
      @return true if this set contained the specified element.
   */
   public boolean remove(Object o)
   {
	   if(!contains(o)){return false;}
	   int pos = linearSearch(o);
	   for(int i=pos; i<vSize-1; i++)
	   {
		   v[i]=v[i+1];
	   }
	   
	   vSize--;
	   return true;
   }
   private int linearSearch(Object o)
   {
	   for(int i=0; i<vSize; i++)
	   {
		   if(v[i].equals(o)){return i;}
	   }
		return -1;
   }
   
   /**
      Returns the number of data item in this set.
      @return the number of data item in this set.
   */
   public int size()
   {
	   return vSize;
   }  
   
   /**
      Returns an array view of this set.
      @return an array containing the data items of this set.
   */
   public Object[] toArray()
   {
	   Object[] arr = new Object[vSize];
	   System.arraycopy(v, 0, arr, 0, vSize);
	   return arr;
   }  
	 
 }