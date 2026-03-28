class Solution {
    public int solution(int[] sticker) {
        int[][] dp = new int[sticker.length][2]; dp[0][0] = sticker[0];
        for(int i = 1 ; i < sticker.length ; i++) {
            dp[i][0] = Math.max(sticker[i], dp[i - 1][0]); dp[i][1] = Math.max(sticker[i], dp[i - 1][1]);
            if(i > 1) {
                if(i != sticker.length - 1) dp[i][0] = Math.max(dp[i][0], dp[i - 2][0] + sticker[i]);
                dp[i][1] = Math.max(dp[i][1], dp[i - 2][1] + sticker[i]);
            } 
        }
        return Math.max(dp[sticker.length - 1][0], dp[sticker.length - 1][1]);
    }
}