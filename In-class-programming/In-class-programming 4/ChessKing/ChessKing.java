/**
	CODE FOR CHESSKING 
	@author B. Metias
	@version 11/05/2025
	
*/

public class ChessKing
{
	public char col;
	public char row;
	public ChessKing(String initialSquare)
	{
		col = initialSquare.charAt(0);
		row = initialSquare.charAt(1);
		
	}


	public boolean isChessValidSquare(String square){
		
		if(square.length()==2 &&square.charAt(0) >='a' && square.charAt(0)<='h'  && square.charAt(1)>='1' && square.charAt(1)<='8'){
			return true;
		}
		else{
			return false;
		}
		
	}
	public boolean isKingReachableSquare(String square){
		
		if(!isChessValidSquare(square)){
			return false;
		}
		else if(Math.abs(col-square.charAt(0))<=1 && Math.abs(row-square.charAt(1))<=1){
			return true;
		}
		return false;
	}
	public void moveToSquare(String toChessSquare){
		if(isChessValidSquare(toChessSquare) && isKingReachableSquare(toChessSquare)){
			col = toChessSquare.charAt(0);
			row = toChessSquare.charAt(1);
		}
	}
	public String toString(){
		return "ChessKing in square "+col+row;
	}
	
}