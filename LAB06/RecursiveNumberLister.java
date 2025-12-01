public class RecursiveNumberLister
{
	public static String output= "";
	public static void main(String[] args)
	{
		int n = Integer.parseInt(args[0]);
		System.out.println(recursivelyListNumbers(n));
	}
	public static String recursivelyListNumbers(int n)
	{
		if(n<2)
		{
			return n+ " ";
		}
		
		return recursivelyListNumbers(n-1) + n + " ";
		
	}
	
}