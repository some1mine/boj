import sys

input = lambda:sys.stdin.readline().strip()
n, h = map(int, input().split())

tops = [0] * (h + 1); bottoms = [0] * (h + 1)
for i in range(n):
	num = int(input())
	if i % 2 == 0: bottoms[num] += 1
	else: tops[h - num + 1] += 1

amount = 9999999999; count = 0; cnt = n // 2
for i in range(1, h + 1):
	cnt -= bottoms[i - 1]; cnt += tops[i]
	if amount == cnt: count += 1
	if amount > cnt:
		amount = cnt; count = 1

print(amount, count)