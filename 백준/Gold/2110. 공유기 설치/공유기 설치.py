import sys
input = lambda:sys.stdin.readline().rstrip()

n, c = map(int, input().split())
arr = sorted([int(input()) for _ in range(n)])

def count(mid, arr):
    cnt = 1; cur = arr[0]
    for i in arr:
        if i - cur >= mid:
            cnt += 1; cur = i
    return cnt

left = 0; right = arr[n - 1]
while left <= right:
    mid = (left + right) // 2
    if(count(mid, arr) < c): right = mid - 1
    else: left = mid + 1
        
print(right)