package assign_4_broederdj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

/*
 * @author Dustin Broeder
 */

public class Connect4Display extends JFrame {
	
	public int[]tokenTracker;//tracks tokens in each column to check if there is available space for a move
	public int rowTracker=11;
	private final int WIN_WIDTH=600;//initial window width
	private final int WIN_HEIGTH=700;//initial window height
	private final int GAME_COLUMNS=9;//number of total columns
	private final int GAME_ROWS=12;//number of total rows
	private final int VGAP=0;//vertical gap between each JPanel
	private final int HGAP=5;//horizontal gap between each JPanel
	public Token[][] gamePanels;//array of JPanels used to create all the rows and columns
	public JTextField playerTurn;//field that shows which players' turn it is
	private Font boldFont;
	private Connect4Game game;
	private MouseAdapter mouseAdapter;
	private String player1,player2;
	private JMenuBar menu;
		
	public Connect4Display()//Constructor that initializes the GUI interface 
	{
		game=new Connect4Game();
		this.setSize(WIN_WIDTH, WIN_HEIGTH);//sets the window size
		this.setTitle("Connect Four");//sets the title
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		populateWindow();//method to fill the widow with the game board
		this.setResizable(false);
		this.setVisible(true);
	}
	
	/*
	 * In my program, I used JPanels to create my game grid. In order to do this I had to use a 2 dimensional
	 * array of JPanels. Thus I have to store this array plus an additional array that helps me validate my
	 * moves in each column.
	 */
	
	public void populateWindow()//method to fill the board
	{
		boldFont=new Font("Veranda",Font.BOLD,16);
		JPanel outsideHolder=new JPanel();
		JPanel gameColumns=new JPanel(new GridLayout(GAME_ROWS,GAME_COLUMNS,HGAP,VGAP));//Panel that holds the individual game panels that create the board
		JPanel playerLabel=new JPanel(new GridLayout(1,1));//panel that contains the status of players turn
		menu=new JMenuBar();
		
		JMenu gameOptions=new JMenu("Game Options");
		JMenu bestScore=new JMenu("Best Scores");
		JMenuItem viewBestScores=new JMenuItem("View Best Scores");
		JMenuItem resetBestScores=new JMenuItem("Reset Best Scores");
		JMenuItem newGameBut=new JMenuItem("New Game");
		JMenuItem saveGameBut=new JMenuItem("Save Game");
		JMenuItem loadGameBut=new JMenuItem("Load old game");
		
		viewBestScores.addActionListener(new ActionListener()
        {   public void actionPerformed(ActionEvent ae)
        	{   
   	 			game.loadHighScore();
   	 			game.displayHighScore();
        	}
        }); 
		
		resetBestScores.addActionListener(new ActionListener()
        {   public void actionPerformed(ActionEvent ae)
        	{   
   	 			game.resetHighScore();
   	 			game.saveHighScore();
        	}
        });
		
		newGameBut.addActionListener(new ActionListener()
         {   public void actionPerformed(ActionEvent ae)
             {   
        	 	resetBoard(0);
             }
         });
		
		saveGameBut.addActionListener(new ActionListener()
        {   public void actionPerformed(ActionEvent ae)
        	{
        		game.printScoresDisplay();
        		game.saveGameToFile();
        	}
        });
		
		loadGameBut.addActionListener(new ActionListener()
        {   public void actionPerformed(ActionEvent ae)
        	{   
   	 			fillBoard();
        	}
        });
		
		gameOptions.add(newGameBut);
		gameOptions.add(saveGameBut);
		gameOptions.add(loadGameBut);
		bestScore.add(viewBestScores);
		bestScore.add(resetBestScores);
		menu.add(gameOptions);
		menu.add(bestScore);
		playerLabel.add(menu);
		game.setPlayer1Name();
		game.setPlayer2Name();
		player1=game.getPlayer1Name();
		player2=game.getPlayer2Name();
		playerTurn=new JTextField(30);
		playerTurn.setEditable(false);
		playerTurn.setText(player1+"'s turn");
		playerTurn.setForeground(Color.blue);
		playerTurn.setFont(boldFont);
		playerTurn.setBackground(Color.green);
		
		playerLabel.add(playerTurn);
		
		gameColumns.setBackground(Color.black);
		gamePanels=new Token[GAME_ROWS][GAME_COLUMNS];
		tokenTracker=new int[GAME_COLUMNS];
		
		for(int rowDex=0;rowDex<GAME_ROWS;rowDex++)//for loop creates the array of JPanels for the board
		{
			for(int colDex=0;colDex<GAME_COLUMNS;colDex++)
			{
				tokenTracker[colDex]=rowTracker;
				gamePanels[rowDex][colDex]=new Token();
				gamePanels[rowDex][colDex].setBackground(Color.yellow);
				gameColumns.add(gamePanels[rowDex][colDex]);
				gamePanels[rowDex][colDex].addMouseListener(new MouseAdapter(){//method that instantiates the mouse listener
					public void mouseClicked(java.awt.event.MouseEvent evt){
						getCoordinates(evt);//calls the method that creates the circle
						setPlayerTurn();//calls the method that changes the status of player turn
						
					}
				});
			}
		}
		
		this.getContentPane().add(playerLabel,BorderLayout.NORTH);
		this.getContentPane().add(gameColumns);
	}
	
