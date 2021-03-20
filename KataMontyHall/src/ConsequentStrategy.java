public class ConsequentStrategy extends AbstractStrategy {
	private int choice;
	
	public ConsequentStrategy() {
		super();
	}
	
	@Override
	public int firstQuestion() {
		this.choice = this.generateGateNumber();
		
		return this.choice;
	}

	@Override
	public void willYouReplaceYourGateWith(int gate) {
	}

	@Override
	public int secondQuestion() {
		return this.choice;
	}

}
