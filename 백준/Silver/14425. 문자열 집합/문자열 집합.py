a, b = map(int, input().split())
A = set()
answer = 0
for i in range(a): 
    A.add(input())

for i in range(b):
    c = input()
    if c in A: answer += 1

print(answer)