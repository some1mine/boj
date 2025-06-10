from collections import deque

def solution(info, edges):
    lst = [[] for _ in range(len(info))]
    for a, b in edges: # 간선들을 배열에 담아
        lst[a].append(b); lst[b].append(a)
    visited = set(); queue = deque(); ans = 0
    queue.append(({0}, 1, 0)) # 방문 정점, 양의 수, 늑대 수
    while queue:
        curSet, curSheep, curWolf = queue.popleft() 
        ans = max(ans, curSheep); nxt = set()
        for node in curSet:
            for adj in lst[node]: # 방문한 정점들에 연결된 정점 중 방문하지 않은 정점들을 모아
                if adj not in curSet: nxt.add(adj)
        for node in nxt:
            nxtSet = curSet | {node} # 다음 방문 정점을 추가
            if info[node] == 0:
                if tuple(sorted((nxtSet))) not in visited: # queue에 추가 작업, visited에는 immutable type
                    queue.append((nxtSet, curSheep + 1, curWolf))
                    visited.add(tuple(sorted((nxtSet))))
            elif info[node] == 1 and curSheep > curWolf + 1:
                if tuple(sorted((nxtSet))) not in visited:
                    queue.append((nxtSet, curSheep, curWolf + 1))
                    visited.add(tuple(sorted((nxtSet))))
    return ans