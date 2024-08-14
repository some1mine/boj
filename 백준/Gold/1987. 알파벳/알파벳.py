r, c = map(int, input().split())
arr = [input() for _ in range(r)]; chars = [False for _ in range(26)]
cnt = 0; length = 0
directions = [[0,-1],[0,1],[-1,0],[1,0]]
def go(y, x):
	global cnt, chars, length
	if cnt > 25 or y < 0 or x < 0 or y >= r or x >= c or chars[ord(arr[y][x]) - ord('A')]: return
	chars[ord(arr[y][x]) - ord('A')] = True; length += 1
	cnt = max(cnt, length)
	for d in directions:
		dy = y + d[0]; dx = x + d[1]
		go(dy, dx)
	chars[ord(arr[y][x]) - ord('A')] = False; length -= 1
go(0, 0)
print(cnt)