from copy import deepcopy; 

dy = [-1, 0, 1, 0]; dx = [0, 1, 0, -1]

def out_range(y, x, board): return 0 > y or y >= len(board) or 0 > x or x >= len(board[0])

def func(board, cury, curx, opy, opx):
    
    if out_range(cury, curx, board) or board[cury][curx] == 0 or \
        sum(out_range(cury + dy[i], curx + dx[i], board) or board[cury + dy[i]][curx + dx[i]] == 0 \
            for i in range(4)) == 4: return False, 0
    if out_range(opy, opx, board) or board[opy][opx] == 0: return True, 0

    copied = deepcopy(board); copied[cury][curx] = 0; wins = []; loses = []
    
    for i in range(4):
        nres, ncnt = func(copied, opy, opx, cury + dy[i], curx + dx[i])
        if nres: loses.append(ncnt)
        else: wins.append(ncnt)
        
    if wins: return True, min(wins) + 1
    else: return False, max(loses) + 1

def solution(board, aloc, bloc):
    return func(board, *aloc, *bloc)[1]