r, c = map(int, input().split())
arr = []
for i in range(r): arr.append(input().rstrip())
directions = [[0,-1],[0,1],[-1,0],[1,0]]
s = set(arr[0][0]); cnt = 0
def go(y, x, prev):
	global cnt, s
	cnt = max(cnt, len(s))
	for d in directions:
		dy = y + d[0]; dx = x + d[1]
		if (prev[0] == -d[0] and prev[1] == -d[1]) or dy < 0 or dx < 0 or dy >= r or dx >= c or arr[dy][dx] in s: continue
		s.add(arr[dy][dx])
		go(dy, dx, d)
		s.remove(arr[dy][dx])
go(0, 0, [1,1])
print(cnt)