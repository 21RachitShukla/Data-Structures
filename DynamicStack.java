package Dec21_22_24_25;

public class DynamicStack extends Stack {
	@Override
	public void push(int item) throws Exception {
		if (this.size() == this.data.length) {
			int[] os = this.data;
			int[] ns = new int[os.length * 2];

			for (int i = 0; i < this.size(); i++)
				ns[i] = os[i];
			this.data = ns;
		}
		super.push(item);
	}
}
