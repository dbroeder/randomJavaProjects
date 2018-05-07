package mathProblems;

import java.math.BigInteger;

public class CollatzSequence14 {

	/**
	 * @param args
	 */
	
	public static long tempmax=1l;
	public static long recursive(long n)
	{
		if(n==1)
		{
			return tempmax;
		}
		else if(n%2==0)
		{
			tempmax++;
			return recursive((n/2));
		}	
		else
		{
			tempmax++;
			return recursive((3*n+1));
		}
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long Tempmax=0l;
		long max=0l;
		long num=0l;
		for(long dex=2l;dex<1000000l;dex++)
		{
			Tempmax=recursive(dex);
			if(Tempmax>max)
			{
				max=Tempmax;
				num=dex;
			}
			tempmax=1l;
		}
		System.out.print(num);
	}
}
