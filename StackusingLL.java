package Dec21_22_24_25;

public class StackusingLL {
	private LinkedList ll = new LinkedList();

	public void push(int item) {
		ll.addFirst(item);
	}

	public void pop() throws Exception {
		ll.removeFirst();
	}

	public void size() {
		ll.size();
	}

	public void isEmpty() {
		ll.isEmpty();
	}

	public void display() {
		ll.display();
	}
}
