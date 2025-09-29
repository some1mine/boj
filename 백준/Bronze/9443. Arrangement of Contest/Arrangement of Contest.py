n = int(input()); ans = 0; stand = ord('A'); lst = sorted(ord(input()[0]) - stand for _ in range(n))
for i in range(n): ans += lst[i] == ans
print(ans)