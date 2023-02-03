import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] arr;
    public static int[][] visited;
    public static Deque<int[]> deque = new ArrayDeque<>();
    public static int[][] ord = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++)
            arr[i] = Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        deque.offer(new int[]{0, 0});
        bfs();
    }

    private static void bfs() {
        while(!deque.isEmpty()) {
            int[] ints = deque.poll();
            if(ints[0] == m - 1 && ints[1] == n - 1) {
                System.out.println(visited[ints[1]][ints[0]] + 1);
                System.exit(0);
            }
            for (int i = 0; i < ord.length; i++) {
                int dx = ints[0] + ord[i][0], dy = ints[1] + ord[i][1];
                if (dx < 0 || dx >= m || dy < 0 || dy >= n)
                    continue;
                else if (visited[dy][dx] == 0 && arr[dy][dx] == 1) {
                    deque.offer(new int[]{dx, dy});
                    visited[dy][dx] = visited[ints[1]][ints[0]] + 1;
                }
            }
        }
    }
}
