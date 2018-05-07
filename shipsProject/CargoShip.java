package shipsProject;

public class CargoShip extends Ship{

	
	private int tonnage;
	
	public CargoShip(String tempName,int tempYear,String tempCountry,int tons)
	{
		super(tempName,tempYear,tempCountry);
		tonnage=tons;
	}
	public int getTonnage()
	{
		return tonnage;
	}
}
