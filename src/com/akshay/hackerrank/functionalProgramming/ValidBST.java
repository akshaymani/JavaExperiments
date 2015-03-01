package com.akshay.hackerrank.functionalProgramming;

import java.util.ArrayList;
import java.util.Scanner;

import com.akshay.myJavaCollections.MyTree;

public class ValidBST {
	
	public static class MyTree {

		private int val;
		private MyTree left;
		private MyTree right;

		public int getVal() {
			return val;
		}

		public void setVal(int val) {
			this.val = val;
		}

		public MyTree getLeft() {
			return left;
		}

		public void setLeft(MyTree left) {
			this.left = left;
		}

		public MyTree getRight() {
			return right;
		}

		public void setRight(MyTree right) {
			this.right = right;
		}

		public MyTree(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}

		public static MyTree insert(MyTree tree, int X) {
			if (null == tree) {
				return new MyTree(X);
			}
			else {
				if (tree.getVal() > X) { // go left to insert
					tree.setLeft(insert(tree.getLeft(),X));
				}
				else
					tree.setRight(insert(tree.getRight(), X));
			}
			return tree;
		}
		
		public static void preOrderTraversal(MyTree tree, ArrayList<Integer> traversal) {
			if (tree == null) 
				return;
			traversal.add(tree.getVal());
			preOrderTraversal(tree.getLeft(), traversal);
			preOrderTraversal(tree.getRight(), traversal);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int[] arr = new int[100];
		while (T-- > 0) {
			int N = scanner.nextInt();
			MyTree tree = null;
			for (int i = 0; i < N; i++) {
				arr[i] = scanner.nextInt();
				tree = MyTree.insert(tree, arr[i]);
			}
			
			ArrayList<Integer> traversal = new ArrayList<Integer>();
			MyTree.preOrderTraversal(tree, traversal);
			boolean flag = true;
			for (int i = 0; i < N; i++) {
				if (arr[i] != traversal.get(i)) 
					flag = false;
			}
			
			if (flag == true) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}
	
}
