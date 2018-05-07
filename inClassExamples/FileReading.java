package inClassExamples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileReading {

	public static void main(String[] args) {
		
		int numFriends=Integer.parseInt(JOptionPane.showInputDialog("How many friends do you have?"));
		String filename = JOptionPane.showInputDialog("Pick a filename to save your friends.");
		filename+=".txt";
		
		try{
			FileWriter fwriter = new FileWriter(filename,true);
			PrintWriter writer = new PrintWriter(fwriter);
			for(int i = 1; i<=numFriends;i++)
			{
				writer.println(JOptionPane.showInputDialog("Enter friend "+(i)));
			}
			writer.close();
			BufferedReader br = new BufferedReader(new FileReader(filename));
			int counter = 0;
			while(br.readLine()!=null)
			{
				counter++;
			}
			JOptionPane.showMessageDialog(null, "You now have a total of "+counter+" friends");
			
		}
		catch(IOException ioe)
		{
			
		}
		

	}

}
