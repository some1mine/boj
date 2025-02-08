import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ns = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int ans = 100000000, sum = 0, end = -1;
        for (int start = 0; start < ns[0]; start++) {
            while (end + 1 < ns[0] && sum + arr[end + 1] < ns[1]) {
                end++; sum += arr[end];
            }
            if (sum < ns[1] && end + 1 < ns[0]) {
                end++; sum += arr[end];
            }
            if (end < ns[0] && sum >= ns[1]) ans = Math.min(ans, end - start + 1);
            sum -= arr[start];
        }
        System.out.println(ans == 100000000 ? 0 : ans);
    }
}
