import java.util.*;

public class Trade {
	
//Variables	
private String strategy, confirmation, position; 
private int tradeID;
private Date eDate;
private Double entryLevel, sl, tp1, tp2, tp3, riskReward, lotSize, profitLoss;
private Pair tPair = new Pair();


	
	public Trade(String strat, String conf, String pos, int tId, Date entryDate, Double eLevel, Double sl, Double tp1, Double tp2, Double tp3, Double lSize, Double rr, Double pnl) {
		// TODO Auto-generated constructor stub
	}

	
	//Write to server
	public Boolean WriteToServer() {
		
		
		
		
		return true;
	}

	public String getStrategy() {
		return strategy;
	}



	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}



	public String getConfirmation() {
		return confirmation;
	}



	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}



	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public int getTradeID() {
		return tradeID;
	}



	public void setTradeID(int tradeID) {
		this.tradeID = tradeID;
	}



	public Date geteDate() {
		return eDate;
	}



	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}



	public Double getEntryLevel() {
		return entryLevel;
	}



	public void setEntryLevel(Double entryLevel) {
		this.entryLevel = entryLevel;
	}



	public Double getSl() {
		return sl;
	}



	public void setSl(Double sl) {
		this.sl = sl;
	}



	public Double getTp1() {
		return tp1;
	}



	public void setTp1(Double tp1) {
		this.tp1 = tp1;
	}



	public Double getTp2() {
		return tp2;
	}



	public void setTp2(Double tp2) {
		this.tp2 = tp2;
	}



	public Double getTp3() {
		return tp3;
	}



	public void setTp3(Double tp3) {
		this.tp3 = tp3;
	}



	//Given the pair, entry, stop and tp --> calculate the risk reward ration
		public Double getRiskReward(String pair, Double entry, Double stop, Double tp) {
			return 0.0;
		}
		


	public void setRiskReward(Double riskReward) {
		this.riskReward = riskReward;
	}



	public Double getLotSize() {
		return lotSize;
	}



	public void setLotSize(Double lotSize) {
		this.lotSize = lotSize;
	}



	public Double getProfitLoss() {
		return profitLoss;
	}



	public void setProfitLoss(Double profitLoss) {
		this.profitLoss = profitLoss;
	}



	public Pair gettPair() {
		return tPair;
	}



	public void settPair(Pair tPair) {
		this.tPair = tPair;
	}

	
	
}
