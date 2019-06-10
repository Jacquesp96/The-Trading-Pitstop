import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextField;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.*;
import javax.swing.UnsupportedLookAndFeelException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.awt.event.ActionEvent;

import java.text.DecimalFormat;

import javax.swing.JComboBox;

public class Calculator{
	//JFrame Variables
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	//Calculator Variables
	public static Double entryLevel;
	public static Double stopLossLevel;
	public static Double accountSize;
	public  String pair;
	
	//Main 
	public static void main(String[] args) {
		
		//Set the look and Feel
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            System.out.println("Oops");
        } catch (InstantiationException ex) {
        	System.out.println("Oops");
        } catch (IllegalAccessException ex) {
        	System.out.println("Oops");
        } catch (UnsupportedLookAndFeelException ex) {
        	System.out.println("Oops");
        }      
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	
	//Create the application.	 
	public Calculator() {
		initialize();
	}

	
	//Initialize the contents of the frame.	
	private void initialize() {	
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTheTradingPitstop = new JLabel("The Trading Pitstop");
		lblTheTradingPitstop.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTheTradingPitstop.setBounds(108, 11, 216, 29);
		frame.getContentPane().add(lblTheTradingPitstop);
		
		JLabel lblLotSizeCalculator = new JLabel("Lot Size Calculator");
		lblLotSizeCalculator.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLotSizeCalculator.setBounds(156, 51, 120, 14);
		frame.getContentPane().add(lblLotSizeCalculator);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(-1, 46, 434, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblEntryLevel = new JLabel("Entry Level");
		lblEntryLevel.setBounds(111, 159, 83, 19);
		frame.getContentPane().add(lblEntryLevel);
		
		JLabel lblStopLossLevel = new JLabel("Stop Loss Level");
		lblStopLossLevel.setBounds(111, 191, 83, 14);
		frame.getContentPane().add(lblStopLossLevel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-1, 68, 434, 2);
		frame.getContentPane().add(separator_1);
		
		textField = new JTextField();
		textField.setBounds(204, 158, 120, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(204, 188, 120, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel lblAccountSize = new JLabel("Account Size $");
		lblAccountSize.setBounds(111, 221, 83, 14);
		frame.getContentPane().add(lblAccountSize);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(204, 218, 120, 20);
		frame.getContentPane().add(textField_2);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(-1, 296, 434, 2);
		frame.getContentPane().add(separator_2);
		
		JLabel lblLotSize = new JLabel("Lot Size");
		lblLotSize.setBounds(111, 309, 46, 14);
		frame.getContentPane().add(lblLotSize);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(204, 306, 120, 20);
		frame.getContentPane().add(textField_3);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(204, 128, 120, 20);
		frame.getContentPane().add(comboBox);
		
		comboBox.addItem("EUR/USD");
		comboBox.addItem("USD/CAD");
		comboBox.addItem("NZD/USD");
		comboBox.addItem("GBP/USD");
		comboBox.addItem("USD/JPY");
		comboBox.addItem("USD/CHF");
		comboBox.addItem("AUD/USD");
		comboBox.addItem("USD/ZAR");
		
		
		//Calculate Button 
		JButton btnCalculate = new JButton("Calculate");
		
		//When the Button is clicked
		
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setEntryLevel(Double.parseDouble(textField.getText()));
				setStopLossLevel(Double.parseDouble(textField_1.getText()));
				setAccountSize(Double.parseDouble(textField_2.getText()));
				
				//Calculate the Distance between the Stop Loss and the Entry
				Double StopDistance;
				StopDistance = getStopDistance(entryLevel, stopLossLevel);		
				
				//Correctly Display the Lot size and round the number
				DecimalFormat df = new DecimalFormat("#.#####");
				df.setRoundingMode(RoundingMode.CEILING);
				df.format(StopDistance);	
				
				setPair(comboBox.getItemAt(comboBox.getSelectedIndex()));
				
				//Calculate and Display the Lot Size
				Double FinalLotSize;
				FinalLotSize = getLotSize(StopDistance, accountSize, getPair());				
				textField_3.setText(df.format(FinalLotSize));	
				
			}
		});
		btnCalculate.setBounds(164, 249, 89, 23);
		frame.getContentPane().add(btnCalculate);
		
		JLabel lblPair = new JLabel("Pair");
		lblPair.setBounds(111, 129, 83, 19);
		frame.getContentPane().add(lblPair);
		
	
		
		
	}
	
	public static void setEntryLevel(Double level) {
		entryLevel = level;
	}
	
	public static void setStopLossLevel(Double level) {
		stopLossLevel = level;
	}
	
	public static void setAccountSize(Double value) {
		accountSize = value;
	}
	
	
	public static Double getStopDistance(Double inputEntryLevel, Double inputStopLossLevel) {	
		Boolean Long;
		//Check if it is a Long or Short Position
		if (inputEntryLevel > inputStopLossLevel) {
			Long = true;
		}
		else {
			Long = false;
		}				
		Double result;
		//If it is a Long position then the entry level should be subtracted from the Stop Loss Level
		if (Long) {
			result = inputEntryLevel - inputStopLossLevel;
			result /= 0.00001;			
			
		} else {
			result = inputStopLossLevel - inputEntryLevel;
			result /= 0.00001;
		}		
		return result;		
	}
	
	
	//Lot Size  = $Risk / Stop Loss Distance
	public  Double getLotSize(Double StopDistance, Double Account, String pair) {			
		String[] parts = pair.split("/");
		String base = parts[0];
		String quote = parts[1];
		Double riskAmount;
		riskAmount = Account * 0.01;		
		
		if (quote.equals("USD")) {
					
			return (riskAmount / StopDistance);	
			
		} else if (base.equals("USD")) {
			
			return ((riskAmount / StopDistance)* getExchangeRate(pair));
		}
		else {	
			JOptionPane.showMessageDialog(null,"Ovverride");
			return (riskAmount / StopDistance);	
		}
				
	}

	
	public void setPair(String pair) {
		this.pair = pair;
	}
	
	public String getPair()
	{
		return this.pair;
	}
	
	
	public Double getExchangeRate(String pair) {
		
		ExchageRate nExchange = new ExchageRate();
		return nExchange.PairExchange(getPair());
		
		
		}
	
	
}

