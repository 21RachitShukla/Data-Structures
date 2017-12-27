package Dec21_22_24_25;

public class StackusingQ {
	Queue primary;

	public StackusingQ() {
		primary = new DynamicQueue();
	}

	public void push(int item) throws Exception {
		try {
			primary.enQueue(item);
		} catch (Exception e) {
			throw new Exception("Stack Overflow");
		}
	}

	public int pop() throws Exception {
		try {
			int rv;
			DynamicQueue helper = new DynamicQueue();
			while (primary.size() != 1) {
				int val = primary.deQueue();
				helper.enQueue(val);
			}
			rv = primary.deQueue();
			primary = helper;
			return rv;
		} catch (Exception e) {
			throw new Exception("Stack Underflow");

		}
	}

	public int top() throws Exception {
		try {
			int rv;
			DynamicQueue helper = new DynamicQueue();
			while (primary.size() != 1) {
				int val = primary.deQueue();
				helper.enQueue(val);
			}
			rv = primary.deQueue();
			helper.enQueue(rv);
			primary = helper;
			return rv;
		} catch (Exception e) {
			throw new Exception("Stack Underflow");

		}
	}

	public int size() {
		return primary.size();
	}

	public boolean isEmpty() {
		return primary.isEmpty();
	}

	public void display() throws Exception {

		this.display(0);

	}

	private void display(int count) throws Exception {
		if (count == primary.size())
			return;
		int val = primary.deQueue();
		primary.enQueue(val);
		display(count + 1);
		System.out.print(val + " ");
	}
}
