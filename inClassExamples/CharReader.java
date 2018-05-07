package inClassExamples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class CharReader {

	public static void main(String[] args) {
		String filename = JOptionPane.showInputDialog("Enter in a filename with text");
		filename+=".txt";
		char userchar = JOptionPane.showInputDialog("Enter a character to match").toLowerCase().charAt(0);
		try{
			FileReader file = new FileReader(filename);
			BufferedReader br = new BufferedReader(file);
			int counter = 0;
			while(br.readLine()!=null)
			{
				counter++;
			}
			br.close();
			file = new FileReader(filename);
			br=new BufferedReader(file);
			if(counter==0)
			{
				JOptionPane.showMessageDialog(null, "Oops, please enter a file with text in it.","Error",JOptionPane.ERROR_MESSAGE);
			}
			else{
				int charcounter =0;
				for(int index = 0; index<counter;index++)
				{
					String line = br.readLine().toLowerCase();
					for(int dex=0;dex<line.length();dex++)
					{
						if(line.charAt(dex)==userchar)
						{
							charcounter++;
						}
					}
					
					
				}
				JOptionPane.showMessageDialog(null, "The character "+ userchar+" is found "+charcounter+" times in the file.");
			}
			
		}catch(IOException ioe)
		{
			ioe.printStackTrace();
			JOptionPane.showMessageDialog(null, "File does not exist","Oops",JOptionPane.ERROR_MESSAGE);
		}

	}

}
