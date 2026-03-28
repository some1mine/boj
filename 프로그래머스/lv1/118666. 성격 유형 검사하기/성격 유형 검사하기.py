def solution(survey, choices):
    answer = ''; scales = [0, 0, 0, 0]; letters = ['R', 'T', 'C', 'F', 'J', 'M', 'A', 'N']
    
    for i in range(len(survey)):
        idx = letters.index(survey[i][0])
        scales[idx // 2] += 4 - choices[i] if idx % 2 else choices[i] - 4
    
    for i in range(len(scales)): answer += letters[i * 2 + 1] if scales[i] > 0 else letters[i * 2]
    
    return answer