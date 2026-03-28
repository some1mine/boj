def solution(s):
    answer = ''
    lst = list(s.split(' '))
    for i in range(len(lst)):
        answer += lst[i].lower().capitalize()
        if i != len(lst) - 1 : answer += ' '
    return answer