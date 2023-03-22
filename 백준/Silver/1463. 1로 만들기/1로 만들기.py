n = int(input())
dp = [0 for _ in range(n + 1)]
for i in range(n - 1, 0, -1):
    if i * 3 <= n: dp[i] = min(dp[i + 1], dp[i * 2], dp[i * 3]) + 1
    elif i * 2 <= n: dp[i] = min(dp[i + 1], dp[i * 2]) + 1
    else: dp[i] = dp[i + 1] + 1
print(dp[1])
