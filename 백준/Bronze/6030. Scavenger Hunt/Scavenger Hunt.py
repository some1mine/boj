def get_divs(n): return [i for i in range(1, n + 1) if n % i == 0]
l = list(map(int, input().split()))
a = get_divs(l[0]); b = get_divs(l[1])
for q in a:
    for w in b: print(q, w)