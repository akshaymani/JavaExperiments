package com.akshay.myJavaCollections;

// This is a Min Heap
public class MyHeap {

	private int size;
	private int[] heap = null;
	private int maxCapacity;


	public MyHeap(int capacity) {
		try {
			this.size = 0;
			this.maxCapacity = capacity;
			heap = new int[capacity];
			heap[0] = 0;
		} catch (OutOfMemoryError e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int incrementSize() {
		return ++this.size;
	}	

	public int decrementSize() {
		return --this.size;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public int getSize() {
		return this.size;
	}

	public int getHeap(int index) {
		int val = 0;
		try {
			val = heap[index];
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return val;
	}

	public void setHeap(int index, int val) {
		try {
			heap[index] = val;
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(int key) {
		try {
			int i = 0;
			for (i = incrementSize(); getHeap(i/2) > key; i/=2) {
				setHeap(i, getHeap(i/2));
			}
			setHeap(i, key); 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void percolateUp(int val) {

	}

	public void percolateDown(int val) {

	}
	
	public void decreaseKey(int index, int decreaseAmount) {
		
	}
	
	public void increaseKey(int index, int increaseAmount) {
		
	}

	public int deleteMin() {
		int minimum = -1;
		try {
			int i = 0;
			minimum = getHeap(1);
			int lastElement = getHeap(getSize());
			decrementSize();
			int child = 0;
			for (i = 1; i*2 < getSize(); i = child) {
				child = i*2;
				if (child != getSize() && getHeap(child+1) < getHeap(child)) {
					child++;
				}

				// Percolate One Level Up
				if (lastElement > getHeap(child)) {
					setHeap(i, getHeap(child));
				}
				else
					break;
			}
			setHeap(i, lastElement);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return minimum;
	}

	public static void main(String[] args) {
		MyHeap heap = new MyHeap(20);
		heap.insert(21); heap.insert(16); heap.insert(19); heap.insert(18); heap.insert(13); heap.insert(31);
		printHeap(heap);
		heap.deleteMin(); heap.deleteMin();
		printHeap(heap);
	}

	public static void printHeap(MyHeap heap) {
		for (int i = 1; i < heap.size; i++) {
			System.out.print(heap.getHeap(i) + " ");
		}
		System.out.println();
	}


}
