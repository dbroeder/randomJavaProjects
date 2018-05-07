package canvasExamples;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author canderson
 */
public class Canvas extends JPanel{
    
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        
        g.setColor(Color.RED);
        g.drawString("Hello ya'll! ",125,120);
        
        g.drawLine(200,25,400,45);
        g.setColor(Color.BLUE);
        
        g.drawRect(10,255,100,30);
        
        g.setColor(Color.GREEN);
        g.fillOval(310,95,100,30);
        
        
        g.setColor(Color.orange);
        g.fillRect(10,160,100,50);
        
        g.setColor(Color.GREEN);
        g.fillArc(150, 150, 100, 100, 0, 30);
        
        g.setColor(Color.pink);
        g.fillArc(150, 150, 100, 100, 30, 60);
        
        g.setColor(Color.BLUE);
        g.fillArc(150, 150, 100, 100, 90, 95);
         
        g.setColor(Color.RED);
        g.fillArc(150, 150, 100, 100, 185, 100);
        g.setColor(Color.black);
        g.fillArc(150, 150, 100, 100, 285, 75);
        
       int x[] = {50,0,50,100,150,100};
       int y[] = {0,50,100,100,50,0};
        g.setColor(Color.RED);
        g.fillPolygon(x,y,6);
        
        
        
        
        g.setColor(Color.pink);
        g.fillOval(280, 170, 40, 40);
        g.fillOval(280, 140, 40, 40);
        
        g.setColor(Color.red);
        g.fillOval(290, 150, 5, 5);
        g.fillOval(295, 165, 4, 4);
        g.fillOval(310, 155, 5, 4);
        
        g.fillOval(280, 185, 5, 5);
        g.fillOval(290, 190, 4, 4);
        g.fillOval(310, 185, 5, 4);
        
        
        
        g.setColor(Color.orange);
        g.fillArc(250, 200, 100, 100, 70, 40);
        //g.drawRect(250, 150, 100, 100);
        
        for(int dex=50; dex>0 ; dex= dex-3)
        {
            if(dex%2 ==0)
                g.setColor(Color.green);
            else
                
                g.setColor(Color.red);
            
             g.fillOval(450, 150,dex, dex);
        }
        
        
        
        
        
        for(int dex=50; dex>0 ; dex= dex-10)
        {
            g.setColor(new Color( 0,  0, 5*dex));
            
             g.fillOval(450, 275,dex, dex);
        }
        
        for(int dex=50; dex>0 ; dex= dex-10)
        {
            g.setColor(new Color( 0,  0, 5*dex));
            
             g.fillOval(450-dex, 275,dex, dex);
        }
        
        for(int dex=50; dex>0 ; dex= dex-10)
        {
            g.setColor(new Color( 0,  0, 5*dex));
            
             g.fillOval(450, 275-dex,dex, dex);
        }
        for(int dex=50; dex>0 ; dex= dex-10)
        {
            g.setColor(new Color( 0,  0, 5*dex));
            
             g.fillOval(450-dex, 275-dex,dex, dex);
        }
        g.setColor(Color.yellow);
            
        g.fillOval(442, 267,15,15);
        
        
    }
    
    
}
