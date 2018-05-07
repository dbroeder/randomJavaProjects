package ticTacToe;
/**
 * Graphics application  Tic-TacoToe
 * Demo code for CSIS 150
 * Game board
 */
import javax.swing.*;
/**
 *
 * @author canderson
 */
public class TTTgame {
    
    
    private int[][] board;
    private String[] players;
    private int turn;
    private String message;
    private Boolean gameOver;
    
    
    public TTTgame()
    {
        board = new int[3][3];
        initBoard();
        players = new String[2];
        players[0] = "0 Player";
        players[1] = "X Player";
        turn = 1;
        gameOver = false;
        
    }
    
    
    public void initBoard()
    {
        for(int row = 0; row < 3; row++)
        {
           for(int col = 0; col < 3; col++)
           {
               board[row][col] = -1;
           } 
        }
        gameOver = false;
    }
    /**
     * checks game board array for win situation.
     * @return 
     */
    public boolean isWon()
    {
        if( ( getBoard()[0][0] != -1 &&getBoard()[0][0] == getBoard()[0][1] &&getBoard()[0][0] == getBoard()[0][2] ) ||
            ( getBoard()[1][0] != -1 &&getBoard()[1][0] == getBoard()[1][1] &&getBoard()[1][0] == getBoard()[1][2] ) || 
            ( getBoard()[2][0] != -1 &&getBoard()[2][0] == getBoard()[2][1] &&getBoard()[2][0] == getBoard()[2][2] ) ||  
            ( getBoard()[0][0] != -1 &&getBoard()[0][0] == getBoard()[1][0] &&getBoard()[0][0] == getBoard()[2][0] ) || 
            ( getBoard()[0][0] != -1 &&getBoard()[0][0] == getBoard()[1][0] &&getBoard()[0][0] == getBoard()[2][0] ) || 
            ( getBoard()[0][1] != -1 &&getBoard()[0][1] == getBoard()[1][1] &&getBoard()[0][1] == getBoard()[2][1] ) || 
            ( getBoard()[0][2] != -1 &&getBoard()[0][2] == getBoard()[1][2] &&getBoard()[0][2] == getBoard()[2][2] ) ||  
            ( getBoard()[0][0] != -1 &&getBoard()[0][0] == getBoard()[1][1] &&getBoard()[0][0] == getBoard()[2][2] ) || 
            ( getBoard()[0][2] != -1 &&getBoard()[0][2] == getBoard()[1][1] &&getBoard()[0][2] == getBoard()[2][0] ) )
        {       
                return true;
        }
        return false;
    }
    
    
    public boolean areMorePlays()
    {
        for(int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++)
            {
                if(getBoard()[row][col] == -1)
                    return true;
            
            }
        }
        return false;
    }
    
    
    public boolean isValid(int coors[])
    {     if(getBoard()[coors[0]][coors[1]] != -1)
          {
              if(coors[0] < 0 || coors[0] > 2 || coors[1] < 0 || coors[1] > 2 )
              {
                  message = "invalid row or column number!";
                  return false;
              }
              else
              {
                  message = "Position row: "+(coors[0]+1)+"  column: "+(coors[1]+1) +"\n is already taken, click on another!";
                  return false;
              }
              
          }
         return true;
    }
    
    
    public boolean updateBoard(int coors[])
    {
         message = "";
         if(!isValid(coors))
         {
           return false;
         }
         board[coors[0]][coors[1]] = turn;
         message = "Good move!, "+players[turn];
         return true;
         
    }
    
    
    private void changePlayer()
    {
        turn = (turn+1)%2;
        
    }
    
    
    public String processPlay(int coors[])
    {  
        String status = "";
        if( !updateBoard(coors) )
        {
            status = "\n"+message;
            return status;
        }
         status = "\n"+message;
        if(continuePlay())
        {
            changePlayer();
        }
        else
        {
            status +="\n"+message;
        }
        return status;
    }
    
    
    public int getPositionStatus(int row,int col)
    {
        return board[row][col];
    }
    
    
    
    
    public boolean continuePlay()
    {   message = "";
        if(isWon())
        {
           message = "Game is over! "+players[turn]+ " won!"; 
           gameOver = true;
           return false;
        }
        else if (!areMorePlays())
        {
           message = "Game is tied, No winner!"; 
           gameOver = true;
           return false;
        }
        return true;
    }

    /**
     * @return the board
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * @return the gameOver
     */
    public Boolean getGameOver() {
        return gameOver;
    }

    /**
     * @param gameOver the gameOver to set
     */
    public void setGameOver(Boolean gameOver) {
        this.gameOver = gameOver;
    }
    
}
