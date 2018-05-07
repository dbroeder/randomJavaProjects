package ticTacToe;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author canderson
 */
public class TTTGameBoardDisplay extends JPanel{
   
    private int cellWidth = 40;
    private int boardStart_X = cellWidth/2;
    private int boardStart_Y = cellWidth/2;
    private TTTgame game; 
    
    private static final int BOARD_HEIGHT = 250;
    private static final int BOARD_WIDTH = 250;
    private static final int BORDER_WIDTH = 10;
    
    public  TTTGameBoardDisplay(TTTgame g)
    {
        game = g;
    }
    
    
    private boolean drawX(Graphics g, int xStart, int yStart, int width, int height)
    {
        g.setColor(Color.RED);
        g.drawLine(xStart, yStart, xStart+width, yStart+height);
        g.drawLine(xStart+width, yStart, xStart, yStart+height);
        
        
        return true;
    }
    
    
    private boolean drawO(Graphics g, int xStart, int yStart, int width, int height)
    {
        g.setColor(Color.BLUE);
        g.drawOval(xStart, yStart, width, height);
        return true;
    }
    
    
    public int[] getClickedRowCol(int x, int y)
    {
        int clickedCoors[] = new int[2];
        int col =  ( x - x % (2*cellWidth) )/ (2*cellWidth) ;
        
        int row = ( y - y % (2*cellWidth) )/ (2*cellWidth) ;
        clickedCoors[0]  = row;
        clickedCoors[1]  = col;
        return clickedCoors;
    }
    
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        
        //#############################################
        //   drawing board   
        //#############################################
            g.fillRect(0, 2*cellWidth, 6*cellWidth,  3);
            g.fillRect(0, 4*cellWidth, 6*cellWidth,  3);
            g.fillRect(2*cellWidth, 0, 3,  6*cellWidth);
            g.fillRect(4*cellWidth, 0, 3,  6*cellWidth);
               
        g.fillRect(0,0,BORDER_WIDTH,BOARD_HEIGHT);
        g.fillRect(BOARD_WIDTH - BORDER_WIDTH,0,BORDER_WIDTH,BOARD_HEIGHT);
        
        g.fillRect(0,0,BOARD_WIDTH, BORDER_WIDTH);
        g.fillRect(0,BOARD_HEIGHT - BORDER_WIDTH,BOARD_WIDTH, BORDER_WIDTH);
       
            
        //#############################################
        //   filling board   
        //#############################################
        for(int row =0; row < 3; row++)
        { 
            for(int col =0; col < 3; col++)
            { 
                int curPosition = game.getPositionStatus(row, col);
                if ( curPosition == 1)
                {
                    drawX(g, boardStart_X+2*cellWidth*col, boardStart_Y+2*cellWidth*row, cellWidth, cellWidth);
                }
                else if( curPosition == 0 )
                {
                    drawO(g, boardStart_X+2*cellWidth*col, boardStart_Y+2*cellWidth*row, cellWidth, cellWidth);
                }
            }
        }
    }
}
