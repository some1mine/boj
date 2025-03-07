from collections import deque

n, m, v = map(int, input().split())
arr = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    arr[a].append(b)
    arr[b].append(a)
for l in arr: l.sort()
def dfs(arr, v, visited):
    print(v, end = " ")
    visited[v] = True
    for i in arr[v]: 
        if not visited[i]: dfs(arr, i, visited)
def bfs(arr, v, visited):
    lst = deque(); lst.append(v); visited[v] = True
    while lst:
        a = lst.popleft()
        print(a, end = " ")
        for i in arr[a]: 
            if visited[i]: continue
            visited[i] = True
            lst.append(i)
dfs(arr, v, [False for _ in range(n + 1)]); print(); bfs(arr, v, [False for _ in range(n + 1)])