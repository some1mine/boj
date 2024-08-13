import sys
input = sys.stdin.readline
n = int(input().rstrip())
arr = list(map(int, input().rstrip().split()))
dp = [[0, 0] for _ in range(n)]; dp[0][1] = arr[0]
for i in range(1, n):
	dp[i][1] = max(dp[i - 1][1] + arr[i], 0)
	dp[i][0] = arr[i]

res = max(map(max, dp))
print(res if res > 0 else max(arr))