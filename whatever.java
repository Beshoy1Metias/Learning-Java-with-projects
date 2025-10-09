import java.util.Scanner;

public class whatever{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        String item;
        double price;
        int quantity;
        char currency = '$';
        System.out.println("What would you like to order?");
        item = scanner.nextLine();
        System.out.println("How many "+ item +"s would you like?");
        quantity = scanner.nextInt();
        price = 15 * quantity;
        System.out.println("Your totall is: " + price + currency);
        scanner.close();
    }
}