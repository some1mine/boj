def is_prime(n):
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0: return False
    return True

def get_prime(n):
    if n == 1 or n == 0 or n == 2: return 2
    for i in range(n, int(1e15)):
        if is_prime(i): return i
    return -1

T = int(input())
for _ in range(T): print(get_prime(int(input())))