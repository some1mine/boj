prime_list = []

def is_prime(n):
    global prime_list
    if n == 1: return False
    if n == 2: return True
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0: return False
    return True

for i in range(1000000): prime_list.append(is_prime(i + 1))

def get_count(n):
    return sum(prime_list[i - 1] and prime_list[n - i - 1] for i in range(2, n // 2 + 1))

T = int(input())
for _ in range(T): print(get_count(int(input())))