import sys
input = sys.stdin.readline
n = int(input().rstrip())
arr = list(map(int, input().rstrip().split()))
for i in range(1, n):
	if arr[i - 1] > 0 and arr[i] + arr[i - 1] > 0: arr[i] += arr[i - 1]

print(max(arr))