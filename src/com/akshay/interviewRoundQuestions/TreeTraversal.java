package com.akshay.interviewRoundQuestions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * arr[] = -1 0 0 1 1 then -1 is the parent at index 0 and its children will have the value 0 in arr[], therefore children of parent are 1 / 2 
 * and so on 
 */

public class TreeTraversal {

	private int val;
	private TreeTraversal left;
	private TreeTraversal right;

	public TreeTraversal(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public TreeTraversal getLeft() {
		return left;
	}

	public void setLeft(TreeTraversal left) {
		this.left = left;
	}

	public TreeTraversal getRight() {
		return right;
	}

	public void setRight(TreeTraversal right) {
		this.right = right;
	}

	public static void main(String[] args) {
		try {
			ArrayList<Integer> input = new ArrayList<Integer>();
			Scanner scan = new Scanner(System.in);
			int n = scan.nextInt();
			for (int i = 0; i < n ; i++) {
				input.add(scan.nextInt());
			}
			printInputArray(input);
			int rootIndex = findIndexOfRoot(input);
			if (rootIndex != -1) {
				System.out.println("Parent Element is at Index: " + rootIndex);
				// Construct Tree Now Recursively
				TreeTraversal tree = null;
				for (int i = 0; i < input.size(); i++) {
					tree = buildTree(tree,input,rootIndex);
				}
				inOrderTraversal(tree);
				System.out.println();
				System.out.println("Height of Tree: " + heightOfTree(tree));
				System.out.println("Level Order Traversal of Tree: ");
				levelOrderTraversal(tree);
				System.out.println("Reverse Level Order Traversal of Tree: ");
				reverseLevelOrderTraversal(tree);
			}
			else {
				throw new Exception("Can't find the Parent Element in the Tree");
			}
		}
		catch (IOException e) {
			System.out.println("IO Exception occurred: " + e.getLocalizedMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void inOrderTraversal(TreeTraversal tree) {
		if (null == tree) return;
		inOrderTraversal(tree.getLeft());
		System.out.print(tree.getVal() + " ");
		inOrderTraversal(tree.getRight());
	}
	
	private static int heightOfTree(TreeTraversal tree) {
		if (null == tree) return 0;
		return maximum(heightOfTree(tree.getLeft()),heightOfTree(tree.getRight())) + 1;
	}
	
	private static int maximum(int a,int b) {
		return a > b ? a : b;
	}
	
	private static void reverseLevelOrderTraversal(TreeTraversal tree) {
		int height = heightOfTree(tree);
		for (int i = height; i >=0 ; i--) {
			levelOrderTraversal(tree, i);
			System.out.println();
		}
	}
	
	private static void levelOrderTraversal(TreeTraversal tree) {
		int height = heightOfTree(tree);
		for (int i = 0; i < height; i++) {
			levelOrderTraversal(tree, i);
			System.out.println();
		}
	}

	private static void levelOrderTraversal(TreeTraversal tree, int level) {
		if (null == tree || level < 0) return;
		if (level == 0) {
			System.out.print(tree.getVal() + " ");
		}
		levelOrderTraversal(tree.getLeft(), level - 1);
		levelOrderTraversal(tree.getRight(), level - 1);
	}

	private static TreeTraversal buildTree(TreeTraversal tree,
			ArrayList<Integer> input, int rootIndex) {
		try {
				tree = new TreeTraversal(rootIndex);
				boolean[] used = new boolean[input.size()]; // default value of boolean is false
				used[rootIndex] = true;
				ArrayList<Integer> children = null;
				ArrayList<Integer> currentParents = new ArrayList<Integer>();
				currentParents.add(rootIndex);
				int index = 0;
				while (isAnyArrayItemPendingToBeInserted(used)) {
					children = findChildren(input, currentParents.get(index));
					//inOrderTraversal(tree);
					TreeTraversal parentTree = searchInTree(tree,currentParents.get(index));
					if (children.size() == 1) {
						parentTree.setLeft(new TreeTraversal(children.get(0)));
						index++;
						currentParents.add(children.get(0));
						used[parentTree.getVal()] = true;
					}
					else if (children.size() == 2) {
						parentTree.setLeft(new TreeTraversal(children.get(0)));
						parentTree.setRight(new TreeTraversal(children.get(1)));
						index++;
						currentParents.add(children.get(0));
						currentParents.add(children.get(1));
						used[parentTree.getVal()] = true;
					}
					else if (children.size() == 0 || null == children){
						index++;
						used[parentTree.getVal()] = true;
					}
					else {
						throw new Exception("No of Children Can't be more than two in binary tree");
					}
				}
		}
		catch(Exception e) {
			System.out.println("Exception caught");
		}
		return tree;
	}

	private static boolean isAnyArrayItemPendingToBeInserted(boolean[] used) {
		for (int i = 0; i < used.length; i++) {
			if (!used[i])
				return true;
		}
		return false;
	}

	private static void printInputArray(ArrayList<Integer> input) {
		for (int i = 0; i < input.size(); i++) {
			System.out.print(input.get(i) + " ");
		}
		System.out.println();
	}

	private static TreeTraversal searchInTree(TreeTraversal tree, int val) {
		if (null == tree) return null;
		if (tree.getVal() == val) return tree;
		TreeTraversal temp = null;
		temp = searchInTree(tree.getLeft(), val);
		if (null != temp)
			return temp;
		temp = searchInTree(tree.getRight(), val);
		return temp;
	}

	private static ArrayList<Integer> findChildren(ArrayList<Integer> input, int parentVal) {
		ArrayList<Integer> childrenIndex = findElement(input, parentVal);
		try {
			if (childrenIndex.size() <= 2 && childrenIndex.size() >=0) {
				return childrenIndex;
			}
			else {
				throw new Exception("Not a Binary Tree");
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	private static int findIndexOfRoot(ArrayList<Integer> input) {
		ArrayList<Integer> indexes = findElement(input, -1);
		if (indexes.size() > 0) {
			return indexes.get(0);
		}
		else
			return -1;

	}

	private static ArrayList<Integer> findElement(ArrayList<Integer> input, int key) {
		ArrayList<Integer> index = new ArrayList<Integer>();

		for (int j = 0; j < input.size(); j++) {
			if (input.get(j) == key) {
				index.add(j);
			}
		}
		return index;
	}

}

