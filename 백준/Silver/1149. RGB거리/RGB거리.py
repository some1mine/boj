import sys
input = sys.stdin.readline

n = int(input().rstrip())
arr = [list(map(int, input().rstrip().split())) for _ in range(n)]
dp = [[10000000,10000000,10000000] for _ in range(n)]
for i in range(3): dp[0][i] = arr[0][i]

for i in range(n):
	for j in range(3):
		for k in range(j + 1, j + 3):
			dp[i][j] = min(dp[i][j], dp[i - 1][k % 3] + arr[i][j])

print(min(dp[n - 1]))