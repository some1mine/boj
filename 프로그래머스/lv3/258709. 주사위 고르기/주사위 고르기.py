from itertools import combinations

def get_win_num(dice, comb1, comb2): 
    n = len(comb1)
    dp1 = [[0] * (501) for _ in range(n + 1)]; dp1[0][0] = 1
    dp2 = [[0] * (501) for _ in range(n + 1)]; dp2[0][0] = 1
    
    for i in range(1, len(comb1) + 1):
        for x in range(1, 501):
            for num in dice[comb1[i - 1]]: dp1[i][x] += dp1[i - 1][x - num] if x - num >= 0 else 0
            for num in dice[comb2[i - 1]]: dp2[i][x] += dp2[i - 1][x - num] if x - num >= 0 else 0
    
    dp2_psum = [0] * 501; win_num = 0
    for x in range(1, 501): dp2_psum[x] = dp2[n][x] + dp2_psum[x - 1]
    for x in range(1, 501): win_num += dp1[n][x] * dp2_psum[x - 1]

    return win_num

def solution(dice):
    best_win_num = -1; best_case = None; n = len(dice) // 2
    for cur_case in combinations(range(n * 2), n):
        cur_win_num = get_win_num(dice, cur_case, tuple(sorted(list(set(range(n * 2)) - set(cur_case)))))
        if cur_win_num > best_win_num:
            best_win_num = cur_win_num; best_case = list(cur_case)
    
    return [bc + 1  for bc in best_case]