class Solution {
    public int solution(int[][] board, int[][] skill) {
        int r = board.length, c = board[0].length, answer = r * c;
        int[][] dp = new int[r + 2][c + 2];
        for(int[] s : skill) {
            s[5] = s[0] == 1 ? -s[5] : s[5];
            dp[s[1] + 1][s[2] + 1] += s[5]; dp[s[1] + 1][s[4] + 2] -= s[5];
            dp[s[3] + 2][s[2] + 1] -= s[5]; dp[s[3] + 2][s[4] + 2] += s[5];
        }
        for(int i = 1 ; i <= r ; i++) {
            for(int j = 1 ; j <= c ; j++) dp[i][j] += dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];
        }
        for(int i = 0 ; i < r ; i++) {
            for(int j = 0 ; j < c ; j++) {
                if(board[i][j] + dp[i + 1][j + 1] <= 0) answer--;
            }
        }
        return answer;
    }
}