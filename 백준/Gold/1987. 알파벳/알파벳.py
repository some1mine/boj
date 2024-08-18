r, c = map(int, input().split()); cnt = 0; chars = 0; length = 0
arr = [input() for _ in range(r)]; directions = [[0,-1],[0,1],[-1,0],[1,0]]
def go(y, x):
	global cnt, chars, length
	if y < 0 or x < 0 or y >= r or x >= c: return # 범위 벗어남
	if cnt > 25: return # 알파벳 전부 거쳐옴
	toBinary = 1 << (ord(arr[y][x]) - ord('A'))
	if chars & toBinary: return # 이미 거쳐온 알파벳일 때
	chars |= toBinary; length += 1; cnt = max(cnt, length)
	for d in directions:
		dy = y + d[0]; dx = x + d[1]
		go(dy, dx)
	chars -= toBinary; length -= 1
go(0, 0)
print(cnt)