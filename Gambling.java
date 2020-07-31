import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Gambling{
	
	// Initializing the Constants & Variables...
	final int Stake = 100;
	final int Bet = 1;
	final int NoOfDayInMonth = 30;
	int numberOfGames, dayWinAmt, dayLossAmt,cash;
	int totalcashAmtWon, totalcashAmtLost;
	static int winCount;
	float winPercentage, loosePercentage;
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
		
		// This will return max value in the Hashmap through which we get the gambler's luckiest and Unluckiest Day
		float maxWinDay=(Collections.max(win.values()));  
		for (Entry<Integer, Float> entry : win.entrySet()) { 
			if (entry.getValue()==maxWinDay) {
				System.out.println("The Luckiest Day of the Gambler is "+entry.getKey());     
			}
		}
		float maxLossDay=(Collections.max(loss.values()));  
		for (Entry<Integer, Float> entry : loss.entrySet()) { 
			if (entry.getValue()==maxLossDay) {
				System.out.println("The UnLuckiest Day of the Gambler is "+entry.getKey());     
			}
		}
		toPlayAgain();
	}

	//This method check whether gambler win for this month or not and if gambler win than it will asked to him whether he want to play for another month
	static void toPlayAgain() {
		
		if(winCount > 15) {
			System.out.println("Congrats!! You Win the game for this Month. \n Do you Want to Play Again for another month..\n Enter your choice 1)Yes 2)No ");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1: 
					main(null);
					break ;
				case 2:
					System.out.println("Thankyou for Playing. Hope You Enjoyed the Game. Please Come Again");
					break ;
				default :
					System.out.println("Enter a Valid Choice.. You have enter a wrong choice.");
			}
			sc.close();
		}else {
			System.out.println("Sorry!! You Lost the game for this Month.");
		}

	}
	
}
