// Mock Exam dated January 14, 2026

/**
  * Implements an Extended Stack.
  *
  * @param <E> the parametric type of the elements of the extended stack.
  * @see S
  *
  * @author A. Luchetta
  * @version 07-Jan-2026
  */
public class ES<E extends Comparable> extends S<E>
{   
   /**
      Constructs an empty extended stack.
   */
   public ES()
   {
      super();
   }
   
   @Override
   /**
      Overrides the superclass method with the same name by using a recursive
      implementation.
      @return the minimum element in this stack.
      @throw emptyStackException if this stack is empty.
   */
   public E getMin()
   {
		if(size()<2){return top();}								//base case
										
		E item = pop();								//simplification
										
		E min = getMin();								//recursive step
										
		push(item);								//reinsertion
										
		if(min.compareTo(item)>0){min = item;}								//computation
										
		return min;								//return
	  
   }
   
   @Override
   /**
      Compares the specified object with this extended stack for equality.
      @param o the specified object to be compared with this extended stack.
   */
   public boolean equals(Object o)
   {
      ES<E> s = (ES) o;
	  ES<E> f = new ES();
	  ES<E> l = new ES();
	  if(size() != s.size()){return false;}
	  while(!isEmpty())
	  {
		  if(!top().equals(s.top())){return false;}
		  f.push(pop());
		  l.push(s.pop());
	  }
	  while(!f.isEmpty()){push(f.pop());}
	  while(!l.isEmpty()){s.push(l.pop());}
	  return true;
   }
      
   /**
      Returns an extended stack containing the elements of both this stack and
      the specified one. In the returned stack, elements are sorted in ascending
      order with the maximum element at the top of the extended stack.
      @param s the specified extended stack.
      @return a sorted extended stack containing elements from both this
              extended stack and the specified one, if the specified stack is
              not null, otherwise a sorted stack containing only the elements of
              this stack sorted in ascending order.
   */
   public ES<E> mergeSorted(ES<E> s)
   {
      Object[] first = new Object[size()];
	  Object[] second = new Object[s.size()];
	  int j=0;
	  while(!isEmpty()){first[j++]=pop();}
	  j=0;
	  while(!s.isEmpty()){second[j++]=s.pop();}
	  for(int i =0; i<first.length;i++){push((E)first[i]);}
	  for(int i =0; i<second.length;i++){s.push((E)second[i]);}
      mergeSort(first);
	  mergeSort(second);
	  Object[] a = new Object[(first.length+second.length)];
	  merge(a, first, second);

		
		
		
	  ES<E> out = new ES();
	  for(int i=0;i<a.length;i++){out.push((E)a[i]);}
      return out;
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
		   if(((Comparable)b[ib]).compareTo(c[ic])<0){a[ia++]=b[ib++];}
		   else{a[ia++]=c[ic++];}
	   }
	   while(ib<b.length){a[ia++]=b[ib++];}
	   while(ic<c.length){a[ia++]=c[ic++];}
   }

}
