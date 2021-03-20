package core;

public class Line {
	private Frame[] frames;
	private int framesIndex = 0;
	
	public Line() {
		frames = new Frame[BowlingRols.FramesNumber];
		framesIndex = 0;
	}
	
	public void addFrame(Frame frame) {
		frames[framesIndex++] = frame;
	}
	
	public int getFramesNumber() {
		return framesIndex;
	}
	
	public Frame getFrame(int index) {
		return frames[index];
	}
	
	public int getResult() {
		int result = 0;

		for(int i = 0; i < BowlingRols.FramesNumber; i++){
			Frame actualFrame = frames[i];
			result += actualFrame.getHittedPinsNumber();
			
			if (actualFrame.isSpare()) {
				result += getHittedPinsNumberForNextThrows(1, i + 1);
			} else if (actualFrame.isStrike()) {
				result += getHittedPinsNumberForNextThrows(2, i + 1);
			}
		}

		return result;
	}

	private int getHittedPinsNumberForNextThrows(int throwInheadNumber, int startIndex) {
		if (startIndex == BowlingRols.FramesNumber) {
			startIndex--;
		}

		Frame frame = frames[startIndex];
		int result = 0;
		
		for(int i = 0; i < throwInheadNumber; i++) {
			int hits = frame.getPinsNumberByHit(i + 1);
			if (hits != Frame.NoResult) {
				result += hits;
			} else {
				return result + getHittedPinsNumberForNextThrows(throwInheadNumber - i, startIndex + 1);
			}
		}

		return result;
	}
}
