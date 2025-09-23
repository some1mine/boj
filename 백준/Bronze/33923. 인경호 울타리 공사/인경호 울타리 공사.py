def get(n):
    return (n - 2) ** 2 + 1

l = list(map(int, input().split()))
print(min(l[0] - 1, l[1] - 1) ** 2 if len(set(l)) == 2 else get(l[0]))