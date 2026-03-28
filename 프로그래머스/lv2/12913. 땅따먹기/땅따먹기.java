import java.util.*;

class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        for(int i = 0 ; i < land.length ; i++) {
            for(int j = 0 ; j < 4 ; j++) dp[i][j] = land[i][j];
            if(i > 0) {
                dp[i][0] += Math.max(dp[i - 1][1], Math.max(dp[i - 1][2], dp[i - 1][3]));
                dp[i][1] += Math.max(dp[i - 1][0], Math.max(dp[i - 1][2], dp[i - 1][3]));
                dp[i][2] += Math.max(dp[i - 1][1], Math.max(dp[i - 1][0], dp[i - 1][3]));
                dp[i][3] += Math.max(dp[i - 1][1], Math.max(dp[i - 1][2], dp[i - 1][0]));
            }
        }
        return Arrays.stream(dp[land.length - 1]).max().getAsInt();
    }
}