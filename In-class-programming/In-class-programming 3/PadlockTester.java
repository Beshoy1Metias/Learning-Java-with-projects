/**
   Test class of Padlock class
   
   @author A. Luchetta
   @version 20201027

*/
public class PadlockTester
{
   public static void main(String[] args)
   {
      final String INIT_KEY = "0000";
      final String PASSWD1 = "OpenSesame";
      final String PASSWD2 = "ReopenSesame";
      
      // creates padlock
      Padlock p = new Padlock();
      System.out.println(p);      // prints textual description
      
      // sets a new combination
      p.setCombination(INIT_KEY, PASSWD1);
      System.out.println(p);      // prints textual description     
            
      // closes the padlock
      p.close();
      System.out.println(p);      // prints textual description
      
      // opens the padlock - not successful as combination is wrong
      p.open(PASSWD2);
      System.out.println(p);      // prints textual description
      
      // opens the padlock - successfull as combination is correct
      p.open(PASSWD1);
      System.out.println(p);      // prints textual description
      
      // sets  new combination
      p.setCombination(PASSWD1, PASSWD2);
      System.out.println(p);      // prints textual description      
      
      // opens the padlock
      p.open(PASSWD2);
      System.out.println(p);      // prints textual description           
   }
}
