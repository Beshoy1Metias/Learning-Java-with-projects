 /**
  * Implements an array list
  * The class uses a partially filled array that is dinamically resized when
  * needed
  *
  * @version 11-Dec-2021
  * @author Adriano Luchetta
  *
  */
  
 public class MyArrayList implements Container
{
   // class constants
   private static final int INITIAL_CAPACITY = 1; // any positive integer

   // instance variables
   private Object[] v;  // Object -> can allocate any type of Java objects
   private int vSize;
   
   /**
      constructs an empty array list with a predefined initial capacity
   */
   public MyArrayList()
   {
      makeEmpty();
   }
   
   /**
      Checks if this array list is empty
      @return true if this array list is empty
   */
   public boolean isEmpty()
   {
      return vSize <= 0;
   }
   
   /**
      Makes this array list empty
   */
   public void makeEmpty()
   {
      v = new Object[INITIAL_CAPACITY];
      vSize = 0;
   }
   
   /**
      Returns the number of elements in this array list
      @return number of elements in this array list
   */
   public int size()
   {
      return vSize;
   }   
   
   /**
       Adds the specified element to this array list as last element, if not
       null, otherwise simply returns 
       @param e the specified element
   */
   public void add(Object e)
   {
      add(vSize, e); // example of code reuse
   }
   
   /**
      Inserts the specified element into the position specified in this array
      list, if the specified index is in the range [0, size]<br>
      Moves the item currently in that position to the right (if any) and each
      subsequent element (adds one to their index)<br>
      If the specified index is outside the range [0, size] or the specified
      element is null, the method simply returns
      @param index position to which the specified element is to be inserted
      @param e the specified element to add to this array list    
   */
   public void add(int index, Object e)
   {
      // check preconditions
      if (index < 0 || index > vSize || e == null) return;

      // dynamically resize when needed
      if (vSize >= v.length)
      {
         Object[] tmp = new Object[2 * v.length]; // doubles the length
         for (int i = 0; i < v.length; i++)
         {
            tmp[i] = v[i];
         }
         
         v = tmp;
      }
         
      // shift elements before inserting new element into the array
      for (int i = vSize; i > index; i--)
      {
         v[i] = v[i - 1];
      }
         
      // insert new element at the specified position
      v[index] = e;
      
      // update the element counter      
      vSize++;
   }
   
   /**
      Returns the capacity of this array list, that is the length of the inner
      array
      @return capacity of this array list
   */
   public int capacity()
   {
      return v.length;  // length of the inner array
   }

   /**
      Checks if the specified element is contained in this array list
      @param e the specified element
      @return true if the specified element is contained in this array list
   */
   public boolean contains(Object e)
   {
      // perform linear search in a partially filled array
      for (int i = 0; i < vSize; i++)  // use vSize e NOT v.length!
      {
         if (v[i].equals(e))           // use equals method and NOT == operator
         {
            return true;               // element is found
         }
      }
            
      return false;  // element is not found
   }
   
   /**
      Returns the element at the specified index, if it is in the range
      [0, size -1], otherwise returns null
      @param index the specified index
      @return the element at the specified index
   */
   public Object elementAt(int index)
   {
      // check preconditions
      if (index < 0 || index >=vSize) return null;

      return v[index];
   }
   
   /**
      Returns the index of the first occurrence in this array list of the
      specified element, or -1 if this array list  does not contain it 
      @param e the specified element
      @return index of the first occurrence in this array list of the
      specified element, or -1 if this array list  does not contain it
   */
   public int indexOf(Object e)
   {
      for (int i = 0; i < vSize; i++)  // use vSize and NOT v.length!
      {
         if (v[i].equals(e))           // use equals e NOT == operator 
         {         
            return i;
         }
      }

      return -1;
   }
   
   /**
      Removes from this array list the element at the specified index, if it is
      in the range [0, size - 1], otherwise returns null
      @param index the specified index
      @return the element removed
   */
   public Object remove(int index)
   {
      // check preconditions
      if (index < 0 || index >= vSize) return null;
         
      // temporarily store element to be removed
      Object tmp = v[index];
      
      // shift elements
      for (int i = index; i < vSize - 1; i++)
      {
         v[i] = v[i + 1];
      }
         
      // update element counter
      vSize--;
         
      return tmp;
   }

   /**
      Replaces the element at the specified position in this array list with the
      specified element, if the specified index is in the range [0, size - 1]
      @param index the specified index of the element to be replaced
      @param e the specified element
      @return element previously placed at the specified position or null if the
              specified position is not in the range [0, size] or the specified
              element is null
   */
   public Object set(int index, Object e)
   {
      // check preconditions
      if (index < 0 || index >= vSize || e == null) return null;
         
      // temporarily store the element to be replaced
      Object tmp = v[index];
        
      // replace old with new element
      v[index] = e;

      return tmp;
   }
  
   /**
      Returns  a full array containing the elements of this array list in the
      same sequence as in the array list
      @return full array containing the elements of this array list
   */
   public Object[] toArray()
   {
      // create return array
      Object[] tmp = new Object[vSize]; // Note: the array length is vSize

     // copy from array list to return array
     for (int i = 0; i < tmp.length; i++)
      {
         tmp[i] = v[i];
      }
         
      return tmp;
   }
   
   /**
      Returns the textual description consisting of a string containing the
      elements of this array list in the same sequence as in the array list, one
      element per line 
      @return textual description
   */
   public String toString()
   {
      String tmp = "";
      for (int i = 0; i < vSize; i++)
      {
         tmp = tmp +  v[i] + "\n";
      }
        
      return tmp;
   }
}
