package com.akshay.hackerrank.algorithms;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

public class Triplets {

	public static class BinaryIndexedTree {
		private int index;
		private int val;
		private BinaryIndexedTree left;
		private BinaryIndexedTree right;
		private int leftChildSize;
		private int rightChildSize;
		
		public BinaryIndexedTree(int val, int index) {
			this.index = index;
			this.val = val;
			this.left = null;
			this.right = null;
			this.leftChildSize = 0;
			this.rightChildSize = 0;
		}
		
		public int getVal() {
			return val;
		}
		public void setVal(int val) {
			this.val = val;
		}
		public BinaryIndexedTree getLeft() {
			return left;
		}
		public void setLeft(BinaryIndexedTree left) {
			this.left = left;
		}
		public BinaryIndexedTree getRight() {
			return right;
		}
		public void setRight(BinaryIndexedTree right) {
			this.right = right;
		}
		public int getLeftChildSize() {
			return leftChildSize;
		}
		public void setLeftChildSize(int leftChildSize) {
			this.leftChildSize = leftChildSize;
		}
		public int getRightChildSize() {
			return rightChildSize;
		}
		public void setRightChildSize(int rightChildSize) {
			this.rightChildSize = rightChildSize;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BinaryIndexedTree tree = null;
		int N = scanner.nextInt();
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = scanner.nextInt();
			tree = insert(tree, nums[i], i);
		}
		
		for (int i = 0; i < N; i++) {
			traverseTree(tree, nums[i], i);
		}
		
		System.out.println();
		
	}
	
	private static void traverseTree(BinaryIndexedTree tree, int val, int index) {
		if (null == tree) return;
		if (tree.getVal() < val && tree.getIndex() < index) {
			tree.setRightChildSize(tree.getRightChildSize()+1);
		}
		if (tree.getVal() > val && tree.getIndex() > index) {
			tree.setLeftChildSize(tree.getLeftChildSize()+1);
		}
		traverseTree(tree.getLeft(), val, index);
		traverseTree(tree.getRight(), val, index);
	}
	
	private static BinaryIndexedTree insert(BinaryIndexedTree tree, int key, int index) {
		if (null == tree) {
			tree = new BinaryIndexedTree(key, index);
			return tree;
		}
		if (key < tree.getVal()) {
			tree.setLeft(insert(tree.getLeft(), key, index));
		}
		else if (key > tree.getVal()) {
			tree.setRight(insert(tree.getRight(), key, index));
		}
		return tree;
	}

}
