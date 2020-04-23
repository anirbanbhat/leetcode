package org.anirban.interview.leetcode.weeklychallange.easy;

public class TicTacToe {

	public static void main(String[] args) {
		TicTacToe ttt = new TicTacToe();
		System.out.println(ttt.tictactoe(new int[][] {{0,0},{2,0},{1,1},{2,1},{2,2}}));
		System.out.println(ttt.tictactoe(new int[][] {{0,0},{1, 1},{0,1},{0,2},{1,0},{2,0}}));
		System.out.println(ttt.tictactoe(new int[][] {{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}}));
		System.out.println(ttt.tictactoe(new int[][] {{0,0},{1,1}}));
		
		System.out.println(ttt.tictactoe2(new int[][] {{0,0},{2,0},{1,1},{2,1},{2,2}}));
		System.out.println(ttt.tictactoe2(new int[][] {{0,0},{1, 1},{0,1},{0,2},{1,0},{2,0}}));
		System.out.println(ttt.tictactoe2(new int[][] {{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}}));
		System.out.println(ttt.tictactoe2(new int[][] {{0,0},{1,1}}));
	}
	
	
	public String tictactoe2(int[][] moves) {
        int[] aRow = new int[3], aCol = new int[3], bRow = new int[3], bCol = new int[3];
        int aDiaL = 0, aDiaR = 0, bDiaL = 0, bDiaR = 0;
        for (int i = 0; i < moves.length; i++) {
        	int row = moves[i][0], col = moves[i][1];
        	if(i%2 == 0) {
        		if(++aRow[row] == 3 || ++aCol[col] == 3 || (row == col && ++aDiaL==3) || (row + col == 2 && ++aDiaR==3)) {
        			return "A";
        		}
        	} else {
        		if(++bRow[row] == 3 || ++bCol[col] == 3 || (row == col && ++bDiaL==3) || (row + col == 2 && ++bDiaR==3)) {
        			return "B";
        		}
        	}
		}
        return moves.length==9?"Draw":"Pending";
    }
	
	
	public String tictactoe(int[][] moves) {
        Character[][] table = new Character[3][3];
        Character ch = null;
        for(int i=0; i<moves.length; i++){
            ch = i%2==0?'A':'B';
            table[moves[i][0]][moves[i][1]] = ch;
            if(isWinner(moves[i][0], moves[i][1], table)){
                return Character.toString(ch);
            }
        }
        return moves.length==9?"Draw":"Pending";
    }
    
    public boolean isWinner(int row, int col, Character[][] table){
        Character ch = table[row][col];
        int max = 0;
        int[] xAxis = {1, 0, 1, -1};
        int[] yAxis = {0, -1, 1, 1};
        for (int dir = 0; dir < 4; dir++) {
        	int count = 0;
        	for(int i=-2; i<3; i++){
        		int newRow = row+(i*xAxis[dir]);
        		int newCol = col+(i*yAxis[dir]);
                if(isValid(newRow, newCol)){
                    if(table[newRow][newCol] != null && ch == table[newRow][newCol]){
                        count++;
                    }
                }
                max = Math.max(max, count);
            }
        	if(max==3) {
        		return true;
        	}
		}
        return false;
    }
    
    public boolean isValid(int row, int col){
        return row>=0 && col>=0 && row<3 && col<3;
    }

}
