import sys
input = lambda: sys.stdin.readline().rstrip()

# input
N = int(input())

nums = []
times = []

for _ in range(N):
	s, e = map(int, input().split())
	times.append((s, e))
	nums.append(s)
	nums.append(e)

# coordinate compression (좌표 압축)
nums = sorted(list(set(nums)))
T = len(nums)

convert = dict()
for idx, num in enumerate(nums, 1):
	convert[num] = idx

# solve
starts = dict()
for i in range(N):
	tmp0, tmp1 = convert[times[i][0]], convert[times[i][1]]
	if tmp1 in starts:
		starts[tmp1].append(tmp0)
	else:
		starts[tmp1] = [tmp0]

for key in starts:
	starts[key].sort()

dp = [0] * (T + 1)
for t in range(1, T + 1): # dp[t]
	dp[t] = dp[t - 1]
	if t in starts:
		for s in starts[t]:
			dp[t] = max(dp[t], dp[s] + 1)

print(dp[T])
