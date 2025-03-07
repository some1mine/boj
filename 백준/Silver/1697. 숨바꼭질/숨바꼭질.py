from collections import deque

n, k = map(int, input().split())
visited = [0] * 100001

lst = deque(); lst.append(n)

while lst:
    cur = lst.popleft()
    if cur == k:
        print(visited[cur]); break
    for i in [cur - 1, cur + 1, cur * 2]:
        if 0 <= i <= 100000 and visited[i] == 0:
            visited[i] = visited[cur] + 1; lst.append(i)