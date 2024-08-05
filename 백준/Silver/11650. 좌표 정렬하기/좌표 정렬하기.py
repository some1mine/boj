import sys
input = sys.stdin.readline

n = int(input())
arr = sorted([list(map(int, input().split())) for _ in range(n)])
for l in arr: print(*l)