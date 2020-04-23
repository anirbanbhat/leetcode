package org.anirban.interview.leetcode.monthlychallange.week2;

/**
 * 
 * @author Anirban
 * 
 * You are given a string s containing lowercase English letters, and a matrix shift, where 
 * shift[i] = [direction, amount]:
 * 
 * direction can be 0 (for left shift) or 1 (for right shift). 
 * amount is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 * 
 * Example 1:
 * 
 * Input: s = "abc", shift = [[0,1],[1,2]]
 * Output: "cab"
 * Explanation: 
 * [0,1] means shift to left by 1. "abc" -> "bca"
 * [1,2] means shift to right by 2. "bca" -> "cab"
 * 
 * Example 2:
 * 
 * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
 * Output: "efgabcd"
 * Explanation:  
 * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
 * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
 * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
 * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 *
 */

public class PerformStringShifts {

	public static void main(String[] args) {
		System.out.println(stringShift("abcdefg", new int[][] {{1,1},{1,1},{0,2},{1,3}}));
		System.out.println(stringShift("abc", new int[][] {{0,1},{1,2}}));
		System.out.println(stringShift2("abcdefg", new int[][] {{1,1},{1,1},{0,2},{1,3}}));
		System.out.println(stringShift2("abc", new int[][] {{0,1},{1,2}}));
		System.out.println(stringShift2("mecsk", new int[][] {{1,4},{0,5},{0,4},{1,1},{1,5}}));
	}
	
	public static String stringShift(String s, int[][] shift) {
		if(s==null || s.length()==0) {
			return s;
		}
		String s1;
		String s2;
        for (int i = 0; i < shift.length; i++) {
        	System.out.print(s + " -> [" + shift[i][0] + "][" + shift[i][1] + "] -> ");
        	if(shift[i][0] == 1) {
        		int shiftPoint = Math.abs(s.length()-shift[i][1]);
            	s1 = s.substring(0, shiftPoint);
            	s2 = s.substring(shiftPoint, s.length());
            	s = s2 + s1;
            } else if(shift[i][0] == 0){
            	s1 = s.substring(0, shift[i][1]%s.length());
            	s2 = s.substring(shift[i][1]%s.length(), s.length());
            	if(s1.length()>0) {
            		for (char ch : s1.toCharArray()) {
            			s2 += ch;
					}
            	}
            	s = s2;
            }
        	System.out.println(s);
		}
        return s;
    }
	
	public static String stringShift2(String s, int[][] shift) {
		if(s==null || s.length()==0) {
			return s;
		}
		String s1;
		String s2;
		int totalShift = 0;
        for (int i = 0; i < shift.length; i++) {
        	if(shift[i][0] == 1) {
        		totalShift += shift[i][1];
            } else if(shift[i][0] == 0){
            	totalShift += -shift[i][1];
            }
		}
        if(totalShift > 0) {
        	int shiftPoint = Math.abs(s.length() - totalShift%s.length());
        	s1 = s.substring(0, shiftPoint);
        	s2 = s.substring(shiftPoint, s.length());
        	s = s2 + s1;
        } else if(totalShift < 0) {
        	s1 = s.substring(0, Math.abs(totalShift)%s.length());
        	s2 = s.substring(Math.abs(totalShift)%s.length(), s.length());
        	if(s1.length()>0) {
        		for (char ch : s1.toCharArray()) {
        			s2 += ch;
				}
        	}
        	s = s2;
        }
        return s;
    }
}
