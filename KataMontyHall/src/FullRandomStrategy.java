
public class FullRandomStrategy extends AbstractStrategy {

	private int firstChoice;
	private int replaceGate;

	@Override
	public int firstQuestion() {
		this.firstChoice = this.generateGateNumber();
		return this.firstChoice;
	}

	@Override
	public void willYouReplaceYourGateWith(int gate) {
		this.replaceGate = gate;
	}

	@Override
	public int secondQuestion() {
		if (this.randomGenerator.nextBoolean()) {
			return this.firstChoice;
		} else {
			return this.replaceGate;
		}
	}

}
