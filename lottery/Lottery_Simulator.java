package lottery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class Lottery_Simulator {

	private JFrame frame;
	private JTextField ageTextField;
	private JTextField lotteryTextField;
	private JTextField powerballTextField;
	private JRadioButton dieRdbtn;
	private JRadioButton winRdbtn;
	private JLabel ageLabel;
	private JLabel lblLotteryNumbers;
	private JLabel lblPowerball;
	private JLabel lblUserNumbers;
	private JLabel lblYearsYouPlayed;
	private JLabel lblMoneySpent;
	private JLabel lblMoneyWon;
	private JLabel lblNet;
	private JLabel lblJackpotsWon;
	private JLabel lblWinPercentage;
	private JButton btnPlay;
	private JLabel lblLotteryStats;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lottery_Simulator window = new Lottery_Simulator();
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
	public Lottery_Simulator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 465, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Box verticalBox = Box.createVerticalBox();
		frame.getContentPane().add(verticalBox, BorderLayout.NORTH);
		
		JTextPane txtpnPlayingTheLottery = new JTextPane();
		txtpnPlayingTheLottery.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtpnPlayingTheLottery.setBackground(SystemColor.menu);
		txtpnPlayingTheLottery.setForeground(new Color(0, 0, 0));
		txtpnPlayingTheLottery.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnPlayingTheLottery.setText("Playing the lottery can be tempting at times but how likely is it that you are actually going to "
				+ "win the jackpot let alone any money at all. Well now you have the chance to simulate what it might be like. "
				+ "This simulator will see what your net gains or losses would be if you played every week for the rest of your life. "
				+ "The ending age will be set to 78.");
		txtpnPlayingTheLottery.setEditable(false);
		verticalBox.add(txtpnPlayingTheLottery);
		
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox.add(horizontalBox);
		
		JLabel lblNewLabel_1 = new JLabel("Run Until: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		horizontalBox.add(lblNewLabel_1);
		
		winRdbtn = new JRadioButton("You Win");
		horizontalBox.add(winRdbtn);
		
		dieRdbtn = new JRadioButton("You Die");
		dieRdbtn.setSelected(true);
		horizontalBox.add(dieRdbtn);
		
		ageLabel = new JLabel("How old are you?");
		ageLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		verticalBox.add(ageLabel);
		
		ageTextField = new JTextField();
		ageTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox.add(ageTextField);
		ageTextField.setColumns(10);
		
		dieRdbtn.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if(dieRdbtn.isSelected()==false)
	            {
	            	dieRdbtn.setSelected(true);
	            }
	            else{
	            	if(winRdbtn.isSelected())
	            	{
	            		winRdbtn.setSelected(false);
	            	}
	            	
	            	ageLabel.setVisible(true);
	            	ageTextField.setVisible(true);
	            }
	           

	        }
	    });
		
		winRdbtn.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if(winRdbtn.isSelected()==false)
	            {
	            	dieRdbtn.setSelected(true);
	            	ageLabel.setVisible(true);
	            	ageTextField.setVisible(true);
	            	
	            }
	            else{
	            	dieRdbtn.setSelected(false);
	            	ageLabel.setVisible(false);
	            	ageTextField.setVisible(false);
	            }

	        }
	    });
		
		lblLotteryNumbers = new JLabel("Lottery Numbers: Enter 5 numbers 1-69");
		lblLotteryNumbers.setFont(new Font("Tahoma", Font.PLAIN, 12));
		verticalBox.add(lblLotteryNumbers);
		
		lotteryTextField = new JTextField();
		lotteryTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
		hintMessage(lotteryTextField,"Ex: 1,2,3,4,5");
		verticalBox.add(lotteryTextField);
		lotteryTextField.setColumns(10);
		
		lblPowerball = new JLabel("PowerBall: Enter 1 number 1-26");
		lblPowerball.setFont(new Font("Tahoma", Font.PLAIN, 12));
		verticalBox.add(lblPowerball);
		
		powerballTextField = new JTextField();
		powerballTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
		hintMessage(powerballTextField,"Ex: 5");
		verticalBox.add(powerballTextField);
		powerballTextField.setColumns(10);
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox.add(verticalBox_1);
		
		lblLotteryStats = new JLabel("Lottery Stats");
		lblLotteryStats.setFont(new Font("Tahoma", Font.PLAIN, 14));
		verticalBox_1.add(lblLotteryStats);
		
		lblUserNumbers = new JLabel("Your Numbers: ");
		lblUserNumbers.setFont(new Font("Tahoma", Font.PLAIN, 12));
		verticalBox_1.add(lblUserNumbers);
		
		lblYearsYouPlayed = new JLabel("Tickets bought: ");
		lblYearsYouPlayed.setFont(new Font("Tahoma", Font.PLAIN, 12));
		verticalBox_1.add(lblYearsYouPlayed);
		
		lblMoneySpent = new JLabel("Money spent: ");
		lblMoneySpent.setFont(new Font("Tahoma", Font.PLAIN, 12));
		verticalBox_1.add(lblMoneySpent);
		
		lblMoneyWon = new JLabel("Money won: ");
		lblMoneyWon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		verticalBox_1.add(lblMoneyWon);
		
		lblNet = new JLabel("Net: ");
		lblNet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		verticalBox_1.add(lblNet);
		
		lblJackpotsWon = new JLabel("Jackpots won: ");
		lblJackpotsWon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		verticalBox_1.add(lblJackpotsWon);
		
		lblWinPercentage = new JLabel("Win percentage: ");
		lblWinPercentage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		verticalBox_1.add(lblWinPercentage);
		
		btnPlay = new JButton("Play");
		btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		verticalBox.add(btnPlay);
		
		btnPlay.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Thread run = new Thread(){
					public void run()
					{
						playBall();
					}
				};
				
				run.start();
				
			}
		});
	}
	
	public void playBall(){
		String tempLott = lotteryTextField.getText();
		int temppb=0;
		int[] tempNums = new int[5];
		int age = 0;
		boolean run1=false;
		boolean run2=false;
		boolean run3=false;
		try{
			if(tempLott.contains(",")){
				tempLott = tempLott.replaceAll(" ", "");
			}
			else if (tempLott.contains(" ")){
				tempLott = tempLott.replaceAll(" ", ",");
			}
			else{
				errorCheck(lblLotteryNumbers,lotteryTextField,"Only enter commmas or spaces between numbers.");
				throw new IOException();
			}
			Scanner inLine = new Scanner(tempLott);
			inLine.useDelimiter(",");
			for(int i = 0; i<5;i++){
				tempNums[i]=inLine.nextInt();
				if(i>0){
					for(int d=0;d<i;d++){
						if(tempNums[i]==tempNums[d])
						{
							errorCheck(lblLotteryNumbers,lotteryTextField,"Cannot duplicate numbers");
							throw new IOException();
						}
					}
				}
				
			}
			
			for(int i=0;i<5;i++){
				if(tempNums[i]<1||tempNums[i]>69)
				{
					errorCheck(lblLotteryNumbers,lotteryTextField,"Enter numbers between 1-69");
					throw new IOException();
				}
			}
			
			run1 = true;
		}catch(NumberFormatException nfe)
		{
			errorCheck(lblLotteryNumbers,lotteryTextField,"Enter numbers between 1-69");
		}catch(InputMismatchException ime)
		{
			errorCheck(lblLotteryNumbers,lotteryTextField,"Enter numbers between 1-69");

		}catch(IOException ioe)
		{
			
		}catch(NoSuchElementException nse){
			errorCheck(lblLotteryNumbers, lotteryTextField,"Please Enter 5 numbers.");
		}
		
		try{
			temppb = Integer.parseInt(powerballTextField.getText());
			if(temppb>26||temppb<1){
				errorCheck(lblPowerball,powerballTextField,"Enter 1 number between 1-26");
				throw new IOException();
			}
			run3=true;
		}catch(NumberFormatException nfe)
		{
			errorCheck(lblPowerball,powerballTextField,"Enter 1 number between 1-26"); 
			
		}catch(InputMismatchException ime)
		{
			errorCheck(lblLotteryNumbers,lotteryTextField,"Enter a number");

		}catch(IOException ioe)
		{
			
		}
		
		try{
			if(ageTextField.getText().equals(null)&&dieRdbtn.isSelected())
			{
				errorCheck(ageLabel,ageTextField,"Enter an age");
				throw new IOException();
			}else if(dieRdbtn.isSelected()){
				age = Integer.parseInt(ageTextField.getText());
				if(age<0)
				{
					errorCheck(ageLabel,ageTextField,"Enter a positive age");
					throw new IOException();
				}
			}
			
			
			run2=true;
		}catch(NumberFormatException nfe)
		{
			errorCheck(ageLabel,ageTextField,"Enter a positive age.");
		}catch(InputMismatchException ime)
		{
			errorCheck(ageLabel,ageTextField,"Enter a positive age.");

		}catch(IOException ioe)
		{
			
		}
		
		if(run1)
		{
			lblLotteryNumbers.setForeground(Color.BLACK);
		}
		if(run2)
		{
			ageLabel.setForeground(Color.BLACK);
		}
		if(run3){
			lblPowerball.setForeground(Color.BLACK);
		}
		
		if(run1==true&&run2==true&&run3==true)
		{
			btnPlay.setEnabled(false);
			Lottery winner = new Lottery(tempNums,temppb);
			String lotteryPicks="";
			
			for(int i = 0;i<winner.getUserPicks().length-1;i++){
				lotteryPicks+=winner.getUserPicks()[i]+", ";
			}
			lotteryPicks+=winner.getUserPicks()[4];
			lblUserNumbers.setText("Your picks: "+lotteryPicks+" Powerball: "+winner.getUserPowerball());
			lblYearsYouPlayed.setText("Years played: ");
			lblMoneySpent.setText("Money spent: ");
			lblMoneyWon.setText("Money won: ");
			lblNet.setText("Net: ");
			lblJackpotsWon.setText("Jackpots won: ");
			lblWinPercentage.setText("Win percentage: ");
			
			
			if(dieRdbtn.isSelected())
			{
				for(int i=0;i<(104*(78-age));i++)
				{
					winner.check4Win();
				}
				lblLotteryStats.setText("Lottery Stats");

			}else{
				lblLotteryStats.setText(lblLotteryStats.getText()+"    Running...");
				int counter=0;
				while(winner.check4Win()==false){
					counter++;
					if(counter%5000000==0)
					{
						lblLotteryStats.setText("Lottery Stats    Running");
					}	
					else if(counter%5000000==1250000)
					{
						lblLotteryStats.setText("Lottery Stats    Running.");
					}
					else if(counter%5000000==2500000)
					{
						lblLotteryStats.setText("Lottery Stats    Running..");
					}
					else if(counter%5000000==3750000)
					{
						lblLotteryStats.setText("Lottery Stats    Running...");
					}
				}
				lblLotteryStats.setText("Lottery Stats");

			}
			updateLabels(winner);
		}
		
	}
	
	public void errorCheck(JLabel label,JTextField field,String message)
	{
		label.setForeground(Color.RED);
		hintMessage(field,message);
	}
	
	public void hintMessage(final JTextField field,final String message)
	{
		field.setForeground(Color.LIGHT_GRAY);
		field.setText(message);
		field.addFocusListener(new FocusListener(){
			@Override
			public void focusGained(FocusEvent e){
				if(field.getText().equals(message)){
					field.setForeground(Color.black);
					field.setText("");
				}
				else{
					
				}
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if(field.getText().equals("")){
					field.setForeground(Color.LIGHT_GRAY);
					field.setText(message);
				}
				
			}
		});
	}
	
	public void updateLabels(Lottery winner){
		int winnings=0;
		DecimalFormat bigMoney = new DecimalFormat("#0,000.00");
		DecimalFormat money = new DecimalFormat("#0.00");
		DecimalFormat percent = new DecimalFormat("#0.0000");
		for(int i = 0;i<winner.getWins().length;i++)
		{
			winnings+=winner.getWins()[i];
		}
		winnings--;
		if(winner.getTrys()<500)
		{
			lblYearsYouPlayed.setText("Years played: "+money.format(winner.getTrys()));
			lblMoneySpent.setText("Money spent: $"+money.format((winner.getTrys()*2)));
		}else
		{
			lblYearsYouPlayed.setText("Years played: "+bigMoney.format(winner.getTrys()));
			lblMoneySpent.setText( "Money spent: $"+bigMoney.format((winner.getTrys()*2)));
		}
		if(winnings<1000){
			lblMoneyWon.setText("Money won: $"+money.format(winnings));

		}else{
			lblMoneyWon.setText("Money won: $"+bigMoney.format(winnings));

		}
		if(winnings-(winner.getTrys()*2)<1000&&winnings-(winner.getTrys()*2)>-1000)
		{
			lblNet.setText("Net: $"+money.format(winnings-(winner.getTrys()*2)));
		}else{
			lblNet.setText("Net: $"+bigMoney.format(winnings-(winner.getTrys()*2)));
		}
		
		lblJackpotsWon.setText("Jackpots won: "+winner.getWin(5));
		lblWinPercentage.setText("Win percentage: "+percent.format(((double)winner.getTotalWins()/(double)winner.getTrys())*100)+"%");
		btnPlay.setText("Play Again");
		btnPlay.setEnabled(true);
		resetTextBoxes(ageLabel,ageTextField,"");
		resetTextBoxes(lblLotteryNumbers,lotteryTextField,"Ex: 1,2,3,4,5");
		resetTextBoxes(lblPowerball,powerballTextField,"Ex: 1");
		
	}
	
	public void resetTextBoxes(JLabel label,JTextField field,String message){
		label.setForeground(Color.black);
		hintMessage(field,message); 
	}

}