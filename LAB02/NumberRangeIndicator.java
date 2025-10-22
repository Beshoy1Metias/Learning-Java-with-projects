/*
	Ranges of number representations in Java	
	
Write a class that prints on standard output the maximum and minimum values of the number ranges for each numeric primitive data type of the Java language.

The printout should be as follows:

Representation ranges of Java numeric primitive data types:

byte range [-128, 127]

short range [-..., ...]

...
*/

public class NumberRangeIndicator
{
	
	public static void main(String[] args)
	{
		
		System.out.println("Representation ranges of Java numeric primitive data types: ");
		
		System.out.printf("byte range [%d, %d] %n", Byte.MIN_VALUE, Byte.MAX_VALUE);
		System.out.printf("char range [%c, %c] %n", Character.MIN_VALUE, Character.MAX_VALUE);
		
		System.out.printf("short range [%d, %d] %n", Short.MIN_VALUE, Short.MAX_VALUE);
		System.out.printf("integer range [%d, %d] %n", Integer.MIN_VALUE, Integer.MAX_VALUE);

		System.out.printf("long range [%d, %d] %n", Long.MIN_VALUE, Long.MAX_VALUE);
		System.out.printf("float range [%f, %f] %n", -Float.MAX_VALUE, Float.MAX_VALUE);
		System.out.printf("double range [%f, %f] %n", -Double.MAX_VALUE, Double.MAX_VALUE);
		System.out.printf("boolean range [false, true] %n");		
	}
	
	
}
