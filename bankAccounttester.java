public class bankAccounttester{
	
	public static void main(String[] args){
		double rate = 0.05;
		double initialAmount = 10000;
		bankAccount account = new bankAccount(initialAmount);
		
		double interest = initialAmount*rate;
		account.deposit(interest);
		System.out.println("Your account's balance after 1 year is: " + account.getBalance());
		interest = account.getBalance()*rate;
		account.deposit(interest);
		System.out.println("Your account's balance after 2 years is: " + account.getBalance());

		System.out.println(account);

		
		
	}
	
	
}