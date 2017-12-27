package Dec21_22_24_25;

public class Stack {
	protected int[] data;
	protected int tos;

	public Stack() {
		this(5);
	}

	public Stack(int cap) {
		this.data = new int[cap];
		this.tos = -1;
	}

	public void push(int val) throws Exception {
		if (this.size() == this.tos + 2) {
			throw new Exception("Stack Underflow");
		}
		this.tos++;
		this.data[this.tos] = val;
	}

	public int pop() throws Exception {
		if (this.tos == -1) {
			throw new Exception("Stack Overflow");
		}
		int val = this.data[this.tos];
		this.data[this.tos] = 0;
		this.tos--;
		return val;
	}

	public int top() throws Exception {
		if (this.tos == -1) {
			throw new Exception("Stack Overflow");
		}
		int val = this.data[this.tos];
		return val;
	}

	public int size() {
		return this.tos + 1;
	}

	public void display() {
		for (int i = this.tos; i >= 0; i--) {
			System.out.print(this.data[i] + " ");
		}
		System.out.println();
	}
}
