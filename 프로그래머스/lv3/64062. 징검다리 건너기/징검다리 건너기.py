def solution(stones, k):
    answer = 1
    right = 200000000
    while answer <= right:
        cnt = 0
        mid = (answer + right) // 2
        for stone in stones:
            if stone - mid <= 0 : cnt += 1
            else : cnt = 0
            if cnt >= k: break
        if cnt >= k : right = mid - 1
        else: answer = mid + 1
    return answer