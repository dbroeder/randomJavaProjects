package canvasExamples;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author canderson
 */
public class AdjustableDrawingWin extends JFrame{
    
    private int height = 600;
    private int width = 600;
    JSlider slider;
    AdjustableDrawing adDraw;
    
    
    
    public AdjustableDrawingWin()
    {
        this.setTitle("Slide bar demo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width,height);
       
        adDraw = new AdjustableDrawing();
        this.add(adDraw, BorderLayout.CENTER);
        slider = new JSlider(SwingConstants.HORIZONTAL,10,100,10 );
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.addChangeListener( new ChangeListener(){
            public void stateChanged(ChangeEvent e)
            {
                adDraw.setDiameter(slider.getValue());
                adDraw.setX_pos(adDraw.getStart_x()- slider.getValue()*2);
                adDraw.setY_pos(adDraw.getStart_y()+ slider.getValue()*8);
                
            }
        });
        this.add(slider,BorderLayout.SOUTH);
        
       
        
        this.setVisible(true);
        
    }
    
    
    
    
    public static void main(String[] args)
    {
        AdjustableDrawingWin win = new AdjustableDrawingWin();
        
    }
    
}
