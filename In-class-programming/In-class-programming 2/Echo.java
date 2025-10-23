import javax.swing.JOptionPane;
public class Echo
{ public static void main(String[] args)
 { // acquires a string from dialog box
 String s = JOptionPane.showInputDialog("enter a string");
 // sends the acquired string to message box
 JOptionPane.showMessageDialog(null, s);
 // sends the acquired string to standard output
 System.out.println(s);
 // ends the execution of the JVM
 System.exit(0);
 }
}