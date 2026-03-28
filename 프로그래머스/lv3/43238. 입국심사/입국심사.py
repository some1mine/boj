def solution(n, times):
    left = 1
    right = max(times) * n
    while left <= right:
        mid = (left+ right) // 2
        count = 0
        for i in times:
            count += mid // i
            if count >= n:
                break
        if count >= n:
            right = mid - 1
        elif count < n:
            left = mid + 1
    return left