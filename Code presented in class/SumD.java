import java.util.Scanner;
public class SumD
{
 public static void main(String[] args)
 { Scanner in = new Scanner(System.in);
 double sum = 0;
 while (in.hasNextDouble()) {
 sum = sum + in.nextDouble();
 }
 System.out.println("Sum: " + sum);
 in.close();
 }
}