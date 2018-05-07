package workersProject;

public class  ProductionWorker extends Employee{
	private int shift;
	private double payRate;
	
	public ProductionWorker(String employNum, String fName, String lName, String hDate,int shif, double rate)
	{
		super(employNum,fName,lName,hDate);
		shift=shif;
		payRate=rate;
	}
	
	public int getShift()
	{
		return shift;
	}
	
	public double getPayRate()
	{
		return payRate;
	}
	
	public void setShift(int s)
	{
		shift=s;
	}
	
	public void setPayRate(double pr)
	{
		payRate=pr;
	}
	
	public String toString()
	{
		String display=super.toString();
		for(int dex=0;dex<2;dex++)
		{
			if(dex==0)
			{
				display+=shift;
				for(int index=0;index<(12);index++)
				{
					display+=" ";
				}	
			}
			else if(dex==1)
			{
				display+=payRate;
				for(int index=0;index<(10);index++)
				{
					display+=" ";
				}
			}
			
		}
		return display;
	}

}
