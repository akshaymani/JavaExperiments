package com.akshay.interviewQuestions;

import java.util.ArrayList;
import java.util.List;

import com.akshay.myJavaCollections.MyHeap;

public class SumoLogic {
	
	/*
	 *  Implement the following operations efficiently:
		e getMax() // returns the maximum element; a most frequently used operation 
		e getMin() // returns minimum element; a most frequently used operation
		void deleteMax() // deletes maximum element; a moderate frequently used operation
		void deleteMin() // deletes minimum element; a moderate frequently used operation
		void insert(e) // inserts element; a least frequently used operation
		void delete(e) // deletes element; a least frequently used operation
	 */
	
	public static class Node {
		int data;
		int minHeapIndex;
		int maxHeapIndex;
		Node next;
		Node prev;
		
		public Node(int val, int minIndex, int maxIndex) {
			this.data = val;
			this.minHeapIndex = minIndex;
			this.maxHeapIndex = maxIndex;
			this.next = null;
			this.prev = null;
		}
	}
	
	public static class DoubleLinkedList {
		List<Node> listOfNodes;
		
		public DoubleLinkedList(ArrayList<Node> arrNodes) {
			this.listOfNodes = new ArrayList<Node>(arrNodes);
		}
		
	}
	
	public static class MinHeap {

		private int size;
		private int[] heap = null;
		private int maxCapacity; 

		public MinHeap(int capacity) {
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

		public static void printHeap(MinHeap heap) {
			for (int i = 1; i < heap.size; i++) {
				System.out.print(heap.getHeap(i) + " ");
			}
			System.out.println();
		}

	}

}
