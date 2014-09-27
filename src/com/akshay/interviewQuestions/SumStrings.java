package com.akshay.interviewQuestions;

public class SumStrings {

	public static void main(String[] args) {
		String val1 = "12345678";
		String val2 = "456789";
		
		System.out.println(sumStrings(val1,val2)); // if sum[0] is not assigned any value , we don't get any exception - commenting line 29 will tell
	}

	private static char[] sumStrings(String val1, String val2) {
		int length = maximum(val1.length(),val2.length());
		char[] sum = new char[length+1];
		if (length == val1.length())
			val2 = appendZerosInSmallerString(length,val2);
		else
			val1 = appendZerosInSmallerString(length,val1);
		System.out.println("val1 : " + val1 + " val2: " + val2 + " Length max: " + length);
		
		int carryforward = 0;
		for (int i = length ; i > 0; i--) {
			int nv = Integer.parseInt(String.valueOf(val1.charAt(i-1))) + Integer.parseInt(String.valueOf(val2.charAt(i-1))) + carryforward;
			carryforward = nv/10;
			System.out.println("NV: " + nv + " CF: " + carryforward);
			sum[i] = (char) (nv % 10 + 48);
			System.out.println("Sum[" + i + "]: " + sum[i]);
		}
		sum[0] = (char) (carryforward % 10 + 48);
		return sum;
	}

	private static String appendZerosInSmallerString(int length, String val) {
		char[] zeros = new char[length-val.length()];
		for (int i = 0; i < length-val.length(); i++) {
			zeros[i] = '0';
		}
		return (new String(zeros)) + val;
	}

	private static int maximum(int length, int length2) {
		return length > length2 ? length : length2;
	}

	
	
}
