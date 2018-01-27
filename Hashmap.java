package Jan13;

import java.util.ArrayList;
import java.util.LinkedList;

public class Hashmap<K, V> {
	private class hmNode {
		K key;
		V value;

		public hmNode(K k, V v) {
			this.key = k;
			this.value = v;
		}
	}

	public Hashmap() {
		this(5);
	}

	private int size;
	private LinkedList<hmNode>[] bucketArray;

	private Hashmap(int cap) {
		bucketArray = (LinkedList<hmNode>[]) new LinkedList[cap];
		for (int i = 0; i < bucketArray.length; i++)
			bucketArray[i] = new LinkedList<>();
	}

	private int hashFunc(K key) {
		int hc = key.hashCode();
		int bi = Math.abs(hc) % bucketArray.length;
		return bi;
	}

	private int findBucket(LinkedList<hmNode> bucket, K key) {
		for (int i = 0; i < bucket.size(); i++) {
			K k = bucket.get(i).key;
			if (key.equals(k))
				return i;
		}
		return -1;
	}

	public void put(K key, V value) {
		int fi = hashFunc(key);
		LinkedList<hmNode> bucket = bucketArray[fi];
		int bi = findBucket(bucket, key);
		if (bi == -1) {
			hmNode ntba = new hmNode(key, value);
			bucket.addLast(ntba);
			this.size++;
		} else {
			hmNode ntbu = bucket.get(bi);
			ntbu.value = value;
		}
		double lambda = (1.0 * this.size) / this.bucketArray.length;
		if (lambda > 2)
			reHash();
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() {
		for (int i = 0; i < bucketArray.length; i++) {
			LinkedList<hmNode> b = bucketArray[i];
			System.out.print("B[" + i + "] -> ");
			for (int j = 0; j < b.size(); j++)
				System.out.print(b.get(j).key + "@" + b.get(j).value + " ");
			System.out.println(".");
		}
	}

	public V get(K k) {
		int fi = hashFunc(k);
		int bi = findBucket(bucketArray[fi], k);
		if (bi == -1)
			return null;
		return bucketArray[bi].get(fi).value;
	}

	public V remove(K k) {
		int fi = hashFunc(k);
		int bi = findBucket(bucketArray[fi], k);
		if (bi == -1)
			return null;
		this.size--;
		return bucketArray[bi].remove(fi).value;
	}

	public boolean containsKey(K k) {
		int fi = hashFunc(k);
		int bi = findBucket(bucketArray[fi], k);
		if (bi == -1)
			return false;
		return true;
	}

	public ArrayList<K> keySet() {
		ArrayList<K> rv = new ArrayList<K>();
		for (int i = 0; i < bucketArray.length; i++) {
			for (int j = 0; j < bucketArray[i].size(); j++) {
				rv.add(bucketArray[i].get(j).key);
			}
		}
		return rv;
	}

	public void reHash() {
		LinkedList<hmNode>[] oba = bucketArray;
		bucketArray = (LinkedList<hmNode>[]) new LinkedList[bucketArray.length * 2];
		for (int i = 0; i < bucketArray.length; i++) {
			bucketArray[i] = new LinkedList();
		}
		this.size = 0;
		for (int i = 0; i < oba.length; i++) {
			LinkedList<hmNode> bucket = oba[i];
			for (int j = 0; j < bucket.size(); j++) {
				hmNode n = bucket.get(j);
				this.put(n.key, n.value);
			}
		}
	}
}