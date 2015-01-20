package com.akshay.hackerrank.contests.weeklyContest13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ASuperHero {

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
			int[][] powers = new int[N][M];
			for (int i = 0; i < N; i++) {
				val = Integer.MAX_VALUE;
				String[] line2 = scanner.nextLine().split(" ");
				for (int j = 0; j < M; j++) {
					powers[i][j] = Integer.parseInt(line2[j]);
				}
			}
			// Now reading the number of bullets of each of the enemies
			int[][] bullets = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				String[] line2 = scanner.nextLine().split(" ");
				for (int j = 0; j < M; j++) {
						bullets[i][j] = Integer.parseInt(line2[j]);
				}
			}
			
			ArrayList<Integer> iBulletList = new ArrayList<Integer>();
			int carryforward = 0;
			int iBullets = 0;
			doBackTracking(0,0,N,M,powers,bullets,iBullets,carryforward,iBulletList);
			
			Collections.sort(iBulletList);
			System.out.println(iBulletList.get(0));
		}

	}

	private static void doBackTracking(int row, int column, int N, int M,
			int[][] powers, int[][] bullets, int iBullets, int carryforward,
			ArrayList<Integer> iBulletList) {
		if (row == N) {
			iBulletList.add(iBullets);
			return;
		}
		
		for (int i = row; i < N; i++) {
			for (int j = column; j < M; j++) {
				int temp = carryforward - powers[i][j];
				int tempIBullets = iBullets;
				if (temp < 0) {
					tempIBullets = iBullets + absoluteVal(temp);
				}
				int tempCarryForward = bullets[i][j];
				doBackTracking(row + 1, 0, N, M, powers, bullets, tempIBullets, tempCarryForward, iBulletList);
			}
		}
		
	}
	
	private static int absoluteVal(int val) {
		return val > 0 ? val : -val;
	}


}
