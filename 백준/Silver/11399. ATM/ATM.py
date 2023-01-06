n = int(input())
arr = list(map(int, input().split()))

arr2 = arr
arr.sort()

answer = 0
tmp = 0
for i in range(n):
    answer += tmp + arr[i]
    tmp += arr[i]
print(answer)