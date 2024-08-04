import sys
input = sys.stdin.readline

def complete(s):
    if(s == 0): return '-'
    return complete(s - 1) + (' ' * (3 ** (s - 1))) + complete(s - 1) 


while True:
    try:
        n = int(input())
        print(complete(n))
    except:
        break