import sys
input = lambda : sys.stdin.readline().rstrip()

n = int(input())
arr = list(map(int, input().split()))
increase = [[0, 0] for _ in range(n)]
decrease = [[0, 0] for _ in range(n)]
total = [0 for _ in range(n)]
for i in range(n):		
	for j in range(i):
		if arr[j] < arr[i]: increase[i][0] = max(increase[i][0], increase[j][0] + 1)
		increase[i][1] = max(increase[j][0], increase[j][1])
for i in range(n, -1, -1):
	for j in range(n - 1, i, -1):
		if arr[i] > arr[j]: decrease[i][0] = max(decrease[i][0], decrease[j][0] + 1)
		decrease[i][1] = max(decrease[j][0], decrease[j][1])
for i in range(n):
	total[i] = max(increase[i][0], increase[i][1]) +  max(decrease[i][0], decrease[i][1])
print(max(total) + 1)