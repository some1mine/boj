def solution(progresses, speeds):
    answer = []
    temp = [0 for _ in range(len(speeds))]
    for i in range(len(speeds)):
        if (100 - progresses[i]) % speeds[i] == 0:
            temp[i] = (100 - progresses[i]) // speeds[i]
        else:
            temp[i] = (100 - progresses[i]) // speeds[i] + 1
    lastIdx = 0
    for i in range(1, len(temp)):
        if temp[lastIdx] < temp[i]:
            answer.append(i - lastIdx)
            lastIdx = i
        if i == len(temp) - 1:
            answer.append(i - lastIdx + 1)
    
    return answer