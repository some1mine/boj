import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            int n = Integer.parseInt(scanner.nextLine());
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m = Integer.parseInt(scanner.nextLine());
            sb.append(solution(arr, m)).append("\n");
        }
        System.out.print(sb);
    }
    public static int solution(int[] arr, int m) {
        int[] dp = new int[m + 1];
        for(int coin : arr) {
            for(int j = 0 ; j <= m ; j++) {
                if(j - coin > 0) dp[j] = dp[j] + dp[j - coin];
                else if(j - coin == 0) dp[j]++;
            }
        }
        return dp[m];
    }
}