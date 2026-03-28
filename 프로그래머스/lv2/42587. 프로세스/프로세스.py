def solution(priorities, location):
    answer = 0
    cursor = 0
    
    while True:
        if max(priorities) == priorities[cursor % len(priorities)]:
            priorities[cursor % len(priorities)] = 0
            answer += 1
            if cursor % len(priorities) == location:
                break
        cursor += 1
        
    return answer