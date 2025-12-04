import java.util.Scanner;
/**
 * Test class of the TextBox class
 *
 * @see TextBox
 * @author Adriano Luchetta
 * @version 18-Nov-2016
 */
public class TextBoxTester
{
   public static void main(String[] args)
   {
      // constant for indentation
      final String INDENT = ">>> ";
      final String DELIMITERS = "[\t\n\r,.;:?!\\-()]+"; // regular expression

      // creating a text box
      TextBox text = new TextBox();
      
      // read tokens from standard input and append them to the text box
      Scanner in = new Scanner(System.in);
      in.useDelimiter(DELIMITERS);
      while (in.hasNext())
      {
         text.append(in.next());   
      }   
      in.close();

      // sorting in lexicographic order
      TextBox inverseText = new TextBox();
      TextBox sortedText = new TextBox();
      while (!text.isEmpty())
      {
         String token = text.removeLast();
         inverseText.append(token);
         sortedText.append(token);
      }
      sortedText.sort();

      // removing the repeated tokens
      TextBox inverseNoRepetitionText = new TextBox();
      TextBox inverseSortedText = new TextBox();

      String current = "";
      while (!sortedText.isEmpty())
      {
         String next = sortedText.removeLast();
         inverseSortedText.append(next);
         if (next.compareTo(current) != 0)
         {
            inverseNoRepetitionText.append(next);
            current = next;
         }
      }

      // printing on standard output
      System.out.println("\n*** PRINTOUT OF TOKENS AS READ ***");
      System.out.println("Number of tokens in the original box: " + inverseText.size());
      while (!inverseText.isEmpty())
         System.out.println(INDENT + inverseText.removeLast());

      System.out.println("\n*** PRINTOUT OF TOKENS IN LEXICOGRAPHIC ORDER ***");
      System.out.println("Number of tokens in the sorted box: " + inverseSortedText.size());
      while (!inverseSortedText.isEmpty())
         System.out.println(INDENT + inverseSortedText.removeLast());

      System.out.println("\n*** PRINTOUT OF TOKENS IN LEXICOGRAPHIC ORDER WITHOUT REPETITIONS ***");
      System.out.println("Number of non-repeated tokens: " + inverseNoRepetitionText.size());
      while (!inverseNoRepetitionText.isEmpty())
         System.out.println(INDENT + inverseNoRepetitionText.removeLast());
   }
}

