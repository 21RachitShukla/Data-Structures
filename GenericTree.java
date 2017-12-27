package Dec21_22_24_25_26;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class GenericTree {
	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	Node root;
	int size;

	public GenericTree() {
		this.root = takeInput(new Scanner(System.in), null, -1);
	}

	public Node takeInput(Scanner scn, Node parent, int ith) {
		if (parent == null)
			System.out.println("Enter data for root node: ");
		else
			System.out.println("Enter data for " + ith + " child of " + parent.data);

		Node nn = new Node();
		nn.data = scn.nextInt();
		this.size++;

		System.out.println("No. of children of " + nn.data);
		int nc = scn.nextInt();

		for (int i = 0; i < nc; i++) {
			Node child = takeInput(scn, nn, i);
			nn.children.add(child);
		}
		return nn;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void display() {
		display(this.root);
	}

	private void display(Node n) {
		String str = n.data + " -> ";
		for (Node child : n.children) {
			str += child.data + ", ";
		}
		str += ".";
		System.out.println(str);
		for (Node child : n.children) {
			display(child);
		}
	}

	public int size1() {
		return this.size1(this.root);
	}

	private int size1(Node n) {
		int c = 0;
		for (Node child : n.children) {
			c += size1(child);
		}
		return c + 1;
	}

	public int leaf() {
		return this.leaf(this.root);
	}

	static int ctr = 0;

	private int leaf(Node n) {
		if (n.children.size() == 0)
			ctr++;
		for (Node child : n.children) {
			leaf(child);
		}
		return ctr;
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node n) {
		int c = 0;
		int max = 0;
		for (Node child : n.children) {
			c = height(child);
			if (c > max)
				max = c;
			c = c + max;
		}
		return c;
	}

	public int max() {
		return this.max(this.root);
	}

	public int max(Node n) {
		int c = 0;
		int max = n.data;
		for (Node child : n.children) {
			c = max(child);
			if (c > max)
				max = c;
		}
		return max;
	}

	public boolean find(int item) {
		return this.find(this.root, item);
	}

	private boolean find(Node node, int item) {

		if (node.data == item) {
			return true;
		}

		for (Node child : node.children) {
			boolean cf = find(child, item);
			if (cf)
				return true;
		}

		return false;
	}

	public void mirror() {
		this.mirror(this.root);
	}

	private void mirror(Node node) {

		for (Node child : node.children) {
			mirror(child);
		}

		int li = 0;
		int ri = node.children.size() - 1;

		while (li < ri) {

			Node lnode = node.children.get(li);
			Node rnode = node.children.get(ri);

			node.children.set(li, rnode);
			node.children.set(ri, lnode);

			li++;
			ri--;
		}

	}

	public void preorder() {
		preorder(this.root);
	}

	private void preorder(Node node) {

		System.out.print(node.data + " ");

		for (Node child : node.children) {
			preorder(child);
		}

	}

	public void postorder() {
		postorder(this.root);
	}

	private void postorder(Node node) {

		for (Node child : node.children) {
			postorder(child);
		}

		System.out.print(node.data + " ");
	}

	public void traversal() {
		traversal(this.root);
	}

	private void traversal(Node node) {

		System.out.println("hi " + node.data);

		for (Node child : node.children) {
			System.out.println("going towards " + child.data);
			traversal(child);
			System.out.println("coming from " + child.data);
		}

		System.out.println("bye " + node.data);
	}

	public void levelorder() {

		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);

		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();

			System.out.print(rn.data + " ");

			for (Node child : rn.children) {
				queue.addLast(child);
			}

		}

	}

	public void levelorderlw() {

		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();

		queue.addLast(this.root);

		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();

			System.out.print(rn.data + " ");

			for (Node child : rn.children) {
				helper.addLast(child);
			}

			if (queue.isEmpty()) {
				System.out.println();
				queue = helper;
				helper = new LinkedList<>();
			}
		}

	}

	public void levelorderal() {

		LinkedList<Node> queue = new LinkedList<>();

		queue.addLast(this.root);
		Node nn = new Node();
		nn.data = Integer.MIN_VALUE;
		queue.addLast(nn);

		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();

			if (rn.data == Integer.MIN_VALUE) {

				System.out.println();
				Node n = new Node();
				n.data = Integer.MIN_VALUE;

				if (queue.size() != 0) {
					queue.addLast(n);
				}

			} else {
				System.out.print(rn.data + " ");

				for (Node child : rn.children) {
					queue.addLast(child);
				}
			}

		}

	}

	public void levelorderzz() {

		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> stack = new LinkedList<>();
		queue.addLast(this.root);
		int counter = 0;

		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();
			System.out.print(rn.data + " ");

			if (counter % 2 == 0) {
				for (int i = 0; i < rn.children.size(); i++) {
					stack.addFirst(rn.children.get(i));
				}
			} else {
				for (int i = rn.children.size() - 1; i >= 0; i--) {
					stack.addFirst(rn.children.get(i));
				}
			}

			if (queue.isEmpty()) {

				System.out.println();
				counter++;
				queue = stack;
				stack = new LinkedList();
			}
		}
	}

	private class HeapMover {

		int size;
		int height;
		int max = Integer.MIN_VALUE;
		boolean find = false;

		Node predecessor;
		Node successor;
		Node jl;
	}

	public void multiSolver(int item) {

		HeapMover mover = new HeapMover();
		multiSolver(mover, this.root, item, 0);

		System.out.println("Size : " + mover.size);
		System.out.println("Height : " + mover.height);
		System.out.println("Max : " + mover.max);
		System.out.println("Find : " + mover.find);
		System.out.println("Pred : " + ((mover.predecessor == null) ? null : mover.predecessor.data));
		System.out.println("Succ : " + ((mover.successor == null) ? null : mover.successor.data));
		System.out.println("JL : " + ((mover.jl == null) ? null : mover.jl.data));
	}

	private void multiSolver(HeapMover mover, Node node, int item, int level) {

		mover.size++;

		if (level > mover.height) {
			mover.height = level;
		}

		if (node.data > mover.max) {
			mover.max = node.data;
		}

		if (mover.find == true && mover.successor == null) {
			mover.successor = node;
		}

		if (node.data == item) {
			mover.find = true;
		}

		if (mover.find == false) {
			mover.predecessor = node;
		}

		if (node.data > item) {

			if (mover.jl == null) {
				mover.jl = node;
			} else {
				if (node.data < mover.jl.data) {
					mover.jl = node;
				}
			}
		}

		for (Node child : node.children) {
			multiSolver(mover, child, item, level + 1);
		}
	}
}