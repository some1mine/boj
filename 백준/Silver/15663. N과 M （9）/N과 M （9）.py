result = []
def comb(arr, n, m, r, start):
    if r == m:
        result.append(arr[:m])
        return
    for i in range(start, n):
        arr[start], arr[i] = arr[i], arr[start]
        comb(arr, n, m, r + 1, start + 1)
        arr[start], arr[i] = arr[i], arr[start]

n, m = map(int, input().split())
arr = sorted(list(map(int, input().split())))
comb(arr, n, m, 0, 0)
tup_result = [tuple(i) for i in result]
result = sorted(list(set(tup_result)))
for r in result: print(*r)