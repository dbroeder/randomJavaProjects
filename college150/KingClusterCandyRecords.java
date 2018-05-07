package college150;

import java.util.*;
import java.io.*;

import javax.swing.*;

/**
 * 
 * @author Dustin Broeder
 *
 */

public class KingClusterCandyRecords {
	
	private static final int MARK_LIMIT=32000;
	private static int[][] companyUnits;
	private static String[] companyNames;
	private static double[] companyPrices;
	
	public static void getFileArray()
	{
		/*
		 * code to search file and create the array taken from 
		 * demo problem in class provided by professor in CSIS150
		 */
		
		System.out.print("Please select a file containing the store locations and monthly sales.\n\n");
		JFileChooser chooser=new JFileChooser();//gets file name
		int status=chooser.showOpenDialog(null);
			
		if(status==JFileChooser.APPROVE_OPTION)
		{
			try
			{
				File file=chooser.getSelectedFile();
				
				BufferedReader inReader = new BufferedReader(new FileReader(file));//reads lines of the file and counts rows and columns 
				inReader.mark(MARK_LIMIT);
				String inLine=inReader.readLine();
				Scanner countScanner = new Scanner(inLine).useDelimiter(",");
				
				countScanner.next();
				int colCount=0;
				while(countScanner.hasNextInt())//counts columns
				{
					colCount++;
					countScanner.nextInt();
				}
				
				int rowCount=0;
				while(inLine != null && !inLine.equals(""))//counts rows
				{
					rowCount++;
					inLine = inReader.readLine();
				}
				inReader.reset();
	
				companyUnits=new int[rowCount][colCount];
				companyNames=new String[rowCount];
				for(int rowIndex = 0; rowIndex<rowCount; rowIndex++)//creates double array for company names and monthly sales
				{
					inLine = inReader.readLine();
					countScanner = new Scanner(inLine).useDelimiter(",");
					companyNames[rowIndex]=countScanner.next();
					for(int colIndex=0; colIndex<colCount;colIndex++)
					{
						companyUnits[rowIndex][colIndex]=countScanner.nextInt();
					}
				}
				
			}catch(IOException ioe)
			{
				System.err.print("\nTrouble reading file");
			}
			return;
		}
		
		System.err.print("\nFile does not exist!\nProcess terminating.");
		System.exit(0);
		
		
	}
	
	public static void getPriceArray()
	{
		/*
		 * Some of the code used below was taken from an example used
		 * in CSIS150.
		 */
		System.out.print("Please select a file containing the store unit prices.\n\n");
		JFileChooser chooser=new JFileChooser();//gets file name
		int status=chooser.showOpenDialog(null);
			
		if(status==JFileChooser.APPROVE_OPTION)
		{
			try
			{
				File file=chooser.getSelectedFile();//opens file
				String filename=file.getPath();
				
				BufferedReader inReader = new BufferedReader(new FileReader(file));
				inReader.mark(MARK_LIMIT);
				String inLine=inReader.readLine();//scans file and counts rows
				Scanner countScanner = new Scanner(inLine).useDelimiter(",");
				
				int rowCount=0;
				while(inLine != null && !inLine.equals(""))//counts rows
				{
					rowCount++;
					inLine = inReader.readLine();
				}
				inReader.reset();
				String[] catchString=new String[rowCount];
				companyPrices=new double[rowCount];
				
				for(int index=0;index<rowCount;index++)//creates company price array
				{
					System.err.println(rowCount);
					inLine = inReader.readLine();
					countScanner = new Scanner(inLine).useDelimiter(",");
					catchString[index]=countScanner.next();
					companyPrices[index]=countScanner.nextDouble();
				}
				
			}catch(IOException ioe)
			{
				System.err.print("\nTrouble reading file");
			}
			return;
		}
		System.err.print("\nFile does not exist!\nProcess terminating.");
	}

 	public static void printMonthlyUnitsWinner()
	{
		int yearlyWinner=0;
		int units=0;
		int companyIndex=0;
		String[] months={"Jan", "Feb", "Mar", "Apr", "May", "Jun", 
				"Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		System.out.print("\nMonth\tStore\t\t#units\n");
		String display="";
		
		for(int month=0;month<12;month++)//output display
		{	
			units=0;
			for(int index=0;index<companyUnits.length;index++)
			{
				if(companyUnits[index][month]>units)//searches highest sales
				{
					units=companyUnits[index][month];
					if(companyNames[index].length()<8)//spaces tabs correctly
					{	
						
					}
					else
					{
						display=months[month]+"\t"+companyNames[index]+"\t"+companyUnits[index][month]+"\n";
					}
						
				}
				if(companyUnits[index][month]>yearlyWinner)//tracks yearly highest monthly sales
				{
					yearlyWinner=companyUnits[index][month];
					companyIndex=index;
				}
			}
			System.out.print(display);			
		}	
		if(companyNames[companyIndex].length()<8)//correct tab alignment
		{	
			System.out.print("\nYear\t"+companyNames[companyIndex]+"\t\t"+yearlyWinner+"\n");
		}
		else
		{
			System.out.print("\nYear\t"+companyNames[companyIndex]+"\t"+yearlyWinner+"\n");
		}
		
	}

	public static void printMonthlySalesWinner()
	{
		double yearlyWinner=0;
		double sales=0;
		int companyIndex=0;
		String[] months={"Jan", "Feb", "Mar", "Apr", "May", "Jun", 
				"Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		System.out.print("\nMonth\tStore\t\tMax Sales\n");
		String display="";
		for(int month=0;month<12;month++)
		{	
			sales=0;
			for(int index=0;index<companyUnits.length;index++)
			{
				double calcSales;
				calcSales=companyUnits[index][month]*companyPrices[index];
				
				if(calcSales>sales)
				{
					sales=calcSales;
					display=months[month]+"\t"+companyNames[index]+"\t\t"+sales+"\n";
					if(companyNames[index].length()<8)
					{	
						display=months[month]+"\t"+companyNames[index]+"\t\t"+companyUnits[index][month]+"\n";
					}
					else
					{
						display=months[month]+"\t"+companyNames[index]+"\t"+companyUnits[index][month]+"\n";
					}
				}
				if(calcSales>yearlyWinner)
				{
					yearlyWinner=calcSales;
					companyIndex=index;
				}
				calcSales=0;
			}
			System.out.print(display);			
		}	
		if(companyNames[companyIndex].length()<8)
		{	
			System.out.print("\nYear\t"+companyNames[companyIndex]+"\t\t"+yearlyWinner+"\n");
		}
		else
		{
			System.out.print("\nYear\t"+companyNames[companyIndex]+"\t"+yearlyWinner+"\n");
		}
		
	}

	public static void printGreetingMessage()
	{
		System.out.print("\nWelcome to King Cluster Candy store records.\n"//opening greeting
				+"\nThis program will take King Cluster Candy stores' locations, monthly sales, and unit prices."
				+"\nThen will calculate the store who sold the most units each month and for the year."
				+"\nFinally it will return who had the highest sales each month and the higest monthly sale for the year. \n\n");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		printGreetingMessage();
		getFileArray();
		getPriceArray();
		printMonthlyUnitsWinner();
		printMonthlySalesWinner();
	}
}
