import sys
input = sys.stdin.readline

n = int(input().rstrip())
arr = list(map(int, input().rstrip().split()))
result = [1 for _ in range(n)]

def fill(n):
	global result
	if result[n] == 1:
		for i in range(n - 1, -1, -1):
			if arr[i] < arr[n]: result[n] = max(result[n], fill(i) + 1)
	return result[n]

for i in range(n): fill(i)
print(max(result))
