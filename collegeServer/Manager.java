package collegeServer;

public class Manager {
	public static final int MAX_RESOURCES=5;
	private int availableResources =MAX_RESOURCES;
	
	public synchronized void decreaseCount(int count)
	{
		if(availableResources<=0)
		{
			try{
				wait();
			}catch(Exception e){}
			
		}
		availableResources-=count;
		
		
	}
	
	public synchronized void increaseCount(int count)
	{
		availableResources+=count;
		notify();
	}
	public int getResources()
	{
		return availableResources;
	}
}
