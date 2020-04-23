package org.anirban.interview.leetcode.monthlychallange.week2;

import java.util.LinkedList;

/**
 * 
 * @author Anirban
 * 
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 * 
 * Example 1:
 * 
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * 
 * Example 2:
 * 
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * 
 * Example 3:
 * 
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * 
 * Example 4:
 * 
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 * 
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * Follow up:
 * 
 * Can you solve it in O(N) time and O(1) space?
 *
 */

public class BackspaceStringCompare {

	public static void main(String[] args) {
		System.out.println(backspaceCompare("ab#c", "ad#c"));
		System.out.println(backspaceCompare("ab##", "c#d#"));
		System.out.println(backspaceCompare("a##c", "#a#c"));
		System.out.println(backspaceCompare("a#c", "b"));
		System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));
	}

	public static boolean backspaceCompare(String S, String T) {
		LinkedList<Character> sList = new LinkedList<>();
		LinkedList<Character> tList = new LinkedList<>();
        for(char ch: S.toCharArray()){
            if(ch == '#' && !sList.isEmpty()){
                sList.removeLast();
            } else if(ch != '#') {
                sList.offer(ch);
            }
        }
        for(char ch: T.toCharArray()){
            if(ch == '#' && !tList.isEmpty()){
                tList.removeLast();
            } else if(ch != '#') {
                tList.offer(ch);
            }
        }
        if(sList.size() == tList.size()){
            for(int i=0; i<sList.size(); i++){
                char chs = sList.poll();
                char cht = tList.poll();
                if(chs != cht){
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
