package com.akshay.hackerrank.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// http://www.comp.nus.edu.sg/~stevenha/visualization/segmenttree.html

// https://www.hackerrank.com/challenges/maximise-sum

// http://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/

public class MaximiseSumSegmentTree {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long T = scanner.nextLong();
		int N = 0;
		long M = 0;
		while (T-- > 0) {
			N = scanner.nextInt(); // no of elements
			M = scanner.nextLong(); // modulo by
			long arr[] = new long[N];
			for (int i = 0; i < N; i++) {
				arr[i] = scanner.nextInt();
			}
			// construct the segment tree
			long[] segmentTree = constructSegmentTree(arr,N);
			long max = Long.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					long val = getSumUtil(segmentTree, 0, N-1, i, j, 0) % M;
					if (val > max) 
						max = val;
				}
			}
			System.out.println(max);
		}
	}
	
	private static long getSumUtil(long[] segmentTree, int ss, int se, int qs, int qe, int index)
	{
	    // If segment of this node is a part of given range, then return the 
	    // sum of the segment
	    if (qs <= ss && qe >= se)
	        return segmentTree[index];
	 
	    // If segment of this node is outside the given range
	    if (se < qs || ss > qe)
	        return 0;
	 
	    // If a part of this segment overlaps with the given range
	    int mid = (ss + se) / 2;
	    return getSumUtil(segmentTree, ss, mid, qs, qe, 2*index+1) +
	           getSumUtil(segmentTree, mid+1, se, qs, qe, 2*index+2);
	}


	private static long[] constructSegmentTree(long[] arr, int N) {
		/*int height = (int) Math.ceil(Math.log(N));
		int maxSize = (2 * (int) Math.pow(2, height)) - 1;*/
		long[] segmentTree = new long[4*N+1];
		constructSTUtil(arr,0,N-1,segmentTree,0);
		return segmentTree;
	}

	private static long constructSTUtil(long[] arr, int ss, int se,
			long[] segmentTree, int si) {
		// If there is one element in array, store it in current node of
		// segment tree and return
		if (ss == se) {
			segmentTree[si] = arr[ss];
	        return arr[ss];
		}

		// If there are more than one elements, then recur for left and
		// right subtrees and store the sum of values in this node
		int mid = (ss + se) / 2;
		segmentTree[si] =  constructSTUtil(arr, ss, mid, segmentTree, si*2+1) +
	              constructSTUtil(arr, mid+1, se, segmentTree, si*2+2);
		return segmentTree[si];
	}

}
