n = int(input()); tmp = 1; ans = 0
while n > 0:
	n -= tmp; tmp += 1; ans += 1
	if tmp > n: tmp = 1
print(ans)