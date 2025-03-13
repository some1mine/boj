from queue import PriorityQueue; import sys
input = lambda: sys.stdin.readline().rstrip()
n, e = map(int, input().split()); k = int(input())
conn = [[] for _ in range(n + 1)]
for _ in range(e):
    u, v, w = map(int, input().split())
    conn[u].append([v, w])

queue = PriorityQueue()
dp = [int(1e12) for _ in range(n + 1)]
dp[k] = 0; queue.put([0, k])

while not queue.empty():
    dist, cur = queue.get()
    for i, length in conn[cur]:
        if dist + length < dp[i]:
            dp[i] = dist + length
            queue.put([dist + length, i])
            
for i in dp[1:]:
    print('INF' if i == int(1e12) else i)