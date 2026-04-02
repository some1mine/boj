n, a, b = map(int, input().split())
print('Bus' if b > a else 'Subway' if b < a else 'Anything')