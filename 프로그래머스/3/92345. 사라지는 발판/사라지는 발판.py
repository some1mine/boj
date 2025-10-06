from copy import deepcopy

dy = [-1, 0, 1, 0]; dx = [0, 1, 0, -1]
def in_range(y, x, board): return 0 <= y < len(board) and 0 <= x < len(board[0])
def func(board, cury, curx, opy, opx):
    cnt = 0
    
    if not in_range(cury, curx, board) or board[cury][curx] == 0: return False, 0
    if not in_range(opy, opx, board) or board[opy][opx] == 0: return True, 0

    for i in range(4):
        ny = cury + dy[i]; nx = curx + dx[i]; cnt += not in_range(ny, nx, board) or board[ny][nx] == 0
    if cnt == 4: return False, 0
    
    cboard = deepcopy(board); cboard[cury][curx] = 0;  win_case = []; lose_case = []
    for i in range(4):
        ny = cury + dy[i]; nx = curx + dx[i]; nres, ncnt = func(cboard, opy, opx, ny, nx)
        if nres == False: win_case.append(ncnt)
        else: lose_case.append(ncnt)
    if win_case: return True, min(win_case) + 1
    else: return False, max(lose_case) + 1


def solution(board, aloc, bloc):
    return func(board, *aloc, *bloc)[1]
