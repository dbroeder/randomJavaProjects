package mathProblems;

public class Fibbonicci2 {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total=2;
		int sum=0;
		int sum1=1;
		int sum2=2;
		while(sum<4000000)
		{
			sum=sum1+sum2;
			sum1=sum2;
			sum2=sum;
			if(sum%2==0)
			{
				total+=sum;
			}
		}
		System.out.print(total);
		
		
	}

}
