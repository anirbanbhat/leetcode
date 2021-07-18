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

public class SetMatrixZeroes2 {

	public static void main(String[] args) {
		int[][] matrix1 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		printMatrix(matrix1);
		setZeroes(matrix1);
		printMatrix(matrix1);
		
		int[][] matrix2 = {{1,0,3}};
		printMatrix(matrix2);
		setZeroes(matrix2);
		printMatrix(matrix2);
		
		int[][] matrix3 = {{1},{0},{3}};
		printMatrix(matrix3);
		setZeroes(matrix3);
		printMatrix(matrix3);
		
		int[][] matrix4 = {{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
		printMatrix(matrix4);
		setZeroes(matrix4);
		printMatrix(matrix4);
	}
	
	public static void setZeroes(int[][] matrix) {
		boolean firstRow = false;
		boolean firstCol = false;
        for(int i = 0; i < matrix.length; i++) {
        	for(int j = 0; j < matrix[0].length; j++) {
    			if(matrix[i][j] == 0) {
    				if(i == 0) {
    					firstRow = true;
    				}
    				if(j == 0) {
    					firstCol = true;
    				}
    				matrix[0][j] = 0;
    				matrix[i][0] = 0;
    			}
    		}
        }
        
        for(int row = 1; row < matrix.length; row++) {
        	if(matrix[row][0] == 0) {
        		for(int col = 0; col < matrix[0].length; col++) {
        			matrix[row][col] = 0;
        		}
        	}
        }
        
        for(int col = 1; col < matrix[0].length; col++) {
        	if(matrix[0][col] == 0) {
        		for(int row = 0; row < matrix.length; row++) {
        			matrix[row][col] = 0;
        		}
        	}
        }
        
        if(firstRow) {
        	for(int col = 0; col < matrix[0].length; col++) {
    			matrix[0][col] = 0;
    		}
        }
        
        if(firstCol) {
    		for(int row = 0; row < matrix.length; row++) {
    			matrix[row][0] = 0;
    		}
    	}
    }

	public static void printMatrix(int[][] matrix) {
		String prefix = "\t";
		for(int i = 0; i < matrix.length; i++) {
        	for(int j = 0; j < matrix[0].length; j++) {
        		System.out.print(prefix + matrix[i][j]);
        		prefix = ",\t";
        	}
        	prefix = "\t";
        	System.out.println();
        }
		System.out.println();
	}
}
