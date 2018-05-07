package canvasExamples;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author canderson
 */
public class AdjustableDrawing extends JPanel{
    
    
    private Color green = new Color(0,150,0);
    private int start_x = 400;
    private int start_y = 0;
    private int x_pos = start_x;
    private int y_pos = 80;
    private int diameter = 20;
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.setColor(green);
        g.fillOval(x_pos, y_pos, diameter, diameter);
        
        
        
    }
    
    
    public Dimension getPreferredSize()
    {
        return new Dimension( 400,400);
    }
    
    public Dimension getMinimumSize()
    {
        return getPreferredSize();
    }
    

    /**
     * @param green the green to set
     */
    public void setGreen(Color green) {
        this.green = green;
    }

    /**
     * @param x_pos the x_pos to set
     */
    public void setX_pos(int x_pos) {
        this.x_pos = x_pos;
    }

    /**
     * @param y_pos the y_pos to set
     */
    public void setY_pos(int y_pos) {
        this.y_pos = y_pos;
    }

    /**
     * @param diameter the diameter to set
     */
    public void setDiameter(int diameter) {
        if(diameter > 10)
            this.diameter = diameter;
        repaint();
    }

    /**
     * @return the start_x
     */
    public int getStart_x() {
        return start_x;
    }

    /**
     * @return the start_y
     */
    public int getStart_y() {
        return start_y;
    }
    
    
    
    
    
    
}
