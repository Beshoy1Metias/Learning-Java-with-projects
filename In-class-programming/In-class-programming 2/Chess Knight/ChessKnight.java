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
		else{
			System.out.println("Moving to the square "+ square + " is not possible");
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
/* AI Written

public class ChessKnight {

    private String currentSquare;

    public ChessKnight(String initialSquare) {
        if (!isChessValidSquare(initialSquare)) {
            throw new IllegalArgumentException("Invalid initial square: " + initialSquare);
        }
        this.currentSquare = normalize(initialSquare);
    }

    public boolean isChessValidSquare(String chessSquare) {
        if (chessSquare == null) return false;
        String s = normalize(chessSquare);
        if (s.length() != 2) return false;
        char file = s.charAt(0);
        char rank = s.charAt(1);
        return file >= 'a' && file <= 'h' && rank >= '1' && rank <= '8';
    }

    public boolean isKnightReachableSquare(String chessSquare) {
        if (!isChessValidSquare(chessSquare)) return false;
        String target = normalize(chessSquare);
        int fx = fileIndex(this.currentSquare);
        int fy = rankIndex(this.currentSquare);
        int tx = fileIndex(target);
        int ty = rankIndex(target);
        int dx = Math.abs(fx - tx);
        int dy = Math.abs(fy - ty);
        return (dx == 1 && dy == 2) || (dx == 2 && dy == 1);
    }

    public void moveToSquare(String toChessSquare) {
        if (!isChessValidSquare(toChessSquare)) {
            System.out.println("Invalid chessboard square: " + toChessSquare);
            return;
        }
        if (!isKnightReachableSquare(toChessSquare)) {
            System.out.println("Chessboard square not reachable: " + toChessSquare);
            return;
        }
        this.currentSquare = normalize(toChessSquare);
    }

    @Override
    public String toString() {
        return "Knight at " + this.currentSquare;
    }

    // --- Helper methods ---
    private String normalize(String s) {
        if (s == null) return null;
        return s.trim().toLowerCase();
    }

    private int fileIndex(String square) {
        return square.charAt(0) - 'a';
    }

    private int rankIndex(String square) {
        return square.charAt(1) - '1';
    }
}
*/