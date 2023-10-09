import java.util.*;

public class Main {
    public static int[] strokes = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] a = scanner.nextLine().toCharArray(), b = scanner.nextLine().toCharArray();
        int[] dp = new int[((a.length * 2 + 1) * (a.length * 2)) / 2 - 1];
        int len = a.length * 2, idx = 0;

        for(int i = 0 ; i < a.length ; i++) {
            dp[idx++] = strokes[a[i] - 'A'];
            dp[idx++] = strokes[b[i] - 'A'];
        }
        while(--len > 1) {
            for(int i = 0 ; i < len ; i++, idx++) dp[idx] = (dp[idx - len - 1] + dp[idx - len]) % 10;
        }
        System.out.print(dp[dp.length - 2] + "" + dp[dp.length - 1]);
    }
}