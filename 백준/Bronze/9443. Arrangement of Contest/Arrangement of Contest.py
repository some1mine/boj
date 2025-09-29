n = int(input()); ans = 0; lst = []; stand = ord('A')
for _ in range(n): lst.append(ord(input()[0]) - stand); lst.sort()
for i in range(n): ans += lst[i] == ans
print(ans)