package com.akshay.hackerrank.contests.weeklyContest13;

import java.util.Scanner;

public class SuperHero {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = Integer.parseInt(scanner.nextLine());
		String[] line = null;
		int val = 0;
		int temp = 0;
		while (T-- > 0) {
			line = scanner.nextLine().split(" ");
			// N is the no of Levels and M is the number of enemies at each level
			int N = Integer.parseInt(line[0]);
			int M = Integer.parseInt(line[1]);
			// Now reading the power of enemies [0] - index and [1] - power
			int[][] powers = new int[N][2];
			for (int i = 0; i < N; i++) {
				val = Integer.MAX_VALUE;
				String[] line2 = scanner.nextLine().split(" ");
				for (int j = 0; j < M; j++) {
					temp = Integer.parseInt(line2[j]);
					if (temp < val) {
						val = temp;
						powers[i][0] = j;
						powers[i][1] = temp;
					}
				}
			}
			// Now reading the number of bullets of each of the enemies
			int iBullets = 0;
			int carryforward = 0;
			for (int i = 0; i < N; i++) {
				String[] line2 = scanner.nextLine().split(" ");
				for (int j = 0; j < M; j++) {
					if (powers[i][0] == j) {
						temp = Integer.parseInt(line2[j]);
						// now i know the number of bullets this person has and for killing it powers[i][1] bullets are required
						// so carryforward is initial bullets plus what he has
						int temp2 = carryforward - powers[i][1];
						if (temp2 < 0) {
							iBullets += absoluteVal(temp2);
						}
						carryforward = temp;
					}
				}
			}
			System.out.println(iBullets);
		}

	}

	private static int absoluteVal(int val) {
		return val > 0 ? val : -val;
	}

}
