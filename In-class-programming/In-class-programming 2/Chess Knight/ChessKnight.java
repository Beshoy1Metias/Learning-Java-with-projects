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