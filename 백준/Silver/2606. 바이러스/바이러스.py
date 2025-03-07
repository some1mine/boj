n = int(input()); m = int(input())
arr = [[] for _ in range(n + 1)]
for _ in  range(m):
	a, b = map(int, input().split())
	arr[a].append(b); arr[b].append(a)
cnt = -1
def dfs(arr, p, visited):
	global cnt
	cnt += 1
	visited[p] = True
	for i in arr[p]:
		if not visited[i]: dfs(arr, i, visited)
dfs(arr, 1, [False for _ in range(n + 1)])
print(cnt)