n = int(input())
arr = list(map(int, input().split()))
lst = [[i, j] for i, j in enumerate(arr)]
result = []; idx = 0
while lst:
    move = lst[idx][1]
    result.append(lst[idx][0] + 1)
    del lst[idx]
    if not lst: break
    idx += move - 1 if move >= 0 else move
    if idx >= len(lst): idx = idx % len(lst)
    if idx < 0: idx = -1 * (-1 * idx) % len(lst)
print(*result)