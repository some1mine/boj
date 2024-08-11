import sys
input = sys.stdin.readline

n = int(input().rstrip())
arr = [0] + list(map(int, input().rstrip().split()))
result = [-1 for _ in range(n + 1)]; result[1] = 1

for i in range(2, n + 1):
	m = 0
	for j in range(1, n):
		if arr[i] > arr[j]: m = max(m, result[j])
	result[i] = m + 1

print(max(result))
