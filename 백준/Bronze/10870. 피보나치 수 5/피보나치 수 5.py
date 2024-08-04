s = {0:0,1:1}

def fibo(n):
    if n in s: return s[n]
    s[n] = fibo(n - 1) + fibo(n - 2)
    return s[n]

print(fibo(int(input())))

