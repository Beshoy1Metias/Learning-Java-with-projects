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
   public ES(T[] a)
   {
      // TODO
   }

   @Override
   /**
      Overrides the superclass method of the same name.
      It behaves in the same way as the method in the superclass, but it is
      implemented through a recursive approach.
   */
   public int search(T x)
   {    
      // TODO  
      
      return 0;
   }
   

   /**
      Returns an array containing all the elements in this stack in the LIFO
      sequence, where the topmost item is at index 0
      @return array of stack items in LIFO sequence or an empty array if this
              stack is empty
   */
   public Comparable[] toArray()
   {
      // TODO

      return null;
   } 
   
   /**
      Returns an array containing all the elements in this stack sorted in
      ascending order according to their natural ordering
      @return array sorted in ascending order according to their natural
              ordering or an empty array if this stack is empty
   */
   public Comparable[] toSortedArray()
   {
      // TODO
      
      return null;
   }     
}
