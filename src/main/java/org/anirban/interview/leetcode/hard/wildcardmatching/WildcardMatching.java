package org.anirban.interview.leetcode.hard.wildcardmatching;

/**
 * 
 * @author Anirban
 *
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false
 *
 */

public class WildcardMatching {

	public static void main(String[] args) {
		isMatch("acdcb", "a*c?b");
		isMatch("acdcb", "ac*?b");
	}
	
	public static boolean isMatch(String s, String p) {
		System.out.println("*********************************");
		System.out.println("s=" + s);
		System.out.println("p=" + p);
		int i = 0;
		int j = 0;
		int star = -1;
		int mark = -1;
		while(i<s.length()) {
			System.out.println("i=" + i);
			System.out.println("s.charAt(i)=" + s.charAt(i));
			System.out.println("j=" + j);
			System.out.println("p.charAt(j)=" + p.charAt(j));
			System.out.println("star=" + star);
			System.out.println("mark=" + mark);
			System.out.println("------------------");
			if(j<p.length() && (p.charAt(j)=='?' || p.charAt(j)==s.charAt(i))) {
				++i;
				++j;
			} else if(j<p.length() && p.charAt(j)=='*') {
				star = j;
				j++;
				mark = i;
			} else if(star != -1) {
				j = star + 1;
				mark++;
				i = mark;
			} else {
				return false;
			}
		}
		while(j<p.length() && p.charAt(j)=='*') {
			j++;
		}
		System.out.println("result=" + (j==p.length()));
		return j==p.length();
	}
}
