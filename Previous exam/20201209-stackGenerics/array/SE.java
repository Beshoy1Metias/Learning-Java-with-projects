/**
  * Foundation of Computer Science - Group 2
  * Programming test - 16-07-2018
  *
  * Implements an extended stack
  *
  * @typeparam T the parametric type of the element of the stack
  *
  * @see EmptyStackException
  * @see S
*/
public class SE<T extends Comparable> extends S<T>
{
   
   /**
       generates a stack that contains the same items as this stack, in the
       same sequence 
       @return a stack that contains the same items as this stack, in the
       same sequence 
   */
   public Stack clone()
   {
      // generate new empty stack
      Stack s = new S();
      
      // retrieve elements from this stack      
      Object[] v = toArray();
      
      // insert stack items into new stack
      for (int i = v.length - 1; i >= 0; i--)// Note! from last to first
      {
         s.push(v[i]); 
      }      
         
      return s;            
    }
    
   /**
       generates a stack that contains the same items as this stack, but in the
       revese sequence 
       @return a stack that contains the same items as this stack, but in the
       reverse sequence 
   */
   public Stack reverse()
   {
      // generate new empty stack
      Stack s = new S();  
      
      // retrieve elements from this stack               
      Object[] v = toArray();
      
      // insert stack items into new stack
      for (int i = 0; i < v.length; i++) // Note! from first to last
      {
         s.push(v[i]); 
      }    
         
      return s;        
    }
    
    /**
       retrieve all elements from this stack
       @return array containing the items of this stack in LIFO sequence
    */
    public Object[] toArray()
    {
       // generate return array
       Object[] v = new Object[size()];
       
       // generate temporary stack
       Stack t = new S();
       
       // access and remove items from this stack
       int i = 0;
       while (!isEmpty())
       {
          t.push((T)top());
          v[i++] = pop();
       }
          
       // reinsert elements into this stack
       while (!t.isEmpty())
       {
          push((T)t.pop());
       }
          
       return v;   
    }
    
    /**
       returns a sorted array containing the elements of this stack
       @returna sorted array containing the elements of this stack
    */ 
    public Object[] toSortedArray()
    {
       // retrieve elements from this stack
       Object[] v = toArray();

       // sort array
       sort(v);
       
       return v;
    } 
    
   // sort by mergesort O(nlogn)
   private void sort(Object[] a)
   {
      if (a.length < 2)
         return;
      
      int mid = a.length / 2;
      Object[] left = new Object[mid];   
      Object[] right = new Object[a.length - mid];
      System.arraycopy(a, 0, left, 0, left.length);
      System.arraycopy(a, mid, right, 0, right.length);
      
      sort(left);
      sort(right);
      
      merge(a, left, right);                  
   }
   
   // merge
   private void merge(Object[] a, Object[] b, Object[] c)
   {
      int ia = 0, ib = 0, ic = 0;
      
      while (ib < b.length && ic < c.length)
         if (((Comparable)b[ib]).compareTo(c[ic]) < 0) // type cast is needed!
            a[ia++] = b[ib++];
         else
            a[ia++] = c[ic++];   
      
      while (ib < b.length)
         a[ia++] = b[ib++];      
      
      while (ic < c.length)
         a[ia++] = c[ic++];             
   }           
}
