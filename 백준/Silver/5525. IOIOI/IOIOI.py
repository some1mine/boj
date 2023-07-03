ans = 0
n = int(input())
m = int(input())
s = input()
p = 'I' + "OI" * n
for i in range(max(m - len(p), 1)):
    if s[i:].startswith(p): ans += 1
print(ans)