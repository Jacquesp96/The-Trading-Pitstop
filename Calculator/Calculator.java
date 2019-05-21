import java.text.DecimalFormat;
import java.util.Scanner;


public class Calculator {
	String pair;
	String Direction;
	Double accountSize;
	public static Double entryLevel;
	public static Double stopLossLevel;
	public static Double takeProfitLevel;

	public Calculator() {	
		
	}

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);		
		
		//Get the Entry Level from the Terminal
		System.out.println("Enter the Entry Level");		
		entryLevel = input.nextDouble();
		
		//Get the Stop Loss Level from the Terminal
		System.out.println("Enter the Stop Loss Level");
		stopLossLevel = input.nextDouble();	
		
		//Use the getStopDistance Procedure to calculate the distance between the entry and Stop Loss
		Double result;
		result = getStopDistance(entryLevel, stopLossLevel, true);
		
		
		//ticks = 5 Decimals
		//Pips  = 4 Decimals
		//Pips		
		DecimalFormat numberFormat = new DecimalFormat("0.00");
		System.out.println(numberFormat.format(result) + "   Pips");			

	}
	
	public static Double getStopDistance(Double inputEntryLevel, Double inputStopLossLevel, Boolean Long) {	
		
		Double result;
		//If it is a Long position then the entry level should be subtracted from the Stop Loss Level
		if (Long) {
			result = inputEntryLevel - inputStopLossLevel;
			result /= 0.0001;
			return result;
			
		} else {
			result = inputStopLossLevel - inputEntryLevel;
			result /= 0.0001;
			return result;

		}		
		
	}

}
