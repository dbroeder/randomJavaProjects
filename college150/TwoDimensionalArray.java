package college150;
import java.util.*;
import java.io.*;


public class TwoDimensionalArray {
	
	private static final int MARK_LIMIT = 32000;
	
	public static int[][] loadArrayFromFile(String fileName)
	{
		File inFile = new File(fileName);
		if(inFile.exists())
		{
			try
			{
				BufferedReader inReader = new BufferedReader(new FileReader(inFile));
				inReader.mark(MARK_LIMIT);
				String inLine=inReader.readLine();
				Scanner countScanner = new Scanner(inLine).useDelimiter(",");
				int colCount=0;
				
				while(countScanner.hasNextInt())
				{
					colCount++;
					countScanner.next();
				}
				
				int rowCount=0;
				while(inLine != null && !inLine.equals(""))
				{
					rowCount++;
					inLine = inReader.readLine();
				}
				inReader.reset();
				
				int[][] nums=new int[rowCount][colCount];
				for(int rowIndex = 0; rowIndex<colCount; rowIndex++)
				{
					inLine = inReader.readLine();
					countScanner = new Scanner(inLine).useDelimiter(",");
					for(int colIndex=0; colIndex<colCount;colIndex++)
					{
						nums[rowIndex][colIndex]=countScanner.nextInt();
					}
				}
				return nums;
			}catch(IOException ioe)
			{
				System.err.print("\nTrouble reading file: "+ fileName);
			}
		}
		System.err.print("\n"+fileName+" does not exist!\nProcess terminating.");
		return null;
	}
	
	public static void displayArray(int[][] intArray,double avgRow)
	{
		System.err.print("\nContent of array:");
		for(int rowIndex=0;rowIndex<intArray.length;rowIndex++)
		{
			System.err.print("\n");
			for(int colIndex=0;colIndex<intArray[rowIndex].length;colIndex++)
			{
				System.err.print(intArray[rowIndex][colIndex]+"\t");
			}
			System.err.print(avgRow);
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileName=("Experimental Numbers");
		int[][]numArray=loadArrayFromFile(fileName);
		if(numArray==null)
		{
			System.exit(0);
		}
		System.err.print("File name: "+fileName);
		//displayArray(numArray);
		
		

	}

}
