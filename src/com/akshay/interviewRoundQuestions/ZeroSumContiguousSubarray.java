package com.akshay.interviewRoundQuestions;

import java.util.HashMap;

public class ZeroSumContiguousSubarray {
	
	// This is the text editor interface. 
	// Anything you type or change here will be seen by the other person in real time.
	/*
	array => find whether there exist a zero sum contiguous subarray

	10 2 -1 4 -5 9
	yes (2, -1, 4, -5)


	Soln:
	    Time O(N)
	    space O(N)
	*/

	public static boolean xerosum(int a[], int length)
	{
	    int sum = 0;
	    
	    HashMap<Integer,Integer> sumMap = new HashMap<Integer,Integer>();
	    sumMap.put(0,-1);
	    
	    for (int i = 0; i < length; i++) {
	        sum += a[i];
	        
	        if (sumMap.get(sum) != null) {
	            return true;
	        }
	        
	        sumMap.put(sum,i);
	    }
	    
	    return false;
	}

	public static void main(String []args) {
	    int [] a = {10,2,-1,4,-5};
	    int length = 5;
	    /*for (int i=0;i<length;i++)
	    {
	        a[i] = i;
	    }*/
	    if (xerosum(a,length)){
	        System.out.println("Found");
	    }
	    else{
	        System.out.println("Not Found");
	    }
	}

}
