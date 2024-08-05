import sys
input = sys.stdin.readline

def comp(a): return ((a[1] * a[2] * a[3]), (a[1] + a[2] + a[3]), a[0])

n = int(input())
arr = sorted([list(map(int, input().split())) for _ in range(n)], key=comp)
for i in range(3): print(arr[i][0])