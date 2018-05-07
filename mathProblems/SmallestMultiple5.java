package mathProblems;

public class SmallestMultiple5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long sum=1l;
		Boolean divisor=false;
		Boolean found=false;
		long dex=21l;
		
		while(found!=true)
		{	
			for(long index=1l;index<21l;index++)
			{
				if(dex%index!=0)
				{
					divisor=false;
				}
			}
			if(divisor==true)
			{				
				found=true;
				System.err.println(dex);
			}
			dex++;
			divisor=true;
		}
		System.err.println("no divisor");
	}

}
