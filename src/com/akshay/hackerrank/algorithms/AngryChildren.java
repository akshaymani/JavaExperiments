package com.akshay.hackerrank.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AngryChildren {

	static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));
	static StringBuilder out = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int numPackets = Integer.parseInt(in.readLine());
		int numKids = Integer.parseInt(in.readLine());
		int[] packets = new int[numPackets];

		for(int i = 0; i < numPackets; i ++)
		{
			packets[i] = Integer.parseInt(in.readLine());
		}

		// Write your code here, to process numPackets N, numKids K, and the packets of candies
		// Compute the ideal value for unfairness over here
		Arrays.sort(packets, 0, numPackets);
		System.out.println(packets[numKids-1] - packets[0]);
	
		
	}
	
	
}
