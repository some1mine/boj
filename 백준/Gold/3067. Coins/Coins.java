import java.io.*;
import java.util.*;
import java.util.stream.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(reader.readLine());
        while(T-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            int[] coins = 
                Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int money = Integer.parseInt(reader.readLine());
            sb.append(getCounts(coins, money)).append("\n");
        }
        System.out.print(sb);
    }
    public static int getCounts(int[] coins, int money) {
        int[] dp = new int[money + 1];
        for(int coin : coins) {
        	if(coin <= money) dp[coin]++;
        	for(int i = coin ; i <= money ; i++) dp[i] += dp[i - coin];
        }
        return dp[money];
    }
}