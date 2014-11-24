package com.akshay.interviewQuestions;

import java.util.Scanner;

public class RowColumnSortedMatrix {

	/*
	 * using Scanner class

	Scanner scan = new Scanner(System.in);
	String s = scan.next();
	int i = scan.nextInt();

	using BufferedReader class

	BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
	String s = br.readLine();
	int i = Integer.parseInt(br.readLine());

	using DataInputStream class

	DataInputStream dis = new DataInputStream(System.in);
	String s = dis.readLine(); 
	 * DataInputStream.readLine() has been deprecated 
	 * to get String value you need to use BufferedReader class

	int i = dis.readInt();

	using Console Class

	Console console = System.console();
	String s = console.readLine();
	int i = Integer.parseInt(console.readLine());
	 */

	public static void main(String[] args) {
		System.out.println("User Input on Square Matrix size [Please enter value 4]: ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		int[][] sortedMatrix = new int[n][n];
		
		init(sortedMatrix);
		printMatrix(sortedMatrix);
		
		System.out.println("Search Element 25 in given array and return its position");
		System.out.println(searchInSortedMatrix(sortedMatrix,25));
		System.out.println("Search Element 50 in given array and return its position");
		System.out.println(searchInSortedMatrix(sortedMatrix,50));
		System.out.println("Search Element 10 in given array and return its position");
		System.out.println(searchInSortedMatrix(sortedMatrix,10));
		
		System.out.println("Print 4th smallest element return its position");
		System.out.println(findKSmallestNo(sortedMatrix,4));
	}

	private static String findKSmallestNo(int[][] sortedMatrix, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	private static String searchInSortedMatrix(int[][] sortedMatrix, int X) {
		String val = searchInSortedMatrix(sortedMatrix,X,3,0);
		return val;
	}

	private static String searchInSortedMatrix(int[][] sortedMatrix, int X, int xCoordinate,int yCoordinate) {
		System.out.println("xCoordinate: " + xCoordinate + " yCoordinate: " + yCoordinate);
		String val = null;
		if (xCoordinate > sortedMatrix.length || xCoordinate < 0) return "-1";
		else if (yCoordinate > sortedMatrix[xCoordinate].length || yCoordinate < 0) return "-1";
		else if (X == sortedMatrix[xCoordinate][yCoordinate]) {
			val = xCoordinate + "," + yCoordinate;
			return val;
		}
		else if (X < sortedMatrix[xCoordinate][yCoordinate]) {
			val = searchInSortedMatrix(sortedMatrix, X, xCoordinate - 1, yCoordinate);
		}
		else {
			val = searchInSortedMatrix(sortedMatrix, X, xCoordinate, yCoordinate+1);
		}
		return val;
	}

	private static void printMatrix(int[][] sortedMatrix) {
		System.out.println("Matrix is given below:");
		for (int i = 0; i < sortedMatrix.length; i++) {
			for (int j = 0; j < sortedMatrix[i].length; j++) {
				System.out.print(sortedMatrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	private static void init(int[][] sortedMatrix) {
		sortedMatrix[0][0] = 10;
		sortedMatrix[1][0] = 15;
		sortedMatrix[2][0] = 24;
		sortedMatrix[3][0] = 32;
		sortedMatrix[0][1] = 20;
		sortedMatrix[1][1] = 25;
		sortedMatrix[2][1] = 29;
		sortedMatrix[3][1] = 35;
		sortedMatrix[0][2] = 30;
		sortedMatrix[1][2] = 33;
		sortedMatrix[2][2] = 37;
		sortedMatrix[3][2] = 39;
		sortedMatrix[0][3] = 40;
		sortedMatrix[1][3] = 45;
		sortedMatrix[2][3] = 48;
		sortedMatrix[3][3] = 50;
	}

}
