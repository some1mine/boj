import java.util.*;

class Solution {
    public int solution(String[] arr) {
        int[][] max_dp = new int[arr.length / 2 + 1][arr.length / 2 + 1]; 
        for(int i = 0 ; i < arr.length / 2 + 1 ; i++) Arrays.fill(max_dp[i], Integer.MIN_VALUE);
        int[][] min_dp = new int[arr.length / 2 + 1][arr.length / 2 + 1]; 
        for(int i = 0 ; i < arr.length / 2 + 1 ; i++) Arrays.fill(min_dp[i], Integer.MAX_VALUE);
        
        for(int i = 0 ; i < arr.length / 2 + 1 ; i++) {
            max_dp[i][i] = Integer.parseInt(arr[i * 2]); min_dp[i][i] = Integer.parseInt(arr[i * 2]);
        }
        
        for(int cnt = 1 ; cnt < arr.length / 2 + 1 ; cnt++) {
            for(int i = 0 ; i < arr.length / 2 + 1 - cnt ; i++) {
                int j = i + cnt;
                for(int k = i ; k < j ; k++) {
                    if(arr[k * 2 + 1].equals("+")) {
                        max_dp[i][j] = Math.max(max_dp[i][j], max_dp[i][k] + max_dp[k + 1][j]);
                        min_dp[i][j] = Math.min(min_dp[i][j], min_dp[i][k] + min_dp[k + 1][j]);
                    } else {
                        max_dp[i][j] = Math.max(max_dp[i][j], max_dp[i][k] - min_dp[k + 1][j]);
                        min_dp[i][j] = Math.min(min_dp[i][j], min_dp[i][k] - max_dp[k + 1][j]);    
                    }
                }
            }
        }
        return max_dp[0][arr.length / 2];
    }
}