package org.anirban.interview.leetcode.medium.zigzagconversion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Anirban
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a number of rows:
 * 
 * string convert(string s, int numRows);
 * Example 1:
 * 
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * 
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * 
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 */

public class ZigZagConversion {

	@Test
	public void test() {
		assertEquals("PAHNAPLSIIGYIR", convert("PAYPALISHIRING", 3));
		assertEquals("PINALSIGYAHRPI", convert("PAYPALISHIRING", 4));
		assertEquals("A", convert("A", 1));
		assertEquals(null, convert(null, 1));
		assertEquals("", convert("", 1));
		
		assertEquals("PAHNAPLSIIGYIR", convert2("PAYPALISHIRING", 3));
		assertEquals("PINALSIGYAHRPI", convert2("PAYPALISHIRING", 4));
		assertEquals("A", convert2("A", 1));
		assertEquals(null, convert2(null, 1));
		assertEquals("", convert2("", 1));
	}
	
	public String convert(String s, int numRows) {
		if(s == null) {
			return null;
		}
		if(numRows>=s.length() || numRows == 0){
            return s;
        }
        Character[][] chr = new Character[numRows][s.length()];
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int col= 0; col< s.length(); col++){
        	if(count>=s.length()){
                break;
            }
            for(int row= 0; row< numRows; row++){
            	if(count>=s.length()){
                    break;
                }
                if(col%(numRows-1)==0 || col%(numRows-1) == (numRows - row -1)){
                    chr[row][col] = s.charAt(count++);
                }             
            }
            display(chr);
        }
        for(int row= 0; row< numRows; row++){
            for(int col= 0; col< s.length(); col++){
                if(chr[row][col] != null){
                    sb.append(Character.toString(chr[row][col]));
                }
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
	
	public void display(Character[][] chr) {
		for (int i = 0; i < chr.length; i++) {
			for (int j = 0; j < chr[i].length; j++) {
				if(chr[i][j] == null) {
					System.out.print("  ");
				} else {
					System.out.print(chr[i][j] + " ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public String convert2(String s, int numRows) {
		if(s == null) {
			return null;
		}
		if(numRows>=s.length() || numRows == 0){
            return s;
        }
		int ind = 0;
		char[] chars = new char[s.length()];
		for (int row = 0; row < numRows; row++) {
			int index = row;
			chars[ind++] = s.charAt(index);
			while(index<s.length()) {
				int prevIndex = index;
				index = index + (numRows-1-row)*2;
				if(prevIndex != index && index<s.length()) {
					chars[ind++] = s.charAt(index);
				}
				prevIndex = index;
				index = index + row*2;
				if(prevIndex != index && index<s.length()) {
					chars[ind++] = s.charAt(index);
				}
			}
		}
		return new String(chars);
	}

}
