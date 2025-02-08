def get_best_idx(left):
	global N, S, psum

	cur = left - 1
	step = N

	while step != 0:
		while (cur + step <= N) and (psum[cur + step] - psum[left - 1] < S):
			cur += step
		step //= 2

	return (cur + 1)


# input
N, S = map(int, input().split())
arr = [0] + list(map(int, input().split()))

# solve
psum = [0] * (N + 1)

for i in range(1, N + 1):
	psum[i] = psum[i - 1] + arr[i]

ans = int(1e12)
for left in range(1, N + 1):
	right = get_best_idx(left)
	if right <= N:
		ans = min(ans, right - left + 1)

print(ans if ans != int(1e12) else 0)
