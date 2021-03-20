
public class NotAssertStrategy extends AbstractStrategy {

	private int suggestedGate;
	
	@Override
	public int firstQuestion() {
		return this.generateGateNumber();
	}

	@Override
	public void willYouReplaceYourGateWith(int gate) {
		this.suggestedGate = gate;
	}

	@Override
	public int secondQuestion() {
		return this.suggestedGate;
	}

}
