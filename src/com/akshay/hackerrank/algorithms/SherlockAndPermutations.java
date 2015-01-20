package com.akshay.hackerrank.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SherlockAndPermutations {

	static long[][] combinations=new long[2000][1001];

	public static void main(String[] args) throws IOException
	{
		for(int r=1;r<1001;r++)
		{
			for(int n=r;n<2000;n++)
			{
				combinations[n][r]=c(n,r);
		
			}
		}
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);

		int testcases=Integer.parseInt(br.readLine());
		while(testcases-->0)
		{
			String[] s=br.readLine().split(" ");
			int N=Integer.parseInt(s[0]);
			int M=Integer.parseInt(s[1]);
			pw.println(combinations[N+M-1][N]);
		}
		pw.flush();
	}

	public static long c(int n,int r)
	{
		long N=1000000007;
		if(r==1)
			return n;
		else
			return (combinations[n-1][r]+combinations[n-1][r-1])%N;
	}

}
