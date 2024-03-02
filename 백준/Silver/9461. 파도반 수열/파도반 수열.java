import java.util.*;

public class Main {
    public static long[] dp = new long[111];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine()); initializeArr();
        while(T-- > 0)  System.out.println(dp[Integer.parseInt(scanner.nextLine())]);
    }
    public static void initializeArr() {
        dp[1] = 1; dp[2] = 1; dp[3] = 1; dp[4] = 2;
        for(int i = 5 ; i < 111 ; i++) dp[i] = dp[i - 1] + dp[i - 5];
    }
}