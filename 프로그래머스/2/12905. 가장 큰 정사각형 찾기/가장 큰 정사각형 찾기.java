class Solution {
    public int solution(int[][] board) {
        int max = board[0][0];
        for(int i = 1 ; i < board.length ; i++) {
            for(int j = 1 ; j < board[i].length ; j++) {
                if(board[i][j] > 0) board[i][j] = getMin(board, i, j) + 1;
                max = max > board[i][j] ? max : board[i][j];
            }
        }
        return max * max;
    }
    public int getMin(int[][] board, int y, int x) {
        int a = board[y][x - 1], b = board[y - 1][x], c = board[y - 1][x - 1];
        
        return (a <= b && a <= c) ? a : (b <= c && b <= a) ? b : c; 
    }
}