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
      Construct an empty extended stack
   */
   public ES()
   {
      super();
   }

   /**
      constructs a new extended stack containing the elements of the specified
      array a, in which the element are in LIFO sequence with the top of the
      extended stack at index length - 1. If the specified array is null, this
      constructor constructs an empty extended stack.
      @param a the specified array containing the elements to be inserted into
             this extended stack

   */
   public ES(T[] a)
   {
      // call superclas constructor
      super();
      
      // check precondition
      if (a == null)
      {
         return;
      }
      
      // insert elements from specified array
      for (T element : a)
      {
         // insert elements from array without throwing IllegalArgumentException
         if (element != null)
         {   
            push(element);
         }
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
      return search(x, 0);
   }
   
   private int search(T x, int depth)
   {
      // base case
      if (isEmpty())
      {
         return -1;
      } 

      if (top().equals(x))
      {
         return depth;         
      } 

      // simplyfy problem
      T removed = pop();  

      // recursive call
      int n = search(x, depth + 1);
      
      // insert removed item
      push(removed);
      
      return n;     
   }
   

   /**
      Returns an array containing all the elements in this stack in the LIFO
      sequence, where the topmost item is at index 0
      @return array of stack items in LIFO sequence or an empty array if this
              stack is empty
   */
   public Comparable[] toArray()
   {
      // define return array
      Comparable[] ret = new Comparable[size()];
      
      // define auxiliary stack
      Stack<T> temp = new S();
      
      // insert stack elements into array and empties original stack
      int i = 0; // index in return array
      while (!isEmpty())
      {
         ret[i++] = top();
         temp.push(pop());
      }
      
      // re-insert elements into original stack
      while(!temp.isEmpty())
      {
         push(temp.pop());
      }

      return ret;
   } 
   
   /**
      Returns an array containing all the elements in this stack sorted in
      ascending order according to their natural ordering
      @return array sorted in ascending order according to their natural
              ordering or an empty array if this stack is empty
   */
   public Comparable[] toSortedArray()
   {
      Comparable[] v = toArray();
      
      sort(v);
      
      return v;
   } 
   
   private static void sort(Comparable[] a)
   {
      // base case
      if (a.length < 2) return;

      // create left and right arrays
      int mid = a.length / 2;  
      Comparable[] left  = new Comparable[mid];   
      Comparable[] right = new Comparable[a.length - mid];
      System.arraycopy(a, 0, left, 0, left.length); 
      System.arraycopy(a, mid, right, 0, right.length); 

      // recursive steps
      sort(left);
      sort(right);

      // merge sorted sub-arrays 
      merge(a, left, right);      
   }

   // Sorts using the mergesort algorithm
   private static void merge(Comparable[] a, Comparable[] b, Comparable[] c) 
   {
      int ia = 0, ib = 0, ic = 0;
      
      while (ib < b.length && ic < c.length)
      {
         if (b[ib].compareTo(c[ic]) <= 0)
         {
            a[ia++] = b[ib++];
         }
         else
         {
            a[ia++] = c[ic++];
         }
      }
      
      while (ib < b.length)
      {
         a[ia++] = b[ib++];
      }
      
      while (ic < c.length)
      {
         a[ia++] = c[ic++];
      }
   }   
}