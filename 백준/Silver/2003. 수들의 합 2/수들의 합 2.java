import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nm = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int sum = 0, end = -1, answer = 0;
        for (int i = 0; i < nm[0]; i++) {
            while (end + 1 < nm[0] && sum + arr[end + 1] <= nm[1]) {
                end++; sum += arr[end];
            }
            if (sum == nm[1]) answer++;
            sum -= arr[i];
        }
        System.out.println(answer);
    }
}
