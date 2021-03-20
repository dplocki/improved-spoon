public class MontyHall {
	private Strategy strategy;
	private int winningGateNumber;
	
	public MontyHall(RandomGenerator winningGateRandomGenerator) {
		this.winningGateNumber = winningGateRandomGenerator.getWinningGateNumber();
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public boolean playGame() {
		
		int firstPlayerChoice = this.strategy.firstQuestion();
		int pointGateToReplace = GetPaintGateToReplace(firstPlayerChoice);
		
		this.strategy.willYouReplaceYourGateWith(pointGateToReplace);
		int secondPlayerChoice = this.strategy.secondQuestion();
		
		boolean result = secondPlayerChoice == this.winningGateNumber;
		
		this.strategy.finalResult(result);
		
		return result;
	}

	private int GetPaintGateToReplace(int firstPlayerChoice) {
		int pointGateToReplace = 1;
		
		if (firstPlayerChoice == winningGateNumber) {
			switch(firstPlayerChoice) {
				case 1:
					pointGateToReplace = 2;
					break;
					
				case 2:
					pointGateToReplace = 3;
					break;
					
				case 3:
					pointGateToReplace = 1;
					break;
			}
		} else {
			pointGateToReplace = winningGateNumber;
		}
		
		return pointGateToReplace;
	}

}
