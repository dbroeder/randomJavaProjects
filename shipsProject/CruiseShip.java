package shipsProject;

public class CruiseShip extends Ship{
	private int capacity;
	
	public CruiseShip(String n,int y, String na,int c)
	{
		super(n,y,na);
		capacity=c;
	}
	public int getPassengers()
	{
		return capacity;
	}
}
