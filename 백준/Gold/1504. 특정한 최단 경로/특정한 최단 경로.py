import heapq; import sys

input = lambda:sys.stdin.readline().rstrip()
n, e = map(int, input().split()); inf = int(1e12)
conn = [[] for _ in range(n + 1)]
for _ in range(e):
	a, b, c = map(int, input().split())
	conn[a].append([b, c]); conn[b].append([a, c])
v1, v2 = map(int, input().split())

def dijkstra(start):
	dp = [inf] * (n + 1); heap = []
	heap = []; heapq.heappush(heap, [0, start]); dp[start] = 0

	while heap:
		dist, cur = heapq.heappop(heap)
		for i, length in conn[cur]:
			if dist + length < dp[i]:
				dp[i] = dist + length; heapq.heappush(heap, [dist + length, i])
	return dp

dp_1 = dijkstra(1); dp_v1 = dijkstra(v1); dp_v2 = dijkstra(v2)
case1 = dp_1[v1] + dp_v1[v2] + dp_v2[n]; case2 = dp_1[v2] + dp_v2[v1] + dp_v1[n]

ans = min(case1, case2)
print(ans if ans < inf else -1)