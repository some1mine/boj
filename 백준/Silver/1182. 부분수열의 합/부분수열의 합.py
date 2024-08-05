import sys
input = sys.stdin.readline

n, s = map(int, input().split())
arr = list(map(int, input().split()))

cnt = 0; choose = []

def combination(idx):
	global cnt
	if idx == n: 
		if choose and sum(choose) == s: cnt += 1
		return
	choose.append(arr[idx])
	combination(idx + 1)
	choose.pop()
	combination(idx + 1)

combination(0)
print(cnt)