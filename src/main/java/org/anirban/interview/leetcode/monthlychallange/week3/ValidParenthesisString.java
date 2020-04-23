package org.anirban.interview.leetcode.monthlychallange.week3;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * @author Anirban
 * 
 * Given a string containing only three types of characters: '(', ')' and '*', write a function 
 * to check whether this string is valid. We define the validity of a string by these rules:
 * 
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an 
 * empty string.
 * An empty string is also valid.
 * Example 1:
 * Input: "()"
 * Output: True
 * Example 2:
 * Input: "(*)"
 * Output: True
 * Example 3:
 * Input: "(*))"
 * Output: True
 * Note:
 * The string size will be in the range [1, 100].
 *
 */

public class ValidParenthesisString {

	public static void main(String[] args) {
		System.out.println(checkValidString("(())(())(((()*()()()))()((()()(*()())))(((*)()")); // false
		System.out.println(checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*")); // false
		System.out.println(checkValidString("()")); // true
		System.out.println(checkValidString("(*)")); // true
		System.out.println(checkValidString("(*))")); // true
		System.out.println(checkValidString("")); // true
		System.out.println(checkValidString(null)); // false
		System.out.println(checkValidString("(*)))")); // false
		System.out.println(checkValidString("()*)*)")); // true
		System.out.println(checkValidString("()*")); // true
		System.out.println(checkValidString("()(**")); // true
		
		// (**((*
	}

	public static boolean checkValidString(String s) {
		if(s==null) {
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> ast = new Stack<>();
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			switch (chars[i]) {
			case '(':
				stack.push(i);
				break;
			case '*':
				ast.push(i);
				break;
			case ')':
				if (!stack.isEmpty()) {
					stack.pop();
				} else if (!ast.isEmpty()) {
					ast.pop();
				} else {
					return false;
				}
			}
		}
		while (!stack.isEmpty() && !ast.isEmpty()) {
			if (stack.pop() > ast.pop()) {
				return false;
			}
		}
		return stack.isEmpty();
    }

	public static boolean checkValidString2(String s) {
		if(s==null) {
			return false;
		}
        char[] chArray = s.toCharArray();
        int left = 0;
        ArrayList<Character> list = new ArrayList<>();
        for(Character ch: chArray){
            if(ch == '(' || ch == '*'){
            	list.add(ch);
            } else  if(ch == ')'){
                if(list.size() == 0) {
                	return false;
                }
                int index = list.size() - 1;
                while(index>=0) {
                	if(list.get(index) == '(') {
                		break;
                	}
                	index--;
                }
                if(index>=0) {
                	list.remove(index);
                } else {
                	list.remove(list.size()-1);
                }
            }
        }
        for (Character character : list) {
			if(character == '(') {
				left++;
			} else if(character == '*' && left>0) {
				left--;
			}
		}
        return left==0;
    }
}
