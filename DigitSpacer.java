public class DigitSpacer
{
	public static void main(String[] args)
	{
		int number =123;
		int firstNumber= number/100;
		number = number - firstNumber *100;
		int secondNumber = number/10;
		number = number - secondNumber *10;
		int thirdNumber = number;
		System.out.println(firstNumber+" "+secondNumber+" " + thirdNumber);
		
	}
	
}