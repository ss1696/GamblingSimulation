public class Gambling{
	
	// Initializing the Varible ...
	static int stake = 100;
	final static int Bet = 1;
	static int numberOfGames=0;
	
	public static void main(String[] args){
		display();
		playGame();
	}
	
	// This method is used to display the Gambling Game starting
	static void display() {
		System.out.println("Welcome to the Gambling Game."); 
	}
	
	// This method returns true(Win) ewhen probability is less than 0.5 else return false(loose)..	
	static boolean winOrLoss() {
		
		if(Math.random() < 0.5) {
			return true;
		}else {
			return false;
		}
	}
	
	//This method is for calculate the stake till the gambler won or lost 50% of the stake
	static void playGame() {
	
		game();
		
		final int MaxWinAmout = stake + (stake * 50 / 100);
		final int MaxLoseAmount = stake - (stake * 50 / 100);

		while(stake>= MaxLoseAmount && stake<=MaxWinAmout) {
			game();
		}
		
	}
	
	// This method returns the value in int and is used for calculating the stake for every play on the basis of win or loose by invoking the winOrLoss method..
	static int  game() {
		
		numberOfGames++;
		
		 if(winOrLoss()) {
			stake+=Bet;
			System.out.println("You won!! \n The new Stake value is "+stake);
		}else {
			stake-=Bet;
			System.out.println("You Lose!! \n The new Stake value is" +stake);
		}
		 
		 return stake;
	}
	
}
