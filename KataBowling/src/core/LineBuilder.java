package core;

import javax.management.RuntimeErrorException;

public class LineBuilder {
	private int firstThrowResult = 0;
	private int frameIndex = 0;
	private LastFrame lastFrame = null;

	public Line getLine(String line) {
		Line result = new Line();
		boolean isFirstThrowInTheFrame = true;

		startLineParsing();
		for(int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);

			if (isFirstThrowInTheFrame) {
				isFirstThrowInTheFrame = parseFirstThrowInFrame(c, result);
			} else {
				isFirstThrowInTheFrame = parseAnotherThrowInFrame(c, result);
			}
		}

		return result;
	}

	private boolean parseFirstThrowInFrame(char c, Line result) {
		if (isMeanStrike(c)) {
			result.addFrame(createFrame(BowlingRols.SpinsNumber, 0));

			if (!isLastFrame()) {
				return true;
			}
		} else {
			firstThrowResult = convertCharacterToValue(c);
		}

		return false;
	}

	private boolean parseAnotherThrowInFrame(char c, Line result) {
		int secondThrowResult;
		
		if (isMeanSpare(c)) {
			secondThrowResult = BowlingRols.SpinsNumber - firstThrowResult;
		} else {
			secondThrowResult = convertCharacterToValue(c);
		}

		if (lastFrame == null) {
			result.addFrame(createFrame(firstThrowResult, secondThrowResult));
			
			if (!isLastFrame()) {
				return true;
			}
		} else {
			lastFrame.addExtraThrowResult(secondThrowResult);
		}
		
		return false;
	}

	private boolean isMeanSpare(char c) {
		return c == '/';
	}

	private boolean isMeanStrike(char c) {
		return c == 'X';
	}

	private void startLineParsing() {
		firstThrowResult = 0;
		frameIndex = 0;
		lastFrame = null;
	}

	private boolean isLastFrame() {
		return frameIndex >= BowlingRols.FramesNumber;
	}
	
	private Frame createFrame(int firstThrowResult, int secondThrowResult) {
		frameIndex++;
		if (isLastFrame()) {
			lastFrame = new LastFrame(firstThrowResult, secondThrowResult);
			return lastFrame;
		} else {
			return new Frame(firstThrowResult, secondThrowResult);
		}
	}
	
	private int convertCharacterToValue(char character) {
		if (Character.isDigit(character)) {
			return Character.digit(character, 10);
		} else if (character == '-') {
			return 0;
		} else if (character == 'X') {
			return BowlingRols.SpinsNumber;
		}
		
		throw new RuntimeErrorException(null, "Character '" + character + "' not recognized");
	}
}
