import java.util.*;

public class Main {
    public static int n;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static boolean[][] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
        char[][] arr = new char[n][n];
        for(int i = 0 ; i < n ; i++) arr[i] = scanner.nextLine().toCharArray();
        visited = new boolean[n][n];
        System.out.print(getSolution(arr) + " ");
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(arr[i][j] == 'R') arr[i][j] = 'G';
            }
        }
        visited = new boolean[n][n];
        System.out.print(getSolution(arr));
    }
    public static int getSolution(char[][] arr) {
        int answer = 0;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(!visited[i][j]) {
                    answer++; dfs(arr, i, j);
                }
            }
        }
        return answer;
    }
    public static void dfs(char[][] arr , int y, int x) {
        visited[y][x] = true;
        for(int i = 0 ; i < 4 ; i++) {
            int ny = y + dy[i], nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
            if(!visited[ny][nx] && arr[ny][nx] == arr[y][x]) {
                dfs(arr, ny, nx);
            }
        }
    }
}
