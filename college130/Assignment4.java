package college130;
import javax.swing.*;
public class Assignment4 {

	/**
	 *Dustin Broeder
	 * @param args
	 */
	
	public static double inputWholesale()
	{
		double value = 0;
		while (value <= 0)
		{
			String inputWholesale = JOptionPane.showInputDialog("This program will ask the user to input the wholesale price\n"
				+ "and markup percentage. It will then calculate the retail price.\n\n"
				+ "Enter the wholesale cost:");
			value = Double.parseDouble(inputWholesale);
		}
		return value;
	}
	public static double inputMarkup()
	{
		double value = 0;
		while (value <= 0)
		{	
			String inputMarkup = JOptionPane.showInputDialog("Enter the markup percentage:");
			value = Double.parseDouble(inputMarkup);
		}	
		return value;
	}
	public static double calculateRetail(double whole, double mark)
	{
		double markupPer = mark/100;
		return (whole*markupPer) + whole;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double wholesale = inputWholesale();
		double markup = inputMarkup();
		double retailPrice = calculateRetail(wholesale, markup);
		
		JOptionPane.showMessageDialog(null, "If an item's wholesale cost is " + wholesale + "and its markup percentage is "
				+ markup + " percent, then the item's retail price is " + retailPrice + ".");	
	}

}
