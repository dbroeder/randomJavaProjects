package carProject;

public class Car {
	/**
	 * @DustinBroeder
	 * car class
	 */
	//declaring the variables
	private int yearModel;
	private String make;
	private int speed;
	
	public Car()//initialization
	{
		make = "0";
		yearModel = 0;
		speed = 0;
	}
	
	public Car(int yM, String mak, int sp)//constructor
	{
		yearModel = yM;
		make = mak;
		speed = sp;
	}
	
	public int accelerate(int spd)//set acceleration increment
	{
		if (spd >= 70)
		{
			return speed;
		}
		return speed + 5;			
	}
	
	public int slowDown(int spd)//set brake increment
	{
		if (spd <= 0)
		{
			return speed;
		}
		return speed - 2;
	}
	
	public String zeroSpeed(int speed)//if the speed drops below zero this message will display.
	{
		if (speed <= 0)
		{
			String output ="\nCannot brake any more. \nSpeed will be less than zero.";
			return output;
		}
		return "";
	}
	
	public String speeding(int speed)//if the speed accelerates above 70 this message displays.
	{
		if (speed > 70)
		{
			return "\nWarning: speed limit exceeded. Please brake.";
		}
		return "";
	}
	
	public String display()//displays the year model, make and speed of the car
	{
		return "The year of the car is: " + yearModel + "\nThe make of the car is: " + make + "\nThe speed of the car is: ";
	}
	
	public int getYearModel()//gets the year model
	{
		return yearModel;
	}
	
	public int getSpeed()//gets the speed
	{
		return speed;
	}
	
	public String getMake()//gets the make
	{
		return make;
	}
	
	public void setYearModel(int yM)//sets the year model
	{
		yearModel = yM;
	}
	
	public void setSpeed(int sp)//sets the speed
	{
		speed = sp;
	}
	
	public void setMake(String mak)//sets the make
	{
		make = mak;
	}
	
}
