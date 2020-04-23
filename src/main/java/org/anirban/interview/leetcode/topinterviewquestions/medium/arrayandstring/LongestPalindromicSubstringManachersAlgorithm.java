package org.anirban.interview.leetcode.topinterviewquestions.medium.arrayandstring;

/**
 * 
 * @author Anirban
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume that the 
 * maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * 
 * Input: "cbbd"
 * Output: "bb"
 *
 */

public class LongestPalindromicSubstringManachersAlgorithm {

	public static void main(String[] args) {
		System.out.println(manachersAlgorithm("babad"));
		System.out.println(manachersAlgorithm("abacabacabb"));

	}

	public static String manachersAlgorithm(String s) {
		int n = s.length();
		String str = getModifiedString(s, n);
		System.out.println(str);
		int len = (2 * n) + 1;
		int[] P = new int[len];
		int maxLenIndex = 0;
		int c = 0; // stores the center of the longest palindromic substring until now
		int r = 0; // stores the right boundary of the longest palindromic substring until now
		int maxLen = 0;
		for (int i = 0; i < len; i++) {
			// get mirror index of i
			int mirror = (2 * c) - i;

			// see if the mirror of i is expanding beyond the left boundary of current
			// longest palindrome at center c
			// if it is, then take r - i as P[i]
			// else take P[mirror] as P[i]
			if (i < r) {
				P[i] = Math.min(r - i, P[mirror]);
			}

			// expand at i
			int a = i + (1 + P[i]);
			int b = i - (1 + P[i]);
			while (a < len && b >= 0 && str.charAt(a) == str.charAt(b)) {
				P[i]++;
				a++;
				b--;
			}

			// check if the expanded palindrome at i is expanding beyond the right boundary
			// of current longest palindrome at center c
			// if it is, the new center is i
			if (i + P[i] > r) {
				c = i;
				r = i + P[i];

				if (P[i] > maxLen) { // update maxlen
					maxLenIndex = i;
					maxLen = P[i];
				}
			}
		}
		System.out.println(maxLenIndex);
		String longestPalindromicSubstring = str.substring(maxLenIndex - maxLen, maxLenIndex + maxLen+1);
		System.out.println(longestPalindromicSubstring.replaceAll("#", ""));
		return longestPalindromicSubstring.replaceAll("#", "");
	}

	public static String getModifiedString(String s, int N) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append("#");
			sb.append(s.charAt(i));
		}
		sb.append("#");
		return sb.toString();
	}
}
