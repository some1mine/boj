a = int(input())
b = set(map(int, input().split()))
c = int(input())
d = set(map(int, input().split()))
for i in d:
    if i in b: print(1, end=' ')
    else: print(0, end=' ')