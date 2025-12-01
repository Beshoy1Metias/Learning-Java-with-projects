import java.util.Random;
import javax.swing.JOptionPane;
public class RecursiveMinFinder
{
	public static void main(String[] args)
	{
		Random rand = new Random();
		
		int[] v = new int[100];
		int vSize = 19;
		System.out.print("Your random numbers are: ");
		for(int i=0; i< vSize; i++)
		{
			v[i]= rand.nextInt(999);
			System.out.print(v[i]+" ");
		}
		System.out.print("Minimum is: "+recursivelyFindMin(v, vSize));
		JOptionPane.showMessageDialog(null, "GFG " + recursivelyFindMin(v, vSize) + "!");
		
	}
	private static int recursivelyFindMin (int [] a, int aSize)
	{
		int minimum=0;
		if(aSize==0){
			return a[0];
		}
		else
		{
			int minOfRest = recursivelyFindMin(a, aSize-1);
			minimum=Math.min(a[aSize-1],minOfRest);
		}
		
		return minimum;
		
	}
}