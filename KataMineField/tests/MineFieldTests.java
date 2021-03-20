import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MineFieldTests {
	
	private String expected;
	private int height;
	private int widht;
	private String map;

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {
			// Basic cases:
			{ "", 0, 0, "" },
			{ "0", 1, 1, "." },
			{ "*", 1, 1, "*" },
			
			// 1D cases:
			{ "00", 1, 2, ".." },
			{ "*1", 1, 2, "*." },
			{ "1*", 1, 2, ".*" },

			{ "01*", 1, 3, "..*" },
			{ "1*1", 1, 3, ".*." },
			{ "1**", 1, 3, ".**" },
			{ "*2*", 1, 3, "*.*" },
			
			// 2D cases:
			{ "000\n000", 2, 3, "...\n..." },
			{ "1*1\n111", 2, 3, ".*.\n..." },
			{ "*10\n110", 2, 3, "*..\n..." },
			{ "110\n*10\n110", 3, 3, "...\n*..\n..." },
			{ "111\n1*1\n111", 3, 3, "...\n.*.\n..." },
			{ "1**\n122\n000\n000", 4, 3, ".**\n...\n...\n..." },
		};

		return Arrays.asList(data);
	}

	public MineFieldTests(String expected, int height, int widht, String map) {
		this.expected = expected;
		this.height = height;
		this.widht = widht;
		this.map = map;
	}

	@Test
	public void test() {
		MineField mineField = new MineField();

		assertEquals("Test for:\n" + map + "\n", expected, mineField.calculate(height, widht, map));
	}
}
