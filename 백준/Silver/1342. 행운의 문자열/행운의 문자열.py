import sys
input = sys.stdin.readline

s = input().rstrip()

cnt = 0
choose = []
check = [False] * len(s)

def factorial(n):
	if n <= 1: return 1
	return n * factorial(n - 1)


def statisfy():
	for i in range(len(s) - 1):
		if choose[i + 1] == choose[i]: return False
	return True

def permuation(level):
	global cnt
	if level == len(s):
		cnt += statisfy()
		return

	for i in range(len(s)):
		if check[i]: continue
		choose.append(s[i])
		check[i] = True
		permuation(level + 1)
		check[i] = False
		choose.pop()

permuation(0)

for l in set(s): cnt //= factorial(s.count(l))
print(cnt)