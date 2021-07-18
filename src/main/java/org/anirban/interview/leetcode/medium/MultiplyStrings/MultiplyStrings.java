package org.anirban.interview.leetcode.medium.MultiplyStrings;

import java.util.*;

public class MultiplyStrings {

	public static void main(String[] args) {
		System.out.println(multiply("123", "456"));
		System.out.println(multiply("999", "909"));
		System.out.println(multiply("999", "0"));
		System.out.println(multiply("0", "1"));
		System.out.println(multiply("6", "501"));
	}

	public static String multiply(String num1, String num2) {
        List<Integer> list = new ArrayList<>();
        int shift = -1;
        for(int j = num2.length() - 1; j >= 0; j--){
            int carry = 0;
            shift++;
            int index = 0;
            for(int i = num1.length() - 1; i >= 0; i--){
                int temp = ((num1.charAt(i) - '0') * (num2.charAt(j) - '0')) + carry;
                if(list.size() > index+shift){
                    temp += list.get(index+shift);
                    list.set(index+shift, temp%10);
                } else {
                    list.add(temp%10);
                }
                carry = temp/10;
                index++;
            }
            while(carry > 0){
                if(list.size() > index+shift){
                    int val = carry + list.get(index+shift);
                    list.set(index+shift, val%10);
                } else {
                    list.add(carry%10);
                }
                carry = carry/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean nonZero = false;
        for(Integer i : list){
        	nonZero = nonZero || i != 0;
            sb.insert(0, Integer.toString(i));
        }
        return nonZero? sb.toString():"0";
    }
}
