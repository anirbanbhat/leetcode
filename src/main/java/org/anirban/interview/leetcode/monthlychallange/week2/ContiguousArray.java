package org.anirban.interview.leetcode.monthlychallange.week2;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Anirban
 * 
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * 
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * 
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Note: The length of the given binary array will not exceed 50,000.
 *
 */

public class ContiguousArray {

	public static void main(String[] args) {
		System.out.println(findMaxLength(new int[] {0, 1})); //2
		System.out.println(findMaxLength(new int[] {0, 1, 0})); //2
		System.out.println(findMaxLength(new int[] {1, 0, 1, 0, 1})); //4
		System.out.println(findMaxLength(new int[] {1, 1, 0, 1, 1})); //2
		System.out.println(findMaxLength(new int[] {1, 1, 1, 1, 1, 1, 1})); //0
		System.out.println(findMaxLength(null)); //0
	}
	
	/**
	 * 
	 * 1.  Starting from left of array and keep adding elements to a variable sum
	 * 2.  Add -1 for 0 and 1 for 1
	 * 3.  Now, every time sum becomes zero, we know all the elements from begining of array have been neutralized , 
	 *     meaning we have got equal number of ones and zeroes,
	 * 4.  let this occurs at index i, so longestContArray = i+1 ('coz w're dealing with indices)
	 * 5.  But we are not done yet!, consider the case : [1,1,0,1,1]
	 * 6.  In this case sum will never become zero,
	 * 7.  but there exists a sub array of length 2, having equal 0 & 1
	 * 8.  let's see the value of sum at index : 1 and 3
	 * 9.  Ohh!! sum = 2 for both indices
	 * 10. what does this mean???
	 * 11. This means that if we get the same sum value for two indices i and j, then all the elements within the 
	 *     range [i,j) or (i,j] have been neutralized
	 * 12. What data structure can remember the sum and index
	 * 13. Of course ! Map, so we use a map to store the sum and index values,
	 * 14. if sum == 0 then we have already solved the cases
	 * 15. but if sum!=0 and this sum doesn't already exist in the map,
	 * 16. then store it with it's corresponding index
	 * 17. but if sum !=0 and sum already exists in the map then,
	 * 18. depending on whether i - m[sum] > LongestContArray, update LongestContArray
	 * 19. Note we need to store a unique sum value only once, after that whenever we encounter the same sum again 
	 *     our interval length is going to increase only and that is what we want
	 * 20. ex- [1,0,1,0,1] we get sum = 1 three times
	 * 21. we store sum = 1 for index = 0 only
	 * 22. and never update it as we want longest length
	 * 
	 * @param nums
	 * @return
	 */
	
	public static int findMaxLength(int[] nums) {
        int sum = 0;
        int maxLength = 0;
        if(nums==null){
            return maxLength;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            sum += nums[i] == 0 ? -1 : 1;
            if(sum == 0){
                maxLength = i+1;
            } else if(map.containsKey(sum)){
                maxLength = Math.max(maxLength, i-map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLength;
    }

}
