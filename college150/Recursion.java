package college150;

import java.util.Scanner;

import javax.swing.*;

public class Recursion {
	
	public Recursion()
	{
		getUserInput();
	}
	
	public void getUserInput()
	{
		String input="";
		String tempInput = JOptionPane.showInputDialog(null, "Enter a word or phrase to test if it is a Palindrome.");
		input=tempInput.replaceAll(" ", "").replaceAll(",","").replaceAll("/","").replaceAll("-", "").toLowerCase();
		System.err.println(input);
		recursiveDetectPal(input);
		if(iterativeDetectPal(input)==true)
		{
			JOptionPane.showMessageDialog(null, "The phrase '"+ tempInput+"' is a palindrome.");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "The phrase '"+ tempInput+"' is NOT a palindrome.");
		}
	}
	
	public Boolean iterativeDetectPal(String input)
	{
		String reverseString="";
		for(int dex=input.length()-1;dex>=0;dex--)
		{
			char letter=input.charAt(dex);
			reverseString+=letter;
		}
		System.err.println(reverseString);
		if(input.contains(reverseString))
		{
			return true;
		}
		else
			return false;
	}
	
	public Boolean recursiveDetectPal(String input)
	{
		int counter=0;
		String phrase="";
		if(input.length()==counter)
		{
			return false;
		}
		else
		{
			phrase=input.substring(1, input.length())+input.charAt(0);
			recursiveDetectPal(phrase);
			System.err.println(phrase);
			counter++;
			return false;
		}
	}
	
	public static void main(String[] args)
	{
		Recursion newString=new Recursion();
	}

}
