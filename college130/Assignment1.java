package college130;
import javax.swing.JOptionPane;
public class Assignment1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	double BASE_PRICE_A = 9.95;
	double BASE_PRICE_B = 13.95;
	double PRICE_C = 19.95;
	double hours;	
		
	char Package = 0; 
	
	while (Package != 'A' && Package != 'B' && Package != 'C')//validate the input
	{
		Package = JOptionPane.showInputDialog("This tool will calculate the cost of the entered number of\n"
				+ "hours of internet usage for the plan you contract for.\n\n"
				+ "The available plans are as follows:\n\n" 
				+ "A-9.95 per month for 10 hours and $2.00 per extra hour\n" 
				+ "B-13.95 per month for 20 hours and $2.00 per extra hour\n"
				+ "C-19.95 per month for unlimited access\n\n" 
				+ "Please enter the uppercase letter for the plan you contracted for:").charAt(0);
	
	}
	
	if(Package == 'C')
		{
		JOptionPane.showMessageDialog(null, "Your charge for this month is $" + PRICE_C + ".");
		System.exit(0);
		}
	
	String inputString2 = JOptionPane.showInputDialog("Please enter the number of hours that you used.");
	hours = Double.parseDouble(inputString2);
	
	while (hours < 0)
	{
		inputString2 = JOptionPane.showInputDialog("Invalid entry" 
				+ "Please enter the number of hours that you used.");	
		hours = Double.parseDouble(inputString2);		
	}
	
	double finalA = (2 * (hours - 10) + BASE_PRICE_A);
	double finalB = ((hours - 20) + BASE_PRICE_B);
	double total_savingsAB = (finalA - finalB);
	double total_savingsAC = (finalA - PRICE_C);
	double total_savingsBC = (finalB - PRICE_C);
	
	switch (Package)
	{
		case 'A':
			if (hours <= 10)
			{
				JOptionPane.showMessageDialog(null,"Your final charge is $" + BASE_PRICE_A);
			}
			else if (finalB >= finalA)
			{
				JOptionPane.showMessageDialog(null, "Your final charge is $" + finalA);
			}
			else if (PRICE_C < finalA)
			{
				JOptionPane.showMessageDialog(null, "Your final charge is $" + finalA + ".\n"
						+ "If you had Plan B, your savings would have been $" + total_savingsAB + ".\n"
						+ "If you had Plan C, your savings would have been $" + total_savingsAC + ".");
			}
			else if (finalB < finalA)
			{
				JOptionPane.showMessageDialog(null, "Your charge for the month is $" + finalA + ".\n"
						+ "If you had Plan B, your savings would have been $" + total_savingsAB + ".");
			}
			break;
		case 'B':
			if (hours <= 20)
			{
				JOptionPane.showMessageDialog(null, "Your charge for the month is $" + BASE_PRICE_B + ".");
			}
			else if (finalB < PRICE_C)
			{
				JOptionPane.showMessageDialog(null, "Your charge for the month is $" + finalB + "."); 
			}
			else if (finalB > PRICE_C)
			{
				JOptionPane.showMessageDialog(null, "Your charge for the month is $" + finalB + ".\n"
						+ "If you had Plan C, your savings would have been $" + total_savingsBC + ".");
			}
			break;
	
	
	}	
	}

}
