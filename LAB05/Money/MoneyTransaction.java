
/**
 * Write a description of class MoneyTransaction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MoneyTransaction
{
    private double amount=0;
    private String date = "";
    private String direction = ""; // revenue or expense
    public MoneyTransaction(double aAmount, String aDate, String aDirection)
    {
        amount  = aAmount;
        date = aDate;
        direction = aDirection;
    }
    public double getMoneyAmount(){
        return amount;
    }
    public String getDate(){
        return date;
    }
    public String getDirection(){
        return direction;
    }
    public String toString(){
        return amount + "" + date + direction;
    }
}