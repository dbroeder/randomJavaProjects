package shipsProject;

public class BattleShip extends Ship{

	private int weaponsCapacity;
	private int fighterCapacity;
	
	public BattleShip(String n,int y,String na,int wp,int fi)
	{
		super(n,y,na);
		weaponsCapacity = wp;
		fighterCapacity = fi;
	}
	public int getWeapons()
	{
		return weaponsCapacity;
	}
	public int getFighters()
	{
		return fighterCapacity;
	}
}
