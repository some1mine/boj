a = b = c = 0
for _ in range(int(input())):
    x = int(input())
    a, b, c = max(a, b, c), a + x, b + x
print(max(a, b, c))