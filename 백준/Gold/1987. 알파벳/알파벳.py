import sys
input = sys.stdin.readline
r, c = map(int, input().rstrip().split())
arr = []
for i in range(r): arr.append(input().rstrip())
directions = [[0,-1],[0,1],[-1,0],[1,0]]
s = arr[0][0]; cnt = 0
def go(y, x):
	global cnt, s
	cnt = max(cnt, len(s))
	if cnt > 25: return
	for d in directions:
		dy = y + d[0]; dx = x + d[1]
		if dy < 0 or dx < 0 or dy >= r or dx >= c or arr[dy][dx] in s: continue
		s += arr[dy][dx]
		go(dy, dx)
		s = s[:len(s) - 1]
go(0, 0)
print(cnt)