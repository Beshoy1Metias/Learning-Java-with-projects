/*
   Foundations of Computer Science
   Programming Test - 1 February 2023
*/
/**  
   Implements the Stack data structure with Last In First Out (LIFO) data
   access mode. 
   
   @param T the parametric type of the stack items
   @see EmptyStackException
*/
public class S<T> implements Stack<T> // Generic stack data structure
{
   // constants
   private static int INITIAL_CAPACITY = 1;
   
   // instance variables
   private Object[] v;     // array of Objects
   private int vSize;      // item counter
   
   /**
      Constructs an empty stack
   */
   public S()
   {
      makeEmpty();
   }
   
   
   /**
      Checks if this container is empty
      @return true if this container is empty
   */
   public boolean isEmpty()
   {
      return vSize <= 0;
   }

   /**
     Makes this container empty
   */
   public void makeEmpty()
   {
      v = new Object[INITIAL_CAPACITY]; // array of Objects!
                                        // creation of arrays of parametric type
                                        // is not supported
      vSize = 0;      
   }
   
   /**
      Returns the size of this container
      @return  the number of items in this container
   */
   public int size()
   {
      return vSize;
   }   
   /**
      Removes the object at the top of this stack and returns it
      @return the object at the top of this stack
      @throws EmptyStackException if this stack is empty
   */
   public T pop()throws EmptyStackException
   {
      // temporarily store topmost item to be returned
      T returned = top();  // also handles EmptyStackException
      
      // remove topmost element
      v[vSize - 1] = null;
      
      // update item counter
      vSize--;
      
      return returned;
   }
   
   /**
      Pushes an item onto the top of this stack, if not null
      @param item the item to be pushed onto this stack
      @throws IllegalArgumentException if the item to be pushed is null
   */
   public void push(T item)
   {
      // check preconditions
      if (item == null)
      {
         throw new IllegalArgumentException();
      }
      
      // dynamically resize if needed
      if (vSize >= v.length)
      {
         // create new array twice the length of old array
         Object[] newV = new Object[2 * v.length];
         
         // copy elements from old to new array
         System.arraycopy(v, 0, newV, 0, v.length);
         
         // abandon old array
         v = newV;
      }
      
      // insert item into array
      v[vSize] = item;
      
      // update item counter
      vSize++;
   }
   
   /**
      Returns the position of an object in the stack. If the object x is present
      in the stack, the method returns the distance from the top of the stack to
      the nearest occurrence of x. The topmost item on the stack is considered
      to be at distance 0.
      @param x the desired object
      @return the position from the top of the stack where the object is
              located; -1 indicates that the object is not in this stack.    
   */
   public int search(T x)
   {
      // check preconditions
      if (isEmpty())
      {
         return -1;
      }
      
      // search
      int dist = 0;
      for (int i = vSize - 1; i >= 0; i--)
      {
         if (v[i].equals(x))  // not equivalent to x.equals(v[i])
         {
            return dist; // or vSize - 1 - i
         }  

         dist++;         
      }
      
      return -1;
   }
     
   /**
      Inspects the object at the top of this stack without removing it
      @return the object at the top of this stack
      @throws EmptyStackException if this stack is empty
   */
   public T top() throws EmptyStackException
   {
      // check preconditions
      if (isEmpty())
      {
         throw new EmptyStackException();
      }
      
      return (T)v[vSize - 1];  // type cast is needed
   }
}
