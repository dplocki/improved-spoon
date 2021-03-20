import static org.junit.Assert.*;

import org.junit.Test;

public class NotAssertStrategyTests {

	@Test
	public void should_take_proposed_gate() {
		final int gatePropose = 2;
		Strategy strategy = new NotAssertStrategy();
		
		strategy.firstQuestion();
		strategy.willYouReplaceYourGateWith(gatePropose);
		
		int secondChoice = strategy.secondQuestion();
		
		assertEquals(gatePropose, secondChoice);
	}

}
