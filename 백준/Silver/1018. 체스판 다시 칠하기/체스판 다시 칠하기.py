import sys
input = sys.stdin.readline
n, m = map(int, input().rstrip().split())
arr = [input().rstrip() for _ in range(n)]
w = 'W'; b = 'B'
candi1 = []; candi2 = []
for i in range(n):
	s1 = ''; s2 = ''
	for j in range(m):
		if (i + j) % 2 == 0: 
			s1 += 'W'; s2 += 'B'
		else: 
			s1 += 'B'; s2 += 'W'
	candi1.append(s1); candi2.append(s2)

res1 = 1000; res2 = 1000

for k in range((n // 8) * 8 - 8 + (n % 8) + 1):
	for l in range((m // 8) * 8 - 8 + (m % 8) + 1):
		can1 = 0; can2 = 0
		for i in range(k, k + 8):
			for j in range(l, l + 8):
				if candi1[i][j] != arr[i][j]: can1 += 1
				if candi2[i][j] != arr[i][j]: can2 += 1
		res1 = min(res1, can1); res2 = min(res2, can2)

print(min(res1, res2))
