import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors{
    public static void main(String[] args){
        
        Random random = new Random();
        
        String[] choices = {"rock", "paper", "scissors"};

        boolean playAgain = true;
        int wincount = 0;
        int losecount = 0;
        int tieCount = 0;
        
        while(playAgain){
            Scanner scanner = new Scanner(System.in);

            System.out.print("choose rock paper or scissors: ");
            
            String userchoice = scanner.nextLine().toLowerCase();
            String computerchoice = choices[random.nextInt(0, 3)];
            if (!userchoice.equals("rock") && !userchoice.equals("paper") && !userchoice.equals("scissors") ) {
                System.out.println("Invalid choice");
                System.out.println("-------------------------------");
                continue;
    }
        if (userchoice.equals(computerchoice)) {
            System.out.println("It's a tieeee!!!! computer chose: " + computerchoice);
            System.out.println("-------------------------------");
            tieCount++;
            
        }
        else{
            switch(computerchoice){
                case "rock" -> {
                    if(userchoice.equals("scissors")){
                        System.out.println("You loseeeee :( Computer chose: "+ computerchoice);
                        System.out.println("-------------------------------");
                        losecount++;
                    }
                    else{
                        System.out.println("You win!!!! computer chose: "+ computerchoice);
                        System.out.println("-------------------------------");
                        wincount++;
                    }
                    }
                case "scissors" -> {
                    if(userchoice.equals("rock")){
                        System.out.println("You win!!!! computer chose: "+ computerchoice);
                        System.out.println("-------------------------------");
                        wincount++;
                    }
                    else{
                        System.out.println("You loseeeee :( Computer chose: "+ computerchoice);
                        System.out.println("-------------------------------");
                        losecount++;
                    }
                    }
                case "paper" -> {
                    if(userchoice.equals("scissors")){
                        System.out.println("You win!!!! computer chose: "+ computerchoice);
                        System.out.println("-------------------------------");
                        wincount++;
                    }
                    else{
                        System.out.println("You loseeeee :( Computer chose: "+ computerchoice);
                        System.out.println("-------------------------------");
                        losecount++;
                    }
                    }
        }
        }
        System.out.printf("You lost %d times and won %d times and tied %d times, ", losecount, wincount, tieCount);
        System.out.print("Wanna play again? (yes/no): ");
        String temp = scanner.nextLine().toLowerCase();
        if(!temp.equals("yes")){
            break;
        }
        
        
            
        }
}
        
}