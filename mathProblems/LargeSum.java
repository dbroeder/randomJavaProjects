package mathProblems;

import java.io.BufferedReader;
import java.io.*;

import javax.swing.JFileChooser;

public class LargeSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFileChooser chooser=new JFileChooser();
		int selection=chooser.showOpenDialog(null);
		
		if(selection==JFileChooser.APPROVE_OPTION)
		{
			try{
				File file=chooser.getSelectedFile();
				
				BufferedReader reader=new BufferedReader(new FileReader(file));
				reader.mark(100000);
				String tempLine=reader.readLine();
				//System.err.println(sum);
			}catch(NumberFormatException nfe)
			{
				System.err.print("error");
			}
			catch(IOException io)
			{
				System.err.print("file");
			}
		}
	
	
	}

}
