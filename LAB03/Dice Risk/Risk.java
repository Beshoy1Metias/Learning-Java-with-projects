
import java.util.Scanner;

public class Risk
{
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		System.out.print("Player 1? ");
		String player1 = in.next();
		System.out.print("Player 2? ");
		String player2 = in.next();		
		
		Dice dice = new Dice();
		String r1 = dice.roll() + " " + dice.roll() + " " + dice.roll();
		String r2 = dice.roll() + " " + dice.roll() + " " + dice.roll();
		System.out.print(dice.winner(player1, player2, r1, r2));
		in.close();
	}
	
	
	
}