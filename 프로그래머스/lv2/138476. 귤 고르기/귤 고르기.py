def solution(k, tangerine):
    answer = 0
    dicts = {}
    for i in tangerine: 
        if i not in dicts: dicts[i] = 1
        else: dicts[i] += 1
    # end of 정렬부분
    dicts = dict(sorted(dicts.items(), key = lambda item: item[1], reverse = True))
    target = k
    for i in dicts.values():
        if i >= k: return 1
        else: 
            answer += 1
            target -= i
        if target <= 0: break
    return answer