import sys

def dPow(a, b, c):
    if b == 1: return a % c
    elif b & 1: return ((dPow(a, b >> 1, c) ** 2) * a) % c
    else: return (dPow(a, b >> 1, c) ** 2) % c
        

input = sys.stdin.readline
a, b, c = map(int, input().split())
print(dPow(a, b, c))