import sys
input = sys.stdin.readline

n, m = map(int, input().rstrip().split())
arr = [list(map(int, input().rstrip().split())) for _ in range(n)]
for i in range(1, n): arr[i][0] += arr[i - 1][0]
for i in range(1, m): arr[0][i] += arr[0][i - 1]
for i in range(1, n):
	for j in range(1, m):
		arr[i][j] = max(arr[i][j - 1] + arr[i][j], max(arr[i - 1][j] + arr[i][j], arr[i - 1][j - 1] + arr[i][j]))

print(max(map(max, arr)))