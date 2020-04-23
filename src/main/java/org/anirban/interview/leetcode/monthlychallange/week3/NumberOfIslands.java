package org.anirban.interview.leetcode.monthlychallange.week3;

public class NumberOfIslands {

	public static void main(String[] args) {
		char[][] grid3 = {{'1'},{'1'}};
		System.out.println(numIslands(grid3));
		char[][] grid1 = {{'1','1','1','1','0'},
				 		  {'1','1','0','1','0'},
				 		  {'1','1','0','0','0'},
				 		  {'0','0','0','0','0'}};
		System.out.println(numIslands(grid1));
		char[][] grid2 = {{'1','1','0','0','0'},
				 		  {'1','1','0','0','0'},
				 		  {'0','0','1','0','0'},
				 		  {'0','0','0','1','1'}};
		System.out.println(numIslands(grid2));
		
	}
	
	public static int numIslands(char[][] grid) {
		if(grid==null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		boolean[][] matrix = new boolean[grid.length][grid[0].length];
		int islands = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if(!matrix[i][j] && grid[i][j] == '1') {
					traverseGrid(matrix, grid, i, j);
					islands++;
				}
			}
		}
		return islands;
	}

	private static void traverseGrid(boolean[][] matrix, char[][] grid, int row, int col) {
		if(isVisited(matrix, row, col)) {
			return;
		}
		matrix[row][col] = true;
		int[] rowAxis = {-1, 0, 1, 0};
		int[] colAxis = {0, 1, 0, -1};
		for (int i = 0; i < 4; i++) {
			int newRow = row + rowAxis[i];
			int newCol = col + colAxis[i];
			if(isValid(grid, newRow, newCol) && grid[newRow][newCol] == '1') {
				traverseGrid(matrix, grid, newRow, newCol);
			}
		}
	}

	public static boolean isValid(char[][] grid, int row, int col) {
		int rows = grid.length;
		int cols = grid[0].length;
		return row>=0 && row<rows && col>=0 && col<cols;
	}
	
	public static boolean isVisited(boolean[][] matrix, int row, int col) {
		return matrix[row][col];
	}
}
