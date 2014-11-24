package com.akshay.myJavaCollections;

public class MyTree {

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

	private static MyTree insert(MyTree tree, int X) {
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

	private static MyTree search(MyTree tree, int key) {
		if (null == tree) {
			return null;
		}
		else {
			if (tree.getVal() == key) return tree;
			else if (tree.getVal() > key) {
				return search(tree.getLeft(),key);
			}
			else
				return search(tree.getRight(),key);
		}
	}

	private static int heightOfTree(MyTree tree) {
		if (null == tree) return 0;
		return maximum(heightOfTree(tree.getLeft()),heightOfTree(tree.getRight())) + 1;
	}

	private static int maximum(int a,int b) {
		return a > b ? a : b;
	}

	private static void reverseLevelOrderTraversal(MyTree tree) {
		int height = heightOfTree(tree);
		for (int i = height-1; i >=0 ; i--) {
			System.out.print("Level  {" + i + "} : ");
			levelOrderTraversal(tree, i);
			System.out.println();
		}
	}

	private static void levelOrderTraversal(MyTree tree) {
		int height = heightOfTree(tree);
		for (int i = 0; i < height; i++) {
			System.out.print("Level  {" + i + "} : ");
			levelOrderTraversal(tree, i);
			System.out.println();
		}
	}

	private static void levelOrderTraversal(MyTree tree, int level) {
		if (null == tree || level < 0) return;
		if (level == 0) {
			System.out.print(tree.getVal() + " ");
		}
		levelOrderTraversal(tree.getLeft(), level - 1);
		levelOrderTraversal(tree.getRight(), level - 1);
	}


	public static void main(String[] args) {
		MyTree tree = null;
		// imbalanced BST
		int[] arr = new int[] {13, 3, 4, 12, 14, 10, 5, 1, 8, 2, 7, 9, 11, 6, 18};
		for (int i = 0; i < arr.length; i++) {
			tree = insert(tree,arr[i]);
		}
		inOrderTraversal(tree);
		System.out.println();
		System.out.println("Searching for 10: " + search(tree,10).getVal());
		MyTree searchTree = search(tree, 12);
		if (null != searchTree) System.out.println("Key with value 12 found");
		else System.out.println("Key with 12 not found");

		if (isBST(tree,Integer.MIN_VALUE,Integer.MAX_VALUE)) System.out.println("The Tree is a Binary Search Tree");
		else System.out.println("The Tree is not a Binary Search Tree");

		System.out.println("\nLevel Order Traversal:");
		levelOrderTraversal(tree);

		System.out.println("\nReverse Level Order Traversal:");
		reverseLevelOrderTraversal(tree);

		// balanced BST - AVL Tree
		System.out.println("\n AVL Tree\n");
		int[] arr2 = new int[] {5, 2, 8, 1, 4, 7, 3, 6, 16, 15, 14, 13, 12, 11, 10, 9};
		MyTree avlTree = null;
		for (int i = 0; i < arr2.length; i++) {
			avlTree = avlInsert(avlTree,arr2[i]);
		}
		levelOrderTraversal(avlTree);

		System.out.println("\nSplay Tree Experimentation using avl tree operations\n");
		// http://www.geeksforgeeks.org/splay-tree-set-1-insert/
		System.out.println("Experiment 1");
		int arr3[] = new int[] {10,11,8,9,6,7,4};
		MyTree tree3 = null;
		for (int i = 0; i < arr3.length; i++) {
			tree3 = insert(tree3,arr3[i]);
		}
		levelOrderTraversal(tree3);
		System.out.println();
		tree3 = singleRotateWithLeft(tree3);
		levelOrderTraversal(tree3);
		System.out.println();
		tree3 = singleRotateWithLeft(tree3);
		levelOrderTraversal(tree3);

		System.out.println("\nExperiment 2");
		int arr4[] = new int[] {10,4,12,2,8,6,9};
		MyTree tree4 = null;
		for (int i = 0; i < arr3.length; i++) {
			tree4 = insert(tree4,arr4[i]);
		}
		levelOrderTraversal(tree4);
		System.out.println();
		tree3 = doubleRotateWithLeft(tree4);
		levelOrderTraversal(tree3);

		// Using splay while searching 'X' the initial tree BST constructed using arr5 array
		int arr5[] = new int[] {100,50,200,40,30,20};
		MyTree tree5 = null;
		for (int i = 0; i < arr5.length; i++) {
			tree5 = insert(tree5,arr5[i]);
		}
		System.out.println("Original Tree before splay operation\n");
		levelOrderTraversal(tree5);
		System.out.println("\nSplay the tree\n");
		tree5 = searchUsingSplay(tree5,20);
		//tree5 = splayTheTree(tree5,20);
		levelOrderTraversal(tree5);

	}

	private static MyTree searchUsingSplay(MyTree tree, int X) {
		if (null != tree && findInTree(tree,X)) {
			while (tree.getVal() != X) {
				tree = splayTheTree(tree, X);
			}
		}
		return tree;
	}

	private static boolean findInTree(MyTree tree, int X) {
		if (null == tree) return false;
			return (tree.getVal() == X) || findInTree(tree.getLeft(), X) || findInTree(tree.getRight(), X);
	}

	private static MyTree splayTheTree(MyTree tree, int X) {
		if (null == tree || tree.getVal() == X) {
			return tree;
		}
		if (null != tree.getLeft() && tree.getLeft().getVal() == X) {
			return singleRotateWithLeft(tree);
		}
		else if (null != tree.getRight() && tree.getRight().getVal() == X) {
			return singleRotateWithRight(tree);
		}
		else if (null != tree.getLeft() && null != tree.getLeft().getLeft() && tree.getLeft().getLeft().getVal() == X) {
			return singleRotateWithLeft(singleRotateWithLeft(tree));
		}
		else if (null != tree.getLeft() && null != tree.getLeft().getRight() && tree.getLeft().getRight().getVal() == X) {
			return doubleRotateWithLeft(tree);
		}
		else if (null != tree.getRight() && null != tree.getRight().getRight() && tree.getRight().getRight().getVal() == X) {
			return singleRotateWithRight(singleRotateWithRight(tree));
		}
		else if (null != tree.getRight() && null != tree.getRight().getLeft() && tree.getRight().getLeft().getVal() == X) {
			return doubleRotateWithRight(tree);
		}
		else if (null != tree.getLeft() && tree.getLeft().getVal() > X) {
			tree.setLeft(splayTheTree(tree.getLeft(), X));
			return tree;
		}
		else { // if (null != tree.getRight() && tree.getRight().getVal() < X) {
			tree.setRight(splayTheTree(tree.getRight(), X));
			return tree;
		}
	}

	private static MyTree avlInsert(MyTree tree, int X) {
		if (null == tree) {
			return new MyTree(X);
		}
		else if (X < tree.getVal()) {
			tree.setLeft(avlInsert(tree.getLeft(), X));
			if (heightOfTree(tree.getLeft()) - heightOfTree(tree.getRight()) == 2) {
				if (X < tree.getLeft().getVal()) {
					tree = singleRotateWithLeft(tree);
				}
				else {
					tree = doubleRotateWithLeft(tree);
				}
			}
		}
		else if (X > tree.getVal()) {
			tree.setRight(avlInsert(tree.getRight(), X));
			if (heightOfTree(tree.getRight()) - heightOfTree(tree.getLeft()) == 2) {
				if (X > tree.getRight().getVal()) {
					tree = singleRotateWithRight(tree);
				}
				else {
					tree = doubleRotateWithRight(tree);
				}
			}
		}
		return tree;
	}

	private static MyTree doubleRotateWithRight(MyTree tree) {
		MyTree tempTree = tree;
		MyTree tempTree2 = tree.getRight();
		MyTree A = tempTree.getLeft();
		MyTree B = tempTree2.getLeft().getLeft();
		MyTree C = tempTree2.getLeft().getRight();
		MyTree D = tempTree2.getRight();

		tree = tempTree2.getLeft();
		tempTree.setRight(B);
		tempTree2.setLeft(C);
		tree.setLeft(tempTree);
		tree.setRight(tempTree2);
		return tree;
	}

	private static MyTree doubleRotateWithLeft(MyTree tree) {
		MyTree tempTree = tree;
		MyTree tempTree2 = tree.getLeft();
		MyTree A = tempTree2.getLeft();
		MyTree B = tempTree2.getRight().getLeft();
		MyTree C = tempTree2.getRight().getRight();
		MyTree D = tempTree.getRight();

		tree = tempTree2.getRight();
		tempTree2.setRight(B);
		tempTree.setLeft(C);
		tree.setLeft(tempTree2);
		tree.setRight(tempTree);
		return tree;
	}

	private static MyTree singleRotateWithRight(MyTree tree) {
		MyTree tempTree = tree;
		//MyTree X = tree.getLeft();
		MyTree Y = tree.getRight().getLeft();
		//MyTree Z = tree.getRight().getRight();
		tree = tree.getRight();
		tempTree.setRight(Y);
		tree.setLeft(tempTree);
		return tree;
	}

	private static MyTree singleRotateWithLeft(MyTree tree) {
		MyTree tempTree = tree;
		// MyTree X = tree.getLeft().getLeft();
		MyTree Y = tree.getLeft().getRight();
		// MyTree Z = tree.getRight();
		tree = tree.getLeft();
		tempTree.setLeft(Y);
		tree.setRight(tempTree);
		return tree;
	}

	private static boolean isBST(MyTree tree, int minValue, int maxValue) {
		if (null == tree) return true;
		if (tree.getVal() < minValue || tree.getVal() > maxValue) return false;
		return isBST(tree.getLeft(), minValue, tree.getVal()) && isBST(tree.getRight(), tree.getVal(), maxValue);
	}

	private static void inOrderTraversal(MyTree tree) {
		if (null == tree) return;
		inOrderTraversal(tree.getLeft());
		System.out.print(tree.getVal() + " ");
		inOrderTraversal(tree.getRight());
	}
}
