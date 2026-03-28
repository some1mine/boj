input(); s = input(); t = 0
for l in s: t += 1 if l == 'y' else -1 if l == 'b' else 0
print('security!' if t > 0 else 'bigdata?' if t < 0 else 'bigdata? security!')
