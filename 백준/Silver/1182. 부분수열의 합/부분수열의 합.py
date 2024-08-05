import sys
input = sys.stdin.readline

n, s = map(int, input().split())
arr = list(map(int, input().split()))

cnt = 0; tot = 0

def combination(idx):
	global cnt, tot
	if idx == n: 
		if tot == s: cnt += 1
		return
	tot += arr[idx]
	combination(idx + 1)
	tot -= arr[idx]
	combination(idx + 1)

combination(0)
print(cnt - 1 if s == 0 else cnt)