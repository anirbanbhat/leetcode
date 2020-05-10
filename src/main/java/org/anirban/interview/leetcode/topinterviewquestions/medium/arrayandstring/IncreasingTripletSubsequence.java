package org.anirban.interview.leetcode.topinterviewquestions.medium.arrayandstring;

/**
 * 
 * @author Anirban
 * 
 * Given an unsorted array return whether an increasing subsequence of length 3 exists 
 * or not in the array.
 * 
 * Formally the function should:
 * 
 * Return true if there exists i, j, k 
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,4,5]
 * Output: true
 * 
 * Example 2:
 * 
 * Input: [5,4,3,2,1]
 * Output: false
 *
 */

public class IncreasingTripletSubsequence {

	public static void main(String[] args) {
		System.out.println(increasingTriplet(new int[] {1,2,3,4,5}));
		System.out.println(increasingTriplet(new int[] {5,4,3,2,1}));
		System.out.println(increasingTriplet(new int[] {100, 50, 110, 70, 40, 30, 80}));
	}

	public static boolean increasingTriplet(int[] nums) {
		if(nums == null || nums.length<3) {
			return false;
		}
        int minOne = Integer.MAX_VALUE;
        int minTwo = Integer.MAX_VALUE; 
        for (int i : nums) {
			if(i<minOne) {
				minOne = i;
			}
			if(i>minOne) {
				minTwo = Math.min(i, minTwo);
			}
			if(i>minTwo) {
				return true;
			}
		}
        return false;
    }
}
