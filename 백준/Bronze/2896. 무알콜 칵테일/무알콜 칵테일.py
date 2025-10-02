a, b, c = map(int, input().split()); i, j, k = map(int, input().split()); d = min(a / i, b / j, c / k)
print(f"{a - i * d:.6f}" if (a - i * d) % 1 else a - i * d, 
      f'{b - j * d:.6f}' if (b - j * d) % 1 else b - j * d, 
      f"{c - k * d:.6f}" if (c - k * d) % 1 else c - k * d)