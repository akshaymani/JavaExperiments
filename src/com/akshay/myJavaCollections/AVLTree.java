package com.akshay.myJavaCollections;

public class AVLTree {

	private int val;
	private AVLTree left;
	private AVLTree right;

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public AVLTree getLeft() {
		return left;
	}

	public void setLeft(AVLTree left) {
		this.left = left;
	}

	public AVLTree getRight() {
		return right;
	}

	public void setRight(AVLTree right) {
		this.right = right;
	}

	public AVLTree(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
	
	public static int findMin(AVLTree tree) throws Exception {
		if (tree == null) {
			throw new Exception("Empty Tree");
		}
		return findMinUtil(tree).getVal();
	}
	
	private static AVLTree findMinUtil(AVLTree tree) {
		if (tree.getLeft() == null) {
			return tree;
		}
		return findMinUtil(tree.getLeft());
	}
	
	public static int findMax(AVLTree tree) throws Exception {
		if (tree == null) {
			throw new Exception("Empty Tree");
		}
		return findMaxUtil(tree).getVal();
	}
	
	private static AVLTree findMaxUtil(AVLTree tree) {
		if (tree.getRight() == null) {
			return tree;
		}
		return findMaxUtil(tree.getRight());
	}

	public static AVLTree delete(AVLTree tree, int key) {
		// STEP 1: PERFORM STANDARD BST DELETE
		
		if (tree == null)
			return tree;
		// If the key to be deleted is smaller than the root's key,
	    // then it lies in left subtree
		if (key < tree.getVal()) {
			tree.setLeft(delete(tree.getLeft(),key));
		}
		// If the key to be deleted is greater than the root's key,
	    // then it lies in right subtree
		else if (key > tree.getVal()) {
			tree.setRight(delete(tree.getRight(),key));
		}
		// if key is same as root's key, then This is the node
	    // to be deleted
		else {
			// node with only one child or no child
			if (tree.getLeft() == null || tree.getRight() == null) {
				AVLTree temp = tree.getLeft() != null ? tree.getLeft() : tree.getRight();
				
				// No child case
				if (temp == null) {
					temp = tree;
					tree = null;
				}
				// One child case
				else {
					tree.setLeft(temp.getLeft());
					tree.setRight(temp.getRight());
					tree.setVal(temp.getVal());
				}
			}
			else
	        {
	            // node with two children: Get the inorder successor (smallest
	            // in the right subtree)
				AVLTree temp = findMinUtil(tree.getRight());
				
				// Copy the inorder successor's data to this node
				tree.setVal(temp.getVal());
				
				// Delete the inorder successor
				tree.setRight(delete(tree.getRight(), temp.getVal()));
				
	        }
		}
		
		// If the tree had only one node then return
	    if (tree == null)
	      return tree;
	    
	    // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
	    //  this node became unbalanced)
	    int balance = getBalance(tree);
	    // Left Left Case
	    if (balance > 1 && getBalance(tree.getLeft()) >= 0)
	        return singleRotateWithRight(tree);
	 
	    // Left Right Case
	    if (balance > 1 && getBalance(tree.getLeft()) < 0)
	    {
	        tree.setLeft(singleRotateWithLeft(tree.getLeft()));
	        return singleRotateWithRight(tree);
	    }
	 
	    // Right Right Case
	    if (balance < -1 && getBalance(tree.getRight()) <= 0)
	        return singleRotateWithLeft(tree);
	 
	    // Right Left Case
	    if (balance < -1 && getBalance(tree.getRight()) > 0)
	    {
	        tree.setRight(singleRotateWithRight(tree.getRight()));
	        return singleRotateWithLeft(tree);
	    }
	    
	    return tree;
	}
	
	public static int getBalance(AVLTree tree) {
		if (tree == null) {
			return 0;
		}
		return heightOfTree(tree.getLeft()) - heightOfTree(tree.getRight());
	}
	
	public static AVLTree deleteMin(AVLTree tree) throws Exception {
		int key = findMin(tree);
		return delete(tree,key);
	}
	
	public static AVLTree deleteMax(AVLTree tree) throws Exception {
		int key = findMax(tree);
		return delete(tree,key);
	}

	public static AVLTree search(AVLTree tree, int key) {
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

	private static int heightOfTree(AVLTree tree) {
		if (null == tree) return 0;
		return maximum(heightOfTree(tree.getLeft()),heightOfTree(tree.getRight())) + 1;
	}

	private static int maximum(int a,int b) {
		return a > b ? a : b;
	}

	private static AVLTree avlInsert(AVLTree tree, int X) {
		if (null == tree) {
			return new AVLTree(X);
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

	private static AVLTree doubleRotateWithRight(AVLTree tree) {
		AVLTree tempTree = tree;
		AVLTree tempTree2 = tree.getRight();
		AVLTree A = tempTree.getLeft();
		AVLTree B = tempTree2.getLeft().getLeft();
		AVLTree C = tempTree2.getLeft().getRight();
		AVLTree D = tempTree2.getRight();

		tree = tempTree2.getLeft();
		tempTree.setRight(B);
		tempTree2.setLeft(C);
		tree.setLeft(tempTree);
		tree.setRight(tempTree2);
		return tree;
	}

	private static AVLTree doubleRotateWithLeft(AVLTree tree) {
		AVLTree tempTree = tree;
		AVLTree tempTree2 = tree.getLeft();
		AVLTree A = tempTree2.getLeft();
		AVLTree B = tempTree2.getRight().getLeft();
		AVLTree C = tempTree2.getRight().getRight();
		AVLTree D = tempTree.getRight();

		tree = tempTree2.getRight();
		tempTree2.setRight(B);
		tempTree.setLeft(C);
		tree.setLeft(tempTree2);
		tree.setRight(tempTree);
		return tree;
	}

	private static AVLTree singleRotateWithRight(AVLTree tree) {
		AVLTree tempTree = tree;
		//MyTree X = tree.getLeft();
		AVLTree Y = tree.getRight().getLeft();
		//MyTree Z = tree.getRight().getRight();
		tree = tree.getRight();
		tempTree.setRight(Y);
		tree.setLeft(tempTree);
		return tree;
	}

	private static AVLTree singleRotateWithLeft(AVLTree tree) {
		AVLTree tempTree = tree;
		// MyTree X = tree.getLeft().getLeft();
		AVLTree Y = tree.getLeft().getRight();
		// MyTree Z = tree.getRight();
		tree = tree.getLeft();
		tempTree.setLeft(Y);
		tree.setRight(tempTree);
		return tree;
	}

	// To confirm my avl insert is working fine
	private static boolean isBST(AVLTree tree, int minValue, int maxValue) {
		if (null == tree) return true;
		if (tree.getVal() < minValue || tree.getVal() > maxValue) return false;
		return isBST(tree.getLeft(), minValue, tree.getVal()) && isBST(tree.getRight(), tree.getVal(), maxValue);
	}

	// Traversal check
	private static void inOrderTraversal(AVLTree tree) {
		if (null == tree) return;
		inOrderTraversal(tree.getLeft());
		System.out.print(tree.getVal() + " ");
		inOrderTraversal(tree.getRight());
	}
	
	public static void main(String[] args) {
		AVLTree tree = null;
		
		int[] arr = new int[] {13, 3, 4, 12, 14, 10, 5, 1, 8, 2, 7, 9, 11, 6, 18};
		for (int i = 0; i < arr.length; i++) {
			tree = avlInsert(tree,arr[i]);
		}
		
		inOrderTraversal(tree);
		System.out.println();
		
		delete(tree, 13);
		try {
			deleteMin(tree);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			deleteMax(tree);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		inOrderTraversal(tree);
		System.out.println();
		
	}
	
}
