/**
  * Implements an Extended Stack.
  *
  * @param <E> the parametric type of the extended stack elements.
  * @see S
  *
  * @author A. Luchetta
  * @version 07-Jan-2026
  */
// implementation by partially filled array
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
	   if(isEmpty()){throw new EmptyStackException();}
	   return null;
   }/**
      Compares the specified object with this extended stack for equality.
      @param o the specified object to be compared with this extended stack.
   */
   @Override
   public boolean equals(Object o)
   {
      // check preconditions - null is not a stack
      if (o == null)
      {
         return false;
      }
      
      // check preconditions - specified element shall be an extended stack.
      if (!(o instanceof ES))
      {
         return false;
      }
      
      // check extended stack sizes
      ES s = (ES) o;      // type cast is needed
      if (size() != s.size())
      {
         return false;
      }
      
      // get stack items in arrays
      Object[] v1 = toArray();
      Object[] v2 = s.toArray();
      
      // compare items for equality in pairs
      for (int i = size() - 1; i >= 0; i--)
      {
         if (!v1[i].equals(v2[i]))
         {
            return false;
         }
      }
      
      return true;
   }
   
   // toArray method
   private Comparable[] toArray()
   {
      // define return array
      Comparable[] items = new Comparable[size()];
      int itemsSize = 0;
      
      // define support stack
      ES<E> tmp = new ES();
      
      // copy elements - operation makes this extended stack empty
      while (!isEmpty())
      {
         items[itemsSize++] = top();
         tmp.push(pop());
      }
      
      // re-insert items into this extended stack
      while (!tmp.isEmpty())
      {
         push(tmp.pop());
      }
      
      return items;
   }
      
   /**
      Returns an extended stack containing the elements of both this stack and
      the specified one. In the returned stack, elements are sorted in ascending
      order with the maximum element at the top of the extended stack.
      @param s the specified extended stack.
      @return a sorted extended stack containing elements from both this
              extended stack and the specified one, if the specified stack is
              not null, otherwise a sorted stack containing only the elements of
              this stack,
   */
   public ES<E> mergeSorted(ES<E> s)
   {
      // define return extended stack
      ES<E> result = new ES();
      
      // get element arrays
      Comparable[] v1 = toArray();
      Comparable[] v2;
      if (s != null)
      {
         v2 = s.toArray();         
      }
      else
      {
         v2 = new Comparable[0];  // sets to empty array
      }
      
      // sort arrays
      sort(v1);
      sort(v2);
      
      // insert sorted elements into return array
      mergeArrays(result, v1, v2); 
      
      return result;
   }
   
   // sorts arrays
   private static void sort(Object[] a)
   {
      // base case
      if (a.length < 2)
      {
         return;
      }         
      
      // create and copy
      int mid = a.length / 2;
      Object[] left = new Object[mid];
      Object[] right = new Object[a.length - mid];
      System.arraycopy(a, 0, left, 0, left.length);
      System.arraycopy(a, mid, right, 0, right.length);
      
      // recursive stepd
      sort(left);
      sort(right);
      
      // merge
      merge(a, left, right);
   }
   
   private static void merge(Object[] a, Object[] b, Object[] c)
   {
      int ia = 0, ib = 0, ic = 0;

      while (ib < b.length && ic < c.length)
      {
         // select current b element
         Comparable bItem = (Comparable)b[ib];    
         if (bItem.compareTo(c[ic]) <= 0)
         {
            a[ia++] = b[ib++];
         }
         else
         {
            a[ia++] = c[ic++];
         }
      } 

      while (ib <b.length)
      {
         a[ia++] = b[ib++];
      } 

      while (ic <c.length)
      {
         a[ia++] = c[ic++];
      }           
   }
   
   
   // merges the sorted arrays
   private void mergeArrays(ES a, Comparable[] b, Comparable[] c)
   {
      int ib = 0, ic = 0;

      while (ib < b.length && ic < c.length)
      {
         // select current b element
         E bItem = (E)b[ib];   
         E cItem = (E)c[ic];   
         if (bItem.compareTo(cItem) <= 0)
         {
            a.push(bItem);
            ib++;
         }
         else
         {
            a.push(cItem);
            ic++;
         }
      } 

      while (ib <b.length)
      {
         E bItem = (E)b[ib++];
         a.push(bItem);
      } 

      while (ic <c.length)
      {
         E cItem = (E)c[ic++];
         a.push(cItem);
      }        
   }
}
