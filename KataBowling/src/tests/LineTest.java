package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import core.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class LineTest {
	private LineBuilder lineBuilder;
	private String lineValue;
	private int expectedResult;

	public LineTest(String line, int expectedResult) {
		this.lineValue = line;
		this.expectedResult = expectedResult;
		this.lineBuilder = new LineBuilder();
	}

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {
				// Simple cases:
				{ "--------------------",  0},
				{ "1-------------------",  1},
				{ "5-------------------",  5},
				{ "3-3-3-3-3-----------",  15},
				{ "9-9-9-9-9-9-9-9-9-9-",  90},
				
				// Spares
				{ "4/------------------",  BowlingRols.SpinsNumber},
				{ "4/4-----------------",  BowlingRols.SpinsNumber+4 + 4},
				{ "124/5---------------",  3 + BowlingRols.SpinsNumber+5 + 5},
				
				// Strikes
				{ "X------------------",   BowlingRols.SpinsNumber},
				{ "X12----------------",   BowlingRols.SpinsNumber+1+2 + 1 + 2},
				{ "XX1---------------",    BowlingRols.SpinsNumber+BowlingRols.SpinsNumber+1 + BowlingRols.SpinsNumber+1+0 + 1},
				{ "XXX1-------------",     BowlingRols.SpinsNumber+BowlingRols.SpinsNumber+BowlingRols.SpinsNumber + BowlingRols.SpinsNumber+BowlingRols.SpinsNumber+1 + BowlingRols.SpinsNumber+1+0 + 1},
				{ "X1/1---------------",   BowlingRols.SpinsNumber+1+(BowlingRols.SpinsNumber-1) + BowlingRols.SpinsNumber+1 + 1},

				// Endings
				{ "------------------1/1", BowlingRols.SpinsNumber+1 },
				{ "------------------X11", BowlingRols.SpinsNumber+1+1 },
				{ "------------------XXX", BowlingRols.SpinsNumber+BowlingRols.SpinsNumber+BowlingRols.SpinsNumber },
				
				// Specials
				{ "5/5/5/5/5/5/5/5/5/5/5", BowlingRols.SpinsNumber+5 + BowlingRols.SpinsNumber+5 + BowlingRols.SpinsNumber+5
					+ BowlingRols.SpinsNumber+5 + BowlingRols.SpinsNumber+5 + BowlingRols.SpinsNumber+5
					+ BowlingRols.SpinsNumber+5 + BowlingRols.SpinsNumber+5 + BowlingRols.SpinsNumber+5
					+ BowlingRols.SpinsNumber+5 },

				{ "XXXXXXXXXXXX",          BowlingRols.SpinsNumber+BowlingRols.SpinsNumber+BowlingRols.SpinsNumber
					+ BowlingRols.SpinsNumber+BowlingRols.SpinsNumber+BowlingRols.SpinsNumber
					+ BowlingRols.SpinsNumber+BowlingRols.SpinsNumber+BowlingRols.SpinsNumber
					+ BowlingRols.SpinsNumber+BowlingRols.SpinsNumber+BowlingRols.SpinsNumber
					+ BowlingRols.SpinsNumber+BowlingRols.SpinsNumber+BowlingRols.SpinsNumber
					+ BowlingRols.SpinsNumber+BowlingRols.SpinsNumber+BowlingRols.SpinsNumber
					+ BowlingRols.SpinsNumber+BowlingRols.SpinsNumber+BowlingRols.SpinsNumber
					+ BowlingRols.SpinsNumber+BowlingRols.SpinsNumber+BowlingRols.SpinsNumber
					+ BowlingRols.SpinsNumber+BowlingRols.SpinsNumber+BowlingRols.SpinsNumber
					+ BowlingRols.SpinsNumber+BowlingRols.SpinsNumber+BowlingRols.SpinsNumber},
			};
		
		return Arrays.asList(data);
	}

	@Test
	public void testOfResult() {
		Line line = lineBuilder.getLine(lineValue);

		assertEquals(String.format("Line '%s'", lineValue), expectedResult, line.getResult());
	}
}
 