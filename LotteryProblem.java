package assignments;

import javax.swing.*;

public class LotteryProblem {

	/**
	 * @BroederDustin
	 */
	public static void main(String[] args) {

		displayMessage();//opening message
		char repeatQuestion='y';//initializes the variable to repeat the process
		boolean jackpot=false; //initializes the variable to exit when the winnings numbers are reached
		int counter = 0;
		
		//loop to ask user if they want to repeat the entire program
		while (repeatQuestion=='y'||repeatQuestion=='n')
		{
			switch (repeatQuestion)//statement operates either yes or no for repeat of program.
			{
				case 'y':
					int pick1=getUserInput();//sets user values to picks using methods
					int pick2=getUserInput();
					int pick3=getUserInput();
					int pick4=getUserInput();
					int pick5=getUserInput();
		
					Lottery picks = new Lottery(pick1,pick2,pick3,pick4,pick5);//creates object holding user picks
					Lottery random= new Lottery(); //creates object holding random numbers
					int[] randomLottery=random.getLotteryNumbers();//creates array for random lottery numbers
					int[] userPicks = picks.getUserNumbers();//creates array for user picks
					int[] winnings = new int[5];//declares array for play counter and number of winnings for each match
					
					//loop runs until the random numbers and the user picks match
					while (jackpot==false)
					{
						winnings = picks.comparePicks(randomLottery, userPicks);
						
						if (winnings[4] == 1)
						{
							counter+=1;
							jackpot=true;
						}
						else
						{
							counter+=1;
							randomLottery=random.refreshLottery();
							randomLottery=random.getLotteryNumbers();
						}
					}
					
					int sum = sumWins(winnings);//sums the total number of times numbers matched up
					winningMessage(userPicks, winnings, sum, counter);//method call to display the winning message
					displayProbability(winnings, counter);
					repeatQuestion = replayLottery();//method call to ask for repeat of question
					winnings=random.resetWinnings();//resets the winnings array to 0
					jackpot=false; //resets the variable that the jack pot has been won
					counter =0; //resets game counter
					break;
				case'n':
					exitMessage();//method call for exit program message
					System.exit(0);
					
					
			}
					
		
		}
		
	}
	
	public static int getUserInput()//method for asking user inputs
	{
		int numberInput=0;
		try
		{
			String input = JOptionPane.showInputDialog("Please enter in 5 picks for your lottery\n"
					+"selection. Choose numbers from 1-56.");
			numberInput=Integer.parseInt(input);
		}
		catch (Exception eoi)
		{
			JOptionPane.showMessageDialog(null, "Invalid input.");
		}
		while(numberInput<=0||numberInput>57)
		{
			
			try
			{
				String input = JOptionPane.showInputDialog("You entered an invalid number.\n" +
						"Please enter in 5 picks for your lottery\n"
						+"selection. Choose numbers from 1-56.");
				numberInput=Integer.parseInt(input);
			}
			catch (Exception ioe)
			{
				JOptionPane.showMessageDialog(null, "Invalid input.");
			}
		}
		return numberInput;
		
	}
	
	public static void displayMessage()//method for display message
	{
		JOptionPane.showMessageDialog(null, "This program will ask user for 5 lottery\n" +
											"numbers and will return the number of games\n" +
											"it took to win the jackpot.");
	}
	
	public static void winningMessage(int[]array, int[]wins, int sum, int count)//method for dislpay of winning the lottery
	{
		String display = ""+array[0];
		for(int num=1;num<5;num++)
		{
			display += ", " + array[num];
		}
		JOptionPane.showMessageDialog(null, "Congratulations, you have won the lottery!\n" +
				"The winning picks were: " + display+
				"\nIt took "+count+ " games to win." );
		JOptionPane.showMessageDialog(null, "In the games you played to win the jackpot\n" +
				"You matched 0 picks "+(count-sum)+" times\n"+
				"You matched 1 pick "+wins[0]+" times\n" +
				"You matched 2 picks "+wins[1]+" times\n"+
				"You matched 3 picks "+wins[2]+" times\n"+
				"You matched 4 picks "+wins[3]+" times\n");
	}
	
	public static int sumWins(int[]wins)//method to sum the total number of matches
	{
		int sum=0;
		for (int num=0; num<5;num++)
		{
			sum+=wins[num];
		}
		return sum;
	}
	
	public static void exitMessage()//exit message
	{
		JOptionPane.showMessageDialog(null, "Thank you for playing the lottery!");
	}
	
	public static char replayLottery()//method to ask user if they want to replay the lottery
	{
		char letter='s';
		while (letter!='n'||letter!='y')
		{
			try
			{
				letter = JOptionPane.showInputDialog("Would you like to repeat the program?\n" 
							+"If yes input 'y', if no input 'n'.").charAt(0);
				return letter;
			}
			catch (Exception eoi)
			{
				JOptionPane.showMessageDialog(null, "Invalid input");
			}
		}
		return letter;
	}
	
	public static void displayProbability(int[]wins, int count)//determines the probability of winning the games
	{
		double odds=0;
		String display="In the games it took to hit the jackpot, \n" +
				"you matched on average:\n";
		for(int num=0;num<4;num++)
		{
			odds=(double)count/wins[num];
			odds=Math.ceil(odds);
			display+=""+(num+1)+ " pick(s) every "+odds+" games\n";
		}
		JOptionPane.showMessageDialog(null, display);
	}
}

	