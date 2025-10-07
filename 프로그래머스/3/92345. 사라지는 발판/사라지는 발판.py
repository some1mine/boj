from copy import deepcopy; 

dy = [-1, 0, 1, 0]; dx = [0, 1, 0, -1]

def out_range(y, x, board): return not 0 <= y < len(board) or not 0 <= x < len(board[0])

def func(board, cury, curx, opy, opx):
    cnt = sum((out_range(cury + dy[i], curx + dx[i], board) or board[cury + dy[i]][curx + dx[i]] == 0) for i in range(4))
    
    if out_range(cury, curx, board) or board[cury][curx] == 0 or cnt == 4: return False, 0
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