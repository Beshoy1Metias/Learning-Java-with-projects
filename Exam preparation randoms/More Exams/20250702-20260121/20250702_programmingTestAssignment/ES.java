// FOUNDATIONS OF COMPUTER SCIENCE
// Exam dated 2 July 2025

/**
   Defines an extended stack.
   
   @author A.Luchetta
   @version 26 June 2025
*/
public class ES extends S
{
   /**
      Initializes an empty extended stack 
   */
   public ES()
   {
      super();
   }
   
   /**
      Initializes a new extended stack which contains the same items as the
      specified extended stack in the same LIFO sequence.
      @param s the stack containing the items to initialize the extended stack
   */
   public ES(ES s)
   {
      this();
      // copy items of specified extended stack into array
      Object[] items = s.toArray();
      
      // push items into this extended stack in LIFO sequence
      for (int i = items.length - 1; i >= 0; i--)
      {
         push(items[i]);
      }
   }
   
   /**
      Checks if this stack contains the specified item.
      @param item the specified item to be checked
      @return true if this stack contains the specified item      
   */ // RECURSIVE IMPLEMENTATION
   public boolean contains(Object item)
   {      
      // base case - stack is empty
      if (isEmpty()) return false;
      
      // base case - specified item is stack top item
      Object top = top();
      if (top.equals(item)) return true;
      
      // remove top element - simplify problem
      pop();
      
      // do recursive call
      boolean ret = contains(item);
      
      // re-insert extracted top
      push(top);
      
      return ret;
   }

   /**
      Returns an array that contains the items of this extended stack in LIFO
      sequence where the stack top item is at index 0. The execution of this
      method does not change this extended stack.
      @return an array containing the items of this stack
   */
   public Object[] toArray()
   {
      int len = size();
	  Object[] arr = new Object[len];
	  int count=0;
	  while(!isEmpty())
	  {
		  arr[count++]=pop();
	  }
	  for(int i=0; i<len; i++)
	  {
		  push(arr[i]);
	  }
	  return arr;
	  
   }

}
