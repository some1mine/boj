import heapq
n, m, x = map(int, input().split()); inf = int(1e12)
arr1 = [[] for _ in range(n + 1)]; arr2 = [[] for _ in range(n + 1)]
for _ in range(m):
	s, e, t = map(int, input().split()); arr1[s].append([e, t]); arr2[e].append([s, t])
def dijkstra(start, arr):
	global inf, n, m, x
	dp = [inf] * (n + 1); dp[start] = 0
	heap = []; heapq.heappush(heap, [0, start])
	while heap:
		d1, cur = heapq.heappop(heap)
		for v, d2 in arr[cur]:
			dist = d1 + d2
			if dist < dp[v]:
				dp[v] = dist; heapq.heappush(heap, [dist, v])
	return dp
ans = 0
for i in range(1, n + 1): ans = max(ans, dijkstra(x, arr1)[i] + dijkstra(x, arr2)[i])
print(ans)