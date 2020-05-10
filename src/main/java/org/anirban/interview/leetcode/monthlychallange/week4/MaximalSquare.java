package org.anirban.interview.leetcode.monthlychallange.week4;

/**
 * 
 * @author Anirban
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return 
 * its area.
 * 
 * Example:
 * 
 * Input: 
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * Output: 4
 *
 */

public class MaximalSquare {

	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1, 0, 1, 0, 0},
			                          {1, 0, 1, 1, 1},
		                              {1, 1, 1, 1, 1},
		                              {1, 0, 0, 1, 0}};
        System.out.println(maximalSquare(matrix));
	}

	public static int maximalSquare(int[][] matrix) {
		if(matrix.length==0) {
			return 0;
		}
        int[][] square = new int[matrix.length+1][matrix[0].length+1];
        int max = 0;
        for(int i = 1; i < square.length; i++){
            for(int j = 1; j < square[0].length; j++){
                if(matrix[i-1][j-1] == 1){
                    square[i][j] = 1 + Math.min(square[i-1][j], Math.min(square[i][j-1], square[i-1][j-1]));
                    max = Math.max(max, square[i][j]);
                }
            }
        }
        return max*max;
    }
}
