import java.util.NoSuchElementException;
/**
 * Container of comparable objects
 *
 * @author Adriano Luchetta
 * @version 18-Nov-2016
 */

public class RawComparableContainer implements Container
{
   // class constants
   static final int INITIAL_SIZE = 1;

   // instance variables
   private Comparable[] c;
   private int cSize;

   /**
      initializes an empty container
   */
   public RawComparableContainer()
   {
      makeEmpty();;
   }

   /**
      checks if this container is empty
      @return true if this container is empty otherwise false
   */
   public boolean isEmpty()
   {
      return cSize <= 0;
   }
   
   /**
      makes this container empty
   */
   public void makeEmpty()
   {
      c = new Comparable[INITIAL_SIZE];
      cSize = 0;
   }

   /**
      provides the number of elements in this container
      @return number of elements in this container
   */
   public int size()
   {
      return cSize;
   }

   /**
      addes the specified data item as last element of the container
      @param obj the specified data item
      @throws IllegalArgumentException if the specified data item is null
   */
   public void add(Comparable obj)
   {
      // preconditions
      if (obj == null)
         throw new IllegalArgumentException();
         
      // resizing when needed   
      if (cSize == c.length)
        c = resize(c, 2 * c.length);

      // inserting the new data item
      c[cSize] = obj;

      // increasing the data item counter
      cSize++;
   }

   /**
      sorts this container by using the mergesort algorithm.
   */
   public void sort()
   {
      // risizing the array before sorting to get a full array
      // note: mergesort works with full arrays!
      c = resize(c, cSize);

      mergesort(c);
   }

   /**
      removes the last data item in this container
      @return the removed data item
      @throws NoSuchElementException if this container is empty
   */
   public Comparable removeLast() throws NoSuchElementException
   {
      // preconditions
      if (isEmpty())
         throw new NoSuchElementException();

      // saving temporarily the data item to remove
      Comparable value = c[cSize-1];

      // removing the data item
      c[cSize - 1] = null;          // garbage collector

      // decreasing the counter of data items
      cSize--;

      return value;
   }

   // mergesort
   private void mergesort(Comparable[] a)
   {
      // base case
      if (a.length < 2)
         return;

      // recursive steps ricorsivi
      int mid = a.length / 2;
      Comparable[] left = new Comparable[mid];
      for (int i = 0; i < left.length; i++)
         left[i] = a[i];

      Comparable[] right = new Comparable[a.length - mid];
      for (int i = 0; i < right.length; i++)
         right[i] = a[mid + i];

      mergesort(left);
      mergesort(right);

      // merging
      merge(a, left, right);
   }

   // merge
   private void merge(Comparable[] a, Comparable[] b, Comparable[] c)
   {
      // indexex in the arrays
      int ia = 0;
      int ib = 0;
      int ic = 0;

      // as long as arrays b and c have data items
      while (ib < b.length && ic < c.length)
         if (b[ib].compareTo(c[ic]) < 0)
            a[ia++] = b[ib++];
         else
            a[ia++] = c[ic++];

      // here one of the two arrays has no more elements
      while (ib < b.length)
         a[ia++] = b[ib++];
      while (ic < c.length)
         a[ia++] = c[ic++];
   }
   
   // resize
   private Comparable[] resize(Comparable[] a, int newLength)
   {
     // chosing the number of data items to copy in the new array
     int minLength;
     if (a.length < newLength)
        minLength = a.length;
     else
        minLength = newLength;

     // creating the new array with specified length 
     Comparable[] newAr = new Comparable[newLength];
     
     // coping the data items to the new array
     for (int i = 0; i < minLength; i++)
       newAr[i] = a[i];
       
     return newAr;
   }
}