	public void getCoordinates(MouseEvent me)//method that creates the circle for each place clicked on
	{
		me.getX();
		for(int rowDex=0;rowDex<GAME_ROWS;rowDex++)
		{
			for(int colDex=0;colDex<GAME_COLUMNS;colDex++)
			{
				if(me.getSource()==gamePanels[rowDex][colDex])
				{
					try
					{
						game.incrementPlayCounter();
						gamePanels[tokenTracker[colDex]][colDex].setCount(game.getPlayCount());
						game.setScores(tokenTracker[colDex], colDex, game.playerMove());
						tokenTracker[colDex]--;
					}catch(ArrayIndexOutOfBoundsException aio)//catches the user trying to make a move in a full column
					{
						JOptionPane.showMessageDialog(null,"Colomn already full. \nPlease try another move.");
						game.decrementPlayCounter();
					}
				}
			}	
		}
		this.repaint();
		resetBoard(game.check4Win());
	}
	
	public void setPlayerTurn()//method that tracks the status of which player turn it is. 
	{
		player1=game.getPlayer1Name();
		player2=game.getPlayer2Name();
		if(game.getPlayCount()%2==0)
		{
			playerTurn.setForeground(Color.blue);
			playerTurn.setText(player1+"'s turn");
		}
		else
		{
			playerTurn.setForeground(Color.red);
			playerTurn.setText(player2+"'s turn");
		}
	}
	
	public void resetPlayerTurn()
	{
		playerTurn.setForeground(Color.blue);
		playerTurn.setText(player1+"'s turn");
	}
	
	public void resetBoard(int num)
	{
		if(num==0)
		{
			for(int rowDex=0;rowDex<GAME_ROWS;rowDex++)
			{
				for(int colDex=0;colDex<GAME_COLUMNS;colDex++)
				{
					tokenTracker[colDex]=rowTracker;
					resetPlayerTurn();
					game.resetPlayerCounter();
					game.resetGame();
					gamePanels[rowDex][colDex].setCount(0);
					this.repaint();	
				}
			}
		}
		else if(num==1)
		{
			JOptionPane.showMessageDialog(null, "Thank you for playing!");
			System.exit(0);
		}
	}
	
	public void resetTokenTracker()
	{
		for(int dex=0;dex<GAME_COLUMNS;dex++)
		{
			tokenTracker[dex]=rowTracker;
		}
	}
	
	public void fillBoard()
	{
		game.loadSavedGame();
		resetTokenTracker();
		setPlayerTurn();
		
		for(int rowDex=0;rowDex<GAME_ROWS;rowDex++)
		{
			for(int colDex=0;colDex<GAME_COLUMNS;colDex++)
			{
				if(game.getScores(rowDex,colDex)==0)
				{
					gamePanels[rowDex][colDex].setCount(0);
				}
				else if(game.getScores(rowDex, colDex)==1)
				{
					gamePanels[rowDex][colDex].setCount(1);
					tokenTracker[colDex]--;
				}
				else if(game.getScores(rowDex, colDex)==2)
				{
					gamePanels[rowDex][colDex].setCount(2);
					tokenTracker[colDex]--;
				}
				this.repaint();
			}
		}
	}
	
	
	

}
