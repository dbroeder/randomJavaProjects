package collegeServer;

public class TractorJam {
	
	public TractorJam()
	{
		Thread northFarmer=tractor("north","south");
		Thread southFarmer=tractor("south","north");
		northFarmer.start();
		southFarmer.start();
		
	}
	
	public final long start=System.currentTimeMillis();
	
	public int randSleepTime()
	{
		return (int)(Math.random()*120);
	}
	public synchronized void tractorCross(Thread p)
	{
		try{p.sleep(10);}catch(Exception e){}
	}
	
	public void workinHard(Thread p)
	{
		try{p.sleep(randSleepTime());}catch(Exception e){}
	}
	
	public Thread tractor(final String farmer, final String notFarmer)
	{
		return new Thread(){
			public void run(){
				int counter=0;
				while(runTime()<1440)
				{	
					try 
					{
						tractorCross(this);
						counter++;
						workinHard(this);							
					} catch (Exception e) {}
					if(counter%2==1)
					{
						System.out.println(farmer+" farmer crossed going "+farmer);
					}
					else
					{
						System.out.println(farmer+" farmer crossed going "+notFarmer);
					}
					
				}
				System.out.println(farmer+" farmer crossed the bridge "+counter+" times");
			}
		};
		
	}
	
	public long runTime()
	{
		return System.currentTimeMillis()-start;
	}
	
	public static void main(String[] args) {
		
		TractorJam t=new TractorJam();
		
	}

}
