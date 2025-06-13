def bin_to_gray(b): return b ^ (b >> 1)
n = int(input()); s = int(input(), 2)
s = bin((s ^ (s >> 1)) % 2 ** n)[2:]
print(s.zfill(n))