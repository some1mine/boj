import sys

input = sys.stdin.readline

n = 1000 - int(input().rstrip())
cnt = 0
arr = [500,100,50,10,5,1]

for i in arr:
	cnt += n // i
	n %= i

print(cnt)