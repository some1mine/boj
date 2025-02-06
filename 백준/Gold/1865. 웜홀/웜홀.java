import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNum = Integer.parseInt(scanner.nextLine());
        while (caseNum-- > 0) {
            int[] nmw = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            List<int[]> map = new ArrayList<>();
            for (int i = 0; i < nmw[1]; i++) {
                int[] input = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
                map.add(new int[]{input[1], input[0], input[2]});
                map.add(new int[]{input[0], input[1], input[2]});
            }
            for (int i = 0; i < nmw[2]; i++) {
                int[] input = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
                map.add(new int[]{input[0], input[1], -input[2]});
            }
            System.out.println(bellmanFord(nmw[0], map));
        }
    }

    private static String bellmanFord(int n, List<int[]> map) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 999999);
        dp[1] = 0;
        for (int i = 0; i < n; i++) {
            for (int[] road : map) {
                int next = dp[road[0]] + road[2];
                if (next < dp[road[1]]) {
                    dp[road[1]] = next;
                    if (i == n - 1) return "YES";
                }
            }
        }
        return "NO";
    }
}
