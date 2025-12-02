import java.util.Scanner;
/**
  * Executable class that implements a stopwatch to measure the execution time
  * of searching algorithms
  *
  * @author A. Luchetta
  * @version 25-Nov-2022
  */
public class SearchChronometer
{
   public static void main(String[] args)
   {
      // constant for micro seconds
      final int MICROS_PER_MILLIS = 1000;    // 1000 micros in a millis 

      // generation of chronometer
      Chronometer chrono = new Chronometer();

      // prompt on standard output     
      System.out.println("\n***TIME MEASUREMENT OF THE SEARCHING ALGORITHMS***");
      System.out.println();
      System.out.println("n    linearSearch linGuardedSearch recBinarySearch itBinarySearch");
      System.out.println("           micros           micros          micros         micros");
      System.out.println("-----------------------------------------------------------------");

      // read data from standard input
      Scanner in = new Scanner(System.in);
      String line = "";
      while (in.hasNextLine())
      {
         // read array size and repetition factor
         line = in.nextLine();
         Scanner tok = new Scanner(line);
         int n = tok.nextInt();                // array size
         int repetitionFactor = tok.nextInt(); // repetition factor

         // generate the random sequence with n size
         int[] vr = SequencesGenerator.uniqueRandomIntegerArray(n);

         // generate the sorted sequence with n length
         int[] vs = SequencesGenerator.uniqueSortedIntegerArray(n);

         // time meaurement on linear search
         chrono.start();
         for (int i = 0; i < repetitionFactor; i++)
         {
            for (int j = 0; j < vr.length; j++)
            {
               ArrayAlgorithms1.linearSearch(vr, j);              
            }
         }
         chrono.stop();

         // computation of linear search average time
         long lsTime = chrono.getElapsedTime();  // in millis      
         double lsAvTime = MICROS_PER_MILLIS * lsTime / (double)repetitionFactor
                              / (double)vr.length;
                 
         chrono.reset();
         
         // time measurement on guarded linear search
         int[] gvr = new int[vr.length + 1]; // generation of array with additional location
         System.arraycopy(vr, 0, gvr, 0, vr.length);
         chrono.start();
         for (int i = 0; i < repetitionFactor; i++)
         {
            for (int j = 0; j < gvr.length - 1; j++)
            {
               ArrayAlgorithms1.guardedLinearSearch(gvr, gvr.length - 1, j);              
            }
         }
         chrono.stop();
         
         // computation of guarded linear search average time
         long glsTime = chrono.getElapsedTime();  // in millis       
         double glsAvTime = MICROS_PER_MILLIS * glsTime
                               / (double)repetitionFactor / (double)vr.length;         
         chrono.reset();
         
         // time measurement on recursive binary search
         chrono.start();
         for (int i = 0; i < repetitionFactor; i++)
         {
            for (int j = 0; j < vs.length; j++)
            {
               ArrayAlgorithms1.recursiveBinarySearch(vs, j);              
            }
         }
         chrono.stop();
         
         // computation of recursive binary search average time
         double rbsTime = chrono.getElapsedTime();  // in millis
         double rbsAvTime = MICROS_PER_MILLIS * rbsTime
                               / (double)repetitionFactor/ (double)vs.length;         
                 
         chrono.reset();
         
         // time measurement on iterative binary search
         chrono.start();
         for (int i = 0; i < repetitionFactor; i++)
         {
            for (int j = 0; j < vs.length; j++)
            {
               int k = ArrayAlgorithms1.iterativeBinarySearch(vs, j); 
               if (k < 0)      
                  throw new IllegalArgumentException();       
            }
         }
         chrono.stop();
         
         // computation of iterative binary search average time
         double ibsTime = chrono.getElapsedTime();  // in millis
         double ibsAvTime = MICROS_PER_MILLIS * ibsTime
                              / (double)repetitionFactor/ (double)vs.length;         
                 
         chrono.reset();
                 
         // printing on standard output by columns
         System.out.printf("%d     %.6f         %.6f        %.6f       %.6f%n",
            n, lsAvTime, glsAvTime, rbsAvTime, ibsAvTime);
      }
      
      in.close();
   }
}
