import static org.junit.Assert.*;

import org.junit.Test;

public class FizzBuzzTests {

	@Test
	public void should_return_number_1() {
		FizzBuzz fizzBuzz = buildFizzBuzz();
		
		assertEquals("1", fizzBuzz.getFizzBuzz(1));
	}

	@Test
	public void should_return_fizz_for_3() {
		FizzBuzz fizzBuzz = buildFizzBuzz();
		
		assertEquals("Fizz", fizzBuzz.getFizzBuzz(3));
	}

	@Test
	public void should_return_buzz_for_5() {
		FizzBuzz fizzBuzz = buildFizzBuzz();
		
		assertEquals("Buzz", fizzBuzz.getFizzBuzz(5));
	}

	@Test
	public void should_return_fizzbuzz_for_15() {
		FizzBuzz fizzBuzz = buildFizzBuzz();
		
		assertEquals("FizzBuzz", fizzBuzz.getFizzBuzz(15));
	}
	
	private FizzBuzz buildFizzBuzz() {
		return new FizzBuzz();
	}

}
