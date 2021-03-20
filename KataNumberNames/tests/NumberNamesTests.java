import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class NumberNamesTests {

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {
			{ "zero", 0 },
			{ "one", 1 },
			{ "two", 2 },
			{ "three", 3 },
			{ "four", 4 },
			{ "five", 5 },
			{ "six", 6 },
			{ "seven", 7 },
			{ "eight", 8 },
			{ "nine", 9 },
			{ "ten", 10 },
			{ "eleven", 11 },
			{ "twelve", 12 },
			{ "thirteen", 13 },

			{ "fourteen", 14 },
			{ "eighteen", 18 },

			{ "twenty", 20 },
			{ "twenty-one", 21 },
			{ "twenty-three", 23 },
			{ "twenty-eight", 28 },
			
			{ "thirty", 30 },
			{ "thirty-one", 31 },
			{ "thirty-five", 35 },
			{ "forty-six", 46 },
			{ "fifty-two", 52 },
			{ "sixty-seven", 67 },
			{ "seventy-eight", 78 },
			{ "eighty-two", 82 },
			{ "ninety-one", 91 },

			{ "one hundred", 100 },
			{ "one hundred and one", 101 },
			{ "three hundred and twenty-one", 321 },
			{ "seven hundred and forty-three", 743 },

			{ "three thousand fifty-six", 3056 },
			{ "twenty-eight thousand three hundred and sixty-six", 28366 },
			{ "five hundred and twelve thousand six hundred and seven", 512607 },
			{ "forty-three million one hundred and twelve thousand six hundred and three", 43112603 },
		};
		
		return Arrays.asList(data);
	}

	private String expectedValue;
	private int givenValue;
	
	public NumberNamesTests(String expectedValue, int givenValue) {
		this.expectedValue = expectedValue;
		this.givenValue = givenValue;
	}
	
	@Test
	public void spellOut_test() {
		NumberNames numberNames = new NumberNames();
		
		assertEquals(expectedValue, numberNames.spellOut(givenValue));
	}

}
