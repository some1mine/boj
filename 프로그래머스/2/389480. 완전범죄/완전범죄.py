def solution(info, n, m):
    arr = [0] + [121 for _ in range(n - 1)]
    for inf in info:
        for i in range(n - 1, -1, -1):
            arr[i] += inf[1]
            if i >= inf[0]: arr[i] = min(arr[i], arr[i - inf[0]])
    for i in range(n):
        if arr[i] < m: return i
    return -1