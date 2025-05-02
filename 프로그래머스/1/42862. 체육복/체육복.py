def solution(n, lost, reserve):
    students = [0 for _ in range(n)]
    for i in lost: students[i - 1] -= 1
    for i in reserve: students[i - 1] += 1
    for i in range(n):
        if i > 0 and students[i] == -1 and students[i - 1] == 1: 
            students[i] = 0; students[i - 1] = 0
        elif i < n - 1 and students[i] == -1 and students[i + 1] == 1:
            students[i] = 0; students[i + 1] = 0
    return len(students) - students.count(-1)