class Solution {
    public int[] solution(int target) {
        int[][] dp = new int[target + 1][];
        for(int i = 0 ; i <= target ; i++) dp[i] = new int[]{100_001, -100_001}; dp[0] = new int[]{0, 0};
        for(int i = 0 ; i < target ; i++) {
            for(int j = 20 ; j > 0 ; j--) {
                calculate(dp, target, i, j    ); calculate(dp, target, i, j * 2); 
                calculate(dp, target, i, j * 3); calculate(dp, target, i,    50);
            }
        }
        return dp[target];
    }
    public void calculate(int[][] dp, int target, int i, int j) {
        if(i + j <= target && (dp[i][0] + 1 < dp[i + j][0] ||
          dp[i][0] + 1 == dp[i + j][0] && dp[i][1] + 1 > dp[i + j][1])) {
            dp[i + j][0] = dp[i][0] + 1; 
            dp[i + j][1] = j <= 20 || j == 50 ? dp[i][1] + 1 : dp[i][1];
        }
    }
}