def gcd(n1, n2):
    n3 = n1 % n2
    if n3 == 0: return n2
    return gcd(n2, n3)

child1, mom1 = map(int, input().split())
child2, mom2 = map(int, input().split())

child = mom1 * child2 + mom2 * child1
gcd = gcd(max(child, mom1 * mom2), min(child, mom1 * mom2))
print(child // gcd, mom1 * mom2 // gcd)