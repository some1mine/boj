import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        Arrays.fill(dp, 9_999_999); dp[x] = 0;
        for(int i = x ; i <= y ; i++) {
            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            if(i >= n) dp[i] = Math.min(dp[i], dp[i - n] + 1);

        }
        return dp[y] == 9_999_999 ? -1 : dp[y];
    }
}