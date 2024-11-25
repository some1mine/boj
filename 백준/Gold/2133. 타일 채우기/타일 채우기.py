n = int(input())
arr = [0, 1]
if n % 2 == 1:
	print(0); exit(0)
for i in range(n // 2): arr.append(3 * arr[-1] + 2 * sum(arr[:-1]))
print(arr[-1])