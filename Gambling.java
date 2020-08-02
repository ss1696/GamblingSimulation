import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;;
public class Gambling{
	
	// Initializing the Constants & Variables...
	final int STAKE = 100;
	final int BET = 1;
	final int NO_OF_DAYS_MONTH = 30;
	int goal;
	int numberOfGames;
	int dayWinAmt;
	int dayLossAmt;
	int cash;
	int totalcashAmtWon;
	int totalcashAmtLost;
	float winPercentage;
	float loosePercentage;
	HashMap<Integer,Float> win = new HashMap<Integer,Float>();
	HashMap<Integer,Float> loss = new HashMap<Integer,Float>();
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Gambling Game."); 
		Gambling gambler = new Gambling();
		gambler.monthPlay();
	}
	
	//This method is used for calculating the cash for every play on the basis of win or loose and also updates the daily win & loose amount..  
	private void  playGame() {
		if(Math.random() < 0.5) {
			cash = cash + BET;
			dayWinAmt++;
		} else {
			cash = cash - BET;
			dayLossAmt++;
		}
	}
	
	//This method is used to display total amount won or lost for each days in a month..
	private void monthPlay() {
		goal = (STAKE * 50 / 100);
		int MaxWinAmout = STAKE + goal;
		int MaxLoseAmount = STAKE - goal;
		int i = 1;		
		while(i<=NO_OF_DAYS_MONTH) {
			cash = STAKE;
			numberOfGames = 0;
			dayWinAmt = 0;
			dayLossAmt = 0;
			while(cash > MaxLoseAmount && cash < MaxWinAmout) {
				numberOfGames++;
				playGame();
			}
			
			if(dayWinAmt > dayLossAmt) {
				winPercentage = ( dayWinAmt * 100 / numberOfGames );
				win.put(i, winPercentage);
				totalcashAmtWon = totalcashAmtWon + (dayWinAmt - dayLossAmt);
				System.out.println("Total Amount Won at day"+i+" "+totalcashAmtWon);
			}
			else {
				loosePercentage = ( dayLossAmt * 100 / numberOfGames );
				loss.put(i, loosePercentage);
				totalcashAmtLost = totalcashAmtLost + (dayLossAmt - dayWinAmt);
				System.out.println("Total Amount Lost at day"+i+" "+totalcashAmtLost);
			}
			i++;
		}
		check();
	}

	//This Method is used to check the luckiest and the unluckiest day for the gambler .....
	void check() {

		float maxWinDay=(Collections.max(win.values()));  
		for (Entry<Integer, Float> entry : win.entrySet()) { 
			if (entry.getValue() == maxWinDay) {
				System.out.println("The Luckiest Day of the Gambler is "+entry.getKey());     
			}
		}
		float maxLossDay=(Collections.max(loss.values()));  
		for (Entry<Integer, Float> entry : loss.entrySet()) { 
			if (entry.getValue()==maxLossDay) {
				System.out.println("The UnLuckiest Day of the Gambler is "+entry.getKey());     
			}
		}
	}
		
}
