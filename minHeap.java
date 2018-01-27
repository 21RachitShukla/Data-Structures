package Jan13;

import java.util.ArrayList;

public class minHeap {
	private ArrayList<Integer> data = new ArrayList<>();

	private void upheapify(int ci) {
		int pi = (ci - 1) / 2;
		if (data.get(ci) < data.get(pi)) {
			swap(ci, pi);
			upheapify(pi);
		}
	}

	private void downheapify(int pi) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int mini = pi;
		if (lci < data.size() && data.get(lci) < data.get(mini)) {
			mini = lci;
		}
		if (rci < data.size() && data.get(rci) < data.get(mini)) {
			mini = rci;
		}
		if (rci < data.size() && lci < data.size()) {
			if (mini != pi) {
				swap(mini, pi);
				downheapify(mini);
			}
		}
	}

	private void swap(int ci, int pi) {
		int a = data.get(ci);
		int b = data.get(pi);
		data.set(ci, b);
		data.set(pi, a);
	}

	public void add(int item) {
		data.add(item);
		upheapify(data.size() - 1);
	}

	public int get() {
		return this.data.get(0);
	}

	public int remove() {
		swap(0, data.size() - 1);
		int rv = data.remove(data.size() - 1);
		downheapify(0);
		return rv;
	}

	public void display() {
		System.out.println(data);
	}

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}
}
