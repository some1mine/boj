import sys
input = sys.stdin.readline

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
candidate = []
for i in range(1, 10):
	for j in range(1, 10): 
		for k in range(1, 10): 
			if i == j or j == k or i == k: continue
			candidate.append(str(i) + str(j) + str(k))

def satisfy(n):
	for cond in arr:
		n1 = str(cond[0]); cnt1 = 0; cnt2 = 0
		for i in range(3):
			for j in range(3):
				if n1[i] == n[j]:
					if i == j: cnt1 += 1
					else: cnt2 += 1
		if cond[1] != cnt1 or cond[2] != cnt2: return False
	return True

result = [i for i in candidate if satisfy(i)]

print(len(result))