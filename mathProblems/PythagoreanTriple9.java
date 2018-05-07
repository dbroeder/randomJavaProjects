package mathProblems;

public class PythagoreanTriple9 {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int product=1;
		for(int c=500;c>0;c--)
		{
			for(int a=1;a<500;a++)
			{
				for(int b=1;b<500;b++)
				{
					if(a*a+b*b==c*c)
					{
						if(a+b+c==1000)
						{
							product=a*b*c;
							System.err.print(product);
							System.exit(0);
						}
					}
				}
			}
		}
	
	}
}
