import sys

T = int(sys.stdin.readline())
for _ in range(T):
    x1,y1,x2,y2 = map(int, sys.stdin.readline().split())

    n = int(sys.stdin.readline())
    cnt = 0
    for i in range(n):
        x,y,r = map(int, sys.stdin.readline().split())
        Dis1_Squ = (x1-x)**2 + (y1-y)**2
        Dis2_Squ = (x2-x)**2 + (y2-y)**2
        if (Dis1_Squ < r**2) and (Dis2_Squ < r**2):
            pass
        elif (Dis1_Squ < r**2) or (Dis2_Squ < r**2):
            cnt += 1
        else:
            pass

    print(cnt)