import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class ExchageRate {

	public ExchageRate() {
		
	}
	
	public static Double exchangeRate(String base, String quote) {
		try {
			
			URL url = new URL("https://free.currencyconverterapi.com/api/v6/convert?q=" + base + "_" + quote + "&compact=ultra&apiKey=08643ced16414e9af543");
			 BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	         String line = reader.readLine();
	         if (line.length() > 0) {
	        	 String[] parts = line.split(":");
	        	 String part1 = parts[1];	        	 
	        	 String[] parts2 = part1.split("}");
	        	 String stukkie = parts2[0];   	 
	        	 line = stukkie;
	        	 return Double.parseDouble(line);
	         }
	         reader.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
		
		
		
	}
	
	public  Double PairExchange(String pair) {
		
		String[] parts = pair.split("/");
		String base = parts[0];
		String quote = parts[1];
		
		Double eRate = exchangeRate(base, quote);
		return eRate;
		
	}
	
	
	//Get the multiplier for the formula
	public static Double Multiplier(String baseCurrency, String quoteCurrency, String accountBase) {		
		
		if (accountBase == quoteCurrency) {
			return 1.0;			
		}
		else{		
					
			//To-Do: Move the decimal always to 1 (USD/JPY) doesn't work correctly
			return exchangeRate(baseCurrency, quoteCurrency);
		}		
		
	}

}
