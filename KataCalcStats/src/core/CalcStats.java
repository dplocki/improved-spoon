package core;
import java.util.List;

public class CalcStats {

	private List<Integer> collection;
	private Integer minimum = null;
	private Integer maximum = null;
	private int sum = 0;
	private boolean isCalculated = false;

	public CalcStats(List<Integer> collection) {
		this.collection = collection;
	}

	public double getAverage() {
		calculate();
		
		if (sum != 0) {
			return sum/getElementsNumber();
		}

		return 0;
	}

	public int getElementsNumber() {
		if (collection != null) {
			return collection.size();
		}

		return 0;
	}

	public Integer getMaximum() {
		calculate();
		return maximum;
	}

	public Integer getMinium() {
		calculate();
		return minimum;
	}

	private void calculate() {
		if (isCalculated || collection == null) {
			return;
		}

		for (Integer value : collection) {
			calculateMinimum(value);
			calculateMaximum(value);
			calculateSum(value);
		}

		isCalculated = true;
	}

	private void calculateMaximum(Integer value) {
		if (maximum == null || value > maximum) { 
			maximum = value;
		}
	}

	private void calculateMinimum(Integer value) {
		if (minimum == null || value < minimum) { 
			minimum = value;
		}
	}

	private void calculateSum(Integer value) {
		sum += value;
	}
}
