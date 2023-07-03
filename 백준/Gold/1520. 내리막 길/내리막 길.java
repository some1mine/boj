import java.io.*;
import java.util.*;

public class Main {
    public static int[][] arr, dp;
    public static int m, n;
    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        m = Integer.parseInt(st.nextToken()); n = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        dp = new int[m][n];
        for(int i = 0 ; i < m ; i++) {
            arr[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.fill(dp[i], -1);
        }
        System.out.print(solution(0, 0));
    }
    public static int solution(int x, int y) {
        if(y == m - 1 && x == n - 1) {
            return 1;
        }
        if(dp[y][x] != -1) return dp[y][x];
        
        dp[y][x] = 0;
        for(int i = 0 ; i < 4 ; i++) {
            int ny = y + dy[i], nx = x + dx[i];
            if(ny < 0 || ny >= m || nx < 0 || nx >= n) continue;
            if(arr[ny][nx] < arr[y][x]) dp[y][x] += solution(nx, ny);
        }
        return dp[y][x];
    }
}