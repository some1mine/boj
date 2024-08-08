import sys
input = sys.stdin.readline

n, m = map(int, input().rstrip().split())
arr = list(sorted(map(int, input().rstrip().split())))
plus = list(reversed([i for i in arr if i >= 0]))
minus = list([-i for i in arr if i < 0])
cnt = 0

for i in plus[::m]: cnt += i
for i in minus[::m]: cnt += i

print(cnt * 2 - max(map(abs, arr)))