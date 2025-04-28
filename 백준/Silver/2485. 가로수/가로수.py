def get_gcd(n1, n2):
    if n1 % n2 == 0: return n2
    return get_gcd(n2, n1 % n2)

n  = int(input())
arr = sorted([int(input()) for _ in range(n)])
intervals = [arr[i + 1] - arr[i] for i in range(n - 1)]

gcd = min(intervals)

for i in intervals: gcd = get_gcd(max(i, gcd), min(i, gcd))
        
ans = 0
for i in range(len(arr) - 1):
    if arr[i + 1] - arr[i] > gcd: ans += intervals[i] // gcd - 1
print(ans)