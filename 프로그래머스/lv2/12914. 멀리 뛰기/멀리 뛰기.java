class Solution {
    public long[] memo = new long[2001];
    public long solution(int n) {
        long answer = fibo(n);
        return answer % 1234567;
    }
    public long fibo(int n) {
        memo[1] = 1; memo[2] = 2;
        for(int i = 3 ; i < n + 1 ; i++) {
            memo[i] = memo[i - 1] + memo[i - 2] % 1234567;
        }
        return memo[n];
    }
}