def calc(k : int, n : int, dp : list):
        if n < 0 or n > 9 or (k == 1 and n == 0): return 0
        if k == 1: return 1
        if dp[k][n]: return dp[k][n]
        dp[k][n] = (calc(k - 1, n - 1, dp) % 1_000_000_000 + calc(k - 1, n + 1, dp) % 1_000_000_000) % 1_000_000_000
        return dp[k][n]
n = int(input()); ans = 0; dp = [[0 for i in range(10)] for _ in range(n + 1)]
for i in range(10): ans = (ans + calc(n, i, dp)) % 1_000_000_000
print(ans)