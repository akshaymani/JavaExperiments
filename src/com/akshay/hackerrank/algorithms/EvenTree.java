package com.akshay.hackerrank.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class EvenTree {

	public static void main(String[] args) {

		int tree[];
		int count[];

		Scanner scanner = new Scanner(System.in);
		String[] line = scanner.nextLine().split(" ");
		int N = Integer.parseInt(line[0]); 
		int M = Integer.parseInt(line[1]);

		tree = new int[N];
		count = new int[N];
		Arrays.fill(count, 1);

		for(int i = 0; i < M; i++)
		{
			line = scanner.nextLine().split(" ");
			int u1 = Integer.parseInt(line[0]); 
			int v1 = Integer.parseInt(line[1]);

			tree[u1-1] = v1;

			count[v1-1] += count[u1-1];

			int root = tree[v1-1];

			while(root!=0)
			{
				count[root-1] += count[u1-1];
				root = tree[root-1];
			}
		}

		int counter = -1;
		for(int i=0;i<count.length;i++)
		{
			if(count[i]%2==0)
			{
				counter++;
			}

		}
		System.out.println(counter);

	}
}
