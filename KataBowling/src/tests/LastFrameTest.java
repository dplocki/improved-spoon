package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import core.LastFrame;

public class LastFrameTest {

	@Test
	public void withSpareTest() {
		LastFrame lastFrame = new LastFrame(4, 6);
		lastFrame.addExtraThrowResult(3);

		assertEquals("First throw result", 4, lastFrame.getPinsNumberByHit(1));
		assertEquals("Second throw result", 6, lastFrame.getPinsNumberByHit(2));
		assertEquals("Third throw result", 3, lastFrame.getPinsNumberByHit(3));
	}
	
	@Test
	public void withStrikeTest() {
		LastFrame lastFrame = new LastFrame(10, 0);
		lastFrame.addExtraThrowResult(3);
		lastFrame.addExtraThrowResult(5);

		assertEquals("First throw result", 10, lastFrame.getPinsNumberByHit(1));
		assertEquals("Second throw result", 3, lastFrame.getPinsNumberByHit(2));
		assertEquals("Third throw result", 5, lastFrame.getPinsNumberByHit(3));
	}

}
