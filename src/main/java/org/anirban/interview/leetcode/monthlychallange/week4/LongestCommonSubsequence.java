package org.anirban.interview.leetcode.monthlychallange.week4;

/**
 * 
 * @author Anirban
 * 
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * 
 * A subsequence of a string is a new string generated from the original string with some characters(can be none) 
 * deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" 
 * while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
 * 
 * If there is no common subsequence, return 0.
 * 
 * Example 1:
 * 
 * Input: text1 = "abcde", text2 = "ace" 
 * Output: 3  
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * 
 * Example 2:
 * 
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * 
 * Example 3:
 * 
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 */

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence("abcde", "ace"));
		System.out.println(longestCommonSubsequence("abc", "abc"));
		System.out.println(longestCommonSubsequence("abc", "def"));
	}

	public static int longestCommonSubsequence(String text1, String text2) {
        int[][] table = new int[text1.length()+1][text2.length()+1];
        for(int index1 = 1; index1 < table.length; index1++){
            for(int index2 = 1; index2 < table[0].length; index2++){
                if(text1.charAt(index1-1) == text2.charAt(index2-1)){
                    table[index1][index2] = 1 + table[index1-1][index2-1];
                } else {
                    table[index1][index2] = Math.max(table[index1-1][index2], table[index1][index2-1]);
                }
            }
        }
        return table[text1.length()][text2.length()];
    }
}
