import sys
input = sys.stdin.readline

n, s = map(int, input().split())
arr = list(map(int, input().split()))

cnt = 0; choose = []

def combination(idx):
	global cnt
	if choose and sum(choose) == s: cnt += 1
	for i in range(idx, n):
		choose.append(arr[i])
		combination(i + 1)
		choose.remove(arr[i])

combination(0)
print(cnt)