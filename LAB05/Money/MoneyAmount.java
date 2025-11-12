
/**
 * Write a description of class MoneyAmount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MoneyAmount
{
    public double amount=0.0;
    public String currency = "$";
    public double rate = 0.0;
    public MoneyAmount(double anAmount, String aCurrency, double aToEuroRate)
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
    public String getcurrency()
    {
        return currency;
    }
    public double getToEuroRate(){
        return rate;
    }
    public String toString(){
        return " ";
    }
    
}