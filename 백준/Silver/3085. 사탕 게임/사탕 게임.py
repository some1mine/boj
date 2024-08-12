import sys
input = sys.stdin.readline
n = int(input().rstrip())
arr = [list(input().rstrip()) for _ in range(n)]; res = 1

def count():
	global res
	answer = 1
	for k in range(n):
		cnt = 1
		for l in range(1, n):        
			if(arr[k][l] == arr[k][l - 1]): cnt += 1
			else: cnt = 1
			answer = max(answer, cnt)
		cnt = 1
		for l in range(1, n):
			if(arr[l][k] == arr[l - 1][k]): cnt += 1
			else: cnt = 1
			answer = max(answer, cnt)

	res = max(res, answer)

for i in range(n):
	for j in range(n):
		if i < n - 1 and arr[i][j] != arr[i + 1][j]:
			arr[i][j], arr[i + 1][j] = arr[i + 1][j], arr[i][j]
			count()
			arr[i][j], arr[i + 1][j] = arr[i + 1][j], arr[i][j]

for i in range(n):
	for j in range(n):
		if j < n - 1 and arr[i][j] != arr[i][j + 1]:
			arr[i][j], arr[i][j + 1] = arr[i][j + 1], arr[i][j]
			count()
			arr[i][j], arr[i][j + 1] = arr[i][j + 1], arr[i][j]

print(res)