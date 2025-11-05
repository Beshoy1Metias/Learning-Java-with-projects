/**
   Test class of ChessKing class
   
   @author A. Luchetta
   @version 20201021
*/
public class ChessKingTester
{
   public static void main(String[] args)
   {
      final String INITIAL_CHESS_SQUARE = "f5";
      final String MOVE1 = "f6";
      final String MOVE2 = "e6";
      final String MOVE3 = "e5";
      final String MOVE4 = "e4";
      final String MOVE5 = "f6";

      ChessKing b1 = new ChessKing(INITIAL_CHESS_SQUARE);     
      System.out.println(b1);
      
      b1.moveToSquare(MOVE1);
      System.out.println(b1);
      
      b1.moveToSquare(MOVE2);
      System.out.println(b1); 
           
      b1.moveToSquare(MOVE3);
      System.out.println(b1); 
      
      b1.moveToSquare(MOVE4);
      System.out.println(b1); 
      
      b1.moveToSquare(MOVE5);  // non reachable square
      System.out.println(b1);
      
      b1.moveToSquare("abc");  // invalid square
      System.out.println(b1);                     

      b1.moveToSquare("p9");   // invalid square
      System.out.println(b1);           
   }

}
