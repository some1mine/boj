import sys
from collections import deque
input = sys.stdin.readline

def run(com, num):
    count = 0
    for c in com:
        if c == 'D':
            if count % 2 == 1:
                num.pop()
            else:
                num.popleft()
        elif c == 'R':
            count+=1
    if num:
        if count % 2:
            num.reverse()
    return num

for _ in range(int(input())):
    command = input().rstrip().replace('RR', '')
    n = int(input())
    data = deque(input()[1:-2].split(','))
    if n < command.count('D'):
        print('error')
        continue
    print('[' + ','.join(run(command, data)) + ']')