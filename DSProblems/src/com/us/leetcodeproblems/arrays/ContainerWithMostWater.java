package com.us.leetcodeproblems.arrays;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1
 
 */
public class ContainerWithMostWater {

	// Time Complexity : O(n) Space Complexity : O(1)
	public static int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int maxArea = 0;
		// int width = right - left;
        // int h = Math.min(height[left], height[right]);
        // int area = h * width;
		while (left < right) {
			int currentArea = Math.min(height[left], height[right]) * (right - left);
			maxArea = Math.max(maxArea, currentArea);

			if (height[left] < height[right])
				left++;
			else
				right--;
		}
		return maxArea;
	}
	
	public static void main(String[] args) {
		int[] heights = {1,8,6,2,5,4,8,3,7};
		System.out.println("Max Area : "+maxArea(heights));
	}
}
