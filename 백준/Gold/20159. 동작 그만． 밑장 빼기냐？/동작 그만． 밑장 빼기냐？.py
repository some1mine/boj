import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

my_sum = sum(arr[0::2])

result = my_sum; tmp = my_sum

for i in range(n - 1, 0, -2):
	tmp += arr[i]; tmp -= arr[i - 1]; result = max(tmp, result)

tmp = my_sum

for i in range(n - 2, 1, -2):
	tmp -= arr[i]; tmp += arr[i - 1]; result = max(tmp, result)

print(result)
