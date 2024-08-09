import sys
import copy
input = sys.stdin.readline

n, m = map(int, input().rstrip().split())
arr = [list(map(int, input().rstrip().split())) for _ in range(n)]
result = copy.deepcopy(arr)
for i in range(1, n): result[i][0] += result[i - 1][0]
for i in range(1, m): result[0][i] += result[0][i - 1]
for i in range(1, n):
	for j in range(1, m):
		result[i][j] = max(result[i][j], max(result[i][j - 1] + arr[i][j], max(result[i - 1][j] + arr[i][j], result[i - 1][j - 1] + arr[i][j])))

print(max(map(max, result)))