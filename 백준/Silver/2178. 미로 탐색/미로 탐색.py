from collections import deque

n, m = map(int, input().split())
arr = []
for i in range(n): arr.append(input())

directions = [[-1, 0], [0, 1], [1, 0], [0, -1]]
visited = [[False] * m for _ in range(n)]

lst = deque(); lst.append([0, 0, 1]); visited[0][0] = True
while lst:
	cur = lst.popleft()
	if cur[0] + 1 == n and cur[1] + 1 == m:	
		print(cur[2]); break
	for direction in directions:
		y = cur[0] + direction[0]; x = cur[1] + direction[1]
		if y >= n or x >= m or y < 0 or x < 0 or arr[y][x] == '0' or visited[y][x]: continue
		lst.append([y, x, cur[2] + 1])
		visited[y][x] = True