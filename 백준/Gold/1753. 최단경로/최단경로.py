import heapq; import sys
input = lambda: sys.stdin.readline().rstrip()
n, e = map(int, input().split()); k = int(input())
conn = [[] for _ in range(n + 1)]
for _ in range(e):
    u, v, w = map(int, input().split())
    conn[u].append([v, w])

dp = [int(1e12) for _ in range(n + 1)]
heap = []; heapq.heappush(heap, [0, k]); dp[k] = 0

while heap:
    dist, cur = heapq.heappop(heap)
    for i, length in conn[cur]:
        if dist + length < dp[i]:
            dp[i] = dist + length
            heapq.heappush(heap, [dist + length, i])

for i in dp[1:]:
    print('INF' if i == int(1e12) else i)