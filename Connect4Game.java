package assign_4_broederdj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Connect4Game {
	
	private int playCounter=0;
	private int[][] scores;
	private final int ROWS=12;
	private final int COLUMNS=9;
	Connect4Display display;
	String player1, player2,highScorePlayer, saveGame,highScoreString;
	private int highScore;
	private final int MARK_LIMIT=30000;
	private File file;
	Token things[][];
	
	
	public Connect4Game()
	{
		resetGame();
		
		//check4Win();
	}
	
	public void loadSavedGame()
	{
		JFileChooser chooser=new JFileChooser();//gets file name
		chooser.setDialogTitle("Please select a file containing your previously saved game");
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
	
				
				player1=countScanner.next();
				player2=countScanner.next();
				String playCounterString=countScanner.next();
				playCounter=Integer.parseInt(playCounterString);
				
				for(int rowIndex = 0; rowIndex<ROWS; rowIndex++)//creates double array for company names and monthly sales
				{	
					inLine = inReader.readLine();
					countScanner = new Scanner(inLine).useDelimiter(",");
					for(int colIndex=0; colIndex<COLUMNS;colIndex++)
					{
						String count=countScanner.next();
						scores[rowIndex][colIndex]=Integer.parseInt(count);
					}
				}
				
			}catch(IOException ioe)
			{
				System.err.print("\nTrouble reading file");
			}
			catch(NullPointerException npe)
			{
				
			}
			catch(NoSuchElementException nse){
				JOptionPane.showMessageDialog(null, "Error Reading File.");
			}
		}
	
		
		
		if(highScore>playCounter)
		{
			
		}
	}
	
	public void saveHighScore()
	{		
		try
		{
			FileWriter outWriter=new FileWriter(file);
			outWriter.write(highScoreString);
			outWriter.close();
		}
		catch(IOException ioe)
		{
			JOptionPane.showMessageDialog(null, "Error writing file.\nReturning to main screen.");
			
		}
		catch(NullPointerException npe)
		{
			
		}
	}
	
	public void loadHighScore()
	{
		file=new File("highScore.txt");
		if(file.exists())
		{
			try
			{
				file.getAbsolutePath();
				BufferedReader inReader=new BufferedReader(new FileReader(file));
				inReader.mark(MARK_LIMIT);
				String inLine=inReader.readLine();
				Scanner scanner=new Scanner(inLine).useDelimiter(",");
				highScorePlayer=scanner.next();
				String score=scanner.next();
				highScore=Integer.parseInt(score);
			}
			catch(IOException ioe)
			{
				
			}
			catch(NullPointerException npe)
			{
				
			}
		}
		else
		{
			highScore=0;
			JOptionPane.showMessageDialog(null, "No saved best scores. \nYou have the new best score!!");
		}
	}
	
	public void resetHighScore()
	{
		highScore=0;
		highScorePlayer=" ";
		highScoreString=highScorePlayer+","+highScore;
		try
		{
			FileWriter outWriter=new FileWriter(file);
			outWriter.write(highScoreString);
			outWriter.close();
		}
		catch(IOException ioe)
		{
			JOptionPane.showMessageDialog(null, "Error writing file.\nReturning to main screen.");
			
		}
		catch(NullPointerException npe)
		{
			
		}
	}
	
	public void displayHighScore()
	{
		JOptionPane.showMessageDialog(null,highScorePlayer+" has the best score of "+highScore);
	}
	
	public void checkHighScore(String player)
	{
		highScorePlayer=player;
		loadHighScore();
		if(highScore==0)
		{
			highScore=playCounter;
			highScoreString=player+","+highScore;
			saveHighScore();
			JOptionPane.showMessageDialog(null, "Congratulations "+player+"!! You have the new high score of: "+highScore);
		}
		else if(playCounter<highScore)
		{
			highScore=playCounter;
			highScoreString=player+","+highScore;
			saveHighScore();
			JOptionPane.showMessageDialog(null, "Congratulations "+player+"!! You have the new high score of: "+highScore);
		}
	}
	
	public void setPlayer1Name()
	{
		player1=JOptionPane.showInputDialog(null,"Enter Player 1's name.");
		if(player1==null)
		{
			player1="Player 1";
		}
		else if(player1.equals(""))
		{
			player1="Player 1";
		}
	}
	
	public String getPlayer1Name()
	{
		return player1;
	}
	
	public void setPlayer2Name()
	{
		player2=JOptionPane.showInputDialog(null,"Enter Player 2's name.");
		if(player2==null)
		{
			player2="Player 2";
		}
		else if(player2.equals(""))
		{
			player2="Player 2";
		}
	}
	
	public String getPlayer2Name()
	{
		return player2;
	}
	
	public void printScoresDisplay()
	{
		saveGame="";
		saveGame+=player1+","+player2+","+playCounter+"\n";
		for(int rowDex=0; rowDex<ROWS; rowDex++)
		{
			for(int colDex=0; colDex<COLUMNS; colDex++)
			{
				saveGame+=scores[rowDex][colDex];
				if(colDex<COLUMNS-1)
				{
					saveGame+=",";
				}
			}
			saveGame+="\n";
		}
		System.err.print(saveGame);
	}
	
	public void resetGame()
	{
		scores=new int[ROWS][COLUMNS];
		for(int rowDex=0; rowDex<ROWS; rowDex++)
		{
			for(int colDex=0; colDex<COLUMNS; colDex++)
			{
				scores[rowDex][colDex]=0;
			}
		}
	}
	
	public int check4Win()
	{
		
		for(int rowDex=0;rowDex<ROWS-3;rowDex++)
		{
			for(int colDex=0;colDex<COLUMNS-3;colDex++)
			{
				if(scores[rowDex][colDex]==1&&scores[rowDex+1][colDex+1]==1&&scores[rowDex+2][colDex+2]==1&&scores[rowDex+3][colDex+3]==1)
				{
					checkHighScore(player1);
					int ans=JOptionPane.showConfirmDialog(null, "Congratulations! "+player1+" wins!!!\nWould you like to replay?", "Yay!!", JOptionPane.YES_NO_OPTION);
					
					return ans;
					
				}
				else if(scores[rowDex][colDex]==2&&scores[rowDex+1][colDex+1]==2&&scores[rowDex+2][colDex+2]==2&&scores[rowDex+3][colDex+3]==2)
				{
					checkHighScore(player2);
					int ans=JOptionPane.showConfirmDialog(null, "Congratulations! "+player2+" wins!!!\nWould you like to replay?", "Yay!!", JOptionPane.YES_NO_OPTION);
					
					return ans;				}
			}
		}
		
		for(int rowDex=11;rowDex>=3;rowDex--)
		{
			for(int colDex=0;colDex<COLUMNS-3;colDex++)
			{
				if(scores[rowDex][colDex]==1&&scores[rowDex-1][colDex+1]==1&&scores[rowDex-2][colDex+2]==1&&scores[rowDex-3][colDex+3]==1)
				{
					checkHighScore(player1);
					int ans=JOptionPane.showConfirmDialog(null, "Congratulations! "+player1+" wins!!!\nWould you like to replay?", "Yay!!", JOptionPane.YES_NO_OPTION);
					
					return ans;				
				}
				else if(scores[rowDex][colDex]==2&&scores[rowDex-1][colDex+1]==2&&scores[rowDex-2][colDex+2]==2&&scores[rowDex-3][colDex+3]==2)
				{
					checkHighScore(player2);
					int ans=JOptionPane.showConfirmDialog(null, "Congratulations! "+player2+" wins!!!\nWould you like to replay?", "Yay!!", JOptionPane.YES_NO_OPTION);
					
					return ans;								
				}
			}
		}
		
		for(int rowDex=0;rowDex<ROWS;rowDex++)
		{
			for(int colDex=0;colDex<COLUMNS-3;colDex++)
			{
				if(scores[rowDex][colDex]==1&&scores[rowDex][colDex+1]==1&&scores[rowDex][colDex+2]==1&&scores[rowDex][colDex+3]==1)
				{
					checkHighScore(player1);
					int ans=JOptionPane.showConfirmDialog(null, "Congratulations! "+player1+" wins!!!\nWould you like to replay?", "Yay!!", JOptionPane.YES_NO_OPTION);
					
					return ans;				
				}
				else if(scores[rowDex][colDex]==2&&scores[rowDex][colDex+1]==2&&scores[rowDex][colDex+2]==2&&scores[rowDex][colDex+3]==2)
				{
					checkHighScore(player2);
					int ans=JOptionPane.showConfirmDialog(null, "Congratulations! "+player2+" wins!!!\nWould you like to replay?", "Yay!!", JOptionPane.YES_NO_OPTION);
					
					return ans;									
				}
			}
		}
		
		for(int rowDex=0;rowDex<ROWS-3;rowDex++)
		{
			for(int colDex=0;colDex<COLUMNS;colDex++)
			{
				if(scores[rowDex][colDex]==1&&scores[rowDex+1][colDex]==1&&scores[rowDex+2][colDex]==1&&scores[rowDex+3][colDex]==1)
				{
					checkHighScore(player1);
					int ans=JOptionPane.showConfirmDialog(null, "Congratulations! "+player1+" wins!!!\nWould you like to replay?", "Yay!!", JOptionPane.YES_NO_OPTION);
					
					return ans;					
				}
				else if(scores[rowDex][colDex]==2&&scores[rowDex+1][colDex]==2&&scores[rowDex+2][colDex]==2&&scores[rowDex+3][colDex]==2)
				{
					checkHighScore(player2);
					int ans=JOptionPane.showConfirmDialog(null, "Congratulations! "+player2+" wins!!!\nWould you like to replay?", "Yay!!", JOptionPane.YES_NO_OPTION);
					
					return ans;	
				}
			}
		}
		if(playCounter==(ROWS*COLUMNS))
		{
			return JOptionPane.showConfirmDialog(null, "No more valid moves. The Game is a tie.\nWould you like to replay?", "Yay!!", JOptionPane.YES_NO_OPTION);
		}
		return 3;
	}
	
	public void saveGameToFile()
	{
		JFileChooser file=new JFileChooser();
		file.setDialogTitle("Enter file name to save.");
		file.showSaveDialog(null);
		File getFile=file.getSelectedFile();
		if(getFile==null)
		{
			JOptionPane.showMessageDialog(null,"No name selected.\nReturn to main screen.");
		}
		
		try
		{
			FileWriter outWriter=new FileWriter(getFile);
			outWriter.write(saveGame);
			outWriter.close();
		}
		catch(IOException ioe)
		{
			JOptionPane.showMessageDialog(null, "Error writing file.\nReturning to main screen.");
			
		}
		catch(NullPointerException npe)
		{
			
		}
		
	}
	
	public void setScores(int row, int col,int pNum)
	{
		scores[row][col]=pNum;
	}
	
	public int getScores(int row, int col)
	{
		return scores[row][col];
	}
	
	public int playerMove()
	{
		if(playCounter%2==0)
		{
			return 2;
		}
		else
		{
			return 1;
		}
	}
	
	public int getPlayCount()
	{
		return playCounter;
	}
	
	public int incrementPlayCounter()
	{
		return playCounter++;
	}
	
	public int decrementPlayCounter()
	{
		return playCounter--;
	}
	
	public void resetPlayerCounter()
	{
		playCounter=0;
	}
	
	
	public static void main(String[] args)
	{
		
		//Connect4Game myGame=new Connect4Game();
		Connect4Display disp=new Connect4Display();
		
	}

}
