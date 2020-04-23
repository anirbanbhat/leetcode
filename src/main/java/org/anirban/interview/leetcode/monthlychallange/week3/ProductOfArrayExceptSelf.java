package org.anirban.interview.leetcode.monthlychallange.week3;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Anirban
 * 
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] 
 * is equal to the product of all the elements of nums except nums[i].
 * 
 * Example:
 * 
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the 
 * array (including the whole array) fits in a 32 bit integer.
 * 
 * Note: Please solve it without division and in O(n).
 * 
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra 
 * space for the purpose of space complexity analysis.)
 * 
 */

public class ProductOfArrayExceptSelf {

	@Test
	public void test() {
		assertArrayEquals(new int[] {24,12,8,6}, productExceptSelf(new int[] {1, 2, 3, 4}));
		assertArrayEquals(new int[] {10218096,10170790,10123920,10077480}, productExceptSelf(new int[] {215, 216, 217, 218}));
		assertArrayEquals(new int[] {24,12,8,6}, productExceptSelf2(new int[] {1, 2, 3, 4}));
		assertArrayEquals(new int[] {10218096,10170790,10123920,10077480}, productExceptSelf2(new int[] {215, 216, 217, 218}));

	}

    public int[] productExceptSelf(int[] nums) {
        int[] arr1 = new int[nums.length];
        int[] arr2 = new int[nums.length];
        arr1[0] = 1;
        // left to right scan
        for(int i=0; i<nums.length-1; i++){
            arr1[i+1] = arr1[i] * nums[i];
        }
        arr2[nums.length-1] = 1;
        // right to left scan
        for(int i=nums.length-1; i>0; i--){
            arr2[i-1] = arr2[i]*nums[i];
        }
        // multiply
        for(int i=0; i<nums.length; i++){
            nums[i] = arr1[i] * arr2[i];
        }
        return nums;
    }
    
    public int[] productExceptSelf2(int[] nums) {
        int multiply = 1;
        // multiply
        for(int i=0; i<nums.length; i++){
        	multiply *= nums[i];
        }
        // devide
        for(int i=0; i<nums.length; i++){
            nums[i] = multiply / nums[i];
        }
        return nums;
    }
}
