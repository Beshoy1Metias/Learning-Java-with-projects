/**
  *        FOUNDATIONS OF COMPUTER SCIENCE - A.A. 2024-25
  *                Programming Test - 03-09-2025
  *
  * Test class of the Q class
  *
  * @see Q
  * @author A. Luchetta
  * @version 18-Jan-2025
*/
public class QTester {
   public static void main(String[] args) {
      // define constants
      String[] rivers = {"Lena","Ganges","Mekong","Danube","Orinoco","Yukon","Don"};
      
      // define new queue
      Queue q = new Q();                      // test of constructor
      
      // insert items into new queue
      for (String s : rivers) q.enqueue(s);   // test of enqueue method
      
      // print size
      System.out.println("SIZE " + q.size()); // test of size method
      
      // print items
      System.out.print("ITEMS: ");
      int size = q.size();
      for (int i = 0; i < size; i++) {
         String item = (String)q.dequeue(); // test of dequeue method
         System.out.print(item + " ");
         q.enqueue(item);
      }
      System.out.println();
      
      // get max item
      String maxItem = (String)q.maxItem();  // test of maxItem method
      System.out.println("MAXITEM: " + maxItem);
      
      // remove elements
      System.out.print("FRONT/REMOVE ");
      while (!q.isEmpty()) System.out.print(q.front() + "/" + q.dequeue() + " ");
      System.out.println();
      
      // print size
      System.out.println("SIZE " + q.size());
   }
}
