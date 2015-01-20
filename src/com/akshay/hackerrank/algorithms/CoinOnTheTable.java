package com.akshay.hackerrank.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class CoinOnTheTable {

	private final static char[] operations = {'L','R','D','U'};

	public static void main(String[] args) {
		// Starting point is top right
		// At time K we have to reach
		// All cells have info for next operation to be performed
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int k = scanner.nextInt();
		char[][] arr = new char[n][m];

		scanner.nextLine();
		for (int i = 0; i < n; i++) {
			String line = scanner.nextLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = line.charAt(j);
			}
		}

		int[][] costArray = new int[n][m];
		for (int i = 0 ; i < n; i++) {
			Arrays.fill(costArray[i], Integer.MAX_VALUE);
		}
		
		HashMap<Integer,ArrayList<Integer>> visited = new HashMap<Integer,ArrayList<Integer>>();
		ArrayList<Integer> costList = new ArrayList<Integer>();
		breadthFirstSearch(arr,n,m,0,0,k,0,costList,visited,costArray);

		if (costList.isEmpty()) System.out.println(-1);
		else 
			System.out.println(Collections.min(costList));
		
		//System.out.println(costArray[n-1][m-1]);
	}

	private static void breadthFirstSearch(char[][] arr, int n, int m, int row, int column, int k,
			int cost, ArrayList<Integer> costList, HashMap<Integer, ArrayList<Integer>> visited, int[][] costArray) {
		if (row < 0 || row >= n || column < 0 || column >= m) return;
		//if (isCellVisited(row,column,visited)) return;
		if (k == 0 && arr[row][column] != '*') return;
		if (k >= 0 && arr[row][column] == '*') {
			costList.add(cost);
			return;
		}
		if (isCostArrayNotUpdated(row, column, cost, costArray)) return; 

		int tempCost = cost;
		int tempK = k - 1;

		char actual = arr[row][column];
		/*HashMap<Integer,ArrayList<Integer>> tempVisited = new HashMap<Integer,ArrayList<Integer>>(visited);
		ArrayList<Integer> columns = tempVisited.get(row);
		if (columns == null) {
			columns = new ArrayList<Integer>();
		}
		columns.add(column);
		tempVisited.put(row, columns);*/

		for (int o = 0; o < operations.length; o++) {
			if (operations[o] != actual) tempCost = cost + 1;
			else tempCost = cost;

			if (operations[o] == 'L') {
				breadthFirstSearch(arr, n, m, row, column - 1, tempK, tempCost, costList, visited, costArray);
			}
			else if (operations[o] == 'R') {
				breadthFirstSearch(arr, n, m, row, column + 1, tempK, tempCost, costList, visited, costArray);
			}
			else if (operations[o] == 'D') {
				breadthFirstSearch(arr, n, m, row + 1, column, tempK, tempCost, costList, visited, costArray);
			}
			else if (operations[o] == 'U') {
				breadthFirstSearch(arr, n, m, row - 1, column, tempK, tempCost, costList, visited, costArray);
			}
		}

	}

	private static boolean isCostArrayNotUpdated(int row, int column, int cost,
			int[][] costArray) {
		if (costArray[row][column] > cost) {
			costArray[row][column] = cost;
			return false;
		}
		return true;
	}

	private static boolean isCellVisited(int row, int column,
			HashMap<Integer, ArrayList<Integer>> visited) {
		if (visited.get(row) != null && visited.get(row).contains(column))
			return true;
		return false;
	}

}
