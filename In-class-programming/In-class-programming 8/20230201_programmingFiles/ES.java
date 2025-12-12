/*
   Foundations of Computer Science
   Programming Test - 1 February 2023
*/
/**  
   Implements an extended stack data structure 
   
   @param T the parametric type of the stack items
   @see S
*/
public class ES<T extends Comparable> extends S<T>
{  
   /**
      constructs a new extended stack containing the elements of the specified
      array a, in which the element are in LIFO sequence with the top of the
      extended stack at index length - 1. If the specified array is null, this
      constructor constructs an empty extended stack.
      @param a the specified array containing the elements to be inserted into
             this extended stack

   */
   private Comparable[] arr;
   public ES(T[] a)
   {
      for(int i=0; i<a.length; i++)
	  {
		  if(a[i]==null){continue;}
		  push(a[i]);
	  }
   }
   @Override
   /**
      Overrides the superclass method of the same name.
      It behaves in the same way as the method in the superclass, but it is
      implemented through a recursive approach.
   */
   public int search(T x)
   {
	   int count =0;
	   int out=-1;
	   int stackSize = size();
	   S<T> why = new S();
	   for(int i=stackSize-1; i>=0; i--)
	   {
		   T s = top();
		   if(s.equals(x)){out = count;}
		   
		   why.push(s);
		   pop();
		   count++;
	   }
	   while(!why.isEmpty())
	   {
		   push(why.pop());
	   }
	   return out;
   }
   

   /**
      Returns an array containing all the elements in this stack in the LIFO
      sequence, where the topmost item is at index 0
      @return array of stack items in LIFO sequence or an empty array if this
              stack is empty
   */
   public Comparable[] toArray()
   {
		int Size = size();
		arr = new Comparable[Size];
		S<T> temp = new S();
		int i=0;
		while(!isEmpty())
		{
			arr[i]=top();
			temp.push(pop());
			i++;
		}
		while(!temp.isEmpty())
		{
			push(temp.pop());
		}
		return arr;
   } 
   
   /**
      Returns an array containing all the elements in this stack sorted in
      ascending order according to their natural ordering
      @return array sorted in ascending order according to their natural
              ordering or an empty array if this stack is empty
   */
   public Comparable[] toSortedArray()
   {
	   Comparable[] tmp = arr;
	   if(isEmpty()){throw new EmptyStackException();}
	   sort(tmp);
	   return tmp;
   }     
   	public void sort(Comparable[] a)
	{
		if(a.length<2){return;}
		int mid = a.length/2;
		Comparable[] left = new Comparable[mid];
		Comparable[] right = new Comparable[a.length-mid];
		System.arraycopy(a, 0, left, 0, left.length);
		System.arraycopy(a, mid, right, 0, right.length);
		sort(left);
		sort(right);
		merge(a, left, right);
	}
	public void merge(Comparable[] a, Comparable[] b, Comparable[] c)
	{
		int ia=0, ib=0, ic = 0;
		while(ib<b.length && ic<c.length)
		{
			if(b[ib].compareTo(c[ic])<0){a[ia++]=b[ib++];}
			else{a[ia++]=c[ic++];}
		}
		while(ib<b.length){a[ia++]=b[ib++];}
		while(ic<c.length){a[ia++]=c[ic++];}
	}
}
