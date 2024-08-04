import sys
input = sys.stdin.readline

arr = [i for i in range(1, int(input()) + 1)]
choose = []
check = [False] * len(arr)

def permutation(level):
	if(level == len(arr)): 
		print(*choose)
		return
	for i in range(0, len(arr)):
		if check[i]: continue
		choose.append(arr[i])
		check[i] = True
		permutation(level + 1)
		check[i] = False
		choose.pop()

permutation(0)