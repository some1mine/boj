n = int(input()); m = int(input()); cnt = m
for _ in range(n):
    i, o = map(int, input().split()); m += i - o; cnt = max(cnt, m)
    if m < 0:
        cnt = 0; break
print(cnt)