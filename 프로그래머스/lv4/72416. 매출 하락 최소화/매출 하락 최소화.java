import java.util.*;

class Solution {
    public int[][] dp; public int[] sales; public List<Integer>[] graph;
    public int solution(int[] sales, int[][] links) {
        this.sales = sales; dp = new int[sales.length + 1][2]; graph = new ArrayList[sales.length + 1];
        for(int i = 0 ; i<= sales.length ; i++) graph[i] = new ArrayList<>();
        for(int[] link : links) graph[link[0]].add(link[1]); dfs(1);
        return Math.min(dp[1][1], dp[1][0]);
    }
    public void dfs(int v) {
        dp[v][1] = sales[v - 1]; dp[v][0] = 0; boolean flag = false; int temp = Integer.MAX_VALUE;
        for(int child : graph[v]){
            dfs(child); int min = Math.min(dp[child][0], dp[child][1]);
            dp[v][1] += min; dp[v][0] += min; flag = dp[child][1] <= dp[child][0] ? true : flag;
            temp = Math.min(temp, dp[child][1] - dp[child][0]);  
        }
        dp[v][0] += !flag && temp != Integer.MAX_VALUE ? temp : 0;
    }
}