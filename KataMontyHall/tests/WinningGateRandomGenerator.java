public class WinningGateRandomGenerator implements RandomGenerator {
	private int winGateNumber;
	
	public WinningGateRandomGenerator(int winGate) {
		this.winGateNumber = winGate;
	}

	@Override
	public int getWinningGateNumber() {
		return this.winGateNumber;
	}
}
