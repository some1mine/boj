import sys
 
n, m = map(int, input().split())
 
table = [[0] * (n + 1)]
 
for i in range(n):
    table_row = list(map(int, sys.stdin.readline().rstrip().split()))
    table_row.insert(0, 0)
    table.append(table_row)

dp_table = [[0] * (n + 1) for _ in range(len(table))]
 
for i in range(1, len(table)):
    for j in range(1, len(table[1])):
        if dp_table[i][j - 1] != 0: dp_table[i][j] = dp_table[i][j - 1] + table[i][j]
        else: dp_table[i][j] = table[i][j]
 
for i in range(m):
    x1, y1, x2, y2 = map(int, sys.stdin.readline().rstrip().split())
    result = 0
    for i in range(x1, x2 + 1):
        num = dp_table[i][y2] - dp_table[i][y1 - 1]
        result = result + num
    print(result)