import java.util.Scanner;
/**
  * didactic class
  *
  * reads from standard input a sequence of integers
  * removes the repeated integers after sorting the sequence
  *
  * asymptotic time complexity O(n logn) due to sorting
  *
  * @author A. Luchetta
  * @version 14-Genn-2019
*/

public class UniqueNumbers1
{
   public static void main(String[] args)
   {
      // create a partially filled array
      int[] v = new int[1]; 
      int vSize = 0;        
      
      // read data from standard input
      Scanner in = new Scanner(System.in);
      while (in.hasNextInt())
      {
         // dinamically resize if needed
         if (vSize >= v.length) 
         {
            int[] vNew = new int[2 * v.length];
            for (int i = 0; i < v.length; i++)
            {
               vNew[i] = v[i];
            }
            v = vNew;   
         }
         
         // insert the new integer into the array
         v[vSize] = in.nextInt(); 
         
         // update the element counter
         vSize++;                 
      }
      
      // Create a full array
      int[] vNew = new int[vSize];
      for (int i = 0; i < vSize; i++)
      {
         vNew[i] = v[i];    
      }     
      v = vNew;
      
      // print the sequence of integers on standard output
      System.out.println("***integers read***");
      for (int k = 0; k < v.length; k++)
      {
         System.out.print(v[k] + " "); 
      }
      System.out.println();
                     
      // create a full array of unique elements
      int[] u = getUniqueValues(v);
      
      // printing the sequence of unique integers on standard output
      System.out.println("***unique integers***");
      for (int k = 0; k < u.length; k++) 
      {
         System.out.print(u[k] + " "); 
      }
      System.out.println();  
   }
    
   // returns an array without repeated values
   private static int[] getUniqueValues(int[] a)      
   {
      // copy input array not to change it in this method
      int[] b = new int[a.length];
      System.arraycopy(a, 0, b, 0, a.length);
      mergeSort(b);
	  b = removeDup(b);
      return b;
   }
   private static void mergeSort(int[] a)
   {
	   if(a.length<2)
	   {
		   return;
	   }
	   int mid = a.length/2;
	   int[] left = new int[mid];
	   int[] right = new int[a.length-mid];
	   System.arraycopy(a, 0, left, 0, left.length);
	   System.arraycopy(a, mid, right, 0, right.length);
	   mergeSort(left);
	   mergeSort(right);
	   merge(a, left, right);
   }
   private static void merge(int[] a, int[] b, int[] c)
   {
	   int ia=0, ib=0, ic=0;
	   while(ib<b.length && ic<c.length)
	   {
		   if(b[ib]<c[ic]){a[ia++]=b[ib++];}
		   else{a[ia++]=c[ic++];}
	   }
	   while(ib<b.length){a[ia++]=b[ib++];}
	   while(ic<c.length){a[ia++]=c[ic++];}
   }
   private static int[] removeDup(int[] a) //223355557
   {
	   int[] t = new int[a.length];
	   int tSize=0;
	   
	   for(int i=1; i<a.length ;i++)
	   {
		   
		   if(a[i-1]==a[i])
		   {
			   
			   continue;
		   }
		   
		   t[tSize++]=a[i-1];
	   }
	   int[] tmp = new int[tSize];
	   System.arraycopy(t, 0, tmp, 0, tSize);
	   return tmp;
   }
}
