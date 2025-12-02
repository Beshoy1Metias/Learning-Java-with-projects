import java.util.Scanner;
/**
  * Executable class that implements a stopwatch to measure the execution time
  * of some sorting algorithms
  *
  * @author A. Luchetta
  * @version 11-Nov-2022
  */
public class SortChronometer
{
   public static void main(String[] args)
   {
      // generation of chronometer
      Chronometer chrono = new Chronometer();

      // prompt on standard output     
      System.out.println("\n***TIME MEASUREMENT OF THE SORTING ALGORITHMS***");
      System.out.println();
      System.out.println("n    selectionSort mergeSort insertionsort");
      System.out.println("                ms        ms            ms");
      System.out.println("------------------------------------------");

      // reading data from standard input
      Scanner in = new Scanner(System.in);
      String line = "";
      while (in.hasNextLine())
      {
         // read array size and repetition factor
         line = in.nextLine();
         Scanner tok = new Scanner(line); 
         int n = tok.nextInt();                 // get array size    
         int repetitionFactor = tok.nextInt();  // get repetition factor

         // generate random sequence with n size
         int[] a = SequencesGenerator.uniqueRandomIntegerArray(n);
         int[] b = new int[n];

         // time measurement to copy array a into array b a number of times
         // equal to the repetition factor
         chrono.start();
         for (int i = 0; i < repetitionFactor; i++)
         {
            System.arraycopy(a, 0, b, 0, a.length);
         }
         chrono.stop();
         double tArrayCopy = chrono.getElapsedTime();
         chrono.reset();

         // time measurement on selection sort
         chrono.start();
         for (int i = 0; i < repetitionFactor; i++)
         {
            System.arraycopy(a, 0, b, 0, a.length);
            ArrayAlgorithms1.selectionSort(b);
         }
         chrono.stop();
         double selectionSortTime = ((double)(chrono.getElapsedTime()
                                       - tArrayCopy)) / repetitionFactor;
         chrono.reset();

         // time measurement on merge sort
         chrono.start();
         for (int i = 0; i < repetitionFactor; i++)
         {
            System.arraycopy(a, 0, b, 0, a.length);
            ArrayAlgorithms1.mergeSort(b);
         }
         chrono.stop();
         double mergeSortTime = ((double)(chrono.getElapsedTime() - tArrayCopy)) / repetitionFactor;
         chrono.reset();

         // time meaurement on insertion sort
         chrono.start();
         for (int i = 0; i < repetitionFactor; i++)
         {
            System.arraycopy(a, 0, b, 0, a.length);
            ArrayAlgorithms1.insertionSort(b);
         }
         chrono.stop();
         double insertionSortTime = ((double)(chrono.getElapsedTime() - tArrayCopy)) / repetitionFactor;
         chrono.reset();
         
         // print on standard output by columns
         System.out.printf("%d          %.2f      %.2f          %.2f%n",
                        n, selectionSortTime, mergeSortTime, insertionSortTime);
      }
      
      in.close();
   }
}
