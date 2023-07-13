T = int(input())
for _ in range(T):
    n = int(input())
    d = {25 : 0, 10 : 0, 5 : 0, 1 : 0}
    for c in d:
        d[c] = n // c
        n %= c
    for k in reversed(sorted(list(d.keys()))): print(d[k], end = ' ')
    print()