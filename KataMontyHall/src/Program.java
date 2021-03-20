
public class Program {

	public static void main(String[] args) {
		
		System.out.println("Consequent Strategy:");
		PlayWithStrategy(new ConsequentStrategy());
		
		System.out.println("Not assert Strategy:");
		PlayWithStrategy(new NotAssertStrategy());

		System.out.println("Full random Strategy:");
		PlayWithStrategy(new FullRandomStrategy());
	}

	private static void PlayWithStrategy(AbstractStrategy consequentStrategy) {
		MontyHall montyHall = new MontyHall(new StandardRandomGenerator());
		montyHall.setStrategy(consequentStrategy);

		for(int i = 0; i < 10000; i++) {
			montyHall.playGame();
		}

		System.out.print("\tWins: ");
		System.out.println(consequentStrategy.getWinGames());

		System.out.print("\tGames: ");
		System.out.println(consequentStrategy.getGamesNumber());
		
		System.out.print("\tProcent: ");
		System.out.print((double)consequentStrategy.getWinGames() / (double)consequentStrategy.getGamesNumber() * 100);
		System.out.println("%");
	}

}
