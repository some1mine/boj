def solution(n):
    answer = 0
    cnt = bin(n).count('1')
    for i in range(n + 1, 2000000):
        if cnt == bin(i).count('1'):
            answer = i
            break
    return answer