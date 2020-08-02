public class Gambling{
	
	// Initializing Constant and the Varible ...
	final int STAKE = 100;
	final int BET = 1;
    	int cash;
	int goal;
	int numberOfGames;

	public static void main(String[] args){
    		System.out.println("Welcome to the Gambling Game.");
    		Gambling gambler = new Gambling();
            	gambler.playGame();
    	}

    	// This method returns the value in int and is used for calculating the cash for every play on the basis of win or loose by invoking the winOrLoss method..
    	void game() {
             if(Math.random() < 0.5) {
                    cash += BET;
            		System.out.println("Won the game \n"+cash+" the value of Stake");
            }else {
                    cash -= BET;
            		System.out.println("Loss the game \n"+cash+" the value of Stake");
            }
    	}
    
    	//This method is for calculate the cash till the gambler won or lost 50% of the cash
    	void playGame() {
	    goal =  (STAKE * 50 / 100);
            final int MaxWinAmout = STAKE + goal;
            final int MaxLoseAmount = STAKE - goal;
            cash = STAKE;
            numberOfGames = 0;
            while(cash > MaxLoseAmount && cash < MaxWinAmout) {
            	numberOfGames++;
                game();
            }
    	}	
}
