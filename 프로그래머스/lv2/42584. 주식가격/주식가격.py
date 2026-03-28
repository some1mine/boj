def solution(prices):
    answer = []
    for i in range(len(prices) - 1):
        a = prices[i]
        b = 0
        for j in range(i, len(prices) - 1):
            if a <= prices[j]:
                b += 1
            else:
                break
        if b == 0 and i != len(prices) - 1:
            b += 1
        answer.append(b)
    answer.append(0)
    return answer