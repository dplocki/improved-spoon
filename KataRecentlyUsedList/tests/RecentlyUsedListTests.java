import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class RecentlyUsedListTests {

	@Test
	public void should_be_empty_after_initialisation() {
		RecentlyUsedList recentlyUsedList = getRecentlyUsedList();

		assertEquals(0, recentlyUsedList.count());
	}

	@Test
	public void should_renember_first_string() {
		RecentlyUsedList recentlyUsedList = getRecentlyUsedList();
		
		String lore = "lore";
		recentlyUsedList.push(lore);
		
		assertEquals(1, recentlyUsedList.count());
		assertEquals(lore, recentlyUsedList.pop());
	}

	@Test
	public void should_renember_first_and_second_string() {
		RecentlyUsedList recentlyUsedList = getRecentlyUsedList();
		
		String first = "lore";
		String second = "ipsum";
		
		recentlyUsedList.push(first);
		recentlyUsedList.push(second);
		
		assertEquals(2, recentlyUsedList.count());
	}
	
	@Test
	public void pop_should_removed_value_from_memory() {
		RecentlyUsedList recentlyUsedList = getRecentlyUsedList();
		
		String first = "lore";
		
		recentlyUsedList.push(first);
		recentlyUsedList.pop();

		assertEquals(0, recentlyUsedList.count());
	}

	@Test
	public void should_returns_renembered_strings_in_revers_order() {
		RecentlyUsedList recentlyUsedList = getRecentlyUsedList();

		String first = "lore";
		String second = "ipsum";
		
		recentlyUsedList.push(first);
		recentlyUsedList.push(second);

		assertEquals(second, recentlyUsedList.pop());
		assertEquals(first, recentlyUsedList.pop());
	}
	
	@Test
	public void null_values_should_be_ignored() {
		RecentlyUsedList recentlyUsedList = getRecentlyUsedList();
		
		String first = null;
		recentlyUsedList.push(first);
		
		assertEquals(0, recentlyUsedList.count());
	}

	@Test
	public void values_should_be_unique() {
		RecentlyUsedList recentlyUsedList = getRecentlyUsedList();
		
		String first = "lore";
		
		recentlyUsedList.push(first);
		recentlyUsedList.push(first);
		
		assertEquals(1, recentlyUsedList.count());
	}
	

	@Test
	public void repeated_values_should_be_moved_on_beginning() {
		RecentlyUsedList recentlyUsedList = getRecentlyUsedList();

		String first = "lore";
		String second = "ipsum";

		recentlyUsedList.push(first);
		recentlyUsedList.push(second);
		recentlyUsedList.push(first);

		assertEquals(2, recentlyUsedList.count());
		assertEquals(first, recentlyUsedList.pop());
		assertEquals(second, recentlyUsedList.pop());
	}
	
	@Test
	public void should_keep_capacity() {
		RecentlyUsedList recentlyUsedList = getRecentlyUsedList(2);

		String first = "lore";
		String second = "ipsum";
		String third = "quia";
		
		recentlyUsedList.push(first);
		recentlyUsedList.push(second);
		recentlyUsedList.push(third);
		
		assertEquals(2, recentlyUsedList.count());
	}
	
	@Test
	public void should_removed_the_laeasted_when_capacity_is_over() {
		RecentlyUsedList recentlyUsedList = getRecentlyUsedList(2);

		String first = "lore";
		String second = "ipsum";
		String third = "quia";
		String fourth = "dolor";
		
		recentlyUsedList.push(first);
		recentlyUsedList.push(second);
		recentlyUsedList.push(third);
		recentlyUsedList.push(fourth);
		
		assertEquals(2, recentlyUsedList.count());
		assertEquals(fourth, recentlyUsedList.pop());
		assertEquals(third, recentlyUsedList.pop());
	}
	
	private RecentlyUsedList getRecentlyUsedList() {
		return new RecentlyUsedList();
	}

	private RecentlyUsedList getRecentlyUsedList(int capacity) {
		return new RecentlyUsedList(capacity);
	}
}
