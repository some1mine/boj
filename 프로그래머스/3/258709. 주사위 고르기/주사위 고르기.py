from itertools import combinations

def get_idx(lst, value): # 정렬된 배열 lst에서 value 보다 작은 가장 오른쪽 인덱스 반환
    cur = -1
    step = len(lst)
    while step != 0:
        while cur + step < len(lst) and (lst[cur + step] < value):
            cur += step
        step //= 2
    return cur
    
def get_win_num(comb1, comb2): # A가 comb1, B가 comb2일 때, A가 이기는 횟수 반환
    global N, dice
    
    arr = [0]
    brr = [0]
    
    for n in range(1, N + 1):
        nxt_arr = []
        for num in arr:
            for d in dice[comb1[n - 1]]:
                nxt_arr.append(num + d)
                
        nxt_brr = []
        for num in brr:
            for d in dice[comb2[n - 1]]:
                nxt_brr.append(num + d)
        
        arr = nxt_arr
        brr = nxt_brr
    
    arr = sorted(arr)
    brr = sorted(brr)
        
    win_num = 0
    for score in arr:
        num = get_idx(brr, score) + 1
        win_num += num
        
    return win_num


def solution(_dice):
    global N, dice
    dice = _dice
    N = len(dice) // 2
    
    best_win_num = -1
    best_comb = None
    for cur_comb in combinations(range(N * 2), N): # range(N * 2) = (0, 1, 2, 3, 4, 5)
        sub_comb = tuple(sorted(list(set(range(N * 2)) - set(cur_comb))))
        # cur_comb = (0, 3, 4)
        # sub_comb = (1, 2, 5)
        
        cur_win_num = get_win_num(cur_comb, sub_comb)
        if cur_win_num > best_win_num:
            best_win_num = cur_win_num
            best_comb = list(cur_comb) # deepcopy
    
    return [bc + 1  for bc in best_comb]
