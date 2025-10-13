def to_min(time_str):
    h, m = map(int, time_str.split(':'))
    return h * 60 + m

def __str__(time): return f'{(time // 60):02d}:{(time % 60):02d}'

def solution(n, t, m, timetable):
    crews = sorted(to_min(x) for x in timetable)
    basetime = 9 * 60; idx = 0; boarded_times = []

    for i in range(n):
        arrive = basetime + i * t; boarded = []
        while idx < len(crews) and crews[idx] <= arrive and len(boarded) < m:
            boarded.append(crews[idx]); idx += 1
        boarded_times.append(list(sorted(boarded)))
    return __str__(basetime + (n - 1) * t) if len(boarded_times[-1]) < m else __str__(boarded_times[-1][-1] - 1)