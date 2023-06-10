import java.io.*;
import java.util.*;

public class Main {
  public static int answer = 0;
  public static int[][] directions = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
    int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(reader.readLine(), " ");
    int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
    int[][] arr = new int[n][m];
    for (int i = 0 ; i < n ; i++) {
      st = new StringTokenizer(reader.readLine(), " ");
      for (int j = 0 ; j < m ; j++) arr[i][j] = Integer.parseInt(st.nextToken());
    }
    outLoop:
    while (true) {
      if(arr[r][c] == 0) {
        answer++; arr[r][c] = 2; continue;
      }
      for (int i = 1; i <= 4; i++) {
        int dir = (d - i + 4) % 4;
        int dy = r + directions[dir][1], dx = c + directions[dir][0];
        if (dy < 0 || dx < 0 || dy >= n || dx >= m) {
          continue;
        }
        if (arr[dy][dx] == 0) {
          d = dir; r = dy; c = dx; continue outLoop;
        }
      }
      int dy = r - directions[d][1], dx = c - directions[d][0];
      if(dy < 0 || dx < 0 || dy >= n || dx >= m || arr[dy][dx] == 1) break;
      else {
        r = dy; c = dx;
      }
    }
    System.out.print(answer);
  }
}
