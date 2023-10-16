import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nk = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] coins = new int[nk[0]];
        for(int i = 0 ; i < nk[0] ; i++) coins[i] = Integer.parseInt(scanner.nextLine());
        int[] dp = new int[nk[1] + 1]; Arrays.fill(dp, 111_111_111); dp[0] = 0; 
        for(int coin : coins) {
            if(coin <= nk[1]) dp[coin] = 1; 
        }
        for(int i = 0 ; i <= nk[1] ; i++) {
            for(int coin : coins) {
                if(i >= coin) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        System.out.print(dp[nk[1]]);
    }
}