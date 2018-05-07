package mathProblems;

public class Palindrome4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer sum=new Integer(0);
		String palindrome="";
		String reverseString="";
		int max=0;
		for(int dex=100;dex<1000;dex++)
		{
			for(int dex2=100;dex2<1000;dex2++)
			{
				sum=dex*dex2;
				System.err.print(sum);
				palindrome=sum.toString();
				reverseString=new StringBuffer(palindrome).reverse().toString();
				if(reverseString.compareTo(palindrome)==0)
				{
					if(max<sum)
						max=sum;
				}
			}
		}
		System.out.print(max);
	}

}
