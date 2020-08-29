package org.anirban.interview.leetcode.topinterviewquestions.medium.other;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * 
 * Example 1:
 * 
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 * 
 * Input: a = -2, b = 3
 * Output: 1
 * Java
 * 
 * @author Anirban Bhattacherji
 *
 */

public class SumOfTwoIntegers {

	public static void main(String[] args) {
		System.out.println(getSum(4, 10)); // 14
		System.out.println(getSum(4, 0)); // 4
		System.out.println(getSum(-4, 0)); // -4
		System.out.println(getSum(4, -10)); // -6
		System.out.println(getSum(-4, 10)); // 6
		System.out.println(getSum(-4, -10)); // -14
	}

	public static int getSum(int a, int b) {
        if(b > 0) {
        	while(b > 0) {
        		a++;
        		b--;
        	}
        } else if (b < 0) {
        	while(b < 0) {
        		a--;
        		b++;
        	}
        }
        return a;
    }
}
