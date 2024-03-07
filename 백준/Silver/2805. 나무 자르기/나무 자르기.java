import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long[] nm = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(arr);
        long left = 1, right = arr[arr.length - 1];
        while(left <= right) {
            long mid = (left + right) / 2;
            long sum = Arrays.stream(arr).map(i -> Math.max(0, i - mid)).sum();
            if(nm[1] == sum) {
                System.out.print(mid); return;
            }
            else if(nm[1] > sum) right = mid - 1;
            else left = mid + 1;
        }
        System.out.print(right);
    }
}
