import sys
input = sys.stdin.readline

n = int(input().rstrip())
a = list(sorted(map(int, input().rstrip().split())))
b = list(sorted(map(int, input().rstrip().split()), reverse=True))
ans = 0

for i in range(n): ans += a[i] * b[i]

print(ans)