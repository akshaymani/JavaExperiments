package com.akshay.hackerrank.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GridSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = Integer.parseInt(scanner.nextLine());
		while(T-- > 0) {
			String[] line = scanner.nextLine().split(" ");
			int R = Integer.parseInt(line[0]);
			int C = Integer.parseInt(line[1]);
			ArrayList<String> grid = new ArrayList<String>();
			for (int i = 0; i < R; i++) {
				grid.add(scanner.nextLine());
			}
			line = scanner.nextLine().split(" ");
			int r = Integer.parseInt(line[0]);
			int c = Integer.parseInt(line[1]);
			ArrayList<String> pattern = new ArrayList<String>();
			for (int i = 0; i < r; i++) {
				pattern.add(scanner.nextLine());
			}
			boolean flag = false;
			ArrayList<Integer> rowsSelected = new ArrayList<Integer>();
			for (int m = 0; m < R-r+1; m++) {
				Pattern p = Pattern.compile(pattern.get(0));
				Pattern p2 = Pattern.compile(pattern.get(r-1));
				Matcher matcher = p.matcher(grid.get(m));
				Matcher matcher2 = p2.matcher(grid.get(m+r-1));
				if (matcher.find() && matcher2.find())
					rowsSelected.add(m);
			}
			
			for (int m = 0; m < rowsSelected.size() ; m++) { // grids row iterator
				for (int i = 0; i < C - c; i++) { // grids column iterator
					// now match m to m+r rows from grid with r rows of pattern
					flag = true;
					int gRow = rowsSelected.get(m);
					String gridE = "";
					for (int row = 0; row < r; row++) {
						gridE = grid.get(gRow).substring(i,c+i);
						Pattern p = Pattern.compile(pattern.get(row));
						Matcher matcher = p.matcher(gridE);
						if (!matcher.matches()) {
							flag = false;
							break;
						}
						else
							gRow++; 
					}
					if (flag == true) 
						break;
				}
				if (flag == true)
					break;
			}
			if (flag == true) 
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
