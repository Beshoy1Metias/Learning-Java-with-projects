import java.util.Scanner;

public class 
Try{



   public 
static 
void main(  String [
] 
args)
{
      
      final String
 END_OF_LINES = "";

Scanner in = 
new 
			Scanner(System
			.in);

			System.out.println("*** ENTER TEXT LINES ***");

boolean done = false; 
while (!done)         
{
 System.out.print("input:  ");

        
         String line = 

in.nextLine();

			 if (
line.equals(END_OF_LINES))
	done =
 true
;
			 else

			 {
		String reverseLine =
 "";

for (int i = 0; i <
 line.length(); i++
)  
reverseLine = line.charAt(i)

+reverseLine;

System.out
.println

("output: " + reverseLine);
					}}System.out.println("***END***");
					   in.close();
					   }
}
