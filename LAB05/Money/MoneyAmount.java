
/**
 * Write a description of class MoneyAmount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MoneyAmount
{
    private double amount=0.0;
    private char currency = '$';
    private double rate = 0.0;
    public MoneyAmount(double anAmount, char aCurrency, double aToEuroRate)
    {
        amount = anAmount;
        currency = aCurrency;
        rate = aToEuroRate;
    }
    public double getAmount()
    {
        return amount;
    }
    public double getConvertedToEuroAmount()
    {
        return amount * rate;
    }
    public char getcurrency()
    {
        return currency;
    }
    public double getToEuroRate(){
        return rate;
    }
    public String toString(){
        return currency + " " + amount*rate;
    }
    
}