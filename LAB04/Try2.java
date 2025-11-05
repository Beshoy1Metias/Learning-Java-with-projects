import java.util.Scanner;	
public class Try2 {
	public static void main(String[] args)
	{
		final String END_OF_DATA =""; 
		System.out.println("CONVERTER");
		System.out.println("press enter to end\n");  
			      //Reading from standard input
		Scanner in = new 
		Scanner(System.in); 
		while(true){System.out.print("enter integer: ");	
		String line  = in.nextLine(); 
		if (line.equals(END_OF_DATA))  
			break;
		int n = Integer.parseInt(line);
		System.out.print("enter base: ");	 
		int base = Integer.parseInt(in.nextLine());
		System.out.println("enteger to be converted: "	+ n +", base: " + base);
		if (n< 0)System.out.println(n + " invalid\n");
		else if (base < 2 || base > 10)
			System.out.println("base " + base + " non ammessa\n");
		else{
		System.out.print("digits used in base " + base + ": ");  
		for (int i = 0; i < base; i++) 
			System.out.print(i);
		System.out.println("");
		String nStr= "";
		int p = n;    
		while (p > 0)
		{int q = p % base;	nStr = q + nStr;p = p / base;}
		System.out.println(n + " decimal = " + nStr + " in base " + base + "\n");
		}
		}
		System.out.println("\n***END***");
		in.close();
		
				   }
}
