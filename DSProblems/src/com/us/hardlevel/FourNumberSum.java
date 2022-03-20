package com.us.hardlevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author Uma Shankar
 * <pre>
 * ------------------------------------------------------------------------------------------------
 * Write a function that takes in a non-empty array of distinct integers and an integer representing
 * a target sum. The function should find all quadruplets in the array that sum up to the target sum
 * and return a two-dimensional array of all these quadruplets in no particular order.
 * 
 * If no four numbers sum up to the target sum, the function should return an empty array.
 * 
 * Sample Input :
 * 	array=[7, 6, 4, -1, 1, 2]
 *	targetSum = 16
 *
 *Sample Output :
 *	[[7, 6, 4, -1],[7, 6, 1, 2]]
 * 
 * --------------------------------------------------------------------------------------------------
 */
public class FourNumberSum {

	public static void main(String[] args) {
		int[] inputArray = { 7, 6, 4, -1, 1, 2 };
		int targetSum = 16;

		List<Integer[]> result = fourNumberSum(inputArray, targetSum);
		result.stream().flatMap(x -> Stream.of(x)).forEach(ele -> {
			System.out.print(ele + " ");

		});
	}

	// O(n^2) Time and O(n^2) Space complexity
	public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
		Map<Integer, List<Integer[]>> allPairSums = new HashMap<>();
		List<Integer[]> quadruplets = new ArrayList<Integer[]>();
		for (int i = 1; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				int currentSum = array[i] + array[j];
				int difference = targetSum - currentSum;
				if (allPairSums.containsKey(difference)) {
					for (Integer[] pair : allPairSums.get(difference)) {
						Integer[] newQuadruplet = { pair[0], pair[1], array[i], array[j] };
						quadruplets.add(newQuadruplet);
					}
				}
			}
			for (int k = 0; k < i; k++) {
				int currentSum = array[i] + array[k];
				Integer[] pair = { array[k], array[i] };
				if (!allPairSums.containsKey(currentSum)) {
					List<Integer[]> pairGroup = new ArrayList<Integer[]>();
					pairGroup.add(pair);
					allPairSums.put(currentSum, pairGroup);
				} else {
					allPairSums.get(currentSum).add(pair);
				}
			}
		}
		return quadruplets;
	}

}
