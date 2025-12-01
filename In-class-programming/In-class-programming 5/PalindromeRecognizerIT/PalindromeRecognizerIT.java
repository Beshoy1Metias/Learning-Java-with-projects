import java.util.Scanner;
/**
 * Write a description of class PalindromeRecognizerIT here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PalindromeRecognizerIT
{
    public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    String input = in.next().toLowerCase();
    
    int l = 0;
    int r = input.length()-1;
    boolean isPalindrome = true;
    while(l <= r)
    {
        if(input.charAt(l) != input.charAt(r)){
            isPalindrome = false;
        };
        l++;
        r--;
        
    }
    System.out.println(isPalindrome);
}}