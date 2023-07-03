import java.io.*;
import java.util.*;
 
public class Main {
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int n, m;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        String[][] arr = new String[n][m];
        for(int i = 0 ; i < n ; i++) arr[i] = reader.readLine().split("");
        bfs(arr);
    }
    public static void bfs(String[][] arr) {
        int result = 0;
        int[] startPoint = getStart(arr);
 
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(startPoint);
        visited[startPoint[1]][startPoint[0]] = true;
 
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int i = 0 ; i < 4 ; i++) {
                int nx = cur[0] + dx[i], ny = cur[1] + dy[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m || arr[ny][nx].equals("X")) continue;
                if(!visited[ny][nx]) {
                    if(arr[ny][nx].equals("P")) result++;
                    visited[ny][nx] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        System.out.print(result == 0 ? "TT" : result);
    }
    public static int[] getStart(String[][] arr) {
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(arr[i][j].equals("I")) return new int[]{j, i};
            }
        }
        return null;
    }
}