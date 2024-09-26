import sys
input = lambda : sys.stdin.readline().rstrip()
n, m = map(int, input().split())
memories = list(map(int, input().split()))
costs = list(map(int, input().split()))
dp = [[0 for _ in range(sum(costs) + 1)] for _ in range(n)]
dp[0][costs[0]] = memories[0]
for i in range(1, n):
	for j in range(sum(costs) + 1):
		dp[i][j] = dp[i - 1][j]
		if j - costs[i] >= 0: dp[i][j] = max(dp[i][j], dp[i - 1][j - costs[i]] + memories[i])
result = 10000
for i in range(n):	
	for j in range(sum(costs) + 1):
		if dp[i][j] >= m:
			result = min(result, j)
print(result)