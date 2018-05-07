package workersProject;

public class Employee {
	private String firstName;
	private String lastName;
	private String employeeNumber;
	private String hireDate;
	
	public Employee(String employNum, String fName, String lName, String hDate)
	{
		employeeNumber=employNum;
		firstName=fName;
		lastName=lName;
		hireDate=hDate;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getEmployeeNumber()
	{
		return employeeNumber;
	}
	
	public String getHireDate()
	{
		return hireDate;
	}
	
	public void setFirstName(String fn)
	{
		firstName=fn;
	}
	
	public void setLastName(String ln)
	{
		lastName=ln;
	}
	
	public void setEmployeeNumber(String en)
	{
		employeeNumber=en;
	}
	
	public void setHireData(String hd)
	{
		hireDate=hd;
	}
	
	public String toString()
	{
		String display="";
		for(int dex=0;dex<4;dex++)
		{
			if(dex==0)
			{
				display+=firstName;
				for(int index=0;index<(13-firstName.length());index++)
				{
					display+=" ";
				}
			}
			else if(dex==1)
			{
				display+=lastName;
				for(int index=0;index<(13-lastName.length());index++)
				{
					display+=" ";
				}
			}
			else if(dex==2)
			{
				display+=employeeNumber;
				for(int index=0;index<(13-employeeNumber.length());index++)
				{
					display+=" ";
				}
			}
			else if(dex==3)
			{
				display+=hireDate;
				for(int index=0;index<(13-hireDate.length());index++)
				{
					display+=" ";
				}
			}
			
		}
		return display;
	}
}
