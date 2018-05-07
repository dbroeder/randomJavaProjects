package carProject;
import javax.swing.*;
public class CarProblem {

	/**
	 * @DustinBroeder
	 * Assignment 5 
	 * CarProblem
	 * 
	 */
	public static void main(String[] args) {
		// Welcome message
		int tempYearModel=0;
		JOptionPane.showMessageDialog(null, "The user will input the year and make of a car\n"
				+ "and it will display the speed.\n" +
				"The user will then accelerate and brake the car.\n" +
				"The new speed will then be displayed after each selection.\n");
		
		//User inputs with validation and try catch
			
		try
		{
				String stringYearModel = JOptionPane.showInputDialog("Please enter the year of the car.");
				tempYearModel = Integer.parseInt(stringYearModel);
		}
		catch (Exception eim)
		{
				JOptionPane.showMessageDialog(null, "Invalid input.");
				System.exit(0);
		}
		
		String stringMake = JOptionPane.showInputDialog("Please Enter the make of the car.");
		int speed = 0;
		
		//Initializing the car class
		Car car = new Car(tempYearModel, stringMake, speed);
		JOptionPane.showMessageDialog(null, car.display() + speed);
		
		//Altering the speed of the car
		String assignLetter = JOptionPane.showInputDialog("Please enter a to accelerate or b to break.\n"
				+ "To exit enter any single character not a or b.");
		char letter = assignLetter.charAt(0);
		
		//Loop to continue altering the speed
		while (letter == 'a' || letter == 'b')
		{
			switch (letter)
			{
			case 'a':
				speed += car.accelerate(speed);
				JOptionPane.showMessageDialog(null, car.display()+ speed+car.speeding(speed));
				assignLetter = JOptionPane.showInputDialog("Please enter a to accelerate or b to break.\n"
					+ "To exit enter any single character not a or b.");
				letter = assignLetter.charAt(0);
				break;
			case 'b':
				speed += car.slowDown(speed);
				JOptionPane.showMessageDialog(null, car.display()+speed+car.zeroSpeed(speed));
				assignLetter = JOptionPane.showInputDialog("Please enter a to accelerate or b to break.\n"
					+ "To exit enter any single character not a or b.");
				letter = assignLetter.charAt(0);
				break;
			}
		}	
		System.exit(0);
	}

}
