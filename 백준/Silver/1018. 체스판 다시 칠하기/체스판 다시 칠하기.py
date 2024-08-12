import sys
input = sys.stdin.readline
n, m = map(int, input().rstrip().split())
arr = [input().rstrip() for _ in range(n)]
res1 = 10000000; res2 = 10000000; 
maxStartN = (n // 8) * 8 - 8 + (n % 8); maxStartM = (m // 8) * 8 - 8 + (m % 8)

for k in range(maxStartN + 1):
	for l in range(maxStartM + 1):
		can1 = 0; can2 = 0
		for i in range(k, k + 8):
			for j in range(l, l + 8):
				if (i + j) % 2 == 0: 
					if arr[i][j] == 'B':can1 += 1
					else: can2 += 1
				if (i + j) % 2 == 1: 
					if arr[i][j] == 'B': can2 += 1
					else: can1 += 1
		res1 = min(res1, can1); res2 = min(res2, can2)

print(min(res1, res2))
