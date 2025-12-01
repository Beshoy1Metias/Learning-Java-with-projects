import java.util.Scanner;
/**
 * Computes if a string is a palindrome or not
 *
 * @Beshoy Metias
 * @11/13/2025
 */
public class PalindromeRecognizerIT1
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = in.next();
        boolean isPalindrome = true;
        while(s.length()>1){
            if(s.charAt(0)!= s.charAt(s.length()-1)){
                isPalindrome= false;
                break;
            }
            String n = s.substring(1, s.length()-1);
            s = n;
        }
        System.out.print(isPalindrome);
    }
}