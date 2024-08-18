r, c = map(int, input().split()); cnt = 0; chars = 0; length = 0
arr = [input() for _ in range(r)]; directions = [[0,-1],[0,1],[-1,0],[1,0]]
def go(y, x):
	global cnt, chars, length
	if cnt > ord('z') - ord('a'): return # 모든 알파벳 돎
	if y < 0 or x < 0 or y >= r or x >= c: return # 범위 벗어남
	if chars & (1 << (ord(arr[y][x]) - ord('A'))): return # 이미 거친 알파벳일 때
	chars |= (1 << ord(arr[y][x]) - ord('A'))
	length += 1; cnt = max(cnt, length)
	for d in directions:
		dy = y + d[0]; dx = x + d[1]
		go(dy, dx)
	chars -= (1 << ord(arr[y][x]) - ord('A')); length -= 1
go(0, 0)
print(cnt)