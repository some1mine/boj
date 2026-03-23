from itertools import combinations

def get_win_num(comb1, comb2):
    dp1 = [[0] * (501) for _ in range(len(comb1) + 1)]; dp1[0][0] = 1
    dp2 = [[0] * (501) for _ in range(len(comb1) + 1)]; dp2[0][0] = 1
    
    for n in range(1, len(comb1) + 1):
        for x in range(1, 501):
            for num in dice[comb1[n - 1]]: dp1[n][x] += dp1[n - 1][x - num] if x - num >= 0 else 0
            for num in dice[comb2[n - 1]]: dp2[n][x] += dp2[n - 1][x - num] if x - num >= 0 else 0
    
    dp2_psum = [0] * 501; win_num = 0
    for x in range(1, 501): dp2_psum[x] = dp2[len(comb1)][x] + dp2_psum[x - 1]
    for x in range(1, 501): win_num += dp1[len(comb1)][x] * dp2_psum[x - 1]

    return win_num

def solution(_dice):
    global dice; dice = _dice
    
    best_win_num = -1; best_case = None
    for cur_case in combinations(range(len(dice)), len(dice) // 2):
        cur_win_num = get_win_num(cur_case, tuple(sorted(list(set(range(len(dice))) - set(cur_case)))))
        if cur_win_num > best_win_num:
            best_win_num = cur_win_num; best_case = list(cur_case)
    
    return [bc + 1  for bc in best_case]