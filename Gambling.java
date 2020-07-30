
public class Gambling{
	
	// Initializing the Constants & Variables...
	final int Stake = 100;
	final int Bet = 1;
	final int NoOfDayInMonth = 30;
	int numberOfGames, dayWinAmt, dayLossAmt,cash;
	int totalcashAmtWon, totalcashAmtLost;
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Gambling Game."); 
		Gambling gambler = new Gambling();
		gambler.monthPlay();
	}
	
	//This method is used for calculating the cash for every play on the basis of win or loose and also updates the daily win & loose amount..  
	private void  playGame() {
		if(Math.random() < 0.5) {
			cash = cash + Bet;
			dayWinAmt++;
		} else {
			cash = cash - Bet;
			dayLossAmt++;
		}
	}
	
	//This method is used to display total amount won or lost for each days in a month..
	private void monthPlay() {
		int MaxWinAmout = Stake + (Stake*50/100);
		int MaxLoseAmount = Stake -(Stake*50/100);
		int i = 1;		
		while(i<=NoOfDayInMonth) {
			cash = Stake;
			numberOfGames = 0;dayWinAmt = 0;dayLossAmt = 0;
			while(cash>MaxLoseAmount && cash<MaxWinAmout) {
				numberOfGames++;
				playGame();
			}
			
			if(dayWinAmt > dayLossAmt) {
				totalcashAmtWon = totalcashAmtWon + (dayWinAmt - dayLossAmt);
				System.out.println("Total Amount Won at day"+i+" "+totalcashAmtWon);
			}
			else {
				totalcashAmtLost = totalcashAmtLost + (dayLossAmt - dayWinAmt);
				System.out.println("Total Amount Lost at day"+i+" "+totalcashAmtLost);
			}
			i++;
		}	
	}
	
}
