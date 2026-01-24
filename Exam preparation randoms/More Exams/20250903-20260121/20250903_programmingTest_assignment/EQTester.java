/**
  *        FOUNDATIONS OF COMPUTER SCIENCE - A.A. 2024-25
  *                Programming Test - 03-09-2025
  *
  * Test class of the EQ class
  *
  * @see Q
  * @author A. Luchetta
  * @version 18-Jan-2025
*/
public class EQTester {
   public static void main(String[] args) {
      // constants
      String[] rivers = {"Lena","Ganges","Mekong","Danube","Orinoco","Yukon","Don"};
      String[] otherRivers = {"Lena","Nile","Ob","Danube"};
      
      // define new empty queue
      EQ q1 = new EQ();
      
      // insert items into new queue
      for (String s : rivers) q1.enqueue(s);
      
      // define new queue non-empty queue
      EQ q = new EQ(q1);
      
      // print size
      System.out.println("SIZE " + q.size());
      
      // print items
      Object[] items = q.toArray();
      System.out.print("ITEMS BEFORE: ");
      for (Object e : items) System.out.print(e + " ");
      System.out.println();
      
      // get max item
      String max = (String)q.maxItem();
      System.out.println("MAX ITEM: " + max);
      
      items = q.toArray();
      System.out.print("ITEMS AFTER: ");
      for (Object e : items) System.out.print(e + " ");
      System.out.println();         
      
      // print size
      System.out.println("SIZE " + q.size());
   }
}
