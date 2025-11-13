  import java.util.Scanner;
  /**
  * computes the average value of rolling the dice n times and prints it on
  * standard output
  * n is read from standard input
  * The program ends when the sentinel "Q" is entered from standard input
  *
  */
  public class AverageDice
  {
     public static void main(String[] args)
     {
        final String SENTINEL = "Q";
        
        Scanner in = new Scanner(System.in);
        Dice d = new Dice();

        System.out.println("*** rolls a dice n times                       ***");
        System.out.println("*** and compures the average value of rolls    ***");       
        System.out.println("*** n is read from standard input              ***");
        System.out.println("*** enter Q to end the program                 ***");                       

        while (true)
        {
           System.out.print("\nEnter n: ");
           String s = in.next();

           // handling of sentinel value
           if (s.equalsIgnoreCase(SENTINEL))
              break;

           // conversion to integer
           int n = Integer.parseInt(s);

           int sum = 0;
           if (n < 1)
              System.out.println("invalid value: " + n);
           else
           {
              for (int i = 0; i < n; i++)
              {
                 int l = d.roll();
                 System.out.print(l + " ");
                 sum += l;  
              }

              System.out.println("\naverage of " + n + " rolls = " + (double)sum / n );
           }   
        }

        System.out.println("\n***END***");
        in.close();
     }
  }
  
