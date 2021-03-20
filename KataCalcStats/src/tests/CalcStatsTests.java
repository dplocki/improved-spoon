package tests;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import core.CalcStats;

public class CalcStatsTests {

	@Test
	public void array_gives_its_average() {
		CalcStats calcStats = GetCalcStatsForArray(new Integer[] { 1, 3 });

		assertEquals(2, calcStats.getAverage(), 0);
	}

	@Test
	public void array_gives_zero_elements_count() {
		CalcStats calcStats = GetCalcStatsForArray(new Integer[] { 3, 33, 7 });

		assertEquals(3, calcStats.getElementsNumber());
	}

	@Test
	public void empty_array_gives_zero_as_average() {
		CalcStats calcStats = GetCalcStatsForEmptyCollection();

		assertEquals(0, calcStats.getAverage(), 0);
	}
	
	@Test
	public void empty_array_gives_zero_elements_count() {
		CalcStats calcStats = GetCalcStatsForEmptyCollection();

		assertEquals(0, calcStats.getElementsNumber());
	}

	@Test
	public void empty_collection_gives_null_minumum() {
		CalcStats calcStats = GetCalcStatsForEmptyCollection();

		assertEquals(null, calcStats.getMinium());
	}
	
	@Test
	public void more_than_one_value_gives_maxium() {
		Integer maxValue = 40;

		CalcStats calcStats = GetCalcStatsForArray(new Integer[] { 3, maxValue, 7 });

		assertEquals(maxValue, calcStats.getMaximum());
	}

	@Test
	public void more_than_one_values_gives_minimum() {
		Integer minimumValue = -10;

		CalcStats calcStats = GetCalcStatsForArray(new Integer[] { 3, minimumValue, 4 });

		assertEquals(minimumValue, calcStats.getMinium());
	}
	
	@Test
	public void null_gives_null_minumum() {
		CalcStats calcStats = GetCalcStatsForNull();

		assertEquals(null, calcStats.getMinium());
	}

	@Test
	public void null_gives_zero_as_average() {
		CalcStats calcStats = GetCalcStatsForNull();

		assertEquals(0, calcStats.getAverage(), 0);
	}

	@Test
	public void null_gives_zero_elements_count() {
		CalcStats calcStats = GetCalcStatsForNull();

		assertEquals(0, calcStats.getElementsNumber());
	}

	@Test
	public void single_element_array_gives_is_as_average() {
		Integer singleValue = 3;

		CalcStats calcStats = GetCalcStatsForArray(new Integer[] { singleValue });

		assertEquals(singleValue, calcStats.getAverage(), 0);
	}

	@Test
	public void single_value_gives_it_as_maxium() {
		Integer singleValue = 40;
		CalcStats calcStats =  GetCalcStatsForArray(new Integer[] { singleValue });
		
		assertEquals(singleValue, calcStats.getMaximum());
	}
	
	@Test
	public void single_value_gives_it_as_minimum() {
		Integer singleValue = 1;
		CalcStats calcStats = GetCalcStatsForArray(new Integer[] { singleValue });

		assertEquals(singleValue, calcStats.getMinium());
	}
	
	private CalcStats GetCalcStats(List<Integer> collection) {
		return new CalcStats(collection);
	}
	
	private CalcStats GetCalcStatsForArray(Integer[] integers) {
		List<Integer> collection = Arrays.asList(integers);
		
		CalcStats calcStats = GetCalcStats(collection);
		return calcStats;
	}
	
	private CalcStats GetCalcStatsForEmptyCollection() {
		return GetCalcStats(new LinkedList<Integer>());
	}
	
	private CalcStats GetCalcStatsForNull() {
		return GetCalcStats(null);
	}

}
