package college130;
import javax.swing.*;
public class Assignment3 {

	/**
	 * @param args
	 */
	
	public static double calculateAverage()
	{
		int score1 = 0, score2=0, score3=0, score4=0,score5=0;
		while (score1 <= 0  || score1 >= 100) 
		{
			String inputScor = JOptionPane.showInputDialog("This program will find the average of 5 test scores\n"+
				"and calculate the final grade.\n\n" + "Enter 1st test score:");
			score1 = Integer.parseInt(inputScor);
		}
		while (score2 <= 0 || score2 >= 100)
		{
			String inputScor2 = JOptionPane.showInputDialog("Enter 2nd test score:");
			score2 = Integer.parseInt(inputScor2);
		}
		while (score3 <= 0 || score3 >= 100)
		{
			String inputScor3 = JOptionPane.showInputDialog("Enter 3rd test score:");
			score3 = Integer.parseInt(inputScor3);
		}
		while (score4 <= 0 || score4 >= 100)
		{
			String inputScor4=JOptionPane.showInputDialog("Enter 4th test score:");
			score4 = Integer.parseInt(inputScor4);
		}
		while (score5  <= 0 || score5 >=100)
		{	
			String inputScor5=JOptionPane.showInputDialog("Enter 5th test score:");
			score5 = Integer.parseInt(inputScor5);
		}
		return ((score1+score2+score3+score4+score5)/5.0);
		
	}
	public static char determineGrade(double avg)
	{
		char result;
		if (avg >= 90)
			result = 'A';
		else if (avg >= 80)
			result='B';
		else if (avg >= 70)
			result = 'C';
		else if (avg >=60)
			result = 'D';
		else 
			result = 'F';
		
		return result;
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double average = calculateAverage();
		char grade = determineGrade(average);
		System.out.print("The average of the 5 test scores is " + average + ". This means the final grade is " + grade + ".");
		
		
		
		
	}
}
