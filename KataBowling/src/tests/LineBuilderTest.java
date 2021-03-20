package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import core.Frame;
import core.LastFrame;
import core.Line;
import core.LineBuilder;

public class LineBuilderTest {

	private LineBuilder lineBuilder;

	@Before
	public void Initialise() {
		lineBuilder = new LineBuilder();
	}

	@Test
	public void noSparesOrSplits() {
		Line line = lineBuilder.getLine("12345678901234567890");

		assertEquals(10, line.getFramesNumber());
	}

	@Test
	public void noSparesOrSplitsWithMisses() {
		Line line = lineBuilder.getLine("123-5678-012345-789-");

		assertEquals(10, line.getFramesNumber());
	}

	@Test
	public void withSpare() {
		Line line = lineBuilder.getLine("123/56780/12345/78-/");

		assertEquals(10, line.getFramesNumber());
	}

	@Test(expected = Exception.class)
	public void withSpareInncorect() {
		Line line = lineBuilder.getLine("123/5678/012345/78-/");

		assertEquals(10, line.getFramesNumber());
	}

	@Test
	public void withStrike() {
		Line line = lineBuilder.getLine("X3/56780/12345/78-/");

		assertEquals(10, line.getFramesNumber());
	}
	
	@Test
	public void withSpareOnEnd() {
		Line line = lineBuilder.getLine("1122334411223344114/-");

		assertEquals(10, line.getFramesNumber());
		
		Frame lastFrame = line.getFrame(9);
		
		assertSame(LastFrame.class, lastFrame.getClass());
		assertEquals("First throw result:", 4, lastFrame.getPinsNumberByHit(1));
		assertEquals("Second throw result:", 6, lastFrame.getPinsNumberByHit(2));
		assertEquals("Third throw result:", 0, lastFrame.getPinsNumberByHit(3));
	}
	
	@Test
	public void withStrikeOnEnd() {
		Line line = lineBuilder.getLine("112233441122334411X27");

		assertEquals(10, line.getFramesNumber());

		Frame lastFrame = line.getFrame(9);

		assertSame(LastFrame.class, lastFrame.getClass());
		assertEquals("First throw result:", 10, lastFrame.getPinsNumberByHit(1));
		assertEquals("Second throw result:", 2, lastFrame.getPinsNumberByHit(2));
		assertEquals("Third throw result:", 7, lastFrame.getPinsNumberByHit(3));
	}
}
