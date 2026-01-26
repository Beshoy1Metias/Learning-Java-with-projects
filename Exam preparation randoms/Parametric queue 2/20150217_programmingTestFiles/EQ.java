public class EQ<T extends Comparable> extends Q<T> // Extended queue
{ 

	 public EQ()
	 {
		 super();
	 }
	 public void enqueue(T x) // code provided by teacher
	 {
		 super.enqueue(x);
	 } 
	 public Object[] toSortedArray()
	 {
		 Object[] arr = toArray();
		 mergeSort(arr);
		 return arr;
	 }
	 public Object[] getOnlyUniqueItems() //  apple apple blackberry blackberry fig grape pear
	 {
		 Object[] arr = toSortedArray();
		 Object[] out = new Object[arr.length];
		 int count=0;
		 out[count++]=arr[0];
		 for(int i=1; i<arr.length; i++)
		 {
			 if(arr[i-1].equals(arr[i])){continue;}
			 out[count++]=arr[i];
		 }
		 Object[] tmp = new Object[count];
		 System.arraycopy(out, 0, tmp, 0, count);
		 return tmp;
	 }
	 
	 /*
		split divides this extended queue (called the source queue) into a specified
 number n of extended queues (called destination queues) according to the
 following rules:
 . each item of the source queue is assigned to one and only one of the
 destination queues
 . all destination queues have the same number of items, except for one unit
 . if item A precedes item B in the source queue and A and B are assigned
 to the same destination queue, then A precedes B in the destination queue
 . running the method does not change the source queue
 param n specified number of destination queues
 return array of extended queues of specified size n
 throws java.lang.IllegalArgumentException if n is less than 1
	 */
	 public EQ[] split(int n)
	 {
		 if(n<1){throw new IllegalArgumentException();}
		 EQ[] queues = new EQ[n];
		 for(int i=0; i<n;i++)
		 {
			 queues[i] = new EQ();
		 }
		 
		Object[] arr = toSortedArray();
		int j = 0;
		for(int i=0; i<arr.length;i++)
		{
			((EQ)queues[j]).enqueue(arr[i]);
			j = (j+1)%n;
		}
		 return queues;
	 }
	 private void mergeSort(Object[] a)
	 {
		 if(a.length<2)
		 {
			 return;
		 }
		 int mid = a.length/2;
		 Object[] left = new Object[mid];
		 Object[] right = new Object[a.length-mid];
		 System.arraycopy(a, 0, left, 0, left.length);
		 System.arraycopy(a, mid, right, 0, right.length);
		 mergeSort(left);
		 mergeSort(right);
		 merge(a, left, right);
	 }
	 private void merge(Object[] a, Object[] b, Object[] c)
	 {
		 int ia=0,ib=0,ic=0;
		 while(ib<b.length && ic<c.length)
		 {
			 if(((Comparable)b[ib]).compareTo(c[ic])<0){a[ia++]=b[ib++];}
			 else{a[ia++]=c[ic++];}
		 }
		 while(ib<b.length){a[ia++]=b[ib++];}
		 while(ic<c.length){a[ia++]=c[ic++];}
	 }
}