package mathProblems;

public class SumSquareDifference6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sumOfSquares=0;
		int sum=0;
		int total=0;
		int difference=0;
		for(int dex=1;dex<=100;dex++)
		{
			sumOfSquares+=dex*dex;
			sum+=dex;			
		}
		total=sum*sum;
		difference=total-sumOfSquares;
		System.out.print(difference);
		
		
		
	}

}
