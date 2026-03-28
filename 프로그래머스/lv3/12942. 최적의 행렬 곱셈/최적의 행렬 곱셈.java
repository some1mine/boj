import java.util.*;

class Solution {
    public int solution(int[][] matrix_sizes) {
        int[][] dp = new int[matrix_sizes.length][matrix_sizes.length];
        for(int i = 0 ; i < dp.length ; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE); dp[i][i] = 0;
        }
        for(int i = 0 ; i < matrix_sizes.length ; i++) {
            for(int j = 0 ; j < matrix_sizes.length - i ; j++) {
                for(int k = j ; k < j + i ; k++) {
                    dp[j][j + i] = Math.min(dp[j][j + i], dp[j][k] + dp[k + 1][j + i] + matrix_sizes[j][0] * matrix_sizes[k][1] * matrix_sizes[i + j][1]);
                }
            }
        }
        return dp[0][dp.length - 1];
    }
}