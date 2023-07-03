def getnum(s1, s2,  s3):
    d = 0
    for i in range(4):
        if s1[i] != s2[i]: d += 1
        if s1[i] != s3[i]: d += 1
        if s2[i] != s3[i]: d += 1
    return d

def solution(arr):
    ret = 12
    if len(arr) > 32: return 0
    
    for i in range(0, len(arr)):
        for j in range(i + 1, len(arr)):
            for k in range(j + 1, len(arr)):
                ret = min(ret, getnum(arr[i], arr[j], arr[k]))
    return ret
T = int(input())
for _ in range(T):
    input()
    arr = input().split()
    print(solution(arr))