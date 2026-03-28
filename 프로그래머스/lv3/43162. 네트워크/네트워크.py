from collections import deque

def bfs(start, n, computers, graph):
    network = deque([start])
    graph[start] = True
    while network:
        net = network.popleft()
        for i in range(n):
            if computers[net][i] == 1:
                if graph[i] == False:
                    network.append(i)
                    graph[i] = True

def solution(n, computers):
    answer = 0
    graph = [False] * n
    for i in range(n):
        if graph[i] == False:
            bfs(i, n, computers, graph)
            answer += 1
        
    return answer