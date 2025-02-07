import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nm = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[nm[0] + 1];
        for (int i = 0; i < nm[0]; i++) {
            for (int j = 0; j <= i; j++) dp[i + 1] += arr[j];
        }
        int start = 0, end = 1, answer = 0;
        while(end <= nm[0]) {
            if (dp[end] - dp[start] > nm[1]) {
                start++; continue;
            }
            if (dp[end] - dp[start] == nm[1]) answer++;
            end++;
        }
        System.out.println(answer);
    }
}
