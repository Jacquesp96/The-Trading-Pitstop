import java.sql.*;


public class mysql {
	
	//Trade table
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	
	//Pair table
	private Connection pairConn;
	private Statement pairStatement;
	private ResultSet pairRS;
	
	
	//Constructor
	public mysql() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("got something1");
			
			
			
			
		}catch(Exception e) {
			System.out.println("Couldnt connect" + e);
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trade","root","");
			pairConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pair","root","");
			
			//System.out.println("got something2");
			
		} catch (Exception x) {
			System.out.println("Connection: " + x);
		}
		
		try {
			st = conn.createStatement();
			pairStatement = pairConn.createStatement();
			//System.out.println("got something3");
		} catch (Exception y) {
			System.out.println("statement :" + y);		
			}
		
	}

	
	//Main Method
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
		
	//Get Data
	public  void getData() {
		try {
			System.out.println("Getting data...");
			String newQuery = "select * from trade";
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	//createTables
	public void createTables() {
		this.createPair();
		this.createStrategy();
		this.createConfirmation();
		this.createPattern();
		this.createTrade();
		
	}
	
	//Drop Tables
	public void dropTabeles() {
		this.dropConfirmation();
		this.dropPair();
		this.dropPattern();
		this.dropStrategy();
		this.DropTrade();
	}
	
	//Create and drop the Trade table
	public void createTrade() {
		
		
		String createTable = "CREATE TABLE TRADE(\r\n" + 
				"TRADE_ID INTEGER PRIMARY KEY,\r\n" + 
				"DATE_AND_TIME DATE,\r\n" + 
				"PAIR_ID INTEGER REFERENCES PAIR(PAIR_ID),\r\n" + 
				"STRATEGY_ID INTEGER REFERENCES STRATEGY(STRATEGY_ID),\r\n" + 
				"CONFIRMATION_ID INTEGER REFERENCES CONFIRMATION(CONFIRMATION_ID),\r\n" + 
				"TRADE_POSITION VARCHAR(35),\r\n" + 
				"ENTRY_LEVEL DOUBLE,\r\n" + 
				"SL DOUBLE,\r\n" + 
				"TP1 DOUBLE,\r\n" + 
				"TP2 DOUBLE,\r\n" + 
				"TP3 DOUBLE,\r\n" + 
				"RISK_REWARD DOUBLE,\r\n" + 
				"LOT_SIZE DOUBLE, \r\n" + 
				"PROFIT_LOSS DOUBLE\r\n" + 
				")";
			
		try {
			st = conn.createStatement();
			st.executeUpdate(createTable);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	//Drop Trade
	public void DropTrade() {
		String dropTable = "DROP TABLE TRADE";
		
		try {
			st = conn.createStatement();
			st.executeUpdate(dropTable);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	//Create and drop the pair table
	public void createPair() {
		String createPair = "CREATE TABLE PAIR(\r\n" + 
				"PAIR_ID INTEGER PRIMARY KEY,\r\n" + 
				"PAIR_NAME VARCHAR(35)\r\n" + 
				")";
				
		try {
			st = conn.createStatement();
			st.executeUpdate(createPair);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

	//Drp Pair
	public void dropPair() {
		String dropPair = "DROP TABLE PAIR";
		try {
			st = conn.createStatement();
			st.executeUpdate(dropPair);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	//Create and Drop the strategy table
	public void createStrategy() {
		String createStrategy = "CREATE TABLE STRATEGY(\r\n" + 
				"STRATEGY_ID INTEGER PRIMARY KEY,\r\n" + 
				"STRATEGY_NAME VARCHAR(35)\r\n" + 
				")";
				
		try {
			st = conn.createStatement();
			st.executeUpdate(createStrategy);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	//Drop Strategy
	public void dropStrategy() {
		String dropStrategy = "DROP TABLE STRATEGY";
		try {
			st = conn.createStatement();
			st.executeUpdate(dropStrategy);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	//Create the Confirmation table in the MySQL database
	public void createConfirmation() {
		String createConfirmation = "CREATE TABLE CONFIRMATION(\r\n" + 
				"CONFIRMATION_ID INTEGER PRIMARY KEY,\r\n" + 
				"CONFIRMATION_NAME VARCHAR(35)\r\n" + 
				")";
				
		try {
			st = conn.createStatement();
			st.executeUpdate(createConfirmation);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	//Drop the Confirmation table
	public void dropConfirmation() {
		String dropConfirmation = "DROP TABLE CONFIRMATION";
		try {
			st = conn.createStatement();
			st.executeUpdate(dropConfirmation);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	//Create the Pattern table
	public void createPattern() {
		String createPattern = "CREATE TABLE TRADE_PATTERN(\r\n" + 
				"PATTERN_ID INTEGER PRIMARY KEY,\r\n" + 
				"PATTERN_NAME VARCHAR(35)\r\n" + 
				"\r\n" + 
				")";
				
		try {
			st = conn.createStatement();
			st.executeUpdate(createPattern);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//Drop the pattern table
	public void dropPattern() {
		String dropPattern = "DROP TABLE TRADE_PATTERN";
		try {
			st = conn.createStatement();
			st.executeUpdate(dropPattern);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
		
		

	//Writes a new trade to the database
	public int newTrade(String SQL) {
		
		//SQL for newTrade
		
		//Need to write the sql for inserting all the values correctly into the 
		String newTrade;
		
		newTrade = SQL;
		
		
		try {
			st = conn.createStatement();
			st.executeUpdate(newTrade);
			
		} catch (Exception e) {
			System.out.println(e + "newTrade");
		}
		
		//Return the new Trade_ID that should be used
		return 1;
		
	}
	
	
	
	//All of the procedures required for NewTrade
	//Convert the pair name into an ID: "EUR/USD" --> 1
	//If the pairs is not found, a new entry in the database should be made and the correct ID returned
	
	public int getNewPairID() {
		return 1;
	}
	
	//Get the Pair_id give the pair
	public int getPairID(String pair) {
		return 1;
	}
	
	//Convert the strategy name into an index number of the strategy on the database
	//If it is not found it should create a new strategy with the given name and return the new ID
	public int getStrategyID(String stratName) {
		return 1;
	}
	
	//Get the index number of the entry in the database
	//IF not found--> Create new entry
	public int getConfirmationID(String confName) {
		return 1;
	}
	
	
	public int getPatternID(String patternName) {
		return 1;
	}
	
	
	public void getAllTrades() {

		String getalltrade = "SELECT * FROM TRADE;";
		try {
			st = conn.createStatement();
			st.executeUpdate(getalltrade);
			
		} catch (Exception e) {
			System.out.println(e + "newTrade");
		}
		
		
	}
	
	
	
	public void newPair() {
		
		
	}
	
	public void newStrategy() {
		
	}

	public void newPattern() {
		
	}
	
	public void newConfirmation() {
		
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


///////////////////////////////////////                                                                                                            ////////////////////////////////////
//////////////////////////////////////                                                  Procedures                                                             ////////////////////////////////////
//////////////////////////////////////                                                 SQL statements                                                    ////////////////////////////////////


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	//SELECT 
	public String selectStatement(String iState) {
		
		String resultSet;

		try {
			
			
			
			st = conn.createStatement();
			st.executeQuery(iState);
			
			
			rs.next();
			rs.getString("TRADE_ID");
			
			return  iState;
			
			
			
		} catch (Exception e) {
			System.out.println(e + "     Select Statement");
			return "FAILED";
		}
	}
	
	
	//INSERT
	public static void insertStatement() {
		
	}
	
	
	
}
