import sys
input = sys.stdin.readline
n = int(input().rstrip())
arr = [list(input().rstrip()) for _ in range(n)]; res = 1

def count(y, x):
	answer = 1; cnt = 1
	for i in range(n):        
		if i < n - 1 and arr[y][i] == arr[y][i + 1]: cnt += 1
		else: cnt = 1
		answer = max(answer, cnt)
	for i in range(n): 
		if i < n - 1 and arr[i][x] == arr[i + 1][x]: cnt += 1
		else: cnt = 1
		answer = max(answer, cnt)

	return answer

for i in range(n):
	for j in range(n):
		if i == j: res = max(res, count(i, j))
		if i < n - 1 and arr[i][j] != arr[i + 1][j]:
			arr[i][j], arr[i + 1][j] = arr[i + 1][j], arr[i][j]
			res = max(res, count(i, j), count(i + 1, j))
			arr[i][j], arr[i + 1][j] = arr[i + 1][j], arr[i][j]
		if j < n - 1 and arr[i][j] != arr[i][j + 1]:
			arr[i][j], arr[i][j + 1] = arr[i][j + 1], arr[i][j]
			res = max(res, count(i, j), count(i, j + 1))
			arr[i][j], arr[i][j + 1] = arr[i][j + 1], arr[i][j]

print(res)