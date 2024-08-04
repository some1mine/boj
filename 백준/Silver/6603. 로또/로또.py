import sys
input = sys.stdin.readline

def combination(idx, depth, arr):
    global choose
    if depth == 6:
        print(*choose); return
    for i in range(idx, len(arr)):
        choose.append(arr[i])
        combination(i + 1, depth + 1, arr)
        choose.pop()
        
while True:
    arr = list(map(int, input().split()))
    choose = []
    if arr == [0]: break
    combination(1, 0, arr)
    print()