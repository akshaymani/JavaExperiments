package com.akshay.myJavaCollections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyMap<K,V> {

	private int size;
	private int DEFAULT_CAPACITY = 16;

	private MyEntry<K, V>[] values = new MyEntry[DEFAULT_CAPACITY];

	public V get(K key) {
		for (int i = 0; i < size; i++) {
			if (null != values[i]) {
				if (values[i].getKey().equals(key)) {
					return values[i].getValue();
				}
			}
		}
		return null;
	}

	public void put(K key, V value) {
		boolean insert = true;
		for (int i = 0; i < size; i++) {
			if (values[i].getKey().equals(key)) {
				values[i].setValue(value);
				insert = false;
			}
		}
		if (insert) {
			ensureCapacity();
			values[size++] = new MyEntry<K, V>(key, value);
		}
	}

	private void ensureCapacity() {
		if (size == values.length) {
			int newsize = values.length * 2;
			values = Arrays.copyOf(values,newsize);
		}
	}

	public int size() {
		return size;
	}

	public void remove(K key) {
		for (int i = 0; i < size; i++) {
			if (null != values[i]) {
				if (values[i].getKey().equals(key)) {
					size--;
					values[i] = null;
					condenseArray(i);
				}
			}
		}
	}

	private void condenseArray(int start) {
		for (int i = start; i < size ; i++) {
			values[i] = values[i+1];
		}
	}

	public Set<K> keySet() {
		Set<K> set = new HashSet<K>();
		for (int i = 0; i < size; i++) {
			set.add(values[i].getKey());
		}
		return set;
	}

	@Override
	public int hashCode() {
		return size * size;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (! (obj instanceof MyMap)) return false;
		if (this.size() != ((MyMap) obj).size()) return false;
		return true;
	}

	

}
