from collections import deque

def solution(info, edges):
    lst = [[] for _ in range(len(info))]
    for a, b in edges:
        lst[a].append(b); lst[b].append(a)
    visited = set(); queue = deque(); ans = 0
    queue.append(({0}, 1, 0))
    while queue:
        curSet, curSheep, curWolf = queue.popleft()
        ans = max(ans, curSheep)
        nxt = set()
        for node in curSet:
            for adj in lst[node]:
                if adj not in curSet: nxt.add(adj)
        for node in nxt:
            nxtSet = curSet | {node}
            if info[node] == 0:
                if tuple(sorted((nxtSet))) not in visited:
                    queue.append((nxtSet, curSheep + 1, curWolf))
                    visited.add(tuple(sorted((nxtSet))))
            elif info[node] == 1 and curSheep > curWolf + 1:
                if tuple(sorted((nxtSet))) not in visited:
                    queue.append((nxtSet, curSheep, curWolf + 1))
                    visited.add(tuple(sorted((nxtSet))))
    return ans