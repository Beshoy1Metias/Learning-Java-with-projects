public class ChessKnight
{
	private char col;
	private char row;
	
	
	
	public ChessKnight(String initialSquare){
		if(isValidSquare(initialSquare)){
			col = initialSquare.charAt(0);
			row = initialSquare.charAt(1);
		}
	}
	
	
	public void moveToSquare(String square){
		if(isKnightReachable(square)){
			col = square.charAt(0);
			row = square.charAt(1);
		}
	}
	
	public boolean isKnightReachable(String square){
		
		if(isValidSquare(square)!= true){
			return false;
		}
		
		int deltacol = col - square.charAt(0);
		int deltarow = row - square.charAt(1);
		
		int pathLength = Math.abs(deltacol) + Math.abs(deltarow);
		return pathLength == 3 && col != square.charAt(0) && row != square.charAt(1);	
		
	}
	
	public boolean isValidSquare(String square){
		
		
		return square.length() == 2 && square.charAt(0) <= 'h' && square.charAt(1) <= '8' && square.charAt(0) >= 'a' && square.charAt(1)>= '1';
		

	}
	
	public String toString(){
		return "ChessKnight: Knight in " + col + row;
	}
	
}