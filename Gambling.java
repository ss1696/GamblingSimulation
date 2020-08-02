
public class Gambling{
	
	// Initializing the Constants & Variables...
	final int STAKE = 100;
	final int BET = 1;
	final int NO_OF_DAYS_MONTH = 30;
	int numberOfGames;
	int goal;
	int dayWinAmt;
	int dayLossAmt;
	int cash;
	int totalcashAmtWon;
	int totalcashAmtLost;
	
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
	
	//This method is used to display total amount won & loose for each days after 20th day in a month..
	private void monthPlay() {
		goal = (STAKE * 50 / 100);
		int MaxWinAmout = STAKE + goal;
		int MaxLoseAmount = STAKE - goal;
		
		for(int i=1; i<=NO_OF_DAYS_MONTH; i++) {
			cash = STAKE;
			numberOfGames = 0;
			dayWinAmt = 0;
			dayLossAmt = 0;
			while(cash > MaxLoseAmount && cash < MaxWinAmout) {
				numberOfGames++;
				playGame();
			}
			
			if(dayWinAmt > dayLossAmt) {
				totalcashAmtWon = totalcashAmtWon + (dayWinAmt - dayLossAmt);
			} else {
				totalcashAmtLost = totalcashAmtLost + (dayLossAmt - dayWinAmt);
			}

			if(i >= 20) {
				System.out.println("Total Amount Won at day"+i+" "+totalcashAmtWon);
				System.out.println("Total Amount Lost at day"+i+" "+totalcashAmtLost);
			}	
		}	
	}
	
}
