import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] triangle = new int[n][];
        int[][] dp = new int[n][n];
        for(int i = 0 ; i < n ; i++) triangle[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp[0][0] = triangle[0][0];
        for(int i = 1 ; i < n ; i++) {
            for(int j = 0 ; j <= i ; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + triangle[i][j]);
                if(j > 0) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + triangle[i][j]);
            }
        }
        System.out.print(Arrays.stream(dp).flatMapToInt(Arrays::stream).max().getAsInt());
    }
}