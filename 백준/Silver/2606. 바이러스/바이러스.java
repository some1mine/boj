import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine()), k = Integer.parseInt(reader.readLine());
        visited = new boolean[n];
        int[][] arr = new int[k][2];
        for (int i = 0; i < k; i++) arr[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int[] ar : arr) Arrays.sort(ar);
        Arrays.sort(arr, (x, y) -> {
            if(x[0] == y[0]) return x[1] - y[1];
            return x[0] - y[0];
        });
        dfs(arr, 0);
        int answer = 0;
        for(boolean flag : visited) {
            if(flag) answer++;
        }
        System.out.println(answer - 1);
        reader.close();
    }
    private static void dfs(int[][] arr, int n) {
        visited[n] = true;
        for(int[] ar : arr) {
            if(ar[0] - 1 == n && !visited[ar[1] - 1]) dfs(arr, ar[1] - 1);
            else if (ar[1] - 1 == n && !visited[ar[0] - 1]) dfs(arr, ar[0] - 1);
        }
    }
}
