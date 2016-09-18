package counting;

import java.util.ArrayList;

/**
 * Collection of static methods for permutations and combinations
 * @author Tony Song
 *
 */

public class CountingMethods {
	
	/**
	 * Recursive helper method to find the all permutations of a number 
	 * sequence (1, 2, 3 ... n - 1, n)
	 * @param n - the largest number in the sequence (1, 2, 3 ... n - 1, n) 
	 * @param arr - an ArrayList that represents a partial permutation 
	 */
	private static void permutationHelper(int n, ArrayList<Integer> arr) {
		// Example: When n = 3 and i = 1
		//                  []
		//                 1 [1]
		//         2 [1, 2]     3 [1, 3]
		//  3 [1, 2, 3]             2 [1, 3, 2]
		if (arr.size() == n) {
			// Base case
			System.out.println(arr);
		} else {
			// Recursive case
			for (int i = 1; i <= n; i++) {
				if (!arr.contains(i)) {
					ArrayList<Integer> copy = (ArrayList<Integer>) arr.clone();
					copy.add(i);
					permutationHelper(n, copy);
				}
			}	
		}
	}
	
	/**
	 * Take a number and print every permutation of (1, 2, 3 ... n - 1, n) 
	 * when n is the given number.
	 * @param n - the largest number in the sequence (1, 2, 3 ... n - 1, n) 
	 */
	public static void permutation(int n) {
		permutationHelper(n, new ArrayList<Integer>());
	}
}
