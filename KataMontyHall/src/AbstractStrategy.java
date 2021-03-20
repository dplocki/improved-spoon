import java.util.Random;

public abstract class AbstractStrategy implements Strategy, GameStatistic{

	protected Random randomGenerator;
	protected int gamesNumber;
	protected int winGames;

	public AbstractStrategy() {
		this.randomGenerator = new Random();
		this.gamesNumber = 0;
		this.winGames = 0;
	}

	@Override
	public int getGamesNumber() {
		return gamesNumber;
	}

	@Override
	public int getWinGames() {
		return winGames;
	}

	@Override
	public void finalResult(boolean youWin) {
		this.gamesNumber++;
		
		if (youWin) {
			this.winGames++;
		}
	}
	
	protected int generateGateNumber() {
		return this.randomGenerator.nextInt(3) +1;
	}

}