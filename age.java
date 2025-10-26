import java.util.Scanner;

public class age{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your age in years: ");
		int ageInYears = scanner.nextInt();
		int ageInMonths= ageInYears * 12;
		int ageIndays = ageInMonths * 30;
		int ageInHours = ageIndays * 24;
		int ageInMinutes = ageInHours * 60;
		int ageInSeconds = ageInMinutes * 60;
		System.out.printf("You have lived: %d years%n or %d months%n or %d days%n or %d hours%n or %d minutes %n or %d seconds", ageInYears, ageInMonths, ageIndays, ageInHours, ageInMinutes, ageInSeconds);
		
		
	}
	
}