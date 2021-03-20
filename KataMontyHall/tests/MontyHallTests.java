import static org.junit.Assert.*;
import org.junit.Test;


public class MontyHallTests {

	@Test(expected=NullPointerException.class)
	public void null_strategy_case_exception() {
		playMontyHallWithStrategy(null, 1);
		
		fail("Exception should emarged earlier");
	}

	@Test
	public void check_algoryth_of_strategy_use() {
		
		SpyStrategyCorrectStepsOrder spyStrategy = new SpyStrategyCorrectStepsOrder();
		playMontyHallWithStrategy(spyStrategy, 1);
		
		assertTrue("Check if all steps was asked in correct order", spyStrategy.wasOK());
	}
	
	@Test
	public void when_strategy_choose_1_and_goat_is_after_2_and_3_host_should_point_2_or_3() {
		SpyStrategyToTestPointedGate spyStrategyToTestPointedGate = new SpyStrategyToTestPointedGate();
		
		playMontyHallWithStrategy(spyStrategyToTestPointedGate, 1);
		
		int result = spyStrategyToTestPointedGate.getPointedGate();
		
		assertTrue(result == 2 || result == 3);
	}

	@Test
	public void when_strategy_choose_2_and_goat_is_after_1_and_2_host_should_point_3() {
		SpyStrategyToTestPointedGate spyStrategyToTestPointedGate = new SpyStrategyToTestPointedGate();
		
		playMontyHallWithStrategy(spyStrategyToTestPointedGate, 3);
		
		assertEquals(3, spyStrategyToTestPointedGate.getPointedGate());
	}

	@Test
	public void should_win_when_strategy_choose_correcty() {
		boolean result = playMontyHallWithStrategy(new SpyStrategyCorrectStepsOrder(), 1);
		
		assertTrue(result);
	}
	
	@Test
	public void should_loose_when_strategy_choose_incorrecty() {
		boolean result = playMontyHallWithStrategy(new SpyStrategyCorrectStepsOrder(), 2);
		
		assertFalse(result);
	}
	
	private boolean playMontyHallWithStrategy(Strategy strategy, int winGate) {
		MontyHall montyHall = new MontyHall(new WinningGateRandomGenerator(winGate));
		montyHall.setStrategy(strategy);

		return montyHall.playGame();
	}
}
