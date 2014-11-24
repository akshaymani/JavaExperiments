package com.akshay.interviewQuestions;

public class NQueens {

	private static int[] position;
	private static int count;
	
	// position[m] = n; implies Queen at xCoordinate = m and yCoordinate = n
	
	public static void main(String[] args) {
		int val = 8;
		position = new int[val];
		//printArray(val);
		solveNQueens(0,val);
		System.out.println(count);
	}

	private static void solveNQueens(int k, int val) {
		
		for (int i = 0; i <= val-1 ; i++) {
			if (validPosition(k,i)) { // returns true if Queen can be placed at k row and i column
				position[k] = i;
				if (k == val-1) {
					printArray(val);
					count++;
				}
				else {
					solveNQueens(k+1, val);
				}
			}
		}
		
	}

	private static void printArray(int val) {
		System.out.println("-----------------------------");
		for (int i = 0; i < val; i++) {
			for (int j = 0; j < val; j++) {
				if (j != position[i]) {
					System.out.print("- ");
				}
				else {
					System.out.print("Q ");
				}
			}
			System.out.println();
		}
		System.out.println("-----------------------------");
	}

	private static boolean validPosition(int k, int i) {
		for (int j = 0; j <= k-1; j++) {
			if (position[j] == i || (getAbsolute(position[j]-i) == getAbsolute(j-k))){
				return false;
			}
		}
		return true;
	}

	private static Object getAbsolute(int i) {
		return (i > 0) ? i : -i; 
	}
	
}
