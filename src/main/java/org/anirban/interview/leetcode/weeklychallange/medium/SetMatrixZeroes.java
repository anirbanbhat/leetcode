package org.anirban.interview.leetcode.weeklychallange.medium;

/**
 * 
 * Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.
 * 
 * Follow up:
 * 
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 * 
 * @author Anirban Bhattacherji
 *
 */

public class SetMatrixZeroes {

	public static void main(String[] args) {
		int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		printMatrix(matrix);
		setZeroes(matrix);
		printMatrix(matrix);
	}
	
	public static void setZeroes(int[][] matrix) {
        boolean[][] boolMatrix = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
        	for(int j = 0; j < matrix[0].length; j++) {
        		if(matrix[i][j] == 0) {
        			boolMatrix[i][j] = true;
        		}
        	}
        }
        for(int i = 0; i < boolMatrix.length; i++) {
        	for(int j = 0; j < boolMatrix[0].length; j++) {
        		if(boolMatrix[i][j]) {
        			setZeroes(matrix, i, j);
        		}
        	}
        }
    }
	
	private static void setZeroes(int[][] matrix, int row, int col) {
		for(int i = 0; i < matrix[0].length; i++) {
			matrix[row][i] = 0;
		}
		for(int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}
	}

	public static void printMatrix(int[][] matrix) {
		String prefix = " ";
		for(int i = 0; i < matrix.length; i++) {
        	for(int j = 0; j < matrix[0].length; j++) {
        		System.out.print(prefix + matrix[i][j]);
        		prefix = ", ";
        	}
        	prefix = " ";
        	System.out.println();
        }
		System.out.println();
	}
}
