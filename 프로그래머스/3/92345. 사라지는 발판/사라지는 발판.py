from copy import deepcopy; 

dy = [-1, 0, 1, 0]; dx = [0, 1, 0, -1]

def out_range(y, x, board): return 0 > y or y >= len(board) or 0 > x or x >= len(board[0])

def func(board, cury, curx, opy, opx):
    
    if out_range(cury, curx, board) or board[cury][curx] == 0 or \
        sum(out_range(cury + dy[i], curx + dx[i], board) or board[cury + dy[i]][curx + dx[i]] == 0 \
            for i in range(4)) == 4: return False, 0
    if out_range(opy, opx, board) or board[opy][opx] == 0: return True, 0

    copied = deepcopy(board); copied[cury][curx] = 0; win_case = []; lose_case = []
    
    for i in range(4):
        ny = cury + dy[i]; nx = curx + dx[i]; nres, ncnt = func(copied, opy, opx, ny, nx)
        if nres: lose_case.append(ncnt)
        else: win_case.append(ncnt)
        
    if win_case: return True, min(win_case) + 1
    else: return False, max(lose_case) + 1

def solution(board, aloc, bloc):
    return func(board, *aloc, *bloc)[1]