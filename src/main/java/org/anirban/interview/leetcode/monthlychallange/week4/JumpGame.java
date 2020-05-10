package org.anirban.interview.leetcode.monthlychallange.week4;

/**
 * 
 * @author Anirban
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * Example 1:
 * 
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Example 2:
 * 
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes 
 * it impossible to reach the last index.
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 3 * 10^4
 * 0 <= nums[i][j] <= 10^5
 *
 */

public class JumpGame {

	public static void main(String[] args) {
		System.out.println(canJump(new int[] {2,3,1,1,4}));
		System.out.println(canJump(new int[] {3,2,1,0,4}));
		System.out.println(canJump(new int[] {1}));
		System.out.println(canJump(new int[] {0}));
		System.out.println(canJump(new int[] {}));
		
		System.out.println("------------------------------");
		
		System.out.println(canJump2(new int[] {2,0}));
		System.out.println(canJump2(new int[] {2,3,1,1,4}));
		System.out.println(canJump2(new int[] {3,2,1,0,4}));
		System.out.println(canJump2(new int[] {1}));
		System.out.println(canJump2(new int[] {0}));
		System.out.println(canJump2(new int[] {}));
	}

	public static boolean canJump(int[] nums) {
		if(nums.length==0) {
			return false;
		}
		Boolean[] memo = new Boolean[nums.length];
		return canJump(nums, 0, memo);
    }
	
	
	public static boolean canJump(int[] nums, int index, Boolean[] memo) {
        if(index==nums.length-1) {
        	return true;
        }
        if(nums[index] == 0) {
        	return false;
        }
        if(memo[index] == null) {
        	int range = 1;
        	boolean canJump = false;
        	while(range<=nums[index] && range+index<nums.length) {
        		canJump = canJump || canJump(nums, index+range, memo);
        		range++;
        	}
        	memo[index] = canJump;
        }
		return memo[index];
    }
	
	
	public static boolean canJump2(int[] nums) {
		if(nums.length==0) {
			return false;
		}
		if(nums.length==1) {
			return true;
		}
		boolean[] memo = new boolean[nums.length];
		memo[0] = nums[0]>0;
		for (int start = 0; start < memo.length; start++) {
			for (int end = start+1; end < memo.length && end<=start + nums[start]; end++) {
				if(end<memo.length-1) {
					memo[end] = memo[start] && nums[end]>0;
				} else {
					memo[end] = memo[start];
				}
			}
		}
		return memo[nums.length-1];
    }
	
}
