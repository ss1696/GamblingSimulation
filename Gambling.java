public class Gambling{
	
	// Initializing the Varible ...
	static int STAKE = 100;
	final static int BET = 1;
	static int numberOfGames=0;
	
	public static void main(String[] args){
		Gambling gambler = new Gambling();
		gambler.winOrLoss();
	}

	//This function return true(Win) when probability is less then 0.5 else return false(loss) and update the Stake with bet value
	static boolean winOrLoss(){
		numberOfGames++;
		if(Math.random() < 0.5){
			System.out.println("You won!!");
			Stake += Bet;
			return true;
		}else{
			System.out.println("You Loose!!");
			Stake -= Bet;
			return false;
		}
	}
}
