package inClassExamples;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class HelloWorld {

	public static void main(String[] args) {
		try{
			File file = new File("HighSchores.txt");
			PrintWriter writer = new PrintWriter(file);
			
			writer.println("Hello my name is Dustin\nMy favorite events are as follows");
			writer.println("\tGolf");
			writer.close();
		}catch(IOException ioe)
		{
			
		}
		
	}

}
