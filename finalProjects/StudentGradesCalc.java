package finalProjects;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class StudentGradesCalc {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentGradesCalc window = new StudentGradesCalc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentGradesCalc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((int)screenSize.getWidth()/2-(450/2),(int)screenSize.getHeight()/2-(300/2),450,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnPopUpWindow = new JButton("Pop Up Window");
		frame.getContentPane().add(btnPopUpWindow, BorderLayout.CENTER);
		btnPopUpWindow.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				JFrame pupUpFrame=new JFrame();
				pupUpFrame.setBounds(100,100,450,300);
				pupUpFrame.setVisible(true);
			}
		});
	}

}
