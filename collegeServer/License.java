package collegeServer;

public class License {
	public static Thread t;
	public static void sum()
	{
		
		int sum=0;
		for(int i=0;i<100;i++)
		{
			sum+=i;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Manager manager=new Manager();
		final long SLEEP_TIME=10l;
		while(true)
		{
			
			System.out.println(manager.getResources());
			t=new Thread(){
				public void run(){
						manager.decreaseCount(1);
						sum();
						try {
							sleep(SLEEP_TIME);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						manager.increaseCount(1);
				}
			};
			System.out.println("Starting new thread");
			t.start();
			try{Thread.sleep(1);}catch(Exception e){}
			
		}
	}

}
