s = set()
o = int(input())
for _ in range(o):
    n, io = input().split()
    if io == 'enter': s.add(n)
    else: s.remove(n)
lst = list(s)
lst.sort(reverse = True)
for n in lst: print(n)
    