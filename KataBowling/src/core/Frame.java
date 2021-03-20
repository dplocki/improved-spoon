package core;

public class Frame {
	final static int NoResult = -1;

	private int firstThrowResult;
	private int secondThrowResult;
	
	public Frame(int firstThrowResult, int secondThrowResult) {
		this.firstThrowResult = firstThrowResult;
		this.secondThrowResult = secondThrowResult;
	}
	
	public int getFirstThrowResult() {
		return firstThrowResult;
	}

	public int getSecondThrowResult() {
		return secondThrowResult;
	}

	protected void setFirstThrowResult(int firstThrowResult) {
		this.firstThrowResult = firstThrowResult;
	}

	protected void setSecondThrowResult(int secondThrowResult) {
		this.secondThrowResult = secondThrowResult;
	}

	public int getHittedPinsNumber() {
		return firstThrowResult + secondThrowResult;
	}

	public boolean isSpare() {
		return firstThrowResult != BowlingRols.SpinsNumber && this.getHittedPinsNumber() == BowlingRols.SpinsNumber;
	}
	
	public boolean isStrike() {
		return firstThrowResult == BowlingRols.SpinsNumber;
	}
	
	public int getPinsNumberByHit(int number) {
		if (number == 1) {
			return firstThrowResult;
		} else if (number == 2 && !isStrike()) {
			return secondThrowResult;
		}

		return NoResult;
	}
}
