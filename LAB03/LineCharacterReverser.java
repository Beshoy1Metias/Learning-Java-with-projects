import java.util.Scanner;


public class LineCharacterReverser
{
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String output = "";
		for(int i = (input.length()-1); i>=0; i--){
			
			output += input.charAt(i);
			
		}
		System.out.print(output);
		
	}
	
}