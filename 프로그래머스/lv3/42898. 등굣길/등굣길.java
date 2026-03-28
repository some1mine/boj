import java.util.*;

class Solution {
    public static int[][] dirs = {{-1, 0}, {0, -1}};
    public int solution(int m, int n, int[][] puddles) {
        long[][] dp = new long[n + 1][m + 1]; 
        for(int[] puddle : puddles) dp[puddle[1]][puddle[0]] = -1;
        dp[1][1] = 1;
        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= m ; j++) {
                if(dp[i][j] != -1) {
                    if(i > 0 && dp[i - 1][j] >= 0)  dp[i][j] += dp[i - 1][j];
                    if(j > 0 && dp[i][j - 1] >= 0) dp[i][j] += dp[i][j - 1];
                    if(dp[i][j] >= 1_000_000_007) dp[i][j] %= 1_000_000_007;
                }
             }
        }
        return (int) (dp[n][m] % 1_000_000_007);
    }
}