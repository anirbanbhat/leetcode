package org.anirban.interview.leetcode.medium.zigzagconversion;

import java.util.Arrays;

public class ZigzagConversion {

	public static void main(String[] args) {
		String ret = convert("PAYPALISHIRING", 3);
        System.out.println(ret);
        ret = convert("PAYPALISHIRING", 4);
        System.out.println(ret);
        ret = convert("AB", 1);
        System.out.println(ret);
	}
	
	public static String convert(String s, int numRows) {
		if(numRows==1) {
			return s;
		}
        char[][] zigzag = new char[numRows][s.length()];
        for (int i = 0; i < zigzag.length; i++) {
			Arrays.fill(zigzag[i], ' ');
		}
        printMatrix(zigzag);
        int[] dirX = new int[]{1,-1};
        int[] dirY = new int[]{0,1};
        int counter=0;
        int x=0;
        int y=0;
        int dir = 0;
        while(counter<s.length()){
            zigzag[x][y]=s.charAt(counter++);
            x += dirX[dir];
            y += dirY[dir];
            System.out.println("X: " + x + " -- Y: " + y);
            printMatrix(zigzag);
            if(isInvalid(zigzag, x, y)){
                x -= dirX[dir];
                y -= dirY[dir];
                dir = (dir+1)%2;
                x += dirX[dir];
                y += dirY[dir];
            }
        }
        //replaceAll("\\s+","");
        printMatrix(zigzag);
        StringBuilder ret = new StringBuilder();
        for(int i=0; i<numRows; i++){
            ret.append((new String(zigzag[i])).replaceAll("\\s+",""));
        }
        return ret.toString();
    }
    public static boolean isInvalid(char[][] zigzag, int x, int y){
    	System.out.println("zigzag.length: "  + zigzag.length);
        return x>=zigzag.length || y>=zigzag[0].length || x<0 || y<0;
    }
    public static void printMatrix(char[][] zigzag) {
    	for (int i = 0; i < zigzag.length; i++) {
			for (int j = 0; j < zigzag[i].length; j++) {
				System.out.print(zigzag[i][j] + " ");
			}
			System.out.println();
		}
    	System.out.println();
    }
}
