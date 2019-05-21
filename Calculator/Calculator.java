
public class Calculator {

	public Calculator() {
		String pair;
		String Direction;
		Double accountSize;
		Double entryLevel;
		Double stopLossLevel;
		Double takeProfitLevel;		
		
		
		
	}

	public static void main(String[] args) {
		
		
		

	}
	
	public static Double getStopDistance(Double inputEntryLevel, Double inputStopLossLevel, Boolean Long) {	
		
		//If it is a Long position then the entry level should be subtracted from the Stop Loss Level
		if (Long) {
			return inputEntryLevel - inputStopLossLevel;
			
		} else {
			return inputStopLossLevel - inputEntryLevel;

		}		
		
	}

}
