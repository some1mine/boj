from collections import deque

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]; dirs = [[-1, 0], [0, 1], [1, 0], [0, -1]]
ans = 0

def dfs(arr, y, x, h):
    global visited
    lst = deque(); lst.append([y, x]); visited[y][x] = True
    while lst:
        cur = lst.popleft()
        for d in dirs:
            dy = cur[0] + d[0]; dx = cur[1] + d[1]
            if dy < 0 or dx < 0 or dy >= n or dx >= n or visited[dy][dx] or arr[dy][dx] <= h : continue
            visited[dy][dx] = True
            lst.append([dy, dx])
def count(arr, h):
    global visited
    visited = [[False] * n for _ in range(n)]
    
    ans = 0
    for y in range(n):
        for x in range(n):
            if not visited[y][x] and arr[y][x] > h:
                ans += 1; dfs(arr, y, x, h)
    return ans

for i in range(101):
    ans = max(ans, count(arr, i))
print(ans)