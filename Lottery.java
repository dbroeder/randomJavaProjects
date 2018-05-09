package assignments;

import java.util.Random;
//BroederDustin
public class Lottery {

	private int[] lotteryNumbers = new int[5];
	private int[] userNumbers = new int[5];
	private int[] winnings = new int[5];

	//user constructor
	public Lottery(int num1,int num2, int num3, int num4, int num5)
	{
		userNumbers[0]=num1;
		userNumbers[1]=num2;
		userNumbers[2]=num3;
		userNumbers[3]=num4;
		userNumbers[4]=num5;
	}
	
	//random constructor
	public Lottery()
	{
		Random lotteryPick= new Random();
		for (int num=0;num<5;num++)
		{
			lotteryNumbers[num]=lotteryPick.nextInt(56);
		}
	}
	
	//compares the lottery numbers with the user picks 
	//and increments the winnings array accordingly
	public int[] comparePicks(int[]user, int[]rand)
	{
		if(user[0]==rand[0])
		{
			winnings[0]+=1;
			
			if(user[1]==rand[1])
			{
				winnings[1]+=1;
				if(user[2]==rand[2])
				{
					winnings[2]+=1;
					if (user[3]==rand[3])
					{
						winnings[3]+=1;
						if (user[4]==rand[4])
						{
							winnings[4]+=1;
							return winnings;
						}
						return winnings;
					}
					return winnings;
				}
				return winnings;
			}
			return winnings;
		}
		return winnings;
	}
	
	//refreshes the lottery numbers. 
	public int[] refreshLottery()
	{
		Random lotteryPick= new Random();
		for (int num=0;num<5;num++)
		{
			lotteryNumbers[num]=lotteryPick.nextInt(56);
		}
		return lotteryNumbers;
	}
	
	//resets the winnings array to 0's.
	public int[] resetWinnings()
	{
		for (int num=0; num<5; num++)
		{
			winnings[num]=0;
		}
		return winnings;
	}
	
	//gets the user picks array
	public int[] getUserNumbers()
	{
		return userNumbers;
	}
	
	//gets the random lottery picks array
	public int[] getLotteryNumbers()
	{
		return lotteryNumbers;
	}
	
	//gets the winnings array
	public int[] getWinnings()
	{
		return winnings;
	}
	
	//sets the user picks array
	public void setUserNumbers(int[]array)
	{
		userNumbers=array;
	}
	
	//sets the random lottery numbers array
	public void setLotteryNumbers(int[]array)
	{
		lotteryNumbers=array;
	}
	
	//sets the winnings array
	public void setWinnings(int[]array)
	{
		winnings=array;
	}
}
		