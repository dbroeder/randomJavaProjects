package workersProject;

public class TeamLeader extends ProductionWorker{
	private double bonusRate;
	private double requiredTrainingHours;
	private double receivedTrainingHours;
	
	public TeamLeader(String employNum, String fName, String lName, String hDate,int shif, double rate, double bonus, double required, double received)
	{
		super(employNum,fName,lName,hDate,shif,rate);
		bonusRate=bonus;
		requiredTrainingHours=required;
		receivedTrainingHours=received;
	}
	
	public double getBonusRate()
	{
		return bonusRate;
	}
	
	public double getRequiredTrainingHours()
	{
		return requiredTrainingHours;
	}
	
	public double getReceivedTrainingHours()
	{
		return receivedTrainingHours;
	}
	
	public void setBounusRate(double br)
	{
		bonusRate=br;
	}
	
	public void setRequiredTrainingHours(double rth)
	{
		requiredTrainingHours=rth;
	}
	
	public void setReceivedTrainingHours(double reth)
	{
		receivedTrainingHours=reth;
	}
	
	public String toString()
	{
		String display=super.toString();
		for(int dex=0;dex<3;dex++)
		{
			if(dex==0)
			{
				display+=bonusRate;
				String str="bonusRate";
				for(int index=0;index<(12-3);index++)
				{
					display+=" ";
				}	
			}
			else if(dex==1)
			{
				display+=requiredTrainingHours;
				String sal="requiredTrainingHours";
				for(int index=0;index<(12-5);index++)
				{
					display+=" ";
				}
			}
			else if(dex==2)
			{
				display+=receivedTrainingHours;
				String str="receivedTrainingHours";
				for(int index=0;index<(12-4);index++)
				{
					display+=" ";
				}
			}
		}
		return display;
	}
	

}
