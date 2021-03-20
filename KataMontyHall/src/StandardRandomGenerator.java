import java.util.Random;


public class StandardRandomGenerator implements RandomGenerator {

	private Random randomGenerator;
	
	public StandardRandomGenerator() {
		this.randomGenerator = new Random();
	}

	@Override
	public int getWinningGateNumber() {

		return this.randomGenerator.nextInt(3) +1 ;
	}

}
