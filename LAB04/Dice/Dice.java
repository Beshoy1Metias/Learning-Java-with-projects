/**Write the Dice.java class that implements a six-sided die with the following public interface Dice.html.

Each time we roll the die, it generates a random integer in the range [1 - 6].

Suggestions

Check the documentation for the java.util.Random class in the the Java Platform API. Analyze the methods

- int nextInt()

- int nextInt(int n)

Instance variable

reference to an object of class Random.

Constructor

creation and initialization of the Random class object.

Test class

Use the AverageDiceTester.java class to test your Dice.java class.

The class rolls the die a number of times n, where n is an integer read from standard input, and prints the result of the rolls on standard output.

The class also prints the average value of the rolls obtained on standard output.

Program execution ends when the sentinel string Q is entered from standard input.
@author Beshoy.M
@version 11/9/2025
*/
import java.util.Random;

public class Dice
{
	public int number=1;
	
	Random random = new Random(7);
	
	public int randomRoll=0;
	
	public Dice(int n){
		number = n;
		
	}
	public Dice(){
		
		
	}
	public int roll(){
		return randomRoll = random.nextInt(7);
	}
	
	
	
	
}