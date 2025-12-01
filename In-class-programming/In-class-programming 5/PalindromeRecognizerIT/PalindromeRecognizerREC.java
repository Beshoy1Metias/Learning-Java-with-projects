import java.util.Scanner;
/**
 * Write a description of class PalindromeRecognizerREC here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PalindromeRecognizerREC
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = in.next();
        System.out.println(isPalindromeREC(input));
        
        
        in.close();
    }
    public static boolean isPalindromeREC(String s)
    {
        if(s.equals(null)){
            throw new IllegalArgumentException();
        }
        else if(s.length() <2)
        {
            return true;
        }
        else if(s.charAt(0)!=s.charAt(s.length()-1))
        {
            return false;
        }
        
        s = s.substring(1, s.length()-1);
        return isPalindromeREC(s);
        
        
    }
}