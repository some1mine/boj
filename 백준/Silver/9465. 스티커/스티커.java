import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            int[][] arr = new int[2][n], dp = new int[3][n];
            arr[0] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[1] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            dp[0][0] = arr[0][0]; dp[1][0] = arr[1][0];
            for(int i = 1 ; i < n ; i++) {
                dp[0][i] = Math.max(dp[1][i - 1] + arr[0][i], dp[2][i - 1] + arr[0][i]);
                dp[1][i] = Math.max(dp[0][i - 1] + arr[1][i], dp[2][i - 1] + arr[1][i]);
                dp[2][i] = Math.max(dp[2][i - 1], Math.max(dp[0][i - 1], dp[1][i - 1]));
            }
            sb.append(Arrays.stream(dp).flatMapToInt(Arrays::stream).max().getAsInt()).append("\n");
        }
        System.out.print(sb);
    }
}