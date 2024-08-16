arr = [list(map(int, input().split())) for _ in range(9)]
idxs = []
row = [[False] * 10 for _ in range(9)]; col = [[False] * 10 for _ in range(9)]
square  = [[[False] * 10 for _ in range(3)] for _ in range(3)]
for i in range(9):
	for j in range(9):
		if not arr[i][j]: idxs.append((i,j))
		else: row[i][arr[i][j]] = col[j][arr[i][j]] = square[i // 3][j // 3][arr[i][j]] = True
def solution(depth):
	global arr, row, col, square
	if depth == len(idxs):
		for a in arr:
			for i in a: print(i, end = ' ')
			print()
		exit(0)
	y, x = idxs[depth]
	for i in range(1, 10):
		if not (row[y][i] or col[x][i] or square[y // 3][x // 3][i]):
			row[y][i] = col[x][i] = square[y // 3][x // 3][i] = True
			arr[y][x] = i
			solution(depth + 1)
			arr[y][x] = 0
			row[y][i] = col[x][i] = square[y // 3][x // 3][i] = False
solution(0)