input(); arr = list(map(int, input().split())); side = [99999]; seq = 1;
for i in arr:
    if i != seq and side[-1] != seq: 
    	side.append(i); continue
    if i == seq: seq += 1
    while side and side[-1] == seq:
            side.pop(); seq += 1
if side == sorted(side, reverse = True): print("Nice")
else: print("Sad")