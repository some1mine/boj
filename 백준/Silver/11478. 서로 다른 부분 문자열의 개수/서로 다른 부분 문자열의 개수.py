a = input()
b = set()
for i in range(len(a)):
    for j in range(i, len(a)):
        b.add(a[i:j + 1])
print(len(b))