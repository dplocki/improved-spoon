
public class SpyStrategyCorrectStepsOrder implements Strategy {

	private int step = 0;
	
	@Override
	public int firstQuestion() {
		if (step == 0) {
			step = 1;
		}
		
		return 1;
	}

	@Override
	public void willYouReplaceYourGateWith(int gate) {
		if (step == 1) {
			step = 2;
		}
	}

	@Override
	public int secondQuestion() {
		if (step == 2) {
			step = 3;
		}

		return 1;
	}

	@Override
	public void finalResult(boolean youWin) {
		if (step == 3) {
			step = 4;
		}
	}

	public boolean wasOK() {
		return step == 4;
	}
}
