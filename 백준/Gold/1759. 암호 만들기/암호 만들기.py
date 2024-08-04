import sys
input = sys.stdin.readline

l, c = map(int, input().split())
arr = list(sorted(input().split()))
choose = []

def statisfy():
    cntMon = 0; cntSun = 0
    for c in choose:
        if c in ['a','i','o','u','e']: cntMon += 1
        else: cntSun += 1
    return cntMon >= 1 and cntSun >= 2

def combination(idx, depth):
    if depth == l:
        if statisfy(): 
            for c in choose: print(c, end = '')
            print()
        return
    for i in range(idx, len(arr)):
        choose.append(arr[i])
        combination(i + 1, depth + 1)
        choose.pop()

combination(0, 0)