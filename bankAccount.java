public class bankAccount{
	private double balance = 0;
	public bankAccount(){
		balance = 0;
	}
	
	public bankAccount(double initialAmount){
		
		balance = initialAmount;
		
	}
	
	public void deposit(double amount){
		balance += amount;
	}
	
	public void withdraw(double amount){
		balance -= amount;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public String toString(){
		return "BankAccount: Balance is equal to " + balance;
	}
	
	
}