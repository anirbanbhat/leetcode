package org.anirban.interview.leetcode.topinterviewquestions.medium.arrayandstring;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Anirban
 * 
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * 
 * Example 1:
 * 
 * Input: 
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output: 
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 
 * Example 2:
 * 
 * Input: 
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * Output: 
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 
 * Follow up:
 * 
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 *
 */

public class SetMatrixZeroes {

	public static void main(String[] args) {
		setZeroes(new int[][] {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
		setZeroes(new int[][] {{0, 1, 2, 0},{3, 4, 5, 2},{1, 3, 1, 5}});
		setZeroes2(new int[][] {{0, 1, 2, 0},{3, 4, 5, 2},{1, 3, 1, 5}});
		setZeroes(new int[][] {{1, 2, 3}, {0, 4, 5}});
		setZeroes2(new int[][] {{1, 2, 3}, {0, 4, 5}});
		setZeroes2(new int[][] {{1, 0, 3}});
	}

	public static void setZeroes(int[][] matrix) {
		printMatrix(matrix);
        List<int[]> points = new ArrayList<int[]>();
        for(int i=0; i<matrix.length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					points.add(new int[] {i, j});
				}
			}
        }
        
        for (int[] is : points) {
			int row = is[0];
			int col = is[1];
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][col] = 0;
			}
			for (int i = 0; i < matrix[row].length; i++) {
				matrix[row][i] = 0;
			}
		}
        printMatrix(matrix);
    }
	
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void setZeroes2(int[][] matrix) {
		printMatrix(matrix);
		boolean isColumn = false;
		boolean isRow = false;
		for(int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					if(i==0) {
						isRow = true;
					}
					if(j==0) {
						isColumn = true;
					}
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		for(int i = 1; i < matrix.length; i++) {
			if(matrix[i][0] == 0) {
				for(int j = 0; j < matrix[0].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		
		for(int i = 1; i < matrix[0].length; i++) {
			if(matrix[0][i] == 0) {
				for(int j = 0; j < matrix.length; j++) {
					matrix[j][i] = 0;
				}
			}
		}
		
		if(isColumn) {
			for(int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
		if(isRow) {
			for(int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		}
		printMatrix(matrix);
	}
}
