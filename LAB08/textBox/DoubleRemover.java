import java.util.Scanner;
/**
  * Container of integer numbers
  *
  * @author Adriano Luchetta
  * @version 14-Dic-2008
  */
public class DoubleRemover implements Container
{
   private static final int INITIAL_CAPACITY = 1;

   private int[] v;
   private int vSize;
   
   public DoubleRemover()
   {
      makeEmpty();
   }
   
   /**
      inserts the specified integer in this container
      @param n the specified integer
      asymptotic time complexity O(1) in the best and average cases
                           O(n) in the worst case

   */
   public void add(int n)
   {
     // possible dynamic resizing 
     if (vSize >= v.length)
     {
        v = resize(v, 2 * v.length);
     }
        
     // adding the number
     v[vSize] = n;

     // udating the counter of integers
     vSize++;
   }
   
   /**
      @return true if this container is empty, otherwise false
      asymptotic time complexity O(1)
   
   */
   public boolean isEmpty()
   {
      return vSize <= 0;
   }
   
   /**
      makes this container empty
      asymptotic time complexity O(1)
   */
   public void makeEmpty()
   {
      v = new int[INITIAL_CAPACITY];
      vSize = 0;
   }
   
   /**
      @return the number of integers in this container
      asymptotic time complexity O(1)
   */
   public int size()
   {
      return vSize;
   }
   
   /**
      removes non-unique integers from this container
      asymptotic time complexity O(nlogn)
   */
   public void linearRemoveDoubles()
   {
      // sorting
      v = resize(v, vSize);
      mergesort(v);
      
      // remove adjacent elements
      int from = 0;
      int to = 1;
      
      while (to < v.length)
      {
         if (v[from] == v[to])
         {
            to++;
         }
         else
         {
            v[++from] = v[to];
         }
      }

      vSize = from + 1;
   }

   /**
      removes non-unique integers from this container
      asymptotic time complexity O(n*n)
   */
   public void quadraticRemoveDoubles()
   {
      for (int i = 0; i < vSize - 1; i++)
      {
         for (int j = i + 1; j < vSize; j++)
         {
            if (v[i] == v[j])
            {
               int k = vSize - 1;
               while (k > j && v[j] == v[k])
                  k--;

               v[j] = v[k];
               vSize = k;
            }
         }
      }
   }
   
   /**
      provides the textual description
      asymptotic time complexity O(n)
   */
   public String toString()
   {
      String s = "";

      for (int i = 0; i < vSize; i++)
      {
         s = s + v[i] + "\n";
      }
         
      return s;
   }

   private void sort()
   {
      mergesort(v);
   }

   private static void mergesort(int[] a)
   {
      if (a.length < 2)
      {
         return;
      }

      int mid =  a.length / 2;
      int[] left = new int[mid]; 
      int[] right = new int[a.length - mid];
      System.arraycopy(a, 0, left, 0, mid);
      System.arraycopy(a, mid, right, 0, a.length - mid);

      mergesort(left);
      mergesort(right);
      
      merge(a, left, right);
   }

   private static void merge(int[] b, int[] l, int[] r)
   {
      int ib = 0, il = 0, ir = 0;
      
      while (il < l.length && ir < r.length)
      {
         if (l[il] <= r[ir])
         {
            b[ib++] = l[il++];
         }
         else
         {
            b[ib++] = r[ir++];
         }
      }
            
       while (il < l.length)
       {
          b[ib++] = l[il++];
       }
          
       while (ir < r.length)
       {
          b[ib++] = r[ir++];
       }
   }
   
   private int[] resize(int[]a, int size)
   {
      int length = a.length;
      if (size < length)
      {
         length = size;
      }

      int[] b = new int[size];
      System.arraycopy(a, 0, b, 0, length);
      
      return b;
   }
   
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      DoubleRemover d1 = new DoubleRemover();
      DoubleRemover d2 = new DoubleRemover();

      System.out.println("***INPUT INTEGERS WITH DUPLICATES");
      while (in.hasNext())
      {
         String s = in.next();
         int n = Integer.parseInt(s);
         d1.add(n);
         d2.add(n);
         System.out.println(n);
      }

      d1.linearRemoveDoubles();
      d2.quadraticRemoveDoubles();

      System.out.println("***LINEAR ELIMINATION OF DUPLCATES");
      System.out.println(d1.toString());
      
      System.out.println("***QUADRATIC ELIMINATION OF DUBLICATES");
      System.out.println(d2.toString());  
   }
}
