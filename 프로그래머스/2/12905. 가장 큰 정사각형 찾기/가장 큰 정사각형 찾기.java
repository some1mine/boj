import java.util.*;

class Solution {
    public int solution(int[][] board) {
        for(int i = 1 ; i < board.length ; i++) {
            for(int j = 1 ; j < board[i].length ; j++) {
                if(board[i][j] > 0) board[i][j] = getMin(board, i, j) + 1;
            }
        }
        return (int) Math.pow(Arrays.stream(board).flatMapToInt(Arrays::stream).max().getAsInt(), 2);
    }
    public int getMin(int[][] board, int i, int j) {
        return Math.min(Math.min(board[i][j - 1], board[i - 1][j]), board[i - 1][j - 1]);
    }
}