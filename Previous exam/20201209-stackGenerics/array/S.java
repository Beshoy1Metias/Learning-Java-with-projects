/**
  * Foundation of Computer Science - Group 2
  * Programming test - 16-07-2018
  *
  * Implements a stack by using a partially filled array
  * 
  * @typeparam T the parametric data type of the stack data items
  * @see Stack
  * @see EmptyStackException
*/
public class S<T> implements Stack<T>
{

   // class constants
   private static final int INITIAL_CAPACITY = 1;
   
   // instance variables
   private Object[] v;           // attention: non parametric!
   private int vSize;
   
   /**
      constructs an empty stack
   */
   public S()
   {
      makeEmpty();
   }
   
   /**
      checks if this stack is empty
      @return true if this stack is empty, otherwise false
   */
   public boolean isEmpty()
   {
      return vSize <= 0;
   }

   /**
     makes this stack empty
   */
   public void makeEmpty()
   {
       v = new Object[INITIAL_CAPACITY]; // attention: array of objects!
       vSize = 0;     
   }
  
   /**
      returns the number of item in this stack
      @return  number of item in this stack
   */
   public int size()
   {
      return vSize;
   }
  
   /**
      inserts the specified item on top of this stack
      @param o the specified item
   */
   @Override
   public void push(T o) // O(n) in the worst case, O(1) in the average case
   {
         
      // dynamically resize if needed
      if (vSize >= v.length)
      {
         Object[] w = new Object[2 *v.length];
         System.arraycopy(v, 0, w, 0, v.length); //  O(n)
         v = w;
      }
      
      // insert item into array and update stack item counter
      v[vSize++] = o;     
   }
   
   /**
      inspect the item at the top of this stack
      @return the item at the top of this stack
      @throws EmptyStackException if this stack is empty
   */
   @Override
   public T top() throws EmptyStackException //O(1)
   {
      // preconditions
      if (isEmpty())
      {
         throw new EmptyStackException();
      }
         
      return (T)v[vSize - 1];  // note: type cast is required
   }

   /**
      removes the item at the top of this stack
      @return the item removed
      @throws EmptyStackException if the stack is empty
   */
   @Override
   public T pop() throws EmptyStackException // O(1)
   {
      // temporarily store item to remove
      T x = top();          // top can throw EmptyStackException

      // remove item on the top of the stack
      v[vSize - 1] = null;
      
      // update stack item counter
      vSize--;
      
      return x;
   }
    
   /**
      textual description consists of a string where the stack items are in LIFO
      sequence and divided by a space
      @return textual description
   */
   @Override   
   public String toString() //O(n)
   {
      String s = "";
       
      for (int i = vSize - 1; i >= 0; i--)
      {
         s = s + " " + v[i];
      }
          
      return s;   
   } 
}
