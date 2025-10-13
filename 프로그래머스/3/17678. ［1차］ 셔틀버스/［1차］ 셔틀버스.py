def to_min(time):
    h, m = map(int, time.split(':'))
    return h * 60 + m

def __str__(time): return f'{(time // 60):02d}:{(time % 60):02d}'

def solution(n, t, m, timetable):
    crews = sorted(to_min(x) for x in timetable)
    basetime = 9 * 60; idx = 0; boarded_times = []

    for i in range(n):
        boarded = [crews[j] for j in range(idx, len(timetable)) if crews[j] <= basetime + i * t][:m]
        idx += len(boarded); boarded_times.append(list(sorted(boarded)))
        
    return __str__(basetime + (n - 1) * t) if len(boarded_times[-1]) < m else __str__(boarded_times[-1][-1] - 1)