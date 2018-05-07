package canvasExamples;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

/**
 *
 * @author canderson
 */
public class CanvasWindow extends JFrame {

   
    JButton but;
    Color  color1 = (Color.WHITE);
    JPanel panel;
    JPanel panel2;
    Canvas kiwi1 ;
    Canvas kiwi2 ;
    JTextField textField1;
    JTextField textField2;
    JTextField textField3;
    JTextField textField4;
    
   
    
    
    public CanvasWindow()
    {   
        this.setTitle("Learn to draw graphics");
        this.setLayout(new GridLayout(1,1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        kiwi1 = new Canvas();
        kiwi2 = new Canvas();
      //  add(kiwi1, BorderLayout.CENTER);
        add(kiwi1);
       
       
        
      //  add(panel, BorderLayout.SOUTH);
      //  add(panel2, BorderLayout.EAST);
        this.setSize(600,400);
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
       
        CanvasWindow myViewer = new CanvasWindow();
     
     
    }
}
