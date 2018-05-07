package inClassExamples;
import java.io.*;
import javax.swing.*;

public class JFileChooserExample {

	public static void main(String[] args)throws IOException {
		
		String friendName;// stores friend names
		int numFriends; // Number of Friends
		File file;// Creates File object
		FileWriter fwriter;// Creates object to write files.
		PrintWriter outputFile;// Creates object to write files.
		// Creates object to help user pick existing files easier
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Pick a File With Names");// Sets the saying at
															// the very top of
															// the window
		int status = chooser.showOpenDialog(null);// Displays the window
		if (status == JFileChooser.APPROVE_OPTION) 
		{
			file = chooser.getSelectedFile();// connects the file to the program
			// Open the file
			fwriter = new FileWriter(file, true);// appends data to an existing
													// document
			outputFile = new PrintWriter(fwriter);
			// gets number of friends user has
			numFriends = Integer.parseInt(JOptionPane.showInputDialog("How many friends do you have?"));
			for (int dex = 0; dex < numFriends; dex++) {
				friendName = JOptionPane.showInputDialog("Enter the name of friend number " + (dex + 1));
				// Prints names to file
				outputFile.println(friendName);
			}
			// closes and saves file
			outputFile.close();
			JOptionPane.showMessageDialog(null, "Your file is now ready to view.");
			BufferedReader br = new BufferedReader(new FileReader(file));
			int counter = 0;
			while (br.readLine() != null) {
				counter++;
			}
			JOptionPane.showMessageDialog(null, "You now have a total of " + counter + " friends.");
			br.close();
		}
		int test1=90;
		int test2=93;
		int average = (test1+test2)/2;
		System.out.print(average);
	}

}
