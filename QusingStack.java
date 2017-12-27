package Dec21_22_24_25;

public class QusingStack {
	Stack primary;

	public QusingStack() {
		primary = new DynamicStack();
	}

	public void enQueue(int val) throws Exception {
		try {
			primary.push(val);
		} catch (Exception e) {
			throw new Exception("Queue is full");
		}
	}

	public void enQueue1(int item) throws Exception {
		Stack helper = new DynamicStack();
		try {
			while (primary.size() != 0) {
				int j = primary.pop();
				helper.push(j);
			}
			helper.push(item);
			while (helper.size() != 0) {
				int j = helper.pop();
				primary.push(j);
			}
		} catch (Exception e) {
			throw new Exception("Queue is full");

		}
	}

	public void deQueue() throws Exception {
		Stack helper = new DynamicStack();
		try {
			while (primary.size() != 0) {
				int j = primary.pop();
				helper.push(j);
			}
			helper.pop();
			while (helper.size() != 0) {
				int j = helper.pop();
				primary.push(j);
			}
		} catch (Exception e) {
			throw new Exception("Queue is empty");

		}
	}

	public void deQueue1() throws Exception {
		try {
			primary.pop();
		} catch (Exception e) {
			throw new Exception("Queue is empty");
		}
	}

	public int size() {
		return primary.size();
	}

	public int getFront() throws Exception {
		Stack helper = new DynamicStack();
		int rv;
		try {
			while (primary.size() != 0) {
				int j = primary.pop();
				helper.push(j);
			}
			rv = helper.top();
			while (helper.size() != 0) {
				int j = helper.pop();
				primary.push(j);
			}
		} catch (Exception e) {
			throw new Exception("Queue is empty");

		}
		return rv;
	}

	public int getFront1() throws Exception {
		try {
			return primary.top();
		} catch (Exception e) {
			throw new Exception("Queue is empty");

		}
	}

	public boolean isEmpty() {
		if (primary.size() == 0)
			return true;
		else
			return false;
	}

	public void display() throws Exception {
		if (this.size() == 0)
			return;
		int temp = primary.pop();
		this.display();
		System.out.print(temp + " ");
		primary.push(temp);
	}

	public void display1() {
		for (int i = 0; i < primary.tos; i--) {
			System.out.print(primary.data[i] + " ");
		}
		System.out.println();
	}
}
