package lottery;

import java.util.Random;

public class Lottery {
	private int[] lotteryPicks;
	private int powerBall;
	private int[] wins= new int[6];
	private int trys = 0;
	private int totalWins = 0;
	
	public Lottery(int[] lottPicks,int pb){
		lotteryPicks = lottPicks;
		powerBall = pb;
	}
	
	public int[] newRandomPicks(){
		Random rand = new Random();
		int[] tempNums = new int[5];
		for(int dex = 0;dex<5;dex++){
			tempNums[dex] = rand.nextInt(69)+1;
			if(dex>0)
			{
				for(int d = 0;d<dex;d++){
					while(tempNums[dex]==tempNums[d])
					{
						tempNums[dex]=rand.nextInt(69)+1;
					}
				}
				
			}
		}
		return tempNums;
		
	}
	
	public int newRandomPowerball()
	{
		Random rand = new Random();
		return rand.nextInt(26)+1;
	}
	
	public boolean check4Win(){
		trys++;
		int[] tempPicks = newRandomPicks();
		int tempPb = newRandomPowerball();
		int winCount = 0;
		for(int i = 0;i<5;i++){
			for(int d = 0;d<5;d++)
			{
				if(lotteryPicks[i]==tempPicks[d])
				{
					winCount++;
				}
			}
		}
		if(winCount==5&&tempPb==powerBall)
		{
			totalWins++;
			wins[5]++;
			return true;
		}
		else if(winCount==5)
		{
			totalWins++;
			wins[4]+=1000000;
			return false;
		}
		else if(winCount==4&&tempPb==powerBall)
		{
			totalWins++;
			wins[3]+=50000;
			return false;
		}
		else if((winCount==4)||(winCount==3&&tempPb==powerBall))
		{
			totalWins++;
			wins[2]+=100;
			return false;
		}
		else if((winCount==3)||(winCount==2&&tempPb==powerBall))
		{
			totalWins++;
			wins[1]+=7;
			return false;
		}
		else if((winCount==1&&tempPb==powerBall)||tempPb==powerBall)
		{
			totalWins++;
			wins[0]+=4;
			return false;
		}else
		{
			return false;
		}
	}
	
	public int getTotalWins()
	{
		return totalWins;
	}
	
	public int getWin(int index)
	{
		return wins[index];
	}
	
	public int[] getWins()
	{
		return wins;
	}
	
	public int getTrys(){
		return trys;
	}
	
	public void setPowerball(int pb)
	{
		powerBall = pb;
	}
	
	public void setPicks(int[] picks)
	{
		lotteryPicks = picks;
	}
	
	public int[] getUserPicks()
	{
		return lotteryPicks;
	}
	
	public int getUserPowerball(){
		return powerBall;
	}
	

}