/**
Write an executable class that reads two floating point numbers each from an InputBox and prints the sum of the numbers into a MessageBox.

Note: enter the floating point numbers using the point as a separator character between the whole part and the fractional part.
*/

import javax.swing.JOptionPane;


public class Echo6{
	
	public static void main(String[] args){
		String userInput1 = JOptionPane.showInputDialog("Enter your 1st number");
		double userDouble1 = Double.parseDouble(userInput1);
		String userInput2 = JOptionPane.showInputDialog("Enter your 2nd number");
		double userDouble2 = Double.parseDouble(userInput2);

		double sum = userDouble1+userDouble2;
		JOptionPane.showMessageDialog(null, "Sum is: "+ sum);
		

	
}
}