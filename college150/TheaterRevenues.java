package college150;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.text.*;
import java.util.InputMismatchException;
import java.util.zip.DataFormatException;
/*
 * @author Dustin Broeder
 */

public class TheaterRevenues extends JFrame implements ActionListener{

	private final int WIN_WIDTH=600;
	private final int WIN_HEIGTH=200;
	private DecimalFormat decFor;
	private Font boldFont;
	private JButton calcRevenue;
	private JTextField aTicketPrice, aTicketNumInput, cTicketPrice, cTicketNumInput, grossResultChild, grossResultAdult, netResultChild, netResultAdult, totalNetResult, totalGrossResult, displayTotalRevenue,dispNetTotal ;
	private final double PERCENT_TICKET_SALES=0.2; 
	
	/**
	 * @param args
	 */
	
	public TheaterRevenues()
	{
		this.setSize(WIN_WIDTH, WIN_HEIGTH);
		this.setTitle("Theater Revenue Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		populateWindow();
		
		this.setVisible(true);
	}
	
	public void populateWindow()
	{
		boldFont=new Font("Times New Roman", Font.BOLD, 14);
		decFor=new DecimalFormat("###.00");
		JPanel outsideHolder=new JPanel();
		JPanel innerHolderSandR= new JPanel(new GridLayout(1,2));
		JPanel inputHolderSold=new JPanel(new GridLayout(5,2));
		JPanel inputHolderRevenue=new JPanel(new GridLayout(5,2));
		JPanel innerHolderCalc=new JPanel();
		outsideHolder.setBackground(Color.black);
		
		JLabel ticketsMainLabel=new JLabel("Tickets Sold");
		ticketsMainLabel.setFont(boldFont);
		JLabel blankS=new JLabel();
		
		JLabel aTicket=new JLabel("Adult ticket price");
		aTicketPrice= new JTextField(10);
		JLabel aTicketNum=new JLabel("Number adult tickets sold");
		aTicketNumInput= new JTextField(10);
		
		JLabel cTicket=new JLabel("Child ticket price");
		cTicketPrice= new JTextField(10);
		JLabel cTicketNum=new JLabel("Number child tickets sold");
		cTicketNumInput= new JTextField(10);
		
		inputHolderSold.add(ticketsMainLabel);
		inputHolderSold.add(blankS);
		inputHolderSold.add(aTicket);
		inputHolderSold.add(aTicketPrice);
		inputHolderSold.add(aTicketNum);
		inputHolderSold.add(aTicketNumInput);
		inputHolderSold.add(cTicket);
		inputHolderSold.add(cTicketPrice);
		inputHolderSold.add(cTicketNum);
		inputHolderSold.add(cTicketNumInput);
		
		JLabel revenueMainLabel=new JLabel("Revenue");
		revenueMainLabel.setFont(boldFont);
		JLabel blankR=new JLabel();
		
		JLabel aGrossRevenue=new JLabel("Gross Rev. Adult");
		grossResultAdult=new JTextField(10);
		grossResultAdult.setEditable(false);
		grossResultAdult.setBackground(Color.WHITE);
		
		JLabel aNetRevenue=new JLabel("Net Rev. Adult");
		netResultAdult=new JTextField(10);
		netResultAdult.setEditable(false);
		netResultAdult.setBackground(Color.WHITE);
		
		JLabel cGrossRevenue=new JLabel("Gross Rev. Child");
		grossResultChild=new JTextField(10);
		grossResultChild.setEditable(false);
		grossResultChild.setBackground(Color.WHITE);
		
		JLabel cNetRevenue=new JLabel("Net Rev. Child");
		netResultChild=new JTextField(10);
		netResultChild.setEditable(false);
		netResultChild.setBackground(Color.WHITE);
		
		inputHolderRevenue.add(revenueMainLabel);
		inputHolderRevenue.add(blankR);
		inputHolderRevenue.add(aGrossRevenue);
		inputHolderRevenue.add(grossResultAdult);
		inputHolderRevenue.add(aNetRevenue);
		inputHolderRevenue.add(netResultAdult);
		inputHolderRevenue.add(cGrossRevenue);
		inputHolderRevenue.add(grossResultChild);
		inputHolderRevenue.add(cNetRevenue);
		inputHolderRevenue.add(netResultChild);
		
		JPanel buttonPanel=new JPanel();
		calcRevenue=new JButton("Calculate Revenues");
		buttonPanel.add(calcRevenue);
		calcRevenue.addActionListener(this);
		
		JLabel grossRevDisp=new JLabel("Total Gross Rev:");
		displayTotalRevenue=new JTextField(10);
		displayTotalRevenue.setEditable(false);
		displayTotalRevenue.setBackground(Color.WHITE);
		
		JLabel netRev=new JLabel("Total Net Rev:");
		dispNetTotal=new JTextField(10);
		dispNetTotal.setEditable(false);
		dispNetTotal.setBackground(Color.WHITE);
		
		innerHolderCalc.add(buttonPanel);
		innerHolderCalc.add(grossRevDisp);
		innerHolderCalc.add(displayTotalRevenue);
		innerHolderCalc.add(netRev);
		innerHolderCalc.add(dispNetTotal);
		
		
		//innerHolderSandR.add(inputHolderSold);
		//innerHolderSandR.add(inputHolderRevenue);
		//outsideHolder.add(innerHolderSandR);
		//outsideHolder.add(innerHolderCalc);
		
		this.add(outsideHolder);
	}
	
	public void actionPerformed(ActionEvent actEvent)
	{
		if(actEvent.getSource() instanceof JButton)
		{
			JButton clickedButton= (JButton)actEvent.getSource();
			if(clickedButton.getActionCommand().equals("Calculate Revenues"))
			{
				try
				{
					double adultTicketPrice=Double.parseDouble(aTicketPrice.getText());
					double childTicketPrice=Double.parseDouble(cTicketPrice.getText());
					int numChildTicket=Integer.parseInt(cTicketNumInput.getText());
					int numAdultTicket=Integer.parseInt(aTicketNumInput.getText());
					double grossRevAdult=adultTicketPrice*numAdultTicket;
					double grossRevChild=childTicketPrice*numChildTicket;
					double netTotal=grossRevChild*PERCENT_TICKET_SALES+grossRevAdult*PERCENT_TICKET_SALES;
					grossResultChild.setText(decFor.format(grossRevChild));
					grossResultAdult.setText(decFor.format(grossRevAdult));
					netResultChild.setText(decFor.format((grossRevChild*PERCENT_TICKET_SALES)));
					netResultAdult.setText(decFor.format((grossRevAdult*PERCENT_TICKET_SALES)));
					dispNetTotal.setText(decFor.format(netTotal));
					displayTotalRevenue.setText(decFor.format((grossRevAdult+grossRevChild)));	
					
				}
				catch(Exception ioe)
				{
					JOptionPane.showMessageDialog(null, "Invalid input! Program Terminating.");
					System.exit(0);
				}
							
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TheaterRevenues display=new TheaterRevenues();
	}

}
