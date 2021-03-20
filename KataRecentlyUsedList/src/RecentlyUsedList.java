import java.util.Stack;

public class RecentlyUsedList {
	public final static int DefaultCapacity = 20;
	
	private Stack<String> memory;
	private int capacity;

	public RecentlyUsedList() {
		this(DefaultCapacity);
	}

	public RecentlyUsedList(int capacity) {
		this.memory = new Stack<String>();
		this.capacity = capacity;
	}

	public int count() {
		return memory.size();
	}

	public void push(String value) {
		if (value == null) {
			return;
		}
	
		if (capacity == this.count()) {
			this.memory.remove(this.memory.firstElement());
		}

		this.memory.remove(value);
		this.memory.push(value);
	}

	public String pop() {
		return this.memory.pop();
	}

}
