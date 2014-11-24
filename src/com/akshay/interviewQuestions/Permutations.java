package com.akshay.interviewQuestions;

public class Permutations {

	public static void main(String[] args) {
		String str = "123";
		
		computeStringPermutations(str);
	
		/*http://kartikkukreja.wordpress.com/2014/11/04/interesting-problem-multiple-solutions/
		 * Find a permutation of numbers 1 through N such that average of any two numbers in the permutation does not occur between them”. I found this problem particularly interesting because it lends itself to several different solutions.
		 * Note that if the average is not an integer, then it clearly cannot occur between two numbers in the permutation. Let’s make the problem concrete with a few examples:

		 * For N = 3, [1,3,2], [2,1,3], [2,3,1], [3,1,2] are all solution permutations, but [1,2,3] is not because 2 occurs between 1 and 3.

		   For N = 4, [1,3,2,4] is a solution permutation but [1,4,2,3] is not because 2 occurs between 1 and 3.*/
		printRequiredSequence(1,0,10);
		System.out.println();
	}

	private static void printRequiredSequence(int multiple, int decrement, int N) {
		if (2 * multiple - decrement > N) {
			System.out.print(multiple-decrement + " ");
			return;
		}
		printRequiredSequence(2 * multiple, decrement + multiple, N);
		printRequiredSequence(2 * multiple, decrement, N);
			
	}

	private static void computeStringPermutations(String str) {
		computeStringPermutations("",str);	
	}

	private static void computeStringPermutations(String prefix, String str) {
		int n = str.length();
		if (n == 0) System.out.println(prefix);
		else {
			for (int i =0 ; i < n; i++) {
				computeStringPermutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
			}
		}
	}	
	
}
