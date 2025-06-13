n = int(input()); s = int(input(), 2)
print(bin((s ^ (s >> 1)) % 2 ** n)[2:].zfill(n))