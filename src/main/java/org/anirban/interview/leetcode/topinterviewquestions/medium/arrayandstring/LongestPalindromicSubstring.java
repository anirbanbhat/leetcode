package org.anirban.interview.leetcode.topinterviewquestions.medium.arrayandstring;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome("cbbd"));
		System.out.println(longestPalindrome("malayalamalayal"));
		System.out.println(longestPalindrome("babadada"));
		System.out.println(longestPalindrome("babaddtattarrattatddetartrateedredividerb"));
		System.out.println(longestPalindrome("cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"));
	}

	public static String longestPalindrome(String s) {
		String[][] dp = new String[s.length()][s.length()];
		return longestPalindrome(s, 0, s.length() - 1, dp);
    }
	public static String longestPalindrome(String s, int start, int end, String[][] dp) {
        if(start == end) {
        	return s.substring(start, start + 1);
        }
        if(start > end) {
        	return "";
        }
        if(dp[start][end] == null) {
        	String str1 = "";
            String str2 = "";
            String str3 = "";
            if(s.charAt(start) == s.charAt(end)) {
            	str1 = longestPalindrome(s, start + 1, end - 1, dp);
            	if(str1.length() == end - start - 1) {
            		dp[start][end] = s.charAt(start) + str1 + s.charAt(end);
            		return dp[start][end];
            	}
            }
        	str2 = longestPalindrome(s, start + 1, end, dp);
            str3 = longestPalindrome(s, start, end - 1, dp);
            dp[start][end] = str2.length() > str3.length() ? str2 : str3;            
        }
        return dp[start][end];
    }
}
