from collections import deque

m, n = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
visited = [[False] * m for _ in range(n)]

dirs = [[-1, 0], [0, 1], [1, 0], [0, -1]]; lst = deque(); ans = 1
for i in range(n):
    for j in range(m): 
        if arr[i][j] == 1: lst.append([i, j])

while lst:
    cur = lst.popleft()
    for d in dirs:
        y = cur[0] + d[0]; x = cur[1] + d[1]
        if y < 0 or x < 0 or y >= n or x >= m or arr[y][x] != 0: continue
        arr[y][x] = arr[cur[0]][cur[1]] + 1
        ans = max(arr[y][x], ans)
        lst.append([y, x])
        
for i in range(n):
    if 0 in arr[i]: ans = 0

print(ans - 1)