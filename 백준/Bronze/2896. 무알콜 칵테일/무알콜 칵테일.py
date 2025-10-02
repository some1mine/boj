a, b, c = map(int, input().split()); i, j, k = map(int, input().split()); t = min(a / i, b / j, c / k)
print(f"{a - i * t:.6f}" if (a - i * t) % 1 else a - i * t, 
      f'{b - j * t:.6f}' if (b - j * t) % 1 else b - j * t, 
      f"{c - k * t:.6f}" if (c - k * t) % 1 else c - k * t)