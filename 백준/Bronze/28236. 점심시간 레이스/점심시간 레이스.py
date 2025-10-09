n, m, k = map(int, input().split()); results = []
lst = [list(map(int, input().split())) for _ in range(k)]
for l in lst: results.append(l[0] + m - l[1])
print(results.index(min(results)) + 1)