import java.util.NoSuchElementException;
/**
  * implements a sorted container of comparable objects<br>
  * The natural order of the objects inserted defines the comparing criterium 
  *
  * @see Container
  *
  * @author Adriano Luchetta
  * @version 8-Nov-2021
  */
public class SortedContainer implements Container
{
   // class constants
   static final int INITIAL_SIZE = 1;

   // instance variables
   private Object[] v;
   private int vSize;

   /**
      initializes a sorted container
   */
   public SortedContainer()
   {
      makeEmpty();
   }
   
   /**
      checks if this container is empty
      @return true if this container is empty, otherwise false
   */
   public boolean isEmpty()
   {
      return vSize <= 0;
   }

   /**
      makes this container empty
   */
   public void makeEmpty()
   {
      v = new Object[INITIAL_SIZE];
      vSize = 0;
   }
   
   /**
      provides the size of this container
      @return il numero di elementi nel contenitore
   */
   public int size()
   {
      return vSize;
   }

   /**
      Adds the specified comparable object to this container<br>
      The container is maintained sorted in ascending order<br>
      Before object insertion, the container is sorted! <br>
      Asymptotic time complexity O(n)
      @param obj the specofied object
      @throws IllegalArgumentException if the specified object is null
   */
   public void add(Comparable obj)
   {
      // preconditions
      if (obj == null)
      {
         throw new IllegalArgumentException();
      }

      // resize when needed
      if (vSize >= v.length)
      {
         Object[] newV = new Object[2 * v.length];
         System.arraycopy(v, 0, newV, 0, v.length);
         
         v = newV;
      }

      // insert the new object keeping the container sorted
      // inner loop of the insertion sort algorithm!
      int j = vSize - 1;
      while (j >= 0 && obj.compareTo(v[j]) < 0)
      {
         v[j + 1] = v[j];
         j--;
      }
      v[j + 1] = obj;
      
      // update the element counter
      vSize++;
   }
   
   /**
      removes the maximum element of this container, maximum with reference to
      natural order of the objects contained<br>
      Asymptotic time complexity O(1).
      @return the removed element
      @throws NoSuchElementException if the container is empty
   */
   public Object removeMax()
   {
      // preconditions
      if (isEmpty())
      {
         throw new NoSuchElementException("contenitore vuoto");
      }

      // store temporarily the element to remove
      Object obj = v[vSize - 1];

      // remove the element
      v[vSize - 1] = null;          // garbage collector

      // update the counter of elements in the container
      vSize--;

      return obj;
   }
}
