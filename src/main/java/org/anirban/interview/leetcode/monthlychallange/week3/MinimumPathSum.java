package org.anirban.interview.leetcode.monthlychallange.week3;

/**
 * 
 * @author Anirban
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right 
 * which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Example:
 * 
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 */

public class MinimumPathSum {

	public static void main(String[] args) {
		int[][] grid1 = {{1, 3, 1},
						 {1, 5, 1},
						 {4, 2, 1}};
		System.out.println(minPathSum(grid1));
	}
	
	public static int minPathSum(int[][] grid) {
		if(grid==null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
        Integer[][] minPath = new Integer[grid.length][grid[0].length];
        return minPathSum(grid, 0, 0, minPath);
    }

	private static int minPathSum(int[][] grid, int i, int j, Integer[][] minPath) {
		if(i==grid.length-1 && j==grid[0].length-1) {
			return grid[i][j];
		}
		if(minPath[i][j] == null) {
			int sum1 = Integer.MAX_VALUE, sum2 = Integer.MAX_VALUE;
			if(isValid(grid, i+1, j)) {
				sum1 = grid[i][j] + minPathSum(grid, i+1, j, minPath);
			}
			if(isValid(grid, i, j+1)) {
				sum2 = grid[i][j] + minPathSum(grid, i, j+1, minPath);
			}
			minPath[i][j] = Math.min(sum1, sum2);
		}
		return minPath[i][j];
	}

	public static boolean isValid(int[][] grid, int row, int col) {
		int rows = grid.length;
		int cols = grid[0].length;
		return row>=0 && row<rows && col>=0 && col<cols;
	}
}
