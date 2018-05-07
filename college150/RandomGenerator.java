package college150;
import java.util.*;

public class RandomGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int heads=0;
		int tails=0;
		Random rand=new Random();
		for(int dex=0;dex<100;dex++)
		{
			System.out.println();
			int newHeads=0;
			for(int numDex=0;numDex<6;numDex++)
			{
				
				String character;
				Integer ints=new Integer(rand.nextInt()+Integer.MAX_VALUE);
				character=ints.toString();
				if(character.substring(numDex, numDex+1).startsWith("-"))
				{
					int num=Integer.parseInt(character.substring(numDex+1, numDex+2));
					if(num%2==0)
					{
						tails++;
					}
					else if(num%2==1)
					{
						newHeads++;
					}
				}
				else
				{
					int num=Integer.parseInt(character.substring(numDex, numDex+1));
					if(num%2==0)
					{
						tails++;
					}
					else if(num%2==1)
					{
						newHeads++;
					}
				}
				System.out.println("One toss Heads: "+newHeads);
				
				
			}
		}
		System.out.print("Heads: "+heads+"\nTails: "+tails);
		
	}

}
