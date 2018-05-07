package collegeServer;

import java.util.*;

public class BarberSync {
	public final int CHAIRS=7;
	public final int HAIR_CUT_TIME=10;
	public static int currentCustomers=0;
	public static int randomTime()
	{
		int randomTime=(int)(Math.random()*15);
		return randomTime;
	}
	public static int hairCutTime()
	{
		int randomHairTime=(int)(Math.random()*5+5);
		return randomHairTime;
	}
	public static synchronized void newCustomer()
	{
		if(currentCustomers<7&&currentCustomers>=0)
			currentCustomers++;
	}
	public static synchronized void customerLeft()
	{
		currentCustomers--;
	}
	public static boolean checkForCustomer()
	{
		if(currentCustomers==0)
			return false;
		else 
			return true;
	}
	public static void main(String[] args) {
		Thread customers=new Thread(){
			public void run(){
				while(true)
				{
					try{sleep(randomTime());}catch(Exception e){};
					newCustomer();
				}
			}
		};
		Thread barber=new Thread(){
			public void run(){
				int totalCustomers=0;
				int sleepTime=0;
				long start=System.currentTimeMillis();
				while(System.currentTimeMillis()-start<540)
				{
					if(checkForCustomer()==false)
					{
						long start1=System.currentTimeMillis();
						while(currentCustomers==0)
						{
							System.out.println("Waiting");
						}
						sleepTime+=(System.currentTimeMillis()-start1);
					}
					try{sleep(hairCutTime());}catch(Exception e){};
					System.out.println(currentCustomers);
					totalCustomers++;
					customerLeft();
				}
				System.out.println("The barber cut "+totalCustomers+" people's hair in one day and slept "+sleepTime+" minutes during the day.");
				
			}
		};
		customers.start();
		barber.start();
		while(barber.isAlive())
		{	
		}
		customers.stop();
		
	}

}
