package core;

public class LastFrame extends Frame {

	private int extraThrowResult;
	
	public LastFrame(int firstThrowResult, int secondThrowResult) {
		super(firstThrowResult, secondThrowResult);
		
		extraThrowResult = Frame.NoResult;
		
		if (firstThrowResult == BowlingRols.SpinsNumber) {
			super.setSecondThrowResult(Frame.NoResult);
		}
	}

	public void addExtraThrowResult(int result) {
		if (super.getSecondThrowResult() == Frame.NoResult) {
			super.setSecondThrowResult(result);
			return;
		}

		extraThrowResult = result;
	}
	
	@Override
	public int getPinsNumberByHit(int number) {
		if (number == 3) {
			return extraThrowResult;
		} else if (number == 2) {
			return super.getSecondThrowResult();
		}
		
		return super.getPinsNumberByHit(number);
	}

	@Override
	public boolean isSpare() {
		return false;
	}

	@Override
	public boolean isStrike() {
		return false;
	}

	@Override
	public int getHittedPinsNumber() {
		if (extraThrowResult != Frame.NoResult) {
			return super.getHittedPinsNumber() + extraThrowResult;
		}
		
		return super.getHittedPinsNumber();
	}
	
	
}
