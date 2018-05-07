package ticTacToe;

import java.awt.*;
import javax.swing.*;

/**
 * @author canderson
 */
public class TTTwindow extends JFrame{
   
    TTTgame game;
    TTTGameBoardDisplay gameBoard;
    JTextField player2NameTxt, player1NameTxt;
    JTextArea voice;  // meassage board
    
    private static final int WIN_HEIGHT = 270;
    private static final int WIN_WIDTH = 500;
    
    public TTTwindow()
    {
        this.setTitle("Play Tic Tac Toe");
        this.setLayout(new GridLayout(1,2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        game = new TTTgame();
        gameBoard = new TTTGameBoardDisplay(game);
        gameBoard.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    boardClicked(evt);
                }

            }); 
        add(gameBoard);
        
        JPanel panel = new JPanel();
        JButton but = new JButton("New Game");
        but.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    newGame(evt);
                }

            }); 
        
        panel.add(but);
       
        voice = new JTextArea(" Click on any position on the\n game board to begin game", 5, 15);
        voice.setBackground(new Color(240,240,240));
        panel.add(voice);
        
        
        add(panel);
        this.setSize(WIN_WIDTH,WIN_HEIGHT);
        this.setResizable(false);
        setVisible(true);
        
    }


    public void newGame(java.awt.event.MouseEvent me)
    {
        game.initBoard();
        voice.setText(" Click on any position on the\n game board to begin game");
        repaint();
    }
    
    
    public void boardClicked(java.awt.event.MouseEvent me)
    {
       if(!game.getGameOver())
       {    int x = me.getX();
            int y = me.getY();
            int coors[] = gameBoard.getClickedRowCol(x,y);
            String text = game.processPlay(coors);
            voice.setText(text);
            repaint();
       }
       else
       {
           voice.setText("  Game is over! \n  No more moved will be processed\n\n  Click on New Game to continue");
       }
    }
  
    
    public static void main(String[] agrs)
    {
        TTTwindow myWindow = new TTTwindow();
    }
    
}
