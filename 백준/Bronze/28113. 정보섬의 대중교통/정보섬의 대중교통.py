n, a, b = map(int, input().split())
print('Bus' if n > b or b > a else 'Subway' if b < a else 'Anything')