package college150;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.*;

/*
 * @author Dustin Broeder
 */

public class RecursionExercise {
	
	private String binaryStr="0";
	private double number=0;
	private final int MARK_LIMIT=32000;
	private int exp=31;
	private int[] numArray;
	private int min=0;
	
	public RecursionExercise()//constructor
	{
		JOptionPane.showMessageDialog(null,"This program can take a binary string of 1's and 0's and will \n"
										+"return the decimal representation of the number. It will also take\n" +
										"an integer and will return the binary representation.\n" +
										"Finally, it will accept an array of integers from a file and will" +
										"return the lowest value in the set.");
		getUserInput();
	}
	
	public void getUserInput()//gets the user input and processes the request.
	{
		try
		{
			Object[]options={"Input binary string","Input integer","Select a set of integers from file"};
			Object selectedOption = JOptionPane.showInputDialog(null, "Choose one", "Input", JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			if(selectedOption.equals(options[0]))
			{
				String binaryString=JOptionPane.showInputDialog(null,"Enter a binary string of 1's and 0's.");
				if(binaryString.contains("0")||binaryString.contains("1"))
				{
					JOptionPane.showMessageDialog(null,"The binary string "+ binaryString+" equals "+interpretBinaryString(binaryString));
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid input. \nPlease try again.");
					getUserInput();
				}
			}
			else if(selectedOption.equals(options[1]))
			{
				String userStr=JOptionPane.showInputDialog(null,"Enter a positive integer to be converted to binary.");
				long userNum=Integer.parseInt(userStr);
				if(userNum>=0)
				{
					JOptionPane.showMessageDialog(null,"The number "+userNum+" is "+shrinkBinaryString(generateBinaryString(userNum))+" as a binary string.");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid input.\nTry agian.");
					getUserInput();
				}
			}
			else if(selectedOption.equals(options[2]))
			{
				String fileName=selectFileName("Please select a file of integers.");
				loadArrayFromFile(fileName);
				JOptionPane.showMessageDialog(null,"The minimum value in the set of integers is "+findMinimumElement(0));
				
			}
		}
		catch(NullPointerException npe)
		{
			JOptionPane.showMessageDialog(null, "Program terminating.");
			System.exit(0);
		}
		catch(NumberFormatException nfe)
		{
			JOptionPane.showMessageDialog(null,"Invalid Input.\n Try again.");
			getUserInput();
		}
		
	}
	
	public String selectFileName(String purpose)//gets the file name location of the array of numbers.
	{
		String fileName="";
		JFileChooser chooser=new JFileChooser("");
		chooser.setDialogTitle(purpose);
		int returnValue=chooser.showOpenDialog(null);
		if(returnValue==JFileChooser.APPROVE_OPTION)
		{
			fileName=chooser.getSelectedFile().getAbsolutePath();
		}
		else
		{
			JOptionPane.showMessageDialog(null,"No file was chosen. Program terminating.");
			System.exit(0);
		}
		return fileName;
	}
	
	public void loadArrayFromFile(String file)//loads the array from the file.
	{
		try
    	{
    		BufferedReader inReader=new BufferedReader(new FileReader(file));
    		inReader.mark(MARK_LIMIT);
    		String inLine=inReader.readLine();
    		
    		
    		int counter=0;
    		Scanner countScanner= new Scanner(inLine).useDelimiter(",");
			while(inLine != null && !inLine.equals(""))//counts number of integers in array
			{
				counter++;
				inLine = inReader.readLine();
			}
			inReader.reset();
			numArray=new int[counter];
			
			for(int dex=0;dex<counter;dex++)
			{
				String line=inReader.readLine();
				numArray[dex]=Integer.parseInt(line);				
			}
    	}catch(IOException ioe) 
		{
			JOptionPane.showMessageDialog(null, "Trouble reading file.");
			loadArrayFromFile(selectFileName("Please select a file of integers."));
		}
		catch(InputMismatchException e)
		{
			JOptionPane.showMessageDialog(null, "Wrong file. Please select a different file.");
			loadArrayFromFile(selectFileName("Please select a file of integers."));
		}
		catch(NoSuchElementException nsee)
		{
			JOptionPane.showMessageDialog(null, "Wrong file. Please select a different file.");
			loadArrayFromFile(selectFileName("Please select a file of integers."));
		}
	}
	
 	public double interpretBinaryString(String binary)//recursive method that takes a binary string and returns its number.
	{
		if(binary.length()<1)
		{
			return number;
		}
		else
		{
			if(binary.charAt(0)=='1')
			{
				double value=Math.pow(2, binary.length()-1);
				number+=value;
				return interpretBinaryString(binary.substring(1));
			}
			else if(binary.charAt(0)=='0')
			{
				return interpretBinaryString(binary.substring(1));
			}
			else 
			{
				JOptionPane.showMessageDialog(null,"Invalid input! \nPlease try again.");
				getUserInput();
			}
			return interpretBinaryString(binary.substring(1));
		}		
	}
	
	public String generateBinaryString(long num)//recursive method that takes a number and returns its binary representation.
	{		
		if(exp<0)
		{
			return binaryStr;
		}
		else
		{
			if(num>=getExponentialValue(exp))
			{
				binaryStr+="1";
				long sum=num-getExponentialValue(exp);
				exp--;
				return generateBinaryString(sum);
			}
			else
			{
				binaryStr+="0";
				exp--;
				return generateBinaryString(num);
			}				
		}
		
	}
	
	private String shrinkBinaryString(String binary)//this method gets rid of all extra zeros at the beginning of the binary string.
	{
		if(binary.length()==0)
		{
			return binary;
		}
		else if(binary.charAt(0)=='0')
		{
			return shrinkBinaryString(binary.substring(1));
			
		}
		else
		{
			return binary;
		}
	}
	
 	private long getExponentialValue(int x)//this method calculates the powers of two and is used in the interpretBinaryString method.
	{
		double power=Math.pow(2,x);
		return (long)power;
	}
	
	public int findMinimumElement(int nums)
	{
		if(numArray.length==nums)
		{
			return min;
		}
		else if(numArray[nums]<min)
		{
			min=numArray[nums];
			nums++;
			return findMinimumElement(nums);
		}
		else
		{
			nums++;
			return findMinimumElement(nums);
		}
	
	}
	
	 public static void main(String[] args)//main method
	 {
		 RecursionExercise myExercise=new RecursionExercise();
	 }

}
