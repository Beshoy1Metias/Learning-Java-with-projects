import java.util.Scanner;

public class Banking{
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        
        boolean isRunning = true;
        int choice;
        double balance=0;
        

        while(isRunning){

        System.out.println("Welcome to your favorite bank: ");
        System.out.println("1-balance");
        System.out.println("2-deposit");
        System.out.println("3-Withdraw");
        System.out.println("4-exit");

        choice = scanner.nextInt();
        
        switch(choice){
            case 1 -> showbalance(balance);
            case 2 -> balance += deposit(); 
            case 3 -> balance -= withdraw();
            case 4 -> isRunning=false;
            default -> System.out.print("Invalid choice");
            
        }


        }


    }
    static void showbalance(double balance){
        System.out.printf("Your total balance is: $%.2f\n", balance);



    }
    static double deposit(){
        System.out.println("Amount to be deposited: ");
        double amount = scanner.nextDouble();
        if(amount<0){
            System.out.println("Deposit can't be negative!!");

        }
        else{
            return amount;
        }
        return 0;
        
    }
    static double withdraw(){
        System.out.println("Amount to be withdrawn: ");
        double withdrawn = scanner.nextDouble();
        if(withdrawn<0){
            System.out.println("Can't withdraw negative numbers!");

        }
        else{
            return withdrawn;
        }
        return 0;
        
    }

}