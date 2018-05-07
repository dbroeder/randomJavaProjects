package workersProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * @broederdj
 */

public class FactoryEmployees {
	private Employee[] employees;
	private final int MARK_LIMIT=32000;
	
	public FactoryEmployees()
	{
		JOptionPane.showMessageDialog(null, "This program will take a file of factory employees and will allow\n"
											+"the user will be able to search the file by first name, last name,\n" +
											"position, and shift. The program will repeat unitl user decides to stop.");
		String fileName=selectFileName("Please select the employee information file.");
		loadEmployeesFromFile(fileName);
		
		processUserResponse(getUserInputFromMenu());
	}	
	
	private String selectFileName(String purpose)//gets the file name location. 
	{
		/*
		 * some code taken from the lab problem provided by Professor Anderson in CSIS 150.
		 */
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
	
	private void loadEmployeesFromFile(String file)
	{
		/*
		 * Some code taken from the lab problem given by Professor Anderson in CSIS 150.
		 */
		try
    	{
    		BufferedReader inReader=new BufferedReader(new FileReader(file));
    		inReader.mark(MARK_LIMIT);
    		String inLine=inReader.readLine();
    		
    		
    		int rowCount=0;
			while(inLine != null && !inLine.equals(""))//counts rows
			{
				rowCount++;
				inLine = inReader.readLine();
			}
			inReader.reset();
			
			employees=new Employee[rowCount];//creates array of Objects
			
			for(int dex=0; dex<rowCount;dex++)//instantiates the array of Objects from file.
			{	
				inLine=inReader.readLine();
				//System.err.print(">>"+inLine+"<<");
				Scanner countScanner= new Scanner(inLine).useDelimiter(",");
				String employeeNumber=countScanner.next();
				Scanner typeScanner=new Scanner(employeeNumber).useDelimiter("_");
				String classifyType=typeScanner.next();
				String firstName=countScanner.next();
				String lastName=countScanner.next();
				String hireDate=countScanner.next();
								
				if(classifyType.equals("PW"))
				{	
					int shift=countScanner.nextInt();
					double payRate=countScanner.nextDouble();
					employees[dex]=new ProductionWorker(employeeNumber,firstName,lastName,hireDate,shift,payRate);
				}
				else if (classifyType.equals("TL"))
				{
					int shift=countScanner.nextInt();
					double payRate=countScanner.nextDouble();
					double bonusRate=countScanner.nextDouble();
					double requiredTrainingHours=countScanner.nextDouble();
					double receivedTrainingHours=countScanner.nextDouble();
					employees[dex]=new TeamLeader(employeeNumber,firstName,lastName,hireDate,shift,payRate,bonusRate,requiredTrainingHours,receivedTrainingHours);
				}
				else if (classifyType.equals("SU"))
				{
					int shift=countScanner.nextInt();
					double annualSalary=countScanner.nextDouble();
					double bonusRate=countScanner.nextDouble();
					employees[dex]=new ShiftSupervisor(employeeNumber,firstName,lastName,hireDate,shift,annualSalary,bonusRate);
				}	
			}	
    	}catch(IOException ioe) 
		{
			JOptionPane.showMessageDialog(null, "Trouble reading file.");
			loadEmployeesFromFile(selectFileName("Please select the employee information file."));
		}
		catch(InputMismatchException e)
		{
			JOptionPane.showMessageDialog(null, "Wrong file. Please select a different file.");
			loadEmployeesFromFile(selectFileName("Please select the employee information file."));
		}
		catch(NoSuchElementException nsee)
		{
			JOptionPane.showMessageDialog(null, "Wrong file. Please select a different file.");
			loadEmployeesFromFile(selectFileName("Please select the employee information file."));
		}
		return;
    }
	
	private String searchFirstName()//method searches file for first names given by user.
	{
		String display="";
		String tempName=JOptionPane.showInputDialog("Enter the first name you want to search");
		String name=tempName.toLowerCase();
		display = "Employees with the first name "+tempName+" are as follows:\n\n";
		for(int dex=0;dex<employees.length;dex++)
		{
			if(employees[dex].getFirstName().toLowerCase().equals(name))
			{
				display+=employees[dex].toString()+"\n";
			}
		}
		JOptionPane.showMessageDialog(null, display);
		Object[] options={"Yes", "No"};
		Object selectedOption=JOptionPane.showInputDialog(null, "Would you like to save the display to a file?", "Save display", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if(selectedOption.equals("Yes"))
		{
			saveDisplayToFile(display);
			processUserResponse(getUserInputFromMenu());
		}
		else 
		{
			processUserResponse(getUserInputFromMenu());
		}
		return display;
	}
	
	private String searchLastName()//method searches file for last name given by user.
	{
		String display="";
		String tempName=JOptionPane.showInputDialog("Enter the last name you want to search");
		String name=tempName.toLowerCase();
		display = "Employees with the last name "+tempName+" are as follows:\n\n";
		for(int dex=0;dex<employees.length;dex++)
		{
			if(employees[dex].getLastName().toLowerCase().equals(name))
			{
				display+=employees[dex].toString()+"\n";
			}
		}
		JOptionPane.showMessageDialog(null, display);
		Object[] options={"Yes", "No"};
		Object selectedOption=JOptionPane.showInputDialog(null, "Would you like to save the display to a file?", "Save display", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if(selectedOption.equals("Yes"))
		{
			saveDisplayToFile(display);
			processUserResponse(getUserInputFromMenu());
		}
		else 
		{
			processUserResponse(getUserInputFromMenu());
		}
		return display;
	}
	
	private String searchOnPosition()//searches file for employees based on position they work.
	{
		String display="";
		Object[] positions={"Production Worker", "Shift Supervisor", "Team Leader"};
		Object selectedPosition = JOptionPane.showInputDialog(null, "Choose one", "Input", JOptionPane.INFORMATION_MESSAGE, null, positions, positions[0]);
		String inputPosition=selectedPosition.toString();
		if(inputPosition.equals("Production Worker"))
		{
			display = "Employees who are production workers are as follows:\n\n";
			for(int dex=0;dex<employees.length;dex++)
			{
				if(employees[dex] instanceof ProductionWorker)
				{
					display+=((ProductionWorker)employees[dex]).toString()+"\n";
				}
			}
			JOptionPane.showMessageDialog(null, display);
			Object[] options={"Yes", "No"};
			Object selectedOption=JOptionPane.showInputDialog(null, "Would you like to save the display to a file?", "Save display", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if(selectedOption.equals("Yes"))
			{
				saveDisplayToFile(display);
				processUserResponse(getUserInputFromMenu());
			}
			else 
			{
				processUserResponse(getUserInputFromMenu());
			}
		}
		else if(inputPosition.equals("Shift Supervisor"))
		{
			display = "Employees who are shift supervisors are as follows:\n\n";
			for(int dex=0;dex<employees.length;dex++)
			{
				if(employees[dex] instanceof ShiftSupervisor)
				{
					display+=((ShiftSupervisor)employees[dex]).toString()+"\n";
				}
			}
			JOptionPane.showMessageDialog(null, display);
			Object[] options={"Yes", "No"};
			Object selectedOption=JOptionPane.showInputDialog(null, "Would you like to save the display to a file?", "Save display", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if(selectedOption.equals("Yes"))
			{
				saveDisplayToFile(display);
				processUserResponse(getUserInputFromMenu());
			}
			else 
			{
				processUserResponse(getUserInputFromMenu());
			}
		}
		else
		{
			display = "Employees who are team leaders are as follows:\n\n";
			for(int dex=0;dex<employees.length;dex++)
			{
				if(employees[dex] instanceof TeamLeader)
				{
					display+=((TeamLeader)employees[dex]).toString()+"\n";
				}
			}
			JOptionPane.showMessageDialog(null, display);
			Object[] options={"Yes", "No"};
			Object selectedOption=JOptionPane.showInputDialog(null, "Would you like to save the display to a file?", "Save display", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if(selectedOption.equals("Yes"))
			{
				saveDisplayToFile(display);
				processUserResponse(getUserInputFromMenu());
			}
			else 
			{
				processUserResponse(getUserInputFromMenu());
			}
		}
		return display;
	}
	
	private String searchOnShift()//searches file for employees working a certain shift.
	{
		String display="";
		Object[] shifts={"8am-2pm", "2pm-8pm", "8pm-2am", "2am-8am"};
		Object selectedShift = JOptionPane.showInputDialog(null, "Choose a shift:", "Input", JOptionPane.INFORMATION_MESSAGE, null, shifts, shifts[0]);
		String tempShift=selectedShift.toString();
		display = "Employees who work "+tempShift+" are as follows:\n\n";
		if(tempShift.equals("8am-2pm"))
		{
			for(int dex=0;dex<employees.length;dex++)
			{
				if(employees[dex] instanceof ProductionWorker||employees[dex]instanceof ShiftSupervisor)
				{
					if(employees[dex]instanceof ShiftSupervisor)
					{
						if(((ShiftSupervisor)employees[dex]).getShift()==1)
						{
							display+="*"+((ShiftSupervisor)employees[dex]).toString()+"\n";
						}
					}
					else
					{
						if(((ProductionWorker)employees[dex]).getShift()==1)
						{	
							display+=((ProductionWorker)employees[dex]).toString()+"\n";
						}
					}						
				}						
			}
			JOptionPane.showMessageDialog(null, display);
			Object[] options={"Yes", "No"};
			Object selectedOption=JOptionPane.showInputDialog(null, "Would you like to save the display to a file?", "Save display", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if(selectedOption.equals("Yes"))
			{
				saveDisplayToFile(display);
				processUserResponse(getUserInputFromMenu());
			}
			else 
			{
				processUserResponse(getUserInputFromMenu());
			}
		}
		else if(tempShift.equals("2pm-8pm"))
		{
			for(int dex=0;dex<employees.length;dex++)
			{
				if(employees[dex] instanceof ProductionWorker||employees[dex]instanceof ShiftSupervisor)
				{
					if(employees[dex]instanceof ShiftSupervisor)
					{
						if(((ShiftSupervisor)employees[dex]).getShift()==2)
						{
							display+="*"+((ShiftSupervisor)employees[dex]).toString()+"\n";
						}
					}
					else
					{
						if(((ProductionWorker)employees[dex]).getShift()==2)
						{	
							display+=((ProductionWorker)employees[dex]).toString()+"\n";
						}
					}						
				}						
			}
			JOptionPane.showMessageDialog(null, display);
			Object[] options={"Yes", "No"};
			Object selectedOption=JOptionPane.showInputDialog(null, "Would you like to save the display to a file?", "Save display", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if(selectedOption.equals("Yes"))
			{
				saveDisplayToFile(display);
				processUserResponse(getUserInputFromMenu());
			}
			else 
			{
				processUserResponse(getUserInputFromMenu());
			}
		}
		else if(tempShift.equals("8pm-2am"))
		{
			for(int dex=0;dex<employees.length;dex++)
			{
				if(employees[dex] instanceof ProductionWorker||employees[dex]instanceof ShiftSupervisor)
				{
					if(employees[dex]instanceof ShiftSupervisor)
					{
						if(((ShiftSupervisor)employees[dex]).getShift()==3)
						{
							display+="*"+((ShiftSupervisor)employees[dex]).toString()+"\n";
						}
					}
					else
					{
						if(((ProductionWorker)employees[dex]).getShift()==3)
						{	
							display+=((ProductionWorker)employees[dex]).toString()+"\n";
						}
					}						
				}						
			}
			JOptionPane.showMessageDialog(null, display);
			Object[] options={"Yes", "No"};
			Object selectedOption=JOptionPane.showInputDialog(null, "Would you like to save the display to a file?", "Save display", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if(selectedOption.equals("Yes"))
			{
				saveDisplayToFile(display);
				processUserResponse(getUserInputFromMenu());
			}
			else 
			{
				processUserResponse(getUserInputFromMenu());
			}
		}
		else if(tempShift.equals("2am-8am"))
		{
			for(int dex=0;dex<employees.length;dex++)
			{
				if(employees[dex] instanceof ProductionWorker||employees[dex]instanceof ShiftSupervisor)
				{
					if(employees[dex]instanceof ShiftSupervisor)
					{
						if(((ShiftSupervisor)employees[dex]).getShift()==4)
						{
							display+="*"+((ShiftSupervisor)employees[dex]).toString()+"\n";
						}
					}
					else
					{
						if(((ProductionWorker)employees[dex]).getShift()==4)
						{	
							display+=((ProductionWorker)employees[dex]).toString()+"\n";
						}
					}
				}
			}
			JOptionPane.showMessageDialog(null, display);
			Object[] options={"Yes", "No"};
			Object selectedOption=JOptionPane.showInputDialog(null, "Would you like to save the display to a file?", "Save display", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if(selectedOption.equals("Yes"))
			{
				saveDisplayToFile(display);
				processUserResponse(getUserInputFromMenu());
			}
			else 
			{
				processUserResponse(getUserInputFromMenu());
			}
		}	
		return display;
	}
	
	private void saveDisplayToFile(String display)
	{
		JFileChooser file=new JFileChooser();
		file.setDialogTitle("Enter file name to save.");
		file.showSaveDialog(null);
		File getFile=file.getSelectedFile();
		if(getFile==null)
		{
			JOptionPane.showMessageDialog(null,"No name selected.\nReturn to main scree.");
			processUserResponse(getUserInputFromMenu());
		}
		
		try
		{
			FileWriter outWriter=new FileWriter(getFile);
			outWriter.write(display);
			outWriter.close();
		}
		catch(IOException ioe)
		{
			JOptionPane.showMessageDialog(null, "Error writing file.\nReturning to main screen.");
			processUserResponse(getUserInputFromMenu());
		}
	}
	
	private void processUserResponse(String response)//processes given request of user.
	{
		try
		{
			String display="";
			if(response.equals("f"))
			{
				searchFirstName();
			}
			else if(response.equals("l"))
			{
				searchLastName();
			}
			else if(response.equals("p"))
			{
				searchOnPosition();
			}
			else if(response.equals("s"))
			{
				searchOnShift();
			}
			else if(response.equals("a"))
			{
				JOptionPane.showMessageDialog(null, toString());
				Object[] options={"Yes", "No"};
				Object selectedOption=JOptionPane.showInputDialog(null, "Would you like to save the display to a file?", "Save display", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if(selectedOption.equals("Yes"))
				{
					saveDisplayToFile(display);
					processUserResponse(getUserInputFromMenu());
				}
				else 
				{
					processUserResponse(getUserInputFromMenu());
				}
			}
			else if(response.equals("q"))
			{
				JOptionPane.showMessageDialog(null,"Thank you for running this program.\nProgram is now terminating.");
				System.exit(0);
			}
		}catch(NullPointerException npe)
		{
			JOptionPane.showMessageDialog(null, "Error with file.\nProgram in now terminating.");
			System.exit(0);
		}	
	}
	
	private String getUserInputFromMenu()//gives user prompt to select option.
	{
		try
		{	
			String userInput=JOptionPane.showInputDialog("To search the file, input one of the following characters:" +
					"\n\n'f' for first name\n'l' for last name\n'p' for position\n's' for shift\n'a' for all employees\n'q' for quit");
			String input=userInput.toLowerCase();
				if(input.equals("f")||input.equals("l")||input.equals("p")||input.equals("s")||input.equals("q")||input.equals("a"))
				{
					return input;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid entry");
					processUserResponse(getUserInputFromMenu());
				}
		}catch(NullPointerException npe)
		{
			JOptionPane.showMessageDialog(null, "Exiting Program");
			System.exit(0);
		}
		return null;
	}
	
	public String toString()//gives a print out of all employees.
	{
		String display="";
		display="Here is a list of all Employees.\n\n";
		for(int dex=0;dex<employees.length;dex++)
		{
			if(employees[dex] instanceof ShiftSupervisor)
			{
				display+=((ShiftSupervisor)employees[dex]).toString()+"\n";
			}
		}
		for(int dex=0;dex<employees.length;dex++)
		{
			if(employees[dex] instanceof TeamLeader)
			{
				display+=((TeamLeader)employees[dex]).toString()+"\n";
			}
		}
		for(int dex=0;dex<employees.length;dex++)
		{
			if(employees[dex] instanceof ProductionWorker && !(employees[dex] instanceof TeamLeader))
			{
				display+=((ProductionWorker)employees[dex]).toString()+"\n";
			}
		}
		return display;
	}
	
	 public static void main(String[] args)//main method
	 {
		 FactoryEmployees allEmployees=new FactoryEmployees();
	 }
	
	
}
