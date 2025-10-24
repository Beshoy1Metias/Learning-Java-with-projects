/**
   Test class of ChessKnight class
   
   @author A. Luchetta
   @version 20201021
*/
public class ChessKnightTester
{
   public static void main(String[] args)
   {
      final String INITIAL_CHESS_SQUARE = "d4";
      final String MOVE1 = "f5";
      final String MOVE2 = "h4";
      final String MOVE3 = "f3";
      final String MOVE4 = "d4";
      final String MOVE5 = "d7";

      ChessKnight b1 = new ChessKnight(INITIAL_CHESS_SQUARE);     
      System.out.println(b1);
      
      b1.moveToSquare(MOVE1);
      System.out.println(b1);
      
      b1.moveToSquare(MOVE2);
      System.out.println(b1); 
           
      b1.moveToSquare(MOVE3);
      System.out.println(b1); 
      
      b1.moveToSquare(MOVE4);
      System.out.println(b1); 
      
      b1.moveToSquare(MOVE5);  // chessboard square not reachable
      System.out.println(b1);
      
      b1.moveToSquare("abc");  // invalid chessboard square
      System.out.println(b1);                     

      b1.moveToSquare("p9");  // invalid chessboard square
      System.out.println(b1);           
   }
}
