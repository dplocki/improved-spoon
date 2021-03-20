import static org.junit.Assert.*;

import org.junit.Test;

public class ConsequentStrategyTests {

	@Test
	public void should_always_stick_to_firstchoice() {
		Strategy strategy = new ConsequentStrategy();
		
		int firstChoice = strategy.firstQuestion();
		int secondChoice = strategy.secondQuestion();
		
		assertTrue(firstChoice == secondChoice);
	}

}
