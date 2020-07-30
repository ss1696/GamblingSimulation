public class Gambling{
	
	// Initializing the Varible ...
	//CONSTANT
	static int Stake = 100;
	final static int Bet = 1;
	
	int numberOfGames=0;
	
	public static void main(String[] args){
		Gambling gambler = new Gambler();
		gambler.winOrLoss();
	}

	static boolean winOrLoss(){
		
		numberOfGames++;
		if(Math.random()<0.5){
			System.out.println("You won!!");
			Stake+=Bet;
			return true;
		}else{
			System.out.println("You Loose!!");
			Stake-=Bet;
			return false;
		}
	}
}
