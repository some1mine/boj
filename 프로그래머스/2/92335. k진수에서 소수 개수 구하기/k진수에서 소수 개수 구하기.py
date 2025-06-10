def convert(n, k):
    ans = ''
    while n > 0:
        ans += str(n % k)
        n //= k
    return ans[::-1]

def isPrime(n):
    if n == 1: return False
    for i in range(2, int(n ** 0.5 + 1)):
        if n % i == 0: return False
    return True

def solution(n, k): return sum(1 for s in convert(n, k).split('0') if s != '' and isPrime(int(s)))
    
    