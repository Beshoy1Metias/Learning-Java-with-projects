import java.util.Scanner;
/**
 * Write a description of class FibBad here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FibBad
{
    public static void main(String[] args){
        
        int number = Integer.parseInt(args[0]);
        System.out.print(Fib(number));
        
    }
    public static long Fib(int n)
    {
        if(n<0)
        {
            throw new IllegalArgumentException();
        }
        else if(n<2)
        {
            return n;
        }
        else
        {
            return Fib(n-2) + Fib(n-1);
        }
    }
}