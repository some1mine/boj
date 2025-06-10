def getTime(a, b): # 총 시간 구하기
    return (int(b.split(':')[0]) - int(a.split(':')[0])) * 60 + int(b.split(":")[1]) - int(a.split(':')[1])

def getCharge(fees, v): # 총 금액 구하기
    plus = (v - fees[0]) // fees[2] if (v - fees[0]) % fees[2] == 0 else (v - fees[0]) // fees[2] + 1
    return fees[1] + max(0, plus) * fees[3]
    
def solution(fees, records):
    inout = {}; results = {}; answer = 0
    for r in records: # 머문 시간을 추가하고
        r = r.split()
        if r[1] in inout: results[r[1]] = results.get(r[1], 0) + getTime(inout.pop(r[1]), r[0])
        else: inout[r[1]] = r[0]
    for k in inout.keys(): # 자정 전까지 남은 거 추가하고
        results[k] = results.get(k, 0) + getTime(inout[k], '23:59')
    for k in results: # 각각의 금액을 구해서
        results[k] = getCharge(fees, results[k])
    return [*dict(sorted(results.items())).values()] # 정렬 후 값들 반환