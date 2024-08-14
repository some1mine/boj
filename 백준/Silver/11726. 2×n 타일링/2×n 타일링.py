import sys
input = sys.stdin.readline
n = int(input().rstrip())
if n == 1:
	print(n); quit()
dp =[1 for _ in range(n)]; dp[1] = 2
for i in range(2, n): dp[i] = (dp[i - 1] + dp[i - 2]) % 10007
print(dp[n - 1])