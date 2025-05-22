n = int(input())
dists = list(map(int, input().split())); costs = list(map(int, input().split()))
answer = dists[0] * costs[0]; m = costs[0]
for i in range(1, len(dists)):
    m = min(m, costs[i])
    answer += dists[i] * m
print(answer)