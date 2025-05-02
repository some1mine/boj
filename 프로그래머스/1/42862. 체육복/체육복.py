def solution(n, lost, reserve):
    save_count = 0
    tmp = list(filter(lambda x : x in reserve, lost))
    for i in tmp:
        lost.remove(i); reserve.remove(i)
    reserve.sort(); lost.sort()
    for i in lost:
        if i - 1 in reserve:
            reserve.remove(i - 1)
            save_count += 1
        elif i + 1 in reserve:
            reserve.remove(i + 1)
            save_count += 1
    return n - len(lost) + save_count