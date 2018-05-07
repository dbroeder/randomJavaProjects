package mathProblems;

public class Multiples1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum=0;
		for(int dex=0;dex<1000;dex++)
		{
			if(dex%3==0)
			{
				sum+=dex;
			}
			else if(dex%5==0)
			{
				sum+=dex;
			}
		}
		
		System.out.print(sum);

	}

}
