ans = 0
n = int(input())
for i in range(666, 6660001):
    if '666' in str(i): 
        ans += 1
        if ans == n:
            print(i); break