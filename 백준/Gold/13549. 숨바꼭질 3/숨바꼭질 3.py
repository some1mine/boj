import heapq

n, k = map(int, input().split())
arr = [100000] * 100001
heap = []; heapq.heappush(heap, [0, n]); arr[n] = 0

while heap:
    dist, cur = heapq.heappop(heap)
    nexts = [[dist, cur * 2], [dist + 1, cur + 1], [dist + 1, cur - 1]]
    for step, i in nexts:
        if 0 <= i < len(arr) and step < arr[i]:
            arr[i] = step; heapq.heappush(heap, [arr[i], i])
print(arr[k])        