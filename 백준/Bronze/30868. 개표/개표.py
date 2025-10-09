lst = [int(input()) for _ in range(int(input()))]
for c in lst: print('++++ ' * (c // 5) + '|' * (c % 5))