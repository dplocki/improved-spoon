
public class SpyStrategyToTestPointedGate implements Strategy {

	private int pointedGated;
	
	@Override
	public int firstQuestion() {
		return 1;
	}

	@Override
	public void willYouReplaceYourGateWith(int gate) {
		this.pointedGated = gate;
	}

	@Override
	public int secondQuestion() {
		return 1;
	}

	@Override
	public void finalResult(boolean youWin) {
	}

	public int getPointedGate() {
		return this.pointedGated;
	}
}
