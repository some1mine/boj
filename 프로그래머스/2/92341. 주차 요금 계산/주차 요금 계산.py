def getTime(a, b):
    return (int(b.split(':')[0]) - int(a.split(':')[0])) * 60 + int(b.split(":")[1]) - int(a.split(':')[1])

def getCharge(fees, v):
    plus = (v - fees[0]) // fees[2] if (v - fees[0]) % fees[2] == 0 else (v - fees[0]) // fees[2] + 1
    return fees[1] + max(0, plus) * fees[3]
    
def solution(fees, records):
    inout = {}; results = {}; answer = 0
    for r in records:
        r = r.split()
        if r[1] in inout: results[r[1]] = results.get(r[1], 0) + getTime(inout.pop(r[1]), r[0])
        else: inout[r[1]] = r[0]
    for k in inout.keys():
        results[k] = results.get(k, 0) + getTime(inout[k], '23:59')
    for k in results:
        results[k] = getCharge(fees, results[k])
    return [*dict(sorted(results.items())).values()]