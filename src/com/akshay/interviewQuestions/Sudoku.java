package com.akshay.interviewQuestions;

/*
 * Solution (recursive way)
1. Recursive-based exhaustive searching
1.1. This solution is somehow brutal-force based (similar as a maze path-finder).

2. We use an additional array to store the status of each value
2.1. Fixed (pre-setting)
2.2. Temporarily set (we choose and try)
2.3. Non-touched

3. At each position we proceed:
3.1. Check its row/column/3*3-box to decide possible values
3.2. try all possible values one by one
3.3. Reset the temporary settings before try next value setting

4. Return immediately when a solution find!
4.1. So set the method as a boolean method
 */

public class Sudoku {

	public static void main(String[] args) {
		/*int userGrid[][]=new int[][]
				{{0,0,4,7,9,0,0,0,8},
				{0,3,0,0,0,0,2,0,4},
				{0,0,0,0,0,0,0,9,0},
				{0,0,0,3,0,6,9,0,0},
				{0,6,9,8,0,2,4,3,0},
				{0,0,5,4,0,9,0,0,0},
				{0,7,0,0,0,0,0,0,0},
				{1,0,6,0,0,0,0,8,0},
				{8,0,0,0,3,4,6,0,0}};*/ //[horizontal][vertical]
		int userGrid[][]=new int[][]
				{{0,4,0,1,0,6,0,0,3},
				{6,0,3,0,7,2,0,4,5},
				{0,2,8,0,3,0,0,0,0},
				{4,5,0,3,0,0,0,0,0},
				{8,0,0,4,0,5,0,0,7},
				{0,0,0,0,0,8,0,5,1},
				{0,0,0,0,5,0,1,7,0},
				{7,8,0,2,4,0,5,0,9},
				{1,0,0,7,0,9,0,6,0}};


		/*int userGrid[][]=new int[][]
		           {{0,0,0,0,0,0,0,0,0},
		            {0,0,0,0,0,0,0,0,0},
		            {0,0,0,0,0,0,0,0,0},
		            {0,0,0,0,0,0,0,0,0},
		            {0,0,0,0,0,0,0,0,0},
		            {0,0,0,0,0,0,0,0,0},
		            {0,0,0,0,0,0,0,0,0},
		            {0,0,0,0,0,0,0,0,0},
		            {0,0,0,0,0,0,0,0,0}};*/
		Solve(userGrid);

		printGrid(userGrid);

	}

	private static void Solve(int[][] userGrid) {

		int[][] status = new int[userGrid.length][userGrid[0].length];

		initStatus(status,userGrid);
		printGrid(status);

		Solve(userGrid, status, 0, 0); // we start at 0,0 position
	}

	private static boolean Solve(int[][] userGrid, int[][] status, int x, int y) {
		System.out.println("X: " + x + " Y: " + y);
		if (x == 9) { // we have reached the end
			return isStatusSetForAllPositions(status);
		}
		if (status[x][y] >= 1) { // move to the right in the row if possible since current position is already set
			int nextX = x;
			int nextY = y+1;
			if (y == 8) {
				nextX = x+1;
				nextY = 0;
			}
			return Solve(userGrid, status, nextX, nextY);
		}
		else {
			boolean[] used = findPossibleValues(userGrid,status,x,y);
			int[][] userGridTemp = copyDoubleIntegerArray(userGrid);
			int[][] statusTemp = copyDoubleIntegerArray(status);
			for (int i = 0 ; i < used.length; i++) {
				if (!used[i]) {
					status[x][y] = 1;
					userGrid[x][y] = i + 1;
					int nextX = x;
					int nextY = y+1;
					if (y == 8) {
						nextX = x+1;
						nextY = 0;
					}

					if(Solve(userGrid, status, nextX, nextY))
						return true;
					else {
						for (int m = 0; m < 9; m++) {
							for (int n = 0; n < 9; n++) {
								userGrid[m][n] = userGridTemp[m][n];
								status[m][n] = statusTemp[m][n];
							}
						}
					}

				}
			}
		}
		return false;
	}

	private static int[][] copyDoubleIntegerArray(int[][] arr) {
		int[][] newArray = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				newArray[i][j] = arr[i][j];
			}
		}
		return newArray;
	}

	private static boolean[] findPossibleValues(int[][] userGrid,
			int[][] status, int x, int y) {
		boolean[] used = new boolean[9];
		checkInRow(userGrid,status,x,y,used);
		checkInColumn(userGrid,status,x,y,used);
		checkIn3X3SquareMatrix(userGrid,status,x,y,used);
		return used;
	}

	private static void checkIn3X3SquareMatrix(int[][] userGrid,
			int[][] status, int x, int y, boolean[] used) {
		int a = x - (x % 3);
		int b = y - (y % 3);
		for (int i = a; i < a + 3; i++) {
			for (int j = b; j < b + 3; b++) {
				if (status[i][j] >= 1) {
					used[userGrid[i][j]-1] = true;
				}
			}
		}
	}

	private static void checkInColumn(int[][] userGrid, int[][] status, int x,
			int y, boolean[] used) {
		for (int i = 0; i < 9; i++) {
			if (status[i][y] >= 1) {
				used[userGrid[i][y]-1] = true;
			}
		}
	}

	private static void checkInRow(int[][] userGrid, int[][] status, int x,
			int y, boolean[] used) {
		for (int i = 0; i < 9; i++) {
			if (status[x][i] >= 1) {
				used[userGrid[x][i]-1] = true;
			}
		}
	}

	private static boolean isStatusSetForAllPositions(int[][] status) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (status[i][j]==0) {
					System.out.println("Status not set for all the positions");
					return false;
				}
			}
		}
		return true;
	}

	private static void initStatus(int[][] status, int[][] userGrid) {
		for (int i = 0; i < status.length; i++) {
			for (int j = 0; j < status[0].length; j++) {
				status[i][j] = userGrid[i][j] > 0 ? 2 : 0; // Status = 2 means fixed and Status = 0 means non-touched
			}
		}
	}

	public static void printGrid(int[][] grid) {
		System.out.println();
		for (int i=0;i<9;i++) {
			for (int j=0;j<9;j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
}
