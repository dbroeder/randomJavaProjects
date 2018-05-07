package connect4Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Token extends JPanel{
	
	private int count;
	Connect4Game game;
	
	public void paintComponent(Graphics g)//overwrites the paint component
	{
		super.paintComponent(g);//calls the super class
		game=new Connect4Game();
		if(count==0)//if statement paints all of the JPanels based on player turn
		{
			this.setBackground(Color.yellow);
		}
		else if(count==-4)
		{
			g.setColor(Color.orange);
			g.fillOval(0, 0, 50, 50);
		}
		else if(count%2==0)
		{
			g.setColor(Color.red);
			g.fillOval(0, 0, 50, 50);
					
		}
		else if(count%2==1)
		{
			g.setColor(Color.blue);
			g.fillOval(0, 0, 50, 50);
		}
	}

		
	
	
	public int setCount(int pc)
	{
		count=pc;
		return count;
	}
	
}
