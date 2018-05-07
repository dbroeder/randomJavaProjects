package workersProject;

public class ShiftSupervisor extends Employee{
	private int shift;
	private double annualSalary;
	private double bonusRate;
	
	public ShiftSupervisor(String employNum, String fName, String lName, String hDate, int shif, double yearSal, double bonus)
	{
		super(employNum,fName,lName,hDate);
		shift=shif;
		annualSalary= yearSal;
		bonusRate=bonus;
	}
	
	public int getShift()
	{
		return shift;
	}
	
	public double getAnnualSalary()
	{
		return annualSalary;
	}
	
	public double getBonusRate()
	{
		return bonusRate;
	}
	
	public void setShift(int s)
	{
		shift=s;
	}
	
	public void setAnnualSalary(double as)
	{
		annualSalary=as;
	}
	
	public void setBonusRate(double bs)
	{
		bonusRate=bs;
	}
	
	public String toString()
	{
		String display=super.toString();
		for(int dex=0;dex<3;dex++)
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
				display+=annualSalary;
				String sal="annualSalary";
				for(int index=0;index<(12-8);index++)
				{
					display+=" ";
				}
			}	
			else if(dex==2)
			{
				display+=bonusRate;
				for(int index=0;index<(12-3);index++)
				{
					display+=" ";
				}
			}
		}
		return display;
	}
}
