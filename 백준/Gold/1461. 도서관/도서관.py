import sys
input = sys.stdin.readline

def getPos(arr):
	global direction
	maximum = max(map(abs, arr))
	if maximum in arr: 
		if len(arr) > m:
			direction = False
			if min(arr) >= 0: 
				direction = True
				return 0
			for i in range(len(arr) - 1, -1, -1):
				if arr[i] < 0: return i
		else:
			direction = True
			for i in range(len(arr)):
				if arr[i] >= 0: return i
	else: 
		if len(arr) > m:
			direction = True
			if max(arr) < 0:
				direction = False
				return len(arr) - 1
			for i in range(len(arr)):
				if arr[i] >= 0: return i
		else:
			direction = False
			for i in range(len(arr) - 1, -1, -1):
				if arr[i] < 0: return i
	return -1

n, m = map(int, input().rstrip().split())
arr = list(sorted(map(int, input().rstrip().split())))

cnt = 0; direction = True; reach = 0; plusCount = 0; minusCount = 0

def count():
	global plusCount, minusCount
	for i in arr:
		if i >= 0: plusCount += 1
		elif i < 0 : minusCount += 1

count()
# print(plusCount); print(minusCount); print(max(arr)); print(min(arr))
# print(arr)
if plusCount % m != 0:
	mini = min(i for i in arr if i >= 0)
	idx1 = arr.index(mini)
	idx2 = min(arr.index(mini) + (plusCount % m), len(arr))
	reach = arr[idx2 - 1]
	for i in range(idx1, idx2):
		arr.remove(arr[idx1])
	cnt += reach * 2
# 	print(cnt)
# 	print(reach)
# print(arr)
if minusCount % m != 0:
	maxi = max(i for i in arr if i < 0)
	idx1 = arr.index(maxi)	
	idx2 = max(arr.index(maxi) - (minusCount % m), -1)
	far = abs(arr[idx2 + 1])
	for i in range(idx1, idx2, -1):
		arr.remove(arr[idx2 + 1])
	cnt += far * 2
	reach = max(reach, far)
# 	print(far)
# print(cnt)
# print(arr)
while arr:
	pos = getPos(arr)
	far = abs(arr[min(len(arr) - 1, pos + m - 1) if direction else max(0, pos - m + 1)])
	# print(pos)
	# print(arr)
	# print(far)
	for i in range(m):
		if not arr: break
		arr.remove(arr[pos])
		if not direction or pos == len(arr): pos = max(pos - 1, 0)
	cnt += far * 2
	reach = max(reach, far)
	# print(arr)
	# print(cnt)

print(cnt - reach)
# print(reach)