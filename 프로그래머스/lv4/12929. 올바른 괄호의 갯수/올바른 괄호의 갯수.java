class Solution {
    public int solution(int n) {
        int[] dp = new int[n + 1]; dp[0] = 1; dp[1] = 1; if(n > 1) dp[2] = 2; if(n > 2) dp[3] = 5;
        for(int i = 4 ; i <= n ; i++) {
            int count = 0;
            for(int j = 0 ; j < i ; j++) count += dp[j] * dp[i - j - 1];
            dp[i] = count;
        }
        return dp[n];
    }
}