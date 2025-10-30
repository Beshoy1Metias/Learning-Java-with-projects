import java.util.Scanner;
public class WordCounter
{
 public static void main(String[] args)
 {
 Scanner c = new Scanner(System.in);
 int count = 0;
 while (c.hasNext())
 {
 c.next(); // extracts the token!
 count++;
 }
System.out.println(count + " words");
 c.close();
 }
}