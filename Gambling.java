public class Gambling{
	
	// Initializing the Varible ...
	final int Stake = 100;
	final int Bet = 1;
    	
	int numberOfGames,cash;

	public static void main(String[] args){
    		System.out.println("Welcome to the Gambling Game.");
    		GamblingPlay gambler = new GamblingPlay();
            	gambler.playGame();
    	}

    	// This method returns the value in int and is used for calculating the cash for every play on the basis of win or loose by invoking the winOrLoss method..
    	void game() {
             if(Math.random() < 0.5) {
                    cash+=Bet;
            		System.out.println("Won the game \n"+cash+" the value of Stake");
            }else {
                    cash-=Bet;
            		System.out.println("Loss the game \n"+cash+" the value of Stake");
            }
    	}
    
    	//This method is for calculate the cash till the gambler won or lost 50% of the cash
    	void playGame() {
            final int MaxWinAmout = Stake + (Stake * 50 / 100);
            final int MaxLoseAmount = Stake - (Stake * 50 / 100);
            cash = Stake;
            numberOfGames = 0;
            while(cash>MaxLoseAmount && cash<MaxWinAmout) {
            	numberOfGames++;
                game();
            }
    	}	
}
