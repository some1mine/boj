class Solution {
    public int solution(int[] money) {      
        if(money.length == 3) return Math.max(money[2], Math.max(money[0], money[1]));
        int[][] dp = new int[2][money.length]; dp[0][0] = money[0]; dp[0][1] = money[1]; dp[1][1] = money[1];
        for(int i = 2 ; i < money.length ; i++) {
            for(int j = 0 ; j < 2 ; j++) {
                dp[j][i] = Math.max(dp[j][i - 1], dp[j][i - 2] + money[i]);
                if(i > 2) dp[j][i] = Math.max(dp[j][i], dp[j][i - 3] + money[i]);
            }
        }
        return Math.max(dp[0][money.length - 2], dp[1][money.length - 1]);
    }
}